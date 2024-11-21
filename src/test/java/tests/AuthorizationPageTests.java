package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import screen.AuthorizationScreen;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Feature("Тестирование экрана авторизации")
public class AuthorizationPageTests extends TestBase {

    AuthorizationScreen authScreen = new AuthorizationScreen();
    private static final String
            ERROR_TEXT = "Неверные данные для входа. Попробуйте войти в профиль еще раз или обратитесь к администратору.",
            ERROR_TITLE = "Ошибка";

    @Test
    @Owner("Bochkareva Anastasia")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Тестирование авторизации с неверным логином и паролем")
    void unsuccessfulAuthorizationTest() {
        authScreen.setSettings(
                        testData.baseUrl,
                        testData.deviceId,
                        testData.apiKey,
                        testData.parkId)
                .setEmployeePhone(testData.employeePhone)
                .setEmployeePassword(testData.employeePassword)
                .clickLoginButton();

        step("Проверить открытие popup", () ->
                assertThat(authScreen.LOGIN_POPUP.isDisplayed()).isTrue());
        step("Проверить наличие текста ошибки в popup", () -> {
            assertThat(authScreen.ERROR_DIALOG_TITLE.getText())
                    .isEqualTo(ERROR_TITLE);
            assertThat(authScreen.DIALOG_MESSAGE.getText())
                    .isEqualTo(ERROR_TEXT);
        });
    }

    @Test
    @Owner("Bochkareva Anastasia")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Тестирование авторизации с пустыми значениями логина и пароля")
    void unsuccessfulAuthWithEmptyDataTest() {
        authScreen.setSettings(
                        testData.baseUrl,
                        testData.deviceId,
                        testData.apiKey,
                        testData.parkId)
                .setEmployeePhone("")
                .setEmployeePassword("")
                .clickLoginButton();

        step("Проверить, что кнопка Авторизоваться неактивна", () ->
                assertThat(authScreen.LOGIN_BUTTON.isEnabled())
                        .isFalse());
    }
}
