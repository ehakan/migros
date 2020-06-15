package pages;

import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class AbstractPage
{
    protected AbstractPage(Browser browser)
    {
        PageFactory.initElements(browser, this);
    }
}
