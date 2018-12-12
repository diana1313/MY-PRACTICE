package pom;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GmailPage extends PageObject {

    WebDriver driver;

    @FindBy(id = "identifierId")
    private WebElement inputEmail;
    @FindBy(name = "password")
    private WebElement inputPass;
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

    public void enterEmail(String email) {
        inputEmail.sendKeys(email + Keys.ENTER);
    }

    public void enterPass(String pass) {
        inputPass.sendKeys(pass + Keys.ENTER);
    }

}
