package nav.component;

import nav.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Browser;

public class CookiePopup extends AbstractPage {
    public CookiePopup(Browser browser) {
        super(browser);
    }

    @FindBy(className = "cookie-popup-dismiss")
    public WebElement dismissButton;
}
