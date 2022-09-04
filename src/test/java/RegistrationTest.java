import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ui.model.RegistrationPage;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest {

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
        registrationPage.fillFormRegistration("Oleg", "zhum91@email.ru", "123456");
        registrationPage.getButtonRegistration().click();
        registrationPage.waitForLoadLoginPage();
        $(byClassName("Auth_login__3hAey")).shouldBe(Condition.visible);
        sleep(1000);
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/login", webdriver().object().getCurrentUrl());
    }

    @Test
    @Description("Регистрация нового пользователя с ошибкой пароля")
    @Severity(SeverityLevel.NORMAL)
    public void CheckRegistrationUserUncorrect() {
        RegistrationPage registrationPage = open("https://stellarburgers.nomoreparties.site/register", RegistrationPage.class);
        registrationPage.fillFormRegistration("Oleg", "zhum91@email.ru", "11");
        registrationPage.getButtonRegistration().click();
        $(byClassName("input__error")).should(Condition.exist);
        $(byClassName("input__error")).shouldBe(Condition.visible);
        $(byClassName("input__error")).text().equals("Некорректный пароль");
        Assert.assertEquals("https://stellarburgers.nomoreparties.site/register", webdriver().object().getCurrentUrl());
    }
}
