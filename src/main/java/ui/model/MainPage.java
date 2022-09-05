package ui.model;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement tabConstructorBun = $$(byClassName("tab_tab__1SPyG")).get(0);

    private SelenideElement tabConstructorSouce = $$(byClassName("tab_tab__1SPyG")).get(1);

    private SelenideElement tabConstructorTopping = $$(byClassName("tab_tab__1SPyG")).get(2);

    private SelenideElement buttonLogin = $(byText("Войти в аккаунт"));

    private SelenideElement textBurgerConstructorText = $(byText("Соберите бургер"));

    private SelenideElement linkAccount = $(byText("Личный Кабинет"));

    @Step("Получение селектора Таба Булки в кострукторе")
    public SelenideElement getTabConstructorBun() {
        return tabConstructorBun;
    }

    @Step("Получение селектора ссылки на переход в личный кабинет")
    public SelenideElement getLinkAccount() {
        return linkAccount;
    }

    @Step("Получение селектора Таба Соусы в кострукторе")
    public SelenideElement getTabConstructorSouce() {
        return tabConstructorSouce;
    }

    @Step("Получение селектора Таба Начинки в кострукторе")
    public SelenideElement getTabConstructorTopping() {
        return tabConstructorTopping;
    }

    @Step("Получение селектора заголовка в кострукторе")
    public SelenideElement getTextBurgerConstructorText() {
        return textBurgerConstructorText;
    }

    @Step("Ожидание  селектора активации необходимого таба")
    public void waitingToppingTabActivate(SelenideElement tab) {
        tab.shouldHave(Condition.cssClass("tab_tab_type_current__2BEPc"));
    }

    @Step("Ожидание загрузки главной страницы")
    public void waitingMainPage() {
        textBurgerConstructorText.shouldBe(Condition.visible);
    }

    @Step("Клик по ссылке 'Конструктор'")
    public void clickLinkAccountFromMainPage() {
        this.linkAccount.click();
    }

    @Step("Клик по кнопке 'Войти'")
    public void clickButtonLoginFromMainPage() {
        this.buttonLogin.click();
    }

    @Step("Клик по табу с помощью исполнителя Javascript")
    public void clickTabWithJavascriptExecutor(int tabNumber) {
        Selenide.executeJavaScript("document.querySelectorAll('.tab_tab__1SPyG')["+ tabNumber + "].click();");
    }







}
