package tests.purchase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.common.MainPage;
import tests.AbstractTest;

public class FailAtCategorySelectionTest extends AbstractTest {

    private final String CATEGORY_URL = "https://www.migros.com.tr/bebek-oyuncak-c-9";

    @Test
    public void stage_001_testFailAtCategorySelection() {
        MainPage mainPage = new MainPage(browser);
        browser.waitAndClick(mainPage.meatFishChickenMenu);
        Assertions.assertNotEquals(browser.getCurrentUrl(), CATEGORY_URL);
    }

}
