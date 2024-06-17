package Steps;

import Pages.LoginPage;
import Pages.ProfilePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StepDefinition {

    public static WebDriver driver;
    LoginPage loginPage;
    ProfilePage profilePage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage();
        profilePage = new ProfilePage();
    }
    //-----------------------
    @Given("user is on login page")
        public void user_is_on_login_page() {
        driver.get("https://www.saucedemo.com/v1/");
    }
    //-----------------------
    @When("user inputs valid username into username field")
    public void user_inputs_valid_username_into_username_field() {
        loginPage.inputUsername("standard_user");
    }
    @When("user inputs invalid {string} into username field")
    public void user_inputs_invalid_username_into_username_field(String username) {
        loginPage.inputUsername(username);
    }
    //-----------------------
    @And("user inputs valid password into password field")
    public void user_inputs_valid_password_into_password_field() {
        loginPage.inputPassword("secret_sauce");
    }
    @And("user clicks on Login button")
    public void user_clicks_on_login_button() {
        loginPage.clickOnLoginButton();
    }
    @And("redirected to Home page")
    public void redirected_to_home_page() {
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/v1/inventory.html");
    }
    @And("user inputs invalid {string} into password field")
    public void user_inputs_invalid_password_into_password_field(String password) {
        loginPage.inputPassword(password);
    }
    @And("error message appears")
    public void error_message_appears() {
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }
    //-----------------------
    @Then("user is logged in")
    public void user_is_logged_in() {
        Assert.assertTrue(profilePage.cartButton.isDisplayed());
    }
    @Then("user is not logged in")
    public void user_is_not_logged_in() {
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }
}
