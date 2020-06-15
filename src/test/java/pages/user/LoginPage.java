package pages.user;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import utils.Browser;

public class LoginPage extends AbstractPage
{
    public LoginPage(Browser browser)
    {
        super(browser);
    }

    @FindBy(css = "#signInForm > div.form-part.email-part > label > input[type=email]")
    public WebElement inputEmail;

    @FindBy(css = "#signInForm > div.form-part.password-part > label > input[type=password]")
    public WebElement inputPassword;

    @FindBy(css = "#signInForm > div.register-button-container > div > div > div > button")
    public WebElement loginButton;

    @FindBy(className = "display-name")
    public WebElement displayName;
}
