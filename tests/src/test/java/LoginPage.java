import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;

public class LoginPage extends BasePage {
    // Locators for email input field, password input field, and submit button
    private final By emailInput = By.xpath("//input[@type='email' and @name='Email']");
    private final By passwordInput = By.xpath("//input[@type='password' and @name='Password']");
    private final By submitButton = By.xpath("//button[@class='button-1 login-button' and text()='Log in']");

    // Constructor for the LoginPage class
    public LoginPage(WebDriver driver) {
        // Call the constructor of the BasePage class
        super(driver);
        // Navigate to the login page
        this.driver.get("https://demo.nopcommerce.com/login");
    }

    // Method to set the email in the email input field
    public void setEmail(String email) {
        WebElement emailElement = waitAndReturnElement(emailInput);
        emailElement.click();
        emailElement.sendKeys(email);
    }

    // Method to set the password in the password input field
    public void setPassword(String password) {
        WebElement passwordElement = waitAndReturnElement(passwordInput);
        passwordElement.click();
        passwordElement.sendKeys(password);
    }

    // Method to click the submit button
    public void clickSubmit() {
        WebElement submitElement = waitAndReturnElement(submitButton);
        submitElement.click();
    }

}

