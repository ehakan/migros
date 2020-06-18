package nav.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import nav.AbstractPage;
import utils.Browser;

public class CategoryPage extends AbstractPage {
    public CategoryPage(Browser browser) {
        super(browser);
    }

    @FindBy(css = "a[data-monitor-ga-action='Bebek Bezi']")
    public WebElement diaperSubCategory;

    @FindBy(css = "a[data-monitor-ga-action='Oyuncak']")
    public WebElement toySubCategory;
}
