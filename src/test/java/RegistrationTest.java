import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ui.model.LoginPage;
import ui.model.RegistrationPage;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest {
    String name = "Oleg";
    String email = "zhumazay911@email.ru";
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
    @Description("Регистрация нового пользователя")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckRegistrationUser() {
        RegistrationPage registrationPage = open("https://stellarburgers.nomoreparties.site/register", RegistrationPage.class);
        registrationPage.fillFormRegistration(name, email, password);
        registrationPage.clickButtonRegistrationRegistryPage();
        LoginPage loginPage = new LoginPage();
        loginPage.waitingLoginPage();
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/login", webdriver().object().getCurrentUrl());
    }

    @Test
    @Description("Регистрация нового пользователя с ошибкой пароля")
    @Severity(SeverityLevel.NORMAL)
    public void CheckRegistrationUserUncorrect() {
        RegistrationPage registrationPage = open("https://stellarburgers.nomoreparties.site/register", RegistrationPage.class);
        registrationPage.fillFormRegistration(name, email, "11");
        registrationPage.clickButtonRegistrationRegistryPage();
        registrationPage.getTextError().text().equals("Некорректный пароль");
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/register", webdriver().object().getCurrentUrl());
    }
}
