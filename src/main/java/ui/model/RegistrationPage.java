package ui.model;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

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

    public SelenideElement getButtonRegistration() {
        return buttonRegistration;
    }

    public void fillFormRegistration(String name, String email, String password) {
        this.inputName.setValue(name);
        this.inputEmail.setValue(email);
        this.inputPassword.setValue(password);
    }

    public void waitForLoadLoginPage(){
        $(byClassName("Auth_login__3hAey")).should(Condition.exist);
    }

    public SelenideElement getLinkLogin() {
        return linkLogin;
    }
}
