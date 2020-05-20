package demo.selenium.page.heroku;

import demo.selenium.model.User;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HerokuLoginPage {

    public HerokuLoginPage(WebDriver driver) {
        driver.get("https://the-internet.herokuapp.com/login");
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "username")
    private WebElement username;
    @FindBy (id = "password")
    private WebElement password;
    @FindBy(className = "radius")
    private WebElement button;
    @FindBy (id = "flash")
    private WebElement message;
    @FindBy (css = ".secondary.radius")
    private WebElement logoutButton;

    public void performLogIn(User user) {
        username.sendKeys(user.getUsername());
        password.sendKeys(user.getPassword());
        button.click();
    }

    public void assertPositiveLogIn() {
        Assert.assertTrue("Login message is not ok!", message.getText().contains("You logged into a secure area!"));
        Assert.assertTrue("Logout button is not visible!", logoutButton.isDisplayed());
    }

    public void assertNegativeLogIn() {
        Assert.assertTrue("Login message is not ok!", message.getText().contains("Your password is invalid!"));
    }
}
