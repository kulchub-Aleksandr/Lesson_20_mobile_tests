package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserStackDriver;
import drivers.LocalDriver;

import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    public static String deviceHost = System.getProperty("deviceHost");

//    private static final String BROWSERSTACK_DRIVER = "remote",
//            LOCAL_DRIVER = "local";

    @BeforeAll
    static void beforeAll() {

//            switch (System.getProperty("deviceHost", BROWSERSTACK_DRIVER)) {
//                case BROWSERSTACK_DRIVER -> Configuration.browser = BrowserStackDriver.class.getName();
//                case LOCAL_DRIVER -> Configuration.browser = LocalDriver.class.getName();
//            }


        deviceHost = System.getProperty("deviceHost", "local"); // default local

        switch (deviceHost.toLowerCase()) {
            case "remote":
                Configuration.browser = BrowserStackDriver.class.getName();
                break;
            case "local":
            default:
                Configuration.browser = LocalDriver.class.getName();
                break;
        }
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {

        if (deviceHost.equals("remote")) {

            Attach.pageSource();
            String sessionId = Selenide.sessionId().toString();
            closeWebDriver();

            Attach.addVideo(sessionId);
        }

        if(deviceHost.equals("local")) {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            closeWebDriver();
        }

    }
}
