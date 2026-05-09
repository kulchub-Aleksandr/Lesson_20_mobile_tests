package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class SearchPage {

    private final String searchQuery = "Appium";

    private final SelenideElement
            searchArea = $(id("org.wikipedia.alpha:id/search_text_view")),
            container = $(id("org.wikipedia.alpha:id/container")),
            containerCloseButton = $(id("org.wikipedia.alpha:id/closeButton")),
            searchFiled = $(id("org.wikipedia.alpha:id/search_src_text")),
            recentSearchElement = $(byXpath("//android.widget.TextView[@text=\"Appium\"]")),
            searchResultFirst = $(byXpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]")),
            searchResultFirstTitle = $(byXpath("(//android.widget.TextView[@text=\"Appium\"])[1]")),
            closeButton = $(id("org.wikipedia.alpha:id/search_close_btn")),
            backButton = $(accessibilityId("Navigate up"));


    private final ElementsCollection searchResultsList = $$(id("org.wikipedia.alpha:id/fragment_search_results"));


    @Step("Закрыть начальный экран")
    public SearchPage skipStartScreen() {
        back();
        return this;
    }

    @Step("Нажать на область поиска")
    public SearchPage clickSearchArea() {
        searchArea.click();
        return this;
    }

    @Step("Ввести поисковой запрос '{searchQuery}'")
    public SearchPage enterSearchQuery() {
        if (container.is(Condition.visible)) {
            containerCloseButton.click();
        }
        searchFiled.sendKeys(searchQuery);
        return this;
    }

    @Step("Проверить, что по запросу есть результаты")
    public SearchPage verifyResultListIsNotEmpty() {
        searchResultsList.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Нажать на результат поиска")
    public SearchPage clickSearchResultFirst() {
        searchResultFirst.click();
        return this;
    }

    @Step("Нажать на иконку Закрыть")
    public SearchPage clickCloseButton() {
        closeButton.click();
        return this;
    }

    @Step("Нажать Назад")
    public SearchPage clickBackButton() {
        backButton.click();
        return this;
    }

    @Step("Проверить заголовок страницы поискового запроса '{searchQuery}'")
    public SearchPage verifySearchFirstResultTitle() {
        if (container.is(Condition.visible)) {
            containerCloseButton.click();
        }
        searchResultFirstTitle.shouldHave(text(searchQuery));
        return this;
    }

    @Step("Проверка поисковой строки")
    public SearchPage verifySearchFieldIsEmpty() {
        searchFiled.shouldHave(text("Search Wikipedia"));
        return this;
    }

    @Step("Проверка наличия строчки предыдущего запроса")
    public SearchPage verifyRecentSearchElement() {
        recentSearchElement.shouldHave(text(searchQuery));
        return this;
    }
}
