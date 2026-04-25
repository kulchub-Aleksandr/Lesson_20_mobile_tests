package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserStackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackDriver implements WebDriverProvider {
    private static final BrowserStackConfig browserStackConfig = ConfigFactory.create(BrowserStackConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities(); // todo move to UiAutomator2Options

        // Set your access credentials
        caps.setCapability("browserstack.user", browserStackConfig.browserstackUser());
        caps.setCapability("browserstack.key", browserStackConfig.browserstackKey());

        // Set URL of the application under test
        caps.setCapability("app", browserStackConfig.app());

        // Specify device and os_version for testing
        caps.setCapability("device", browserStackConfig.device());
        caps.setCapability("os_version", browserStackConfig.osVersion());

        // Set other BrowserStack capabilities
        caps.setCapability("project", browserStackConfig.project());
        caps.setCapability("build", browserStackConfig.build());
        caps.setCapability("name", browserStackConfig.name());

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL(browserStackConfig.baseUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
