import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import ui.model.MainPage;

public class ConstructorTabTest {

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
    @Description("Проверка перехода к разделу Булки в конструкторе")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckTabConstructorBun() {
        MainPage mainPage = Selenide.open(url, MainPage.class);
        mainPage.clickTabWithJavascriptExecutor(0);
        mainPage.waitingToppingTabActivate(mainPage.getTabConstructorBun());
        Assert.assertEquals("Булки", mainPage.getTabConstructorBun().$(By.cssSelector(".text")).getText());
    }

    @Test
    @Description("Проверка перехода к разделу Соусы в конструкторе")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckTabConstructorSouce() {
        MainPage mainPage = Selenide.open(url, MainPage.class);
        mainPage.clickTabWithJavascriptExecutor(1);
        mainPage.waitingToppingTabActivate(mainPage.getTabConstructorSouce());
        Assert.assertEquals("Соусы", mainPage.getTabConstructorSouce().$(By.cssSelector(".text")).getText());
    }

    @Test
    @Description("Проверка перехода к разделу Начинки в конструкторе")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckTabConstructorTopping() {
        MainPage mainPage = Selenide.open(url, MainPage.class);
        mainPage.clickTabWithJavascriptExecutor(2);
        mainPage.waitingToppingTabActivate(mainPage.getTabConstructorTopping());
        Assert.assertEquals("Начинки", mainPage.getTabConstructorTopping().$(By.cssSelector(".text")).getText());
    }
}
