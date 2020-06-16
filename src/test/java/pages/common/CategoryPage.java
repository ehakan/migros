package pages.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import utils.Browser;

public class CategoryPage extends AbstractPage {
    public CategoryPage(Browser browser) {
        super(browser);
    }

    @FindBy(css = "a[data-monitor-ga-action='Bebek Bezi']")
    public WebElement diaperSubCategory;
}
