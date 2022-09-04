package ui.model;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginPage {

    private SelenideElement buttonLoginLP = $(byText("Войти"));

    private SelenideElement inputSectionEmail = $$(byXpath("//fieldset")).get(0);

    private SelenideElement inputEmail = this.inputSectionEmail.$(byClassName("input__textfield"));

    private SelenideElement inputSectionPassword = $$(byXpath("//fieldset")).get(1);

    private SelenideElement inputPassword = this.inputSectionPassword.$(byClassName("input__textfield"));

    public void fillFormLogin(String email, String password) {
        this.inputEmail.setValue(email);
        this.inputPassword.setValue(password);
    }

    public SelenideElement getButtonLoginLP() {
        return buttonLoginLP;
    }

    public SelenideElement getInputSectionEmail() {
        return inputSectionEmail;
    }

    public SelenideElement getInputEmail() {
        return inputEmail;
    }

    public SelenideElement getInputSectionPassword() {
        return inputSectionPassword;
    }

    public SelenideElement getInputPassword() {
        return inputPassword;
    }
}
