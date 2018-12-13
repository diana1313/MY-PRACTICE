package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class InstantPage {
    private static InstantPage instance = null;
    private WebDriver driver;

    private InstantPage() {
    }

    public WebDriver openBrowser() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Diana_Dmitriienko\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.
                SECONDS);
        driver.manage().window().maximize();
        return driver;
    }


    public static InstantPage getInstance() {
        if (instance == null) {
            instance = new InstantPage();
        }
        return instance;
    }

}