package qaademo;

import org.junit.Assert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qaademo.objects.User;
import qaademo.pages.InboxPage;
import qaademo.pages.LetterPage;
import qaademo.pages.LoginPage;
import qaademo.utils.WebDriverSingleton;

import java.util.Set;


public class CookiesTest {
    private final String BASE_URL = "https://mail.google.com";
    private WebDriver driver;
    private LoginPage loginPage;
    private InboxPage inboxPage;
    private LetterPage letterPage;
    private Set<Cookie> cookies;

    @BeforeMethod
    public void setup() {
        driver = WebDriverSingleton.getWebDriverInstance();
        driver.get(BASE_URL);
    }


    @Test
    public void aLoginToGmail() {
        inboxPage = new LoginPage(driver).login(new User());
        Assert.assertTrue("User name of logged user do NOT match", inboxPage.userNameMatchToEntered());
        cookies = driver.manage().getCookies();
    }

    @Test
    public void checkLetterTopic() {
        for (Cookie getCookie : cookies)
            driver.manage().addCookie(getCookie);
        driver.navigate().to(BASE_URL);
        letterPage = inboxPage.openLetter(0);
        Assert.assertTrue("Topic inside the letter does NOT match", letterPage.topicInsideLetterMatch(inboxPage.getTopicOfSelectedLetter()));

    }

    @AfterMethod
    public void tearDown() {
        WebDriverSingleton.closeBrowser();
    }

}
