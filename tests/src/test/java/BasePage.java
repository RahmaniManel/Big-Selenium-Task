
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    // WebDriver instance to interact with the browser
    protected WebDriver driver;
    // WebDriverWait instance to wait for conditions
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        // Initialize WebDriverWait with a 10-second timeout
        wait = new WebDriverWait(driver, 10);
    }

    // Method to wait for an element to be visible and then return it
    protected WebElement waitAndReturnElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    }

    // Method to fill an input text field
    protected void fillInputTextField(By locator, String text) {
        WebElement element = waitAndReturnElement(locator);
        element.clear(); // Clear any existing text in the input field
        element.sendKeys(text); // Enter the specified text
    }

    // Method to click on an element
    protected void clickElement(By locator) {
        WebElement element = waitAndReturnElement(locator);
        element.click(); // Click the element
    }
}

