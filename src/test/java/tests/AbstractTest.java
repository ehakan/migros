package tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import pages.common.MainPage;
import pages.user.LoginPage;
import utils.Browser;
import utils.TestContext;

public class AbstractTest
{
    public static TestContext context = new TestContext();
    public static Browser browser = context.doCreateBrowser();

    @BeforeClass
    public static void setUpClass()
    {
        browser.get("https://www.migros.com.tr");
    }

    @AfterClass
    public static void tearDownClass()
    {
        if (null != browser)
            browser.close();
    }


    public void login(String username, String password)
    {
        MainPage mainPage = new MainPage(browser);
        browser.waitAndClick(mainPage.loginButton);

        LoginPage loginPage = new LoginPage(browser);

        browser.waitAndSendKeys(loginPage.inputEmail, username);
        browser.waitAndSendKeys(loginPage.inputPassword, password);

        browser.waitAndClick(loginPage.loginButton);

        Assert.assertNotNull(loginPage.displayName.getText());
    }

    public void clearBasket()
    {
        MainPage mainPage = new MainPage(browser);
        browser.waitAndClick(mainPage.shoppingBasketButton);

        while (browser.isElementDisplayed(mainPage.trashButton))
        {
            browser.waitAndClick(mainPage.trashButton);
        }

        browser.waitAndClick(mainPage.shoppingBasketButton);
    }
}
