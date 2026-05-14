package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.back;
import static io.appium.java_client.AppiumBy.id;

public class MainScreen {
    private final SelenideElement
            searchArea = $(id("org.wikipedia.alpha:id/search_text_view"));

    @Step("Закрыть начальный экран")
    public MainScreen skipStartScreen() {
        back();
        return this;
    }

    @Step("Нажать на область поиска")
    public MainScreen clickSearchArea() {
        searchArea.click();
        return this;
    }
}
