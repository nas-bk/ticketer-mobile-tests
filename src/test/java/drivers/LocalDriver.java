package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.LocalMobileConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;

public class LocalDriver implements WebDriverProvider {

    public static LocalMobileConfig localConfig = ConfigFactory.create(LocalMobileConfig.class, System.getProperties());

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setPlatformVersion(localConfig.getPlatformVersion())
                .setDeviceName(localConfig.getDeviceName())
                .setApp(getAppPath())
                .setAppPackage(localConfig.getAppPackage())
                .setAppActivity(localConfig.getAppActivity());

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    public static URL getAppiumServerUrl() {
        try {
            return new URL(localConfig.getAppiumServer());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private String getAppPath() {
        String appPath = localConfig.getAppPath();

        File app = new File(appPath);
        return app.getAbsolutePath();
    }
}
