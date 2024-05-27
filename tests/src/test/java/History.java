import org.openqa.selenium.WebDriver;

public class History {
    // WebDriver instance to interact with the browser
    private WebDriver driver;

    // Constructor for the History class
    public History(WebDriver driver) {
        this.driver = driver;
    }

    // Method to perform the history test
    public void performHistoryTest() {
        // Navigate to the first page (computers)
        driver.navigate().to("https://demo.nopcommerce.com/computers");

        // Navigate to the second page (desktops)
        driver.navigate().to("https://demo.nopcommerce.com/desktops");

        // Navigate back to the first page
        driver.navigate().back();

        // Verify if we are on the first page
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://demo.nopcommerce.com/computers")) {
            System.out.println("Test Passed: History works well!"); // Print success message if URLs match
        } else {
            System.out.println("Test Fail: Error occured"); // Print failure message if URLs don't match
        }

        // Navigate forward to the second page
        driver.navigate().forward();

        // Verify if we are on the second page
        currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://demo.nopcommerce.com/desktops")) {
            System.out.println("Test Passed: Forward history works well!"); // Print success message if URLs match
        } else {
            System.out.println("Test Failed: Error occured"); // Print failure message if URLs don't match
        }
    }
}

