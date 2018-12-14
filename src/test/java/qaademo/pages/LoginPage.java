package qaademo.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import qaademo.objects.User;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(id = "identifierId")
    private WebElement inputEmail;
    @FindBy(name = "password")
    private WebElement inputPass;


    public void enterEmail(String email) {
        inputEmail.sendKeys(email + Keys.ENTER);
    }

    public void enterPass(String pass) {
        inputPass.sendKeys(pass + Keys.ENTER);
    }

    public InboxPage login(User user){
        enterEmail(user.getLogin());
        enterPass(user.getPassword());
        return new InboxPage(driver);
    }

}
