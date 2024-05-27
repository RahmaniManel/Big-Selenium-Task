
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.URL;
import java.net.MalformedURLException;

public class SeleniumTest {
    // WebDriver instance to interact with the browser
    private WebDriver driver;
    // ConfigReader instance to read configuration properties
    private ConfigReader configReader;
    // Array of URLs to test different pages on the website
    String[] pageUrls = {"https://demo.nopcommerce.com/desktops", "https://demo.nopcommerce.com/computers"};

    @Before
    public void setup() throws MalformedURLException {
        // Initialize ConfigReader to read properties
        configReader = new ConfigReader();
        ChromeOptions options = new ChromeOptions();
        // Disable popup blocking in Chrome
        options.addArguments("--disable-popup-blocking"); 
        // Set up RemoteWebDriver to connect to Selenium Grid
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        // Maximize the browser window
        driver.manage().window().maximize();
    }

    @Test
    public void TestLoginAccountPage() {
        // Create an instance of LoginPage
        LoginPage loginPage = new LoginPage(driver);

        // Read username and password from the configuration file
        String email = configReader.getProperty("email");
        String password = configReader.getProperty("password");

        // Check if email and password are null, and provide default values if they are
        if (email == null) {
            email = "rahmani@gmail.com";
        }
        if (password == null) {
            password = "test@TEST21";
        }

        // Enter email and password, then submit the login form
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        loginPage.clickSubmit();

        // Create an instance of AccountPage
        AccountPage accountPage = new AccountPage(driver);
        // Logout from the account page
        accountPage.logoutSubmit();
        // Close the browser
        driver.quit();
    }

    @Test
    public void TestContactFormSubmission() {
        // Initialize the ContactPage
        ContactPage contactPage = new ContactPage(driver);

        // Set the contact form fields
        contactPage.setName("Manel");
        contactPage.setEmail("rahmanimanel21@gmail.com");
        contactPage.setMessage("This is a test message.");

        // Submit the contact form
        contactPage.clickSubmit();
        // Wait for the success message to appear
        WebDriverWait wait = new WebDriverWait(driver, 10);
        By successMessageLocator = By.xpath("//div[@class='result']");
        WebElement successMessage = wait.until(ExpectedConditions.presenceOfElementLocated(successMessageLocator));
        // Check if the success message is displayed
        if (successMessage.isDisplayed()) {
            System.out.println("Test Passed: Contact works well ");
        } else {
            System.out.println("Test Failed: Error occured");
        }
    }

    @Test
    public void TestHomePage() {
        // Navigate to the HomePage
        HomePage homePage = new HomePage(driver);
        // Enter email for subscription and submit
        homePage.setEmail("rahmanimanel21@gmail.com");
        homePage.clickSubmit();

        // Wait for the subscription confirmation or error message to appear
        WebDriverWait wait = new WebDriverWait(driver, 30);
        By successMessageLocator = By.xpath("//div[@class='newsletter-result' and @id='newsletter-result-block']"); 
        WebElement successMessage = wait.until(ExpectedConditions.presenceOfElementLocated(successMessageLocator));
        // Check if the subscription success message is displayed
        if (successMessage.isDisplayed()) {
            System.out.println("Test Passed: Subscription works well");
        } else {
            System.out.println("Test Failed: Error occured");
        }
    }

    @Test
    public void TestHistoryPage() {
        // Create an instance of the History class
        History history = new History(driver);
        // Perform history-related tests
        history.performHistoryTest();
    }
    
    @Test
    public void TestMultiplePages() {
        // Test multiple pages by navigating through URLs in pageUrls array
        for (String pageUrl : pageUrls) {
            try {
                System.out.println("pageUrl: " + pageUrl);
                // Navigate to the page URL
                driver.get(pageUrl);
                // Get the page title
                String pageTitle = driver.getTitle();
                System.out.println("pageTitle: " + pageTitle);
                // Verify the page title contains expected text based on URL
                if (pageUrl.equals("https://demo.nopcommerce.com/computers")) {
                    Assert.assertTrue(pageTitle.contains("Computers"));
                } else if (pageUrl.equals("https://demo.nopcommerce.com/desktops")) {
                    Assert.assertTrue(pageTitle.contains("Desktops"));
                } else {
                    // Fail the test if the URL doesn't match any expected condition
                    Assert.fail("Invalid page URL: " + pageUrl);
                }
            } catch (Exception e) {
                // Handle any exceptions that occur during navigation
                System.out.println("Error occurred while navigating to page: " + pageUrl);
                e.printStackTrace();
            }
        }
    }

    @Test
    public void TestCookies() {
        // Navigate to the website
        driver.get("https://demo.nopcommerce.com");
        // Call the method to test cookies
        CookiesTesting.testCookies(driver);
    } 

    @Test
    public void TestSearchPage() {
        // Navigate to the home page
        driver.get("https://demo.nopcommerce.com");
        // Create an instance of SearchPage
        SearchPage searchPage = new SearchPage(driver);
        // Perform a search with the keyword "books"
        String keyword = "books";
        searchPage.typeInSearchBar(keyword + Keys.RETURN);
        // Wait for the search results to load
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlContains(keyword));
        // Validate the search results by checking the current URL
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains(keyword)) {
            System.out.println("Test Passed: Search function works well.");
        } else {
            System.out.println("Test Failed: Error occured");
        }
    }

    @After
    public void close() {
        // Quit the browser if the driver is not null
        if (driver != null) {
            driver.quit();
        }
    }
}

