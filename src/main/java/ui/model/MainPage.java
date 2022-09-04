package ui.model;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement tabConstructorBun = $$(byClassName("tab_tab__1SPyG")).get(0);

    private SelenideElement linkConstructorBun = $(byText("Булки"));

    private SelenideElement tabConstructorSouce = $$(byClassName("tab_tab__1SPyG")).get(1);

    private SelenideElement linkConstructorSouce = $(byText("Соусы"));

    private SelenideElement tabConstructorTopping = $$(byClassName("tab_tab__1SPyG")).get(2);

    private SelenideElement linkConstructorTopping = $(byText("Начинки"));

    private SelenideElement ButtonLogin = $(byText("Войти в аккаунт"));

    private SelenideElement textBurgerConstructorText = $(byText("Соберите бургер"));

    private SelenideElement linkAccount = $(byText("Личный Кабинет"));

    public SelenideElement getButtonLogin() {
        return ButtonLogin;
    }

    public SelenideElement getTabConstructorBun() {
        return tabConstructorBun;
    }

    public SelenideElement getLinkAccount() {
        return linkAccount;
    }

    public SelenideElement getTabConstructorSouce() {
        return tabConstructorSouce;
    }

    public SelenideElement getTabConstructorTopping() {
        return tabConstructorTopping;
    }

    public SelenideElement getTextBurgerConstructorText() {
        return textBurgerConstructorText;
    }

}
