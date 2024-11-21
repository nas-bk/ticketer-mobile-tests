package screen;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;

public class AuthorizationScreen {
    public final SelenideElement
            LOGIN_POPUP = $(className("android.widget.LinearLayout")),
            ERROR_DIALOG_TITLE = $(id("com.edicult.ticketingsystem:id/dialogTitle")),
            DIALOG_MESSAGE = $(id("com.edicult.ticketingsystem:id/dialogMessage")),
            LOGIN_BUTTON = $(id("com.edicult.ticketingsystem:id/employeeLogin"));
    private final SelenideElement
            EMPLOYEE_PHONE_ELEMENT = $(id("com.edicult.ticketingsystem:id/employeePhone")),
            PASSWORD_ELEMENT = $(id("com.edicult.ticketingsystem:id/employeePassword"));

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
        EMPLOYEE_PHONE_ELEMENT.sendKeys(phone);
        return this;
    }

    @Step("Ввести пароль")
    public AuthorizationScreen setEmployeePassword(String value) {
        PASSWORD_ELEMENT.sendKeys(value);
        return this;
    }

    @Step("Нажать на кнопку 'Войти' ")
    public AuthorizationScreen clickLoginButton() {
        LOGIN_BUTTON.click();
        return this;
    }
}
