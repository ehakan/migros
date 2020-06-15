package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class Browser implements WebDriver
{
    private TestContext context;
    private WebDriver driver;

    public Browser(TestContext context, WebDriver driver)
    {
        this.context = context;
        this.driver = driver;
    }

    public void waitForLoad()
    {
        Waiter.waitForAjaxLoad(this);
        Waiter.waitForAjaxLoadAngular(this);
    }

    public void waitAndClick(WebElement element)
    {
        waitForLoad();
        element.click();
    }

    public void waitAndSendKeys(WebElement element, String key)
    {
        waitForLoad();
        element.sendKeys(key);
    }

    public boolean isElementDisplayed(WebElement element)
    {
        try
        {
            waitForLoad();
            return element.isDisplayed();
        }
        catch (Exception e)
        {
            return false;
        }
    }

    //--

    public void get(String s)
    {
        driver.get(s);
        waitForLoad();
    }

    public String getCurrentUrl()
    {
        waitForLoad();
        return driver.getCurrentUrl();
    }

    public String getTitle()
    {
        waitForLoad();
        return driver.getTitle();
    }

    public List<WebElement> findElements(By by)
    {
        waitForLoad();
        return driver.findElements(by);
    }

    public WebElement findElement(By by)
    {
        waitForLoad();
        return driver.findElement(by);
    }

    public String getPageSource()
    {
        waitForLoad();
        return driver.getPageSource();
    }

    public void close()
    {
        driver.close();
    }

    public void quit()
    {
        driver.close();
    }

    public Set<String> getWindowHandles()
    {
        return driver.getWindowHandles();
    }

    public String getWindowHandle()
    {
        return driver.getWindowHandle();
    }

    public TargetLocator switchTo()
    {
        return driver.switchTo();
    }

    public Navigation navigate()
    {
        return driver.navigate();
    }

    public Options manage()
    {
        return driver.manage();
    }

    //Getters and Setters


    public TestContext getContext()
    {
        return context;
    }

    public void setContext(TestContext context)
    {
        this.context = context;
    }

    public WebDriver getDriver()
    {
        return driver;
    }

    public void setDriver(WebDriver driver)
    {
        this.driver = driver;
    }
}
