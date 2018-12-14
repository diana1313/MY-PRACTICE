package qaademo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LetterPage {

    private WebDriver driver;

    public LetterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//td//div//h2")
    private WebElement topicInLetter;

    public boolean topicInsideLetterMatch(String topicOfSelectedLetter) {
        return topicInLetter.getText().contains(topicOfSelectedLetter);
    }

}
