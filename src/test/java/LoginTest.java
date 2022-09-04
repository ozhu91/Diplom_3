import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ui.model.LoginPage;
import ui.model.MainPage;
import ui.model.RegistrationPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LoginTest {
    String url = "https://stellarburgers.nomoreparties.site/";

    @Before
    public void beforeMethod() {
        Selenide.closeWebDriver();
    }

    @After
    public void  methodAfter() {
        Selenide.closeWebDriver();
    }

    @Test
    @Description("Проверка входа по кнопке 'Войти в аккаунт на главной'")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckLoginUserFromButtonLogin() {
        MainPage mainPage = Selenide.open(url, MainPage.class);
        mainPage.getButtonLogin().click();
        sleep(1500);
        Assert.assertEquals(url + "login", webdriver().object().getCurrentUrl());
        LoginPage loginPage = new LoginPage();
        loginPage.fillFormLogin("zhumzhum@mail.ru", "123456");
        loginPage.getButtonLoginLP().click();
        sleep(1500);
        $(byText("Оформить заказ")).shouldBe(Condition.visible);
        Assert.assertEquals(url, webdriver().object().getCurrentUrl());
        Selenide.closeWebDriver();
    }

    @Test
    @Description("Проверка входа через кнопку 'Личный кабинет'")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckLoginUserFromButtonAccount() {
        MainPage mainPage = Selenide.open(url, MainPage.class);
        mainPage.getLinkAccount().click();
        sleep(1500);
        Assert.assertEquals(url + "login", webdriver().object().getCurrentUrl());
        LoginPage loginPage = new LoginPage();
        loginPage.fillFormLogin("zhumzhum@mail.ru", "123456");
        loginPage.getButtonLoginLP().click();
        sleep(1500);
        $(byText("Оформить заказ")).shouldBe(Condition.visible);
        Assert.assertEquals(url, webdriver().object().getCurrentUrl());
        Selenide.closeWebDriver();
    }

    @Test
    @Description("Проверка входа через кнопку в форме регистрации")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckLoginUserFromRegistrationPage() {
        RegistrationPage regPage = Selenide.open(url + "register", RegistrationPage.class);
        regPage.getLinkLogin().click();
        sleep(1500);
        Assert.assertEquals(url + "login", webdriver().object().getCurrentUrl());
        LoginPage loginPage = new LoginPage();
        loginPage.fillFormLogin("zhumzhum@mail.ru", "123456");
        loginPage.getButtonLoginLP().click();
        sleep(1500);
        $(byText("Оформить заказ")).shouldBe(Condition.visible);
        Assert.assertEquals(url, webdriver().object().getCurrentUrl());
        Selenide.closeWebDriver();
    }

    @Test
    @Description("Проверка входа через кнопку в форме восстановления пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckLoginUserFromRecoveryPage() {
        RegistrationPage recoveryPage = Selenide.open(url + "forgot-password", RegistrationPage.class);
        recoveryPage.getLinkLogin().click();
        sleep(1500);
        Assert.assertEquals(url + "login", webdriver().object().getCurrentUrl());
        LoginPage loginPage = new LoginPage();
        loginPage.fillFormLogin("zhumzhum@mail.ru", "123456");
        loginPage.getButtonLoginLP().click();
        sleep(1500);
        $(byText("Оформить заказ")).shouldBe(Condition.visible);
        Assert.assertEquals(url, webdriver().object().getCurrentUrl());
        Selenide.closeWebDriver();
    }
}
