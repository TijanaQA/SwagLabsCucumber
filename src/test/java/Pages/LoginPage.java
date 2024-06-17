package Pages;

import Steps.StepDefinition;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends StepDefinition {

    public LoginPage() {
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "user-name")
    public WebElement usernameField;
    @FindBy(id = "password")
    public WebElement passwordField;
    @FindBy(id = "login-button")
    public WebElement loginButton;
    @FindBy(css = "h3[data-test='error']")
    public WebElement errorMessage;
    //-----------------------------------
    public void inputUsername(String username) {
        usernameField.sendKeys(username);
    }
    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }
    public void clickOnLoginButton() {
        loginButton.click();
    }

}
