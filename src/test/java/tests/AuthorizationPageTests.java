package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import screen.AuthorizationScreen;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тестирование экрана авторизации")
public class AuthorizationPageTests extends TestBase {

    AuthorizationScreen authScreen = new AuthorizationScreen();
    private static final String
            ERROR_TEXT = "Неверные данные для входа. Попробуйте войти в профиль еще раз или обратитесь к администратору.",
            ERROR_TITLE = "Ошибка";

    @Test
    @DisplayName("Проверить авторизацию с неверными данными")
    void unsuccessfulAuthorizationTest() {
        authScreen.setSettings(
                        testData.baseUrl,
                        testData.deviceId,
                        testData.apiKey,
                        testData.parkId)
                .setEmployeePhone(testData.employeePhone)
                .setEmployeePassword(testData.employeePassword)
                .clickLoginButton();

        step("Проверить, что открылся popup", () ->
                assertThat(authScreen.LOGIN_POPUP.isDisplayed()).isTrue());
        step("Проверить, что в popup содержится текст ошибки", () -> {
            assertThat(authScreen.ERROR_DIALOG_TITLE.getText())
                    .isEqualTo(ERROR_TITLE);
            assertThat(authScreen.DIALOG_MESSAGE.getText())
                    .isEqualTo(ERROR_TEXT);
        });
    }

    @Test
    @DisplayName("Проверить авторизацию с пустыми данными")
    void unsuccessfulAuthorization2Test() {
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
