package screens;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class FirstResultSearchScreen {

    private final String searchQuery = "Appium";

    private final SelenideElement
            container = $(id("org.wikipedia.alpha:id/container")),
            containerCloseButton = $(id("org.wikipedia.alpha:id/closeButton")),
            searchResultFirstTitle = $(byXpath("(//android.widget.TextView[@text=\"Appium\"])[1]")),
            backButton = $(accessibilityId("Navigate up"));


    @Step("Нажать Назад")
    public FirstResultSearchScreen clickBackButton() {
        backButton.click();
        return this;
    }

    @Step("Проверить заголовок страницы поискового запроса '{searchQuery}'")
    public FirstResultSearchScreen verifySearchFirstResultTitle() {
        if (container.is(Condition.visible)) {
            containerCloseButton.click();
        }
        searchResultFirstTitle.shouldHave(text(searchQuery));
        return this;
    }
}
