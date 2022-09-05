package ui.model;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginPage {

    private SelenideElement buttonLoginLP = $(byText("Войти"));

    private SelenideElement inputSectionEmail = $$(byXpath("//fieldset")).get(0);

    private SelenideElement inputEmail = this.inputSectionEmail.$(byClassName("input__textfield"));

    private SelenideElement inputSectionPassword = $$(byXpath("//fieldset")).get(1);

    private SelenideElement inputPassword = this.inputSectionPassword.$(byClassName("input__textfield"));

    private SelenideElement textHeaderLogin = $(byCssSelector(".Auth_login__3hAey")).$(byText("Вход"));

    @Step("Ввод Имени и пароля в форму входа")
    public void fillFormLogin(String email, String password) {
        this.inputEmail.setValue(email);
        this.inputPassword.setValue(password);
    }

    @Step("Клик по кнопке 'Войти' со страницы логина")
    public void clickButtonEnterFromLoginPage() {
        this.buttonLoginLP.click();
    }

    @Step("Ожидание загрузки страницы входа")
    public void waitingLoginPage() {
        this.textHeaderLogin.shouldBe(Condition.visible);
    }
}
