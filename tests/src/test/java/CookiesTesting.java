import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookiesTesting extends BasePage {
    // Constructor for the CookiesTesting class
    public CookiesTesting(WebDriver driver) {
        // Call the constructor of the BasePage class
        super(driver);
    }

    // Method to check if the browser has any cookies
    public static boolean hasCookies(WebDriver driver) {
        // Return true if the browser has cookies, otherwise false
        return !driver.manage().getCookies().isEmpty();
    }

    // Method to test and print cookies
    public static void testCookies(WebDriver driver) {
        // Check if the browser has cookies
        boolean hasCookies = hasCookies(driver);
        // Assert that cookies are present
        assert hasCookies : "No cookies found";

        // Print all cookies
        System.out.println("All Cookies:");
        for (Cookie cookie : driver.manage().getCookies()) {
            String cookieName = cookie.getName(); // Get cookie name
            String cookieValue = cookie.getValue(); // Get cookie value
            System.out.println("Name: " + cookieName); // Print cookie name
            System.out.println("Value: " + cookieValue); // Print cookie value
            System.out.println("---------------------------------"); // Print separator
        }
    }
}

