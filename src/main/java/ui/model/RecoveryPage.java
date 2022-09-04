package ui.model;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RecoveryPage {

    private SelenideElement linkLogin = $(byText("Войти"));

    public SelenideElement getLinkLogin() {
        return linkLogin;
    }

}
