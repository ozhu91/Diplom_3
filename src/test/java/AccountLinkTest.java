import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ui.model.AccountPage;
import ui.model.LoginPage;
import ui.model.MainPage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.webdriver;

public class AccountLinkTest {
    String url = "https://stellarburgers.nomoreparties.site/";

    @Before
    public void beforeMethod() {
        Selenide.closeWebDriver();
    }

    @Test
    @Description("Проверка входа в личный кабинет без авторизации")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckLinkAccountWithoutAuth() {
        MainPage mainPage = Selenide.open(url, MainPage.class);
        mainPage.getLinkAccount().click();
        sleep(1500);
        Assert.assertEquals(url + "login", webdriver().object().getCurrentUrl());
        Selenide.closeWebDriver();
    }

    @Test
    @Description("Проверка входа в личный кабинет авторизованного пользователя")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckLinkAccountWithAuth() {
        LoginPage loginPage = Selenide.open(url + "login", LoginPage.class);;
        loginPage.fillFormLogin("zhumzhum@mail.ru", "123456");
        loginPage.getButtonLoginLP().click();
        sleep(1500);
        MainPage mainPage = new MainPage();
        mainPage.getLinkAccount().click();
        sleep(1500);
        AccountPage accountPage = new AccountPage();
        Assert.assertEquals(url + "account/profile", webdriver().object().getCurrentUrl());
        accountPage.getTextAccountText().shouldBe(Condition.visible);
        accountPage.getLinkHistory().shouldBe(Condition.visible);
        accountPage.getLinkProfile().shouldBe(Condition.visible);
        accountPage.getButtonLogout().shouldBe(Condition.visible);
        Selenide.closeWebDriver();
    }
}
