package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.SearchPage;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class WikiLocalSearchTests extends TestBase {

    SearchPage searchPage = new SearchPage();

    @Tag("local")
    @DisplayName("Тестировании мобильного приложения Wikipedia на локальном эмуляторе")
    @Test
    void successfulSearchTest() {
        searchPage.skipStartScreen()
                .clickSearchArea()
                .enterSearchQuery()
                .verifyResultListIsNotEmpty();
//        back();
//        step("Type search", () -> {
//            $(id("org.wikipedia.alpha:id/search_text_view")).click();
//            if ($(id("org.wikipedia.alpha:id/container")).is(Condition.visible)) {
//                $(id("org.wikipedia.alpha:id/closeButton")).click();
//            }
//            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
//        });
//        step("Verify content found", () ->
//                $$(id("org.wikipedia.alpha:id/fragment_search_results"))
//                        .shouldHave(sizeGreaterThan(0)));


    }
}