package tests.purchase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.NavURL;
import pages.common.MainPage;
import tests.AbstractTest;

public class FailAtCategorySelectionTest extends AbstractTest {

    @Test
    public void stage_001_testFailAtCategorySelection() {
        MainPage mainPage = new MainPage(browser);
        browser.waitAndClick(mainPage.meatFishChickenMenu);
        Assertions.assertNotEquals(browser.getCurrentUrl(), NavURL.CATEGORY_URL);
    }

}
