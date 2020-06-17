package tests.purchase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import pages.NavURL;
import pages.common.CategoryPage;
import pages.common.MainPage;
import tests.AbstractTest;

public class FailAtSubCategorySelection extends AbstractTest {

    @Test
    public void stage_001_testCategorySelection() {
        MainPage mainPage = new MainPage(browser);
        browser.waitAndClick(mainPage.babyToyMenu);
        Assertions.assertEquals(browser.getCurrentUrl(), NavURL.CATEGORY_URL);
    }

    @Test
    public void stage_002_testFailAtSubCategorySelection() {
        CategoryPage categoryPage = new CategoryPage(browser);
        try {
            browser.waitAndClick(categoryPage.cookieDismissButton);
        } catch (NoSuchElementException | ElementNotInteractableException ignored) {
        }
        browser.waitAndClick(categoryPage.toySubCategory);
        Assertions.assertNotEquals(browser.getCurrentUrl(), NavURL.SUB_CATEGORY_URL);
    }
}
