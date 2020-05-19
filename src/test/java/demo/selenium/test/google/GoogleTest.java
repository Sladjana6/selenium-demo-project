package demo.selenium.test.google;

import demo.selenium.page.google.GooglePage;
import demo.selenium.test.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleTest extends BaseTest {

    private GooglePage googlePage;

    @Before
    public void setUp() {
        googlePage = new GooglePage(driver);
    }

    @Test
    public void googleSearchTest() {
        googlePage.performSearch("selenium");
        List<WebElement> results = googlePage.getResults();
        results.forEach(r -> System.out.println(r.getText()));
    }
}
