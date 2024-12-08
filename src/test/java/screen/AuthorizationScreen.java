package screen;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;
import static org.assertj.core.api.Assertions.assertThat;

public class AuthorizationScreen {
    private final SelenideElement
            loginPopup = $(className("android.widget.LinearLayout")),
            errorDialogTitle = $(id("com.edicult.ticketingsystem:id/dialogTitle")),
            dialogMessage = $(id("com.edicult.ticketingsystem:id/dialogMessage")),
            loginButton = $(id("com.edicult.ticketingsystem:id/employeeLogin")),
            employeePhoneElement = $(id("com.edicult.ticketingsystem:id/employeePhone")),
            passwordElement = $(id("com.edicult.ticketingsystem:id/employeePassword"));
    private static final String
            ERROR_TEXT = "Неверные данные для входа. Попробуйте войти в профиль еще раз или обратитесь к администратору.",
            ERROR_TITLE = "Ошибка";

    @Step("Сохранить настройки")
    public AuthorizationScreen setSettings(String url, String device, String key, String park) {
        SettingsScreen settings = new SettingsScreen();
        settings.setBaseUrl(url)
                .setDeviceId(device)
                .setApiKey(key)
                .setParkId(park)
                .clickSaveBtn();
        return this;
    }

    @Step("Ввести номер телефона сотрудника")
    public AuthorizationScreen setEmployeePhone(String phone) {
        employeePhoneElement.sendKeys(phone);
        return this;
    }

    @Step("Ввести пароль")
    public AuthorizationScreen setEmployeePassword(String value) {
        passwordElement.sendKeys(value);
        return this;
    }

    @Step("Нажать на кнопку 'Войти' ")
    public AuthorizationScreen clickLoginButton() {
        loginButton.click();
        return this;
    }

    public AuthorizationScreen checkPopupIsDisplayed() {
        assertThat(loginPopup.isDisplayed()).isTrue();
        return this;
    }

    public AuthorizationScreen checkErrorText() {
        assertThat(errorDialogTitle.getText())
                .isEqualTo(ERROR_TITLE);
        assertThat(dialogMessage.getText())
                .isEqualTo(ERROR_TEXT);
        return this;
    }

    public AuthorizationScreen checkLoginBtnIsNotEnabled() {
        assertThat(loginButton.isEnabled())
                .isFalse();
        return this;
    }
}
