package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class InboxPage {

    private WebDriver driver;

    @FindBy(xpath = "//table//tbody//tr[contains(@class,'zA')]")
    private List<WebElement> letters;
    @FindBy(xpath = "//a[contains(@aria-label,'test.user.john2018@gmail.com')]")
    private WebElement userName;
    @FindBy (xpath = "//td//div//h2")
    private WebElement topicInsideLetter;
    @FindBy (xpath = "//td//span[@class='bog']")
    private List <WebElement> letterTopics;
    private String topicOfSelectedLetter;


    public void openLetter(int letterIndex) {
        topicOfSelectedLetter = letterTopics.get(letterIndex).getText();
        letters.get(letterIndex).click();
    }

    public boolean topicInsideLetterMatch(){
        return topicInsideLetter.getText().contains(topicOfSelectedLetter);
    }

    public boolean userNameMatchToEntered() {
        return  userName.isDisplayed();
    }

}
