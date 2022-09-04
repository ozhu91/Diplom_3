import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ui.model.MainPage;

import static com.codeborne.selenide.Selenide.sleep;

public class ConstructorTabTest {

    String url = "https://stellarburgers.nomoreparties.site/";

    @Before
    public void beforeMethod() {
        Selenide.closeWebDriver();
    }

    @Test
    @Description("Проверка перехода к разделу Булки в конструкторе")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckTabConstructorBun() {
        MainPage mainPage = Selenide.open(url, MainPage.class);
        Selenide.executeJavaScript("document.querySelectorAll('.tab_tab__1SPyG')[0].click();");
        sleep(500);
        Assert.assertTrue(mainPage.getTabConstructorBun().getAttribute("class").contains("tab_tab_type_current__2BEPc"));
    }

    @Test
    @Description("Проверка перехода к разделу Соусы в конструкторе")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckTabConstructorSouce() {
        MainPage mainPage = Selenide.open(url, MainPage.class);
        Selenide.executeJavaScript("document.querySelectorAll('.tab_tab__1SPyG')[1].click();");
        sleep(500);
        Assert.assertTrue(mainPage.getTabConstructorSouce().getAttribute("class").contains("tab_tab_type_current__2BEPc"));
    }

    @Test
    @Description("Проверка перехода к разделу Начинки в конструкторе")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckTabConstructorTopping() {
        MainPage mainPage = Selenide.open(url, MainPage.class);
        Selenide.executeJavaScript("document.querySelectorAll('.tab_tab__1SPyG')[2].click();");
        sleep(500);
        Assert.assertTrue(mainPage.getTabConstructorTopping().getAttribute("class").contains("tab_tab_type_current__2BEPc"));
    }
}
