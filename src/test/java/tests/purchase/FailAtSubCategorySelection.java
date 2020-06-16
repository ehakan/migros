package tests.purchase;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import pages.common.CategoryPage;
import pages.common.MainPage;
import tests.AbstractTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FailAtSubCategorySelection extends AbstractTest {

    private final String CATEGORY_URL = "https://www.migros.com.tr/bebek-oyuncak-c-9";
    private final String SUB_CATEGORY_URL = "https://www.migros.com.tr/bebek-bezi-c-ab";

    @Test
    public void stage_001_testCategorySelection() {
        MainPage mainPage = new MainPage(browser);
        browser.waitAndClick(mainPage.babyToyMenu);
        Assert.assertEquals(browser.getCurrentUrl(), CATEGORY_URL);
    }

    @Test
    public void stage_002_testFailAtSubCategorySelection() {
        CategoryPage categoryPage = new CategoryPage(browser);
        try {
            browser.waitAndClick(categoryPage.cookieDismissButton);
        } catch (NoSuchElementException e) {
        } catch (ElementNotInteractableException e) {
        }
        browser.waitAndClick(categoryPage.toySubCategory);
        Assert.assertNotEquals(browser.getCurrentUrl(), SUB_CATEGORY_URL);
    }
}
