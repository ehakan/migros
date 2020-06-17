package tests.purchase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import pages.NavURL;
import pages.common.CategoryPage;
import pages.common.MainPage;
import pages.common.SubCategoryPage;
import tests.AbstractTest;

public class FailAtBrandSelectionTest extends AbstractTest {

    @Test
    public void stage_001_testCategorySelection() {
        MainPage mainPage = new MainPage(browser);
        browser.waitAndClick(mainPage.babyToyMenu);
        Assertions.assertEquals(browser.getCurrentUrl(), NavURL.CATEGORY_URL);
    }

    @Test
    public void stage_002_testSubCategorySelection() {
        CategoryPage categoryPage = new CategoryPage(browser);
        browser.waitAndClick(categoryPage.diaperSubCategory);
        Assertions.assertEquals(browser.getCurrentUrl(), NavURL.SUB_CATEGORY_URL);
    }

    @Test
    public void stage_003_testFailAtBrandSelection() {
        SubCategoryPage subCategoryPage = new SubCategoryPage(browser);
        try {
            browser.waitAndClick(subCategoryPage.cookieDismissButton);
        } catch (NoSuchElementException | ElementNotInteractableException ignored) {
        }
        browser.waitAndClick(subCategoryPage.diaperBrandHuggiesCheckbox);
        Assertions.assertNotEquals(browser.getCurrentUrl(), NavURL.BRAND_FILTERED_URL);
    }
}
