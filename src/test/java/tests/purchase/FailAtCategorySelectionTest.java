package tests.purchase;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.common.MainPage;
import tests.AbstractTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FailAtCategorySelectionTest extends AbstractTest {

    private final String CATEGORY_URL = "https://www.migros.com.tr/bebek-oyuncak-c-9";

    @Test
    public void stage_001_testFailAtCategorySelection() {
        MainPage mainPage = new MainPage(browser);
        browser.waitAndClick(mainPage.meatFishChickenMenu);
        Assert.assertNotEquals(browser.getCurrentUrl(), CATEGORY_URL);
    }

}
