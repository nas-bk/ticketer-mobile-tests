package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import drivers.LocalDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import models.SettingsModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static helpers.FileReader.readSettingsJson;

public class TestBase {
    public static String deviceHost = System.getProperty("deviceHost");
    public static SettingsModel settingsData = new SettingsModel();

    @BeforeAll
    static void beforeAll() {
        switch (deviceHost) {
            case "browserstack":
                Configuration.browser = BrowserstackDriver.class.getName();
                break;
            case "emulation":
                Configuration.browser = LocalDriver.class.getName();
                break;
            default:
                Configuration.browser = BrowserstackDriver.class.getName();
        }
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
        settingsData = readSettingsJson("settingsData.json");

    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = Selenide.sessionId().toString();
        Attach.screenshotAs("last screenshot" + sessionId);
        Attach.pageSource();

        closeWebDriver();

        if (deviceHost.equals("browserstack")) {
            Attach.addVideo(sessionId);
        }
    }
}
