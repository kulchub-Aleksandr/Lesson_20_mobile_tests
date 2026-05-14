package screens;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class SearchScreen {

    private final String searchQuery = "Appium";

    private final SelenideElement
            container = $(id("org.wikipedia.alpha:id/container")),
            containerCloseButton = $(id("org.wikipedia.alpha:id/closeButton")),
            searchFiled = $(id("org.wikipedia.alpha:id/search_src_text")),
            recentSearchElement = $(byXpath("//android.widget.TextView[@text=\"Appium\"]"));


    @Step("Ввести поисковой запрос '{searchQuery}'")
    public SearchScreen enterSearchQuery() {
        if (container.is(Condition.visible)) {
            containerCloseButton.click();
        }
        searchFiled.sendKeys(searchQuery);
        return this;
    }

    @Step("Проверка поисковой строки")
    public SearchScreen verifySearchFieldIsEmpty() {
        searchFiled.shouldHave(text("Search Wikipedia"));
        return this;
    }

    @Step("Проверка наличия строчки предыдущего запроса")
    public SearchScreen verifyRecentSearchElement() {
        recentSearchElement.shouldHave(text(searchQuery));
        return this;
    }
}
