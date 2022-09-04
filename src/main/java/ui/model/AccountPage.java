package ui.model;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AccountPage {

    private SelenideElement linkProfile = $(byText("Профиль"));

    private SelenideElement linkHistory = $(byText("История заказов"));

    private SelenideElement buttonLogout = $(byText("Выход"));

    private SelenideElement textAccountText = $(byClassName("Account_text__fZAIn"));

    private SelenideElement linkConstructor = $(byText("Конструктор"));

    public SelenideElement getLinkProfile() {
        return linkProfile;
    }

    public SelenideElement getLinkHistory() {
        return linkHistory;
    }

    public SelenideElement getButtonLogout() {
        return buttonLogout;
    }

    public SelenideElement getTextAccountText() {
        return textAccountText;
    }

    public SelenideElement getLinkConstructor() {
        return linkConstructor;
    }
}
