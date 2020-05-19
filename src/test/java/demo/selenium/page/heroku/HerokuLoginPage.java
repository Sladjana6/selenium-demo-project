package demo.selenium.page.heroku;

import demo.selenium.model.User;
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

    public void checkLogIn(User user) {
        username.sendKeys(user.getUsername());
        password.sendKeys(user.getPassword());
        button.click();

    }
}
