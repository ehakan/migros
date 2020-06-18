package nav.component;

import nav.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Browser;

public class LoginModal extends AbstractPage {
    public LoginModal(Browser browser) {
        super(browser);
    }

    @FindBy(css = "#membership-modal")
    public WebElement loginModal;

    public Boolean isDisplayed() {
        return loginModal.isDisplayed();
    }
}
