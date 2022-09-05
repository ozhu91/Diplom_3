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
import ui.model.RecoveryPage;
import ui.model.RegistrationPage;

import static com.codeborne.selenide.Selenide.*;

public class LoginTest {
    String url = "https://stellarburgers.nomoreparties.site/";

    String email = "zhumzhum@mail.ru";

    String password = "123456";

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
        mainPage.clickButtonLoginFromMainPage();
        LoginPage loginPage = new LoginPage();
        loginPage.waitingLoginPage();
        loginPage.fillFormLogin(email, password);
        loginPage.clickButtonEnterFromLoginPage();
        MainPage mainPageWithUser = new MainPage();
        mainPageWithUser.waitingMainPage();
        Assert.assertEquals(url, webdriver().object().getCurrentUrl());
    }

    @Test
    @Description("Проверка входа через кнопку 'Личный кабинет'")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckLoginUserFromButtonAccount() {
        MainPage mainPage = Selenide.open(url, MainPage.class);
        mainPage.clickLinkAccountFromMainPage();
        LoginPage loginPage = new LoginPage();
        loginPage.waitingLoginPage();
        loginPage.fillFormLogin(email, password);
        loginPage.clickButtonEnterFromLoginPage();
        MainPage mainPageWithUser = new MainPage();
        mainPageWithUser.waitingMainPage();
        Assert.assertEquals(url, webdriver().object().getCurrentUrl());
    }

    @Test
    @Description("Проверка входа через кнопку в форме регистрации")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckLoginUserFromRegistrationPage() {
        RegistrationPage regPage = Selenide.open(url + "register", RegistrationPage.class);
        regPage.clickLinkFromRegistryPage();
        LoginPage loginPage = new LoginPage();
        loginPage.waitingLoginPage();
        loginPage.fillFormLogin(email, password);
        loginPage.clickButtonEnterFromLoginPage();
        MainPage mainPageWithUser = new MainPage();
        mainPageWithUser.waitingMainPage();
        Assert.assertEquals(url, webdriver().object().getCurrentUrl());
    }

    @Test
    @Description("Проверка входа через кнопку в форме восстановления пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckLoginUserFromRecoveryPage() {
        RecoveryPage recoveryPage = Selenide.open(url + "forgot-password", RecoveryPage.class);
        recoveryPage.clickLinkFromRecoveryPage();
        LoginPage loginPage = new LoginPage();
        loginPage.waitingLoginPage();
        loginPage.fillFormLogin(email, password);
        loginPage.clickButtonEnterFromLoginPage();
        MainPage mainPageWithUser = new MainPage();
        mainPageWithUser.waitingMainPage();
        Assert.assertEquals(url, webdriver().object().getCurrentUrl());
    }
}
