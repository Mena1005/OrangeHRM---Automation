package tests;
import base.BaseTest;

import java.time.Duration;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.DashboardPage;
import utilities.InputData;
import utilities.SeliniumUtils;
 
public class LoginTest extends BaseTest {
    @Test
    public void verifyLoginFunctionality() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.getPageUrl().contains("login"));
        loginPage.login(InputData.USERNAME, InputData.PASSWORD);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@alt='orangehrm-logo'])[2]")));
        SeliniumUtils.takeScreenshot(driver, "Login_Step");
        loginPage.login_button();
 
        DashboardPage dashboard = new DashboardPage(driver);
        Assert.assertTrue(dashboard.isWelcomeDisplayed());
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10*1000));
        SeliniumUtils.takeScreenshot(driver, "Successful_Login");
    }
}