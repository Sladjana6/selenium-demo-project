package demo.selenium.test.heroku;

import demo.selenium.model.User;
import demo.selenium.page.heroku.HerokuLoginPage;
import demo.selenium.test.BaseTest;
import org.jsoup.Connection;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    @Test
    public void positiveLoginTest() {
        HerokuLoginPage herokuLoginPage = new HerokuLoginPage(driver);
        User user = new User();
        user.setUsername("tomsmith");
        user.setPassword("SuperSecretPassword!");
        herokuLoginPage.checkLogIn(user);
        WebElement message = driver.findElement(By.id("flash"));
        WebElement logout = driver.findElement(By.cssSelector(".secondary.radius"));
        Assert.assertTrue("Login is unsuccessful",message.getText().contains("You logged into a secure area!"));
        Assert.assertTrue("Login is unsuccessful",logout.isDisplayed());
    }

    @Test
    public void negativeLoginTest() {
        HerokuLoginPage herokuLoginPage = new HerokuLoginPage(driver);
        User user = new User();
        user.setUsername("tomsmith");
        user.setPassword("Super");
        herokuLoginPage.checkLogIn(user);
        WebElement message = driver.findElement(By.id("flash"));
        Assert.assertTrue("Something isn't working",message.getText().contains("Your password is invalid!"));

    }
}
