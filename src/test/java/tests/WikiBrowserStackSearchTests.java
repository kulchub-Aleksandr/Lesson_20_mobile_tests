package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.SearchPage;

public class WikiBrowserStackSearchTests extends TestBase {

    SearchPage searchPage = new SearchPage();

    @Tag("remote")
    @DisplayName("При вводе запроса в поисковую строку появляются результаты поиска")
    @Test
    void successfulSearchTest() {
        searchPage.skipStartScreen()
                .clickSearchArea()
                .enterSearchQuery()
                .verifyResultListIsNotEmpty();


//        step("Type search", () -> {
//            $(accessibilityId("Search Wikipedia")).click();
//            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
//        });
//        step("Verify content found", () ->
//            $$(id("org.wikipedia.alpha:id/page_list_item_title"))
//                    .shouldHave(sizeGreaterThan(0)));
    }


    @Tag("remote")
    @DisplayName("Можно выбрать первый результат поискового запроса")
    @Test
    void successfulSearchFirstResultTest() {
        searchPage.skipStartScreen()
                .clickSearchArea()
                .enterSearchQuery()
                .verifyResultListIsNotEmpty()
                .clickSearchResultFirst()
                .verifySearchFirstResultTitle();
    }

    @Tag("remote")
    @DisplayName("Можно вернутся на главный поисковый экран из первого результата поискового запроса")
    @Test
    void successfulSearchFirstResultBackTest() {
        searchPage.skipStartScreen()
                .clickSearchArea()
                .enterSearchQuery()
                .verifyResultListIsNotEmpty()
                .clickSearchResultFirst()
                .verifySearchFirstResultTitle()
                .clickBackButton()
                .verifyResultListIsNotEmpty();
    }

    @Tag("remote")
    @DisplayName("После выхода из главного поискового экрана остается список недавних запросов")
    @Test
    void recentSearchElementCheckTest() {
        searchPage.skipStartScreen()
                .clickSearchArea()
                .enterSearchQuery()
                .clickCloseButton()
                .verifyRecentSearchElement();
    }


    @Tag("remote")
    @DisplayName("После выхода из главного поискового экрана поисковая строчка пустая")
    @Test
    void recentSearchElementEmptyCheckTest() {
        searchPage.skipStartScreen()
                .clickSearchArea()
                .enterSearchQuery()
                .clickCloseButton()
                .verifySearchFieldIsEmpty();
    }

}