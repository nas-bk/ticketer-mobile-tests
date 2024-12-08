package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import screen.AuthorizationScreen;

import static io.qameta.allure.Allure.step;

@Feature("Тестирование экрана авторизации")
public class AuthorizationPageTests extends TestBase {
    final AuthorizationScreen authScreen = new AuthorizationScreen();

    @Test
    @Owner("Bochkareva Anastasia")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Тестирование авторизации с неверным логином и паролем")
    void unsuccessfulAuthorizationTest() {
        authScreen.setSettings(
                        settingsData.getBaseUrl(),
                        settingsData.getDeviceId(),
                        settingsData.getKey(),
                        settingsData.getParkId())
                .setEmployeePhone(settingsData.getEmployee().getPhone())
                .setEmployeePassword(settingsData.getEmployee().getPassword())
                .clickLoginButton();

        step("Проверить открытие popup", () ->
                authScreen.checkPopupIsDisplayed());
        step("Проверить наличие текста ошибки в popup", () ->
                authScreen.checkErrorText());

    }

    @Test
    @Owner("Bochkareva Anastasia")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Тестирование авторизации с пустыми значениями логина и пароля")
    void unsuccessfulAuthWithEmptyDataTest() {
        authScreen.setSettings(
                        settingsData.getBaseUrl(),
                        settingsData.getDeviceId(),
                        settingsData.getKey(),
                        settingsData.getParkId())
                .setEmployeePhone("")
                .setEmployeePassword("")
                .clickLoginButton();

        step("Проверить, что кнопка Авторизоваться неактивна", () ->
                authScreen.checkLoginBtnIsNotEnabled());
    }
}
