package nav.component;

import nav.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Browser;

public class SidebarTitle extends AbstractPage {
    public SidebarTitle(Browser browser) {
        super(browser);
    }

    @FindBy(xpath = "//div[@class='category-sidebar ']/div/div/div/h1")
    public WebElement categoryTitle;

    public String getTitle() {
        return categoryTitle.getText();
    }
}
