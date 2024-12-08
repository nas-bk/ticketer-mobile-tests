package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {
    public static final BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("browserstack.user", browserstackConfig.getUserName());
        caps.setCapability("browserstack.key", browserstackConfig.getKey());

        caps.setCapability("app", browserstackConfig.getApp());
        caps.setCapability("device", browserstackConfig.getDeviceName());
        caps.setCapability("os_version", browserstackConfig.getPlatformVersion());

        caps.setCapability("project", browserstackConfig.getProjectName());
        caps.setCapability("build", browserstackConfig.getBuildName());
        caps.setCapability("name", "test " + browserstackConfig.getDeviceName());

        try {
            return new RemoteWebDriver(
                    new URL(browserstackConfig.getRemoteUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
