package ui.model;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RecoveryPage {

    private SelenideElement linkLogin = $(byText("Войти"));

    @Step("Клик по ссылке 'Войти' со страницы восстановления пароля")
    public void clickLinkFromRecoveryPage() {
        this.linkLogin.click();
    }
}
