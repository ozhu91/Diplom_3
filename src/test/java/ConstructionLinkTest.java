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

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.webdriver;

public class ConstructionLinkTest {

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
        accountPage.getLinkConstructor().click();
        sleep(1500);
        MainPage mainPageWithAuth = new MainPage();
        Assert.assertEquals(url, webdriver().object().getCurrentUrl());
        mainPageWithAuth.getTextBurgerConstructorText().shouldBe(Condition.visible);
    }
}
