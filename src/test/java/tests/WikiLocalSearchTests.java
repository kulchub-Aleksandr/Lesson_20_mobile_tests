package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.SearchScreen;

public class WikiLocalSearchTests extends TestBase {

    SearchScreen searchScreen = new SearchScreen();

    @Tag("local")
    @DisplayName("При вводе запроса в поисковую строку появляются результаты поиска")
    @Test
    void successfulSearchTest() {
        searchScreen.skipStartScreen()
                .clickSearchArea()
                .enterSearchQuery()
                .verifyResultListIsNotEmpty();
    }


    @Tag("local")
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

    @Tag("local")
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

    @Tag("local")
    @DisplayName("После выхода из главного поискового экрана остается список недавних запросов")
    @Test
    void recentSearchElementCheckTest() {
        searchScreen.skipStartScreen()
                .clickSearchArea()
                .enterSearchQuery()
                .clickCloseButton()
                .verifyRecentSearchElement();
    }


    @Tag("local")
    @DisplayName("После выхода из главного поискового экрана поисковая строчка пустая")
    @Test
    void recentSearchElementEmptyCheckTest() {
        searchScreen.skipStartScreen()
                .clickSearchArea()
                .enterSearchQuery()
                .clickCloseButton()
                .verifySearchFieldIsEmpty ();
    }


}