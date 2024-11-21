package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import screen.SettingsScreen;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Feature("Тестирование стартовой страницы настроек после запуска приложения")
public class SettingsScreenTests extends TestBase {
    SettingsScreen settingsScreen = new SettingsScreen();

    @Test
    @Owner("Bochkareva Anastasia")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Тестирование сохранение настроек с незаполненным обязательным полем")
    void unclickableButtonIfSettingsWasEmpty() {

        step("Ввести значения полей deviceId, apiKey, parkId.", () ->
                settingsScreen.setBaseUrl("")
                        .setDeviceId(testData.deviceId)
                        .setApiKey(testData.apiKey)
                        .setParkId(testData.parkId));

        step("Проверить неактивность кнопки Сохранить", () ->
                assertThat(settingsScreen.SAVE_BUTTON.isEnabled())
                        .isFalse());
    }

    @Test
    @Owner("Bochkareva Anastasia")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Тестирование кнопки Проверить обновление")
    void openUpdateAppDialogTest() {
        settingsScreen.clickUpdateBtn();

        step("Проверить открытие popup", () ->
                assertThat(settingsScreen.UPDATE_POPUP.isDisplayed())
                        .isTrue());
    }
}
