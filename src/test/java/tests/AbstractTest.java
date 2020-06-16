package tests;

import org.junit.jupiter.api.*;
import pages.common.MainPage;
import pages.user.LoginPage;
import utils.Browser;
import utils.TestContext;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class AbstractTest
{
    public TestContext context = new TestContext();
    public Browser browser = context.doCreateBrowser();

    @BeforeAll
    public void setUpClass()
    {
        browser.get("https://www.migros.com.tr");
    }

    @AfterAll
    public void tearDownClass()
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

        Assertions.assertNotNull(loginPage.displayName.getText());
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
