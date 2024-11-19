package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import screen.SettingsScreen;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тестирование экрана настроек")
public class SettingsScreenTests extends TestBase {

    SettingsScreen settingsScreen = new SettingsScreen();

    @Test
    @DisplayName("Проверить, что кнопка 'Сохранить' неактивна, если поле Базовый адрес незаполнено")
    void unclickableButtonIfSettingsWasEmpty() {

        step("Ввести значения настроек deviceId, apiKey, parkId.", () ->
                settingsScreen.setBaseUrl("")
                        .setDeviceId(testData.deviceId)
                        .setApiKey(testData.apiKey)
                        .setParkId(testData.parkId));

        step("Проверить, что кнопка Сохранить неактивна", () ->
                assertThat(settingsScreen.SAVE_BUTTON.isEnabled())
                        .isFalse());
    }

    @Test
    @DisplayName("Проверить открытия popup с информацией о доступном обновлении")
    void openUpdateAppDialogTest() {
        settingsScreen.clickUpdateBtn();

        step("Проверить, что открылся popup", () ->
                assertThat(settingsScreen.UPDATE_POPUP.isDisplayed())
                        .isTrue());
    }
}
