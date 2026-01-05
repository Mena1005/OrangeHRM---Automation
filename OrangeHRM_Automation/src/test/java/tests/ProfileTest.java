package tests;
import base.BaseTest;

import java.time.Duration;
 
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.DashboardPage;
import pages.MyInfoPage;
import utilities.InputData;
import utilities.SeliniumUtils;
 
public class ProfileTest extends BaseTest {
    @Test
    public void verifyMyInfoPage() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(InputData.USERNAME, InputData.PASSWORD);
        loginPage.login_button();
        DashboardPage dashboard = new DashboardPage(driver);
        dashboard.clickMyInfo();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='submit'])[1]")));
 
        MyInfoPage myInfo = new MyInfoPage(driver);
        System.out.println("Employee Name: " + myInfo.getFullName());
        System.out.println("Employee ID: " + myInfo.getemployeeId());
        SeliniumUtils.takeScreenshot(driver, "MyInfo_Page");
        myInfo.logout();
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@alt='orangehrm-logo'])[2]")));
        SeliniumUtils.takeScreenshot(driver, "After_Logout");
    }
}