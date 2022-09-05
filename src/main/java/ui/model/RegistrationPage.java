package ui.model;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RegistrationPage {

    private SelenideElement buttonRegistration = $(byText("Зарегистрироваться"));

    private SelenideElement inputSectionName = $$(byXpath("//fieldset")).get(0);

    private SelenideElement inputName = this.inputSectionName.$(byClassName("input__textfield"));

    private SelenideElement inputSectionEmail = $$(byXpath("//fieldset")).get(1);

    private SelenideElement inputEmail = this.inputSectionEmail.$(byClassName("input__textfield"));

    private SelenideElement inputSectionPassword = $$(byXpath("//fieldset")).get(2);

    private SelenideElement inputPassword = this.inputSectionPassword.$(byClassName("input__textfield"));

    private SelenideElement linkLogin = $(byText("Войти"));

    private SelenideElement textError = $(byClassName("input__error"));

    @Step("Получение елемента ошибки форме регистрации")
    public SelenideElement getTextError() {
        return textError;
    }

    @Step("Ввод Имени, пароля и email в форму регистрации")
    public void fillFormRegistration(String name, String email, String password) {
        this.inputName.setValue(name);
        this.inputEmail.setValue(email);
        this.inputPassword.setValue(password);
    }

    @Step("Клик по ссылке 'Войти' со страницы регистрации")
    public void clickLinkFromRegistryPage() {
        this.linkLogin.click();
    }

    @Step("Клик по кнопке 'Зарегистрироваться' со страницы регистрации")
    public void clickButtonRegistrationRegistryPage() {
        this.buttonRegistration.click();
    }

}
