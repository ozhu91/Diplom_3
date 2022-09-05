package ui.model;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AccountPage {

    private SelenideElement linkProfile = $(byText("Профиль"));

    private SelenideElement linkHistory = $(byText("История заказов"));

    private SelenideElement buttonLogout = $(byText("Выход"));

    private SelenideElement textAccountText = $(byClassName("Account_text__fZAIn"));

    private SelenideElement linkConstructor = $(byText("Конструктор"));

    @Step("Получение элемента ссылки 'Профиль' со страницы аккаунта")
    public SelenideElement getLinkProfile() {
        return linkProfile;
    }

    @Step("Получение элемента ссылки 'История заказов' со страницы аккаунта")
    public SelenideElement getLinkHistory() {
        return linkHistory;
    }

    @Step("Получение элемента кнопки 'Выйти' со страницы аккаунта")
    public SelenideElement getButtonLogout() {
        return buttonLogout;
    }

    @Step("Получение элемента текста 'В этом разделе вы можете изменить свои персональные данные' со страницы аккаунта")
    public SelenideElement getTextAccountText() {
        return textAccountText;
    }

    @Step("Ожидание загрузки страницы Аккаунта")
    public void waitingAccountPage() {
        textAccountText.shouldBe(Condition.visible);
    }

    @Step("Клик по ссылке 'Конструктор'")
    public void clickLinkConstructorFromAccountPage() {
        this.linkConstructor.click();
    }
}
