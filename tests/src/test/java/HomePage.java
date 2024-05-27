import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;

public class HomePage extends BasePage {
    // Array of URLs for different sections of the website
    String[] pageUrls = {"https://demo.nopcommerce.com/computers", "https://demo.nopcommerce.com/books", "https://demo.nopcommerce.com/faq"};

    // Locators for the navigation bar, email input field, and submit button
    private final By navbarLocator = By.xpath("//div[@class='header-upper']");
    private final By conactInput = By.xpath("//input[@id='newsletter-email']");
    private final By submitButton = By.xpath("//button[@id='newsletter-subscribe-button']");

    // Constructor for the HomePage class
    public HomePage(WebDriver driver) {
        // Call the constructor of the BasePage class
        super(driver);
        // Navigate to the home page
        this.driver.get("https://demo.nopcommerce.com");
    }

    // Method to get the text from the navigation bar
    public String getNavbarText() {
        WebElement navbarElement = waitAndReturnElement(navbarLocator);
        return navbarElement.getText(); // Return the text of the navigation bar
    }

    // Method to set the email in the newsletter subscription input field
    public void setEmail(String email) {
        WebElement emailElement = waitAndReturnElement(conactInput);
        emailElement.click();
        emailElement.sendKeys(email); // Enter the specified email
    }

    // Method to click the submit button for the newsletter subscription
    public void clickSubmit() {
        WebElement submitElement = waitAndReturnElement(submitButton);
        submitElement.click(); // Click the submit button
    }
}

