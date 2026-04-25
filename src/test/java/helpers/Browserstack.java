package helpers;

import config.BrowserStackConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;


public class Browserstack {
    private static final BrowserStackConfig browserstackConfig = ConfigFactory.create(BrowserStackConfig.class, System.getProperties());

    // curl -u "qaguru_ti9G5S:5yrxu4nFTKkRExUAhqxh" -X GET "https://api.browserstack.com/app-automate/sessions/0359d759d2aaa4f46401dac46bd281b6d9b24943.json"
    // automation_session.video_url

    public static String videoUrl(String sessionId) {
        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(browserstackConfig.browserstackUser(), browserstackConfig.browserstackKey())
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
