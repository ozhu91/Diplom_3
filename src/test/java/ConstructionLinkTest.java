import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ui.model.AccountPage;
import ui.model.LoginPage;
import ui.model.MainPage;

import static com.codeborne.selenide.Selenide.webdriver;

public class ConstructionLinkTest {

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
    @Description("Проверка входа в личный кабинет авторизованного пользователя")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckLinkAccountWithAuth() {
        LoginPage loginPage = Selenide.open(url + "login", LoginPage.class);;
        loginPage.fillFormLogin(email, password);
        loginPage.clickButtonEnterFromLoginPage();
        MainPage mainPage = new MainPage();
        mainPage.waitingMainPage();
        mainPage.clickLinkAccountFromMainPage();
        AccountPage accountPage = new AccountPage();
        accountPage.waitingAccountPage();
        accountPage.clickLinkConstructorFromAccountPage();
        MainPage mainPageWithAuth = new MainPage();
        mainPage.waitingMainPage();
        mainPageWithAuth.getTextBurgerConstructorText().shouldBe(Condition.visible);
        Assert.assertEquals(url, webdriver().object().getCurrentUrl());
    }
}
