package tests.purchase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import pages.NavURL;
import pages.common.CategoryPage;
import pages.common.MainPage;
import pages.common.SubCategoryPage;
import pages.ui_components.Breadcrumb;
import tests.AbstractTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PurchaseSuccessPathTest extends AbstractTest {

    @Test
    public void stage_001_testCategorySelection() {
        MainPage mainPage = new MainPage(browser);
        browser.waitAndClick(mainPage.babyToyMenu);

        // Assert correct url
        Assertions.assertEquals(browser.getCurrentUrl(), NavURL.CATEGORY_URL);

        // Assert correct breadcrumb
        Breadcrumb breadcrumb = new Breadcrumb(browser);
        List<String> expectedBreadcrumb = Arrays.asList("Anasayfa", "Bebek, Oyuncak");
        Assertions.assertEquals(breadcrumb.getBreadcrumb(), expectedBreadcrumb);
    }

    @Test
    public void stage_002_testSubCategorySelection() {
        CategoryPage categoryPage = new CategoryPage(browser);
        browser.waitAndClick(categoryPage.diaperSubCategory);

        // Assert correct url
        Assertions.assertEquals(browser.getCurrentUrl(), NavURL.SUB_CATEGORY_URL);

        // Assert correct breadcrumb
        Breadcrumb breadcrumb = new Breadcrumb(browser);
        List<String> expectedBreadcrumb = Arrays.asList("Anasayfa", "Bebek, Oyuncak", "Bebek Bezi");
        Assertions.assertEquals(breadcrumb.getBreadcrumb(), expectedBreadcrumb);
    }

    @Test
    public void stage_003_testBrandSelection() {
        SubCategoryPage subCategoryPage = new SubCategoryPage(browser);
        try {
            browser.waitAndClick(subCategoryPage.cookieDismissButton);
        } catch (NoSuchElementException | ElementNotInteractableException ignored) {
        }
        browser.waitAndClick(subCategoryPage.diaperBrandPrimaCheckbox);

        // Assert correct url
        Assertions.assertEquals(browser.getCurrentUrl(), NavURL.BRAND_FILTERED_URL);

        // Assert correct breadcrumb (should still be the same)
        Breadcrumb breadcrumb = new Breadcrumb(browser);
        List<String> expectedBreadcrumb = Arrays.asList("Anasayfa", "Bebek, Oyuncak", "Bebek Bezi");
        Assertions.assertEquals(breadcrumb.getBreadcrumb(), expectedBreadcrumb);
    }

    @Test
    public void stage_004_testSortingSelection() {
        SubCategoryPage subCategoryPage = new SubCategoryPage(browser);
        // guarantees not being able to find the button, responsive layouts of the site acts weird
        browser.waitAndClick(subCategoryPage.sortDropdown);

        browser.waitAndClick(subCategoryPage.sortByHighestPrice);

        // Assert correct url
        Assertions.assertEquals(browser.getCurrentUrl(), NavURL.SORTED_BY_HIGHEST_PRICE_URL);

        // Assert correct breadcrumb (should still be the same)
        Breadcrumb breadcrumb = new Breadcrumb(browser);
        List<String> expectedBreadcrumb = Arrays.asList("Anasayfa", "Bebek, Oyuncak", "Bebek Bezi");
        Assertions.assertEquals(breadcrumb.getBreadcrumb(), expectedBreadcrumb);
    }

    @Test
    public void stage_005_testAddToBasket() {
        SubCategoryPage subCategoryPage = new SubCategoryPage(browser);
        browser.waitAndClick(subCategoryPage.addBasket);

        // Assert correct breadcrumb (should still be the same)
        Breadcrumb breadcrumb = new Breadcrumb(browser);
        List<String> expectedBreadcrumb = Arrays.asList("Anasayfa", "Bebek, Oyuncak", "Bebek Bezi");
        Assertions.assertEquals(breadcrumb.getBreadcrumb(), expectedBreadcrumb);

        // Asserts login modal is displayed
        // We can't check the basket since we are not logged in,
        // login modal at least guarantees we clicked on an add to basket buttton
        Assertions.assertEquals(subCategoryPage.loginModal.getCssValue("display"), "block");
    }

}
