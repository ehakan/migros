package utils;

import configs.InternalProps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestContext
{
    private InternalProps internalProps;
    private Browser browser;

    public TestContext()
    {
        this.internalProps = new InternalProps();
    }

    public Browser doCreateBrowser()
    {
        // Optional, if not specified, WebDriver will search your path for chromedriver.
        System.setProperty("webdriver.chrome.driver", "/opt/chromedriver");

        // initialize webdriver
        WebDriver driver = new ChromeDriver();

        //Assign browser variable in Context
        this.browser = new Browser(this, driver);

        return browser;
    }

    //Getters and Setters


    public InternalProps getInternalProps()
    {
        return internalProps;
    }

    public void setInternalProps(InternalProps internalProps)
    {
        this.internalProps = internalProps;
    }

    public Browser getBrowser()
    {
        return browser;
    }

    public void setBrowser(Browser browser)
    {
        this.browser = browser;
    }
}
