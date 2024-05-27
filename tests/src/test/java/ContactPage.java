import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;

public class ContactPage extends BasePage {
    // Locators for the name input field, email input field, message text area, and submit button
    private final By enquiryname = By.id("FullName");
    private final By enquiryemail = By.id("Email");
    private final By enquiryTextArea = By.id("Enquiry");
    private final By submitButton = By.xpath("//button[@name='send-email' and text()='Submit']");

    // Constructor for the ContactPage class
    public ContactPage(WebDriver driver) {
        // Call the constructor of the BasePage class
        super(driver);
        // Navigate to the contact us page
        this.driver.get("https://demo.nopcommerce.com/contactus"); 
    }

    // Method to set the email in the email input field
    public void setEmail(String email) {
        WebElement enquiryemailelement = waitAndReturnElement(enquiryemail);
        enquiryemailelement.click();
        enquiryemailelement.sendKeys(email); // Enter the specified email
    }

    // Method to set the name in the name input field
    public void setName(String name) {
        WebElement enquirynamelement = waitAndReturnElement(enquiryname);
        enquirynamelement.click();
        enquirynamelement.sendKeys(name); // Enter the specified name
    }

    // Method to set the message in the message text area
    public void setMessage(String message) {
        WebElement enquiryTextelement = waitAndReturnElement(enquiryTextArea);
        enquiryTextelement.click();
        enquiryTextelement.sendKeys(message); // Enter the specified message
    }

    // Method to click the submit button
    public void clickSubmit() {
        WebElement submitElement = waitAndReturnElement(submitButton);
        submitElement.click(); // Click the submit button
    }
}

