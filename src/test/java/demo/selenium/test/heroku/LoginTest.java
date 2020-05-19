package demo.selenium.test.heroku;

import demo.selenium.model.User;
import demo.selenium.page.heroku.HerokuLoginPage;
import demo.selenium.test.BaseTest;
import org.junit.Before;
import org.junit.Test;

public class LoginTest extends BaseTest {

    private User user;
    private HerokuLoginPage herokuLoginPage;

    @Before
    public void setUp() {
        herokuLoginPage = new HerokuLoginPage(driver);
        user = new User();
    }

    @Test
    public void positiveLoginTest() {
        user.setUsername("tomsmith");
        user.setPassword("SuperSecretPassword!");
        herokuLoginPage.performLogIn(user);
        herokuLoginPage.assertPositiveLogIn();
    }

    @Test
    public void negativeLoginTest() {
        user.setUsername("tomsmith");
        user.setPassword("Super");
        herokuLoginPage.performLogIn(user);
        herokuLoginPage.assertNegativeLogIn();
    }
}
