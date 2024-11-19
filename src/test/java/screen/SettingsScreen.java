package screen;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;

public class SettingsScreen {

    private final SelenideElement BASE_URL_ELEMENT = $(id("com.edicult.ticketingsystem:id/baseUrl")),
            DEVICE_ID_ELEMENT = $(id("com.edicult.ticketingsystem:id/deviceId")),
            API_KEY_ELEMENT = $(id("com.edicult.ticketingsystem:id/apiKey")),
            PARK_ID_ELEMENT = $(id("com.edicult.ticketingsystem:id/parkId")),
            UPDATE_APP_BUTTON = $(id("com.edicult.ticketingsystem:id/updateApp")),
            SAVE_SETTINGS_BUTTON = $(id("com.edicult.ticketingsystem:id/saveSettings"));
    public final SelenideElement SAVE_BUTTON = $(id("com.edicult.ticketingsystem:id/saveSettings")),
            UPDATE_POPUP = $(className("android.widget.LinearLayout"));

    @Step("Установить {0} для поля 'Базовый адрес' ")
    public SettingsScreen setBaseUrl(String value) {
        BASE_URL_ELEMENT.sendKeys(value);
        return this;
    }

    @Step("Установить '{0}' для поля 'Код устройства' ")
    public SettingsScreen setDeviceId(String value) {
        DEVICE_ID_ELEMENT.sendKeys(value);
        return this;
    }

    @Step("Установить {0} для поля 'Api key' ")
    public SettingsScreen setApiKey(String value) {
        API_KEY_ELEMENT.sendKeys(value);
        return this;
    }

    @Step("Установить {0} для поля 'Код парка' ")
    public SettingsScreen setParkId(String value) {
        PARK_ID_ELEMENT.sendKeys(value);
        return this;
    }

    @Step("Нажать на конпку 'Проверить обновления' ")
    public SettingsScreen clickUpdateBtn() {
        UPDATE_APP_BUTTON.click();
        return this;
    }

    public SettingsScreen clickSaveBtn() {
        SAVE_SETTINGS_BUTTON.click();
        return this;
    }

    public SettingsScreen checkSaveButIsEnabled() {
        SAVE_SETTINGS_BUTTON.shouldBe(Condition.enabled);
        return this;
    }
}
