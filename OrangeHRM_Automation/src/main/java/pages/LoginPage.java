package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class LoginPage {
    private WebDriver driver;
 
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("//button[@type='submit']");
 
    public LoginPage(WebDriver driver) { this.driver = driver; }
 
    public void login(String user, String pass) {
        driver.findElement(usernameField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(pass);  
    }
    
    public void login_button() {
    	
    	driver.findElement(loginButton).click();
    	}
    
    public String getPageTitle() { return driver.getTitle(); }
    public String getPageUrl() { return driver.getCurrentUrl(); }
}