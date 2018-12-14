package qaademo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InboxPage {

    private WebDriver driver;
    private String topicOfSelectedLetter;

    public InboxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//table//tbody//tr[contains(@class,'zA')]")
    private List<WebElement> letters;
    @FindBy(xpath = "//a[contains(@aria-label,'test.user.john2018@gmail.com')]")
    private WebElement userName;

    @FindBy(xpath = "//td//span[@class='bog']")
    private List<WebElement> letterTopics;

    public LetterPage openLetter(int letterIndex) {
        topicOfSelectedLetter = letterTopics.get(letterIndex).getText();
        letters.get(letterIndex).click();
        return new LetterPage(driver);
    }

    public String getTopicOfSelectedLetter() {
        return topicOfSelectedLetter;
    }

    public boolean userNameMatchToEntered() {
        return userName.isDisplayed();
    }

}
