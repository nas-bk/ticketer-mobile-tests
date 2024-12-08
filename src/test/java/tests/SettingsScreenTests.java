package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import screen.SettingsScreen;

import static io.qameta.allure.Allure.step;

@Feature("Тестирование стартовой страницы настроек после запуска приложения")
public class SettingsScreenTests extends TestBase {
    final SettingsScreen settingsScreen = new SettingsScreen();

    @Test
    @Owner("Bochkareva Anastasia")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Тестирование сохранение настроек с незаполненным обязательным полем")
    void NotClickableButtonIfSettingsWasEmpty() {
        step("Ввести значения полей deviceId, apiKey, parkId.", () ->
                settingsScreen.setBaseUrl("")
                        .setDeviceId(settingsData.getDeviceId())
                        .setApiKey(settingsData.getKey())
                        .setParkId(settingsData.getParkId()));

        step("Проверить неактивность кнопки Сохранить", () ->
                settingsScreen.checkSaveBtnIsNotEnabled());
    }

    @Test
    @Owner("Bochkareva Anastasia")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Тестирование кнопки Проверить обновление")
    void openUpdateAppDialogTest() {
        settingsScreen.clickUpdateBtn();

        step("Проверить открытие popup", () ->
                settingsScreen.checkUpdatePopupIsDisplayed());
    }
}
