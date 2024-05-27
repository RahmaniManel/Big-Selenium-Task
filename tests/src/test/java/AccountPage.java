
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.net.MalformedURLException;

public class AccountPage extends BasePage {
    // Locator for the logout button
    private final By logoutButton = By.xpath("//a[@class='ico-logout' and @href='/logout']");

    public AccountPage(WebDriver driver) {
        // Call the constructor of the BasePage class
        super(driver);
        // Navigate to the account info page
        this.driver.get("https://demo.nopcommerce.com/customer/info");
    }

    public void logoutSubmit() {
        // Wait for the logout button to be present and return the WebElement
        WebElement logoutElement = waitAndReturnElement(logoutButton);
        // Click the logout button
        logoutElement.click();

        // Wait for the title to contain "nopCommerce demo store" after logging out
        wait.until(ExpectedConditions.titleContains("nopCommerce demo store"));

        // Find the element containing the "Register" link to confirm successful logout
        WebElement registerLink = driver.findElement(By.xpath("//a[@class='ico-register']"));

        // Check if the register link is present and displayed
        if (registerLink != null && registerLink.isDisplayed()) {
            System.out.println("Test Passed: LoginLogout works well!");
        } else {
            System.out.println("Test Failed: Error occured");
        }
    }
}

