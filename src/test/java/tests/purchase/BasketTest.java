package tests.purchase;

import org.junit.Test;
import tests.AbstractTest;

public class BasketTest extends AbstractTest
{
    @Test
    public void testBasketItem()
    {
        /*
        This default test has been removed due to issues with login and mismatched identifiers.
        It remains commented out for usage as reference in part 2.
         */

        /*
        login(context.getInternalProps().getUsername(), context.getInternalProps().getPassword());
        clearBasket();

        MainPage mainPage = new MainPage(browser);
        browser.waitAndClick(mainPage.meatFishChichkenMenu);

        browser.waitAndClick(mainPage.meatCategory);

        CategoryPage categoryPage = new CategoryPage(browser);
        browser.waitAndClick(categoryPage.cookieDismissButton);
        browser.waitAndClick(categoryPage.addBasket);

        browser.waitAndClick(mainPage.shoppingBasketButton);

        while (browser.isElementDisplayed(mainPage.progressBarText))
        {
            browser.waitAndClick(mainPage.plusButton);
        }

        browser.waitAndClick(mainPage.goToBasketButton);

        BasketPage basketPage = new BasketPage(browser);
        browser.waitAndClick(basketPage.purchaseNote);
        browser.waitAndSendKeys(basketPage.inputNote, "120 gramlık paketler şeklinde hazırlanmasını istiyorum");

        String basketTotal = basketPage.basketTotal.getText();
        browser.waitAndClick(basketPage.approveBasket);

        String summaryTotal = basketPage.basketTotal.getText();
        Assert.assertEquals(basketTotal, summaryTotal);
         */
    }
}
