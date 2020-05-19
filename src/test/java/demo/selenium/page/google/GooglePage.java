package demo.selenium.page.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GooglePage {

    public GooglePage(WebDriver driver) {
        driver.get("https://www.google.rs/");
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "q")
    private WebElement searchInput;
    @FindBy(css = ".LC20lb.DKV0Md")
    private List<WebElement> results;

    /**
     * This method is used to perform Google search.
     */
    public void performSearch(String query) {
        searchInput.clear();
        searchInput.sendKeys(query);
        searchInput.submit();
    }

    public List<WebElement> getResults() {
        return results;
    }
}
