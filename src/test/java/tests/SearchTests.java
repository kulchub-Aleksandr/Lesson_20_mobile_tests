package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

    @Test
    void successfulSearchTest() {
        back();
        step("Type search", () -> {
            $(id("org.wikipedia.alpha:id/search_text_view")).click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });
        step("Verify content found", () ->
            $$(id("org.wikipedia.alpha:id/fragment_search_results"))
                    .shouldHave(sizeGreaterThan(0)));
    }
}