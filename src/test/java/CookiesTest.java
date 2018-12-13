import org.junit.Assert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.InboxPage;
import pom.LoginPage;
import pom.InstantPage;

import java.util.Set;


public class CookiesTest {
    private final String email = "test.user.john2018@gmail.com";
    private final String pass = "TesT2018";
    private final String baseURL = "https://mail.google.com";
    private final String mailInbox = "https://mail.google.com/mail/u/0/#inbox";
    private WebDriver driver;
    private LoginPage loginlPage;
    private InboxPage inboxPage;
    private Set<Cookie> cookies;

    @BeforeMethod
    public void setup() {
        InstantPage instance = InstantPage.getInstance();
        driver = instance.openBrowser();
        driver.get(baseURL);
        loginlPage = PageFactory.initElements(driver, LoginPage.class);
    }


    @Test
    public void aLoginToGmail() {
        loginlPage.enterEmail(email);
        loginlPage.enterPass(pass);
        inboxPage = PageFactory.initElements(driver, InboxPage.class);
        Assert.assertTrue("User name of logged user do NOT match", inboxPage.userNameMatchToEntered());
        cookies = driver.manage().getCookies();
    }

    @Test
    public void checkLetterTopic() {

        for (Cookie getCookie : cookies)
            driver.manage().addCookie(getCookie);
        driver.navigate().to(mailInbox);
        inboxPage.openLetter(0);
        Assert.assertTrue("Topic inside the letter does NOT match", inboxPage.topicInsideLetterMatch());

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
