package screen;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;
import static org.assertj.core.api.Assertions.assertThat;

public class SettingsScreen {
    private final SelenideElement baseUrlElement = $(id("com.edicult.ticketingsystem:id/baseUrl")),
            deviceIdElement = $(id("com.edicult.ticketingsystem:id/deviceId")),
            apiKeyElement = $(id("com.edicult.ticketingsystem:id/apiKey")),
            parkIdElement = $(id("com.edicult.ticketingsystem:id/parkId")),
            updateAppButton = $(id("com.edicult.ticketingsystem:id/updateApp")),
            saveSettingsButton = $(id("com.edicult.ticketingsystem:id/saveSettings")),
            saveButton = $(id("com.edicult.ticketingsystem:id/saveSettings")),
            updatePopup = $(className("android.widget.LinearLayout"));

    @Step("Установить {0} для поля 'Базовый адрес' ")
    public SettingsScreen setBaseUrl(String value) {
        baseUrlElement.sendKeys(value);
        return this;
    }

    @Step("Установить {0} для поля 'Код устройства' ")
    public SettingsScreen setDeviceId(String value) {
        deviceIdElement.sendKeys(value);
        return this;
    }

    @Step("Установить {0} для поля 'Api key' ")
    public SettingsScreen setApiKey(String value) {
        apiKeyElement.sendKeys(value);
        return this;
    }

    @Step("Установить {0} для поля 'Код парка' ")
    public SettingsScreen setParkId(String value) {
        parkIdElement.sendKeys(value);
        return this;
    }

    @Step("Нажать на кнопку 'Проверить обновления' ")
    public SettingsScreen clickUpdateBtn() {
        updateAppButton.click();
        return this;
    }

    @Step("Нажать на кнопку 'Сохранить' ")
    public SettingsScreen clickSaveBtn() {
        saveSettingsButton.shouldBe(enabled).click();
        return this;
    }

    public SettingsScreen checkSaveBtnIsNotEnabled() {
        assertThat(saveButton.isEnabled())
                .isFalse();
        return this;
    }

    public SettingsScreen checkUpdatePopupIsDisplayed() {
        assertThat(updatePopup.isDisplayed())
                .isTrue();
        return this;
    }
}
