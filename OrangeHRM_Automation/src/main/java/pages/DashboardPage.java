package pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class DashboardPage {
    private WebDriver driver;
 
    private By welcomeText = By.className("oxd-userdropdown-name");
    private By myInfoLink = By.xpath("//span[text()='My Info']");
 
    public DashboardPage(WebDriver driver) { this.driver = driver; }
 
    public boolean isWelcomeDisplayed() {
        return driver.findElement(welcomeText).isDisplayed();
    }
 
    public void clickMyInfo() {
        driver.findElement(myInfoLink).click();
    }
}