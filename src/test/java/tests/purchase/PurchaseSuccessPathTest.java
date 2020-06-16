package tests.purchase;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pages.common.CategoryPage;
import pages.common.MainPage;
import pages.common.SubCategoryPage;
import tests.AbstractTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PurchaseSuccessPathTest extends AbstractTest {

    private final String CATEGORY_URL = "https://www.migros.com.tr/bebek-oyuncak-c-9";
    private final String SUB_CATEGORY_URL = "https://www.migros.com.tr/bebek-bezi-c-ab";
    private final String BRAND = "https://www.migros.com.tr/prima-b-390/bebek-bezi-c-ab";
    private final String SORTED_BY_HIGHEST_PRICE_URL = "https://www.migros.com.tr/prima-b-390/bebek-bezi-c-ab?sirala=once-en-yuksek-fiyat";

    @Test
    public void stage_001_testCategorySelection() {
        MainPage mainPage = new MainPage(browser);
        browser.waitAndClick(mainPage.babyToyMenu);
        Assert.assertEquals(browser.getCurrentUrl(), CATEGORY_URL);
    }

    @Test
    public void stage_002_testSubCategorySelection() {
        CategoryPage categoryPage = new CategoryPage(browser);
        browser.waitAndClick(categoryPage.diaperSubCategory);
        Assert.assertEquals(browser.getCurrentUrl(), SUB_CATEGORY_URL);
    }

    @Test
    public void stage_003_testBrandSelection() {
        SubCategoryPage subCategoryPage = new SubCategoryPage(browser);
        try {
            browser.waitAndClick(subCategoryPage.cookieDismissButton);
        } catch (NoSuchElementException e) {
        } catch (ElementNotInteractableException e) {
        }
        browser.waitAndClick(subCategoryPage.diaperBrandCheckbox);
        Assert.assertEquals(browser.getCurrentUrl(), BRAND);
    }

    @Test
    public void stage_004_testRevealSortDropdown() {
        SubCategoryPage subCategoryPage = new SubCategoryPage(browser);
        browser.waitAndClick(subCategoryPage.sortDropdown);
        browser.waitAndClick(subCategoryPage.sortByHighestPrice);
        Assert.assertEquals(browser.getCurrentUrl(), SORTED_BY_HIGHEST_PRICE_URL);
    }

    @Test
    public void stage_005_testAddToBasket() {
        SubCategoryPage subCategoryPage = new SubCategoryPage(browser);
        browser.waitAndClick(subCategoryPage.addBasket);

        // Asserts login modal is displayed
        Assert.assertEquals(subCategoryPage.loginModal.getCssValue("display"), "block");
    }

}
