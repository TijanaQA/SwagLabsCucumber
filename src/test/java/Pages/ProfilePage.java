package Pages;

import Steps.StepDefinition;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends StepDefinition {
   public ProfilePage() {
       PageFactory.initElements(driver,this);
   }
   @FindBy(id = "shopping_cart_container")
    public WebElement cartButton;
}
