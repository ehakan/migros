package tests.purchase;

import org.junit.Assert;
import org.junit.Test;
import pages.common.MainPage;
import tests.AbstractTest;

public class PurchaseSuccessPathTest extends AbstractTest {

    private final String CATEGORY_URL = "https://www.migros.com.tr/bebek-oyuncak-c-9";
    private final String SUB_CATEGORY_URL = "https://www.migros.com.tr/bebek-bezi-c-ab";
    private final String BRAND = "https://www.migros.com.tr/prima-b-390/bebek-bezi-c-ab";

    @Test
    public void testCategorySelection() {
        MainPage mainPage = new MainPage(browser);
        browser.waitAndClick(mainPage.babyToyMenu);
        Assert.assertEquals(browser.getCurrentUrl(), CATEGORY_URL);
    }

    @Test
    public void testSubCategorySelection() {
        MainPage mainPage = new MainPage(browser);
        browser.waitAndClick(mainPage.diaperCategory);
        Assert.assertEquals(browser.getCurrentUrl(), SUB_CATEGORY_URL);
    }

//    @Test
//    public void testBrandSelection() {
//        MainPage mainPage = new MainPage(browser);
//        browser.waitAndClick(mainPage.diaperBrand);
//        Assert.assertEquals(browser.getCurrentUrl(), BRAND);
//    }

}
