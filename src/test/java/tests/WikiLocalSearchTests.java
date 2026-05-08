package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.SearchPage;

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
    }
}