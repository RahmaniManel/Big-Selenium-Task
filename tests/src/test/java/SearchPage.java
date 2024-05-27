import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage {
    // Locators for the search button and search input field
    private final By searchBarButton = By.xpath("//button[@class='button-1 search-box-button']");
    private final By searchBarInput = By.xpath("//input[@id='small-searchterms']");

    // Constructor for the SearchPage class
    public SearchPage(WebDriver driver) {
        // Call the constructor of the BasePage class
        super(driver);
    }

    // Method to open the search bar
    public void openSearchBar() {
        // Find the search bar button and click it
        WebElement searchBarOpenButtonElement = waitAndReturnElement(searchBarButton);
        searchBarOpenButtonElement.click();
    }

    // Method to type a string into the search bar
    public void typeInSearchBar(String keys) {
        // Find the search bar input field and send keys to it
        WebElement searchBarElement = waitAndReturnElement(searchBarInput);
        searchBarElement.sendKeys(keys);
    }

    // Method to perform a search and handle the result
    public void doSomeSearch(String keyword) {
        // Enter the keyword into the search input field
        fillInputTextField(searchBarInput, keyword);

        // Click the search button to initiate the search
        clickElement(searchBarButton);
    }
}

