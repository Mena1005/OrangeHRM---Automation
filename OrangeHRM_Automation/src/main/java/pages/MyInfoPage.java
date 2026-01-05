package pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class MyInfoPage {
    private WebDriver driver;
    private WebDriverWait wait;
 
 
    private By firstName = By.name("firstName");
    private By lastName = By.name("lastName");
    private By middleName = By.name("middleName");
    private By employeeId = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private By userDropdown = By.className("oxd-userdropdown-icon");
    private By logoutLink = By.xpath("//a[text()='Logout']");
 
	
    public MyInfoPage(WebDriver driver) { this.driver = driver; this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); }
 
    public String getFullName() {
    	wait.until(driver -> !driver.findElement(firstName).getAttribute("value").isEmpty());
    	String f1=driver.findElement(firstName).getAttribute("value");
    	String m1=driver.findElement(lastName).getAttribute("value");
    	String l1=driver.findElement(middleName).getAttribute("value");
    	String fullname = f1+" "+m1+" "+l1;
        return fullname;
    }
    public String getemployeeId() {
    	wait.until(driver -> !driver.findElement(employeeId).getAttribute("value").isEmpty());
        return driver.findElement(employeeId).getAttribute("value");
    }
    public void logout() {
        driver.findElement(userDropdown).click();
        driver.findElement(logoutLink).click();
    }
}
