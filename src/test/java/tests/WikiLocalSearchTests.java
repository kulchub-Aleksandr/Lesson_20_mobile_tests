package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.FirstResultSearchScreen;
import screens.MainScreen;
import screens.ResultSearchScreen;
import screens.SearchScreen;

public class WikiLocalSearchTests extends TestBase {

    MainScreen mainScreen = new MainScreen();
    SearchScreen searchScreen = new SearchScreen();
    ResultSearchScreen resultSearchScreen = new ResultSearchScreen();
    FirstResultSearchScreen firstResultSearchScreen = new FirstResultSearchScreen();


    @Tag("local")
    @DisplayName("При вводе запроса в поисковую строку появляются результаты поиска")
    @Test
    void successfulSearchTest() {
        mainScreen.skipStartScreen()
                .clickSearchArea();
        searchScreen.enterSearchQuery();
        resultSearchScreen.verifyResultListIsNotEmpty();
    }

    @Tag("local")
    @DisplayName("Можно выбрать первый результат поискового запроса")
    @Test
    void successfulSearchFirstResultTest() {
        mainScreen.skipStartScreen()
                .clickSearchArea();
        searchScreen.enterSearchQuery();
        resultSearchScreen.verifyResultListIsNotEmpty()
                .clickSearchResultFirst();
        firstResultSearchScreen.verifySearchFirstResultTitle();
    }

    @Tag("local")
    @DisplayName("Можно вернутся на главный поисковый экран из первого результата поискового запроса")
    @Test
    void successfulSearchFirstResultBackTest() {
        mainScreen.skipStartScreen()
                .clickSearchArea();
        searchScreen.enterSearchQuery();
        resultSearchScreen.verifyResultListIsNotEmpty()
                .clickSearchResultFirst();
        firstResultSearchScreen.verifySearchFirstResultTitle()
                .clickBackButton();
        resultSearchScreen.verifyResultListIsNotEmpty();
    }

    @Tag("local")
    @DisplayName("После выхода из главного поискового экрана остается список недавних запросов")
    @Test
    void recentSearchElementCheckTest() {
        mainScreen.skipStartScreen()
                .clickSearchArea();
        searchScreen.enterSearchQuery();
        resultSearchScreen.clickCloseButton();
        searchScreen.verifyRecentSearchElement();
    }

    @Tag("local")
    @DisplayName("После выхода из главного поискового экрана поисковая строчка пустая")
    @Test
    void recentSearchElementEmptyCheckTest() {
        mainScreen.skipStartScreen()
                .clickSearchArea();
        searchScreen.enterSearchQuery();
        resultSearchScreen.clickCloseButton();
        searchScreen.verifySearchFieldIsEmpty();
    }
}