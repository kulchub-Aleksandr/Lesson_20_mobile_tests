package screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;

public class ResultSearchScreen {
    private final SelenideElement
            searchResultFirst = $(byXpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]")),
            closeButton = $(id("org.wikipedia.alpha:id/search_close_btn"));


    private final ElementsCollection searchResultsList = $$(id("org.wikipedia.alpha:id/fragment_search_results"));


    @Step("Проверить, что по запросу есть результаты")
    public ResultSearchScreen verifyResultListIsNotEmpty() {
        searchResultsList.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Нажать на результат поиска")
    public ResultSearchScreen clickSearchResultFirst() {
        searchResultFirst.click();
        return this;
    }

    @Step("Нажать на иконку Закрыть")
    public ResultSearchScreen clickCloseButton() {
        closeButton.click();
        return this;
    }

}
