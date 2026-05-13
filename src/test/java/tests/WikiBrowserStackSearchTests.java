package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.SearchScreen;

public class WikiBrowserStackSearchTests extends TestBase {

    SearchScreen searchScreen = new SearchScreen();

    @Tag("remote")
    @DisplayName("При вводе запроса в поисковую строку появляются результаты поиска")
    @Test
    void successfulSearchTest() {
        searchScreen.skipStartScreen()
                .clickSearchArea()
                .enterSearchQuery()
                .verifyResultListIsNotEmpty();
    }


    @Tag("remote")
    @DisplayName("Можно выбрать первый результат поискового запроса")
    @Test
    void successfulSearchFirstResultTest() {
        searchScreen.skipStartScreen()
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
        searchScreen.skipStartScreen()
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
        searchScreen.skipStartScreen()
                .clickSearchArea()
                .enterSearchQuery()
                .clickCloseButton()
                .verifyRecentSearchElement();
    }


    @Tag("remote")
    @DisplayName("После выхода из главного поискового экрана поисковая строчка пустая")
    @Test
    void recentSearchElementEmptyCheckTest() {
        searchScreen.skipStartScreen()
                .clickSearchArea()
                .enterSearchQuery()
                .clickCloseButton()
                .verifySearchFieldIsEmpty();
    }

}