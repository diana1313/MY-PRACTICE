package pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    private WebDriver driver;

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

}
