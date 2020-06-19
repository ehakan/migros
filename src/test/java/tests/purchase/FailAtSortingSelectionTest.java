package tests.purchase;

import nav.component.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import nav.NavURL;
import nav.page.CategoryPage;
import nav.page.MainPage;
import nav.page.SubCategoryPage;
import tests.AbstractTest;

import java.util.Arrays;
import java.util.List;

public class FailAtSortingSelectionTest extends AbstractTest {

    @Test
    public void stage_001_testCategorySelection() {
        MainPage mainPage = new MainPage(browser);
        browser.waitAndClick(mainPage.babyToyMenu);

        Assertions.assertEquals(browser.getCurrentUrl(), NavURL.CATEGORY_URL);

        Breadcrumb breadcrumb = new Breadcrumb(browser);
        List<String> expectedBreadcrumb = Arrays.asList("Anasayfa", "Bebek, Oyuncak");
        Assertions.assertEquals(breadcrumb.getTextList(), expectedBreadcrumb);

        SidebarTitle sidebarTitle = new SidebarTitle(browser);
        Assertions.assertEquals(sidebarTitle.getTitle(), "Bebek, Oyuncak");
    }

    @Test
    public void stage_002_testSubCategorySelection() {
        CategoryPage categoryPage = new CategoryPage(browser);
        browser.waitAndClick(categoryPage.diaperSubCategory);

        Assertions.assertEquals(browser.getCurrentUrl(), NavURL.SUB_CATEGORY_URL);

        // Assert correct breadcrumb
        Breadcrumb breadcrumb = new Breadcrumb(browser);
        List<String> expectedBreadcrumb = Arrays.asList("Anasayfa", "Bebek, Oyuncak", "Bebek Bezi");
        Assertions.assertEquals(breadcrumb.getTextList(), expectedBreadcrumb);

        SidebarTitle sidebarTitle = new SidebarTitle(browser);
        Assertions.assertEquals(sidebarTitle.getTitle(), "Bebek Bezi");
    }

    @Test
    public void stage_003_testBrandSelection() {
        try {
            CookiePopup cookiePopup = new CookiePopup(browser);
            browser.waitAndClick(cookiePopup.dismissButton);
        } catch (NoSuchElementException | ElementNotInteractableException ignored) {
        }
        SubCategoryPage subCategoryPage = new SubCategoryPage(browser);
        browser.waitAndClick(subCategoryPage.diaperBrandPrimaCheckbox);

        Assertions.assertEquals(browser.getCurrentUrl(), NavURL.BRAND_FILTERED_URL);

        // Assert correct breadcrumb
        Breadcrumb breadcrumb = new Breadcrumb(browser);
        List<String> expectedBreadcrumb = Arrays.asList("Anasayfa", "Bebek, Oyuncak", "Bebek Bezi");
        Assertions.assertEquals(breadcrumb.getTextList(), expectedBreadcrumb);

        SidebarTitle sidebarTitle = new SidebarTitle(browser);
        Assertions.assertEquals(sidebarTitle.getTitle(), "Prima Bebek Bezi");

        // Assert brand is correct
        ProductCardsList productCardsList = new ProductCardsList(browser);
        Assertions.assertTrue(productCardsList.titlesContainKeyword("Prima"));
        Assertions.assertFalse(productCardsList.titlesContainKeyword("Canbebe"));
        Assertions.assertFalse(productCardsList.titlesContainKeyword("Molfix"));
        Assertions.assertFalse(productCardsList.titlesContainKeyword("Minies"));
        Assertions.assertFalse(productCardsList.titlesContainKeyword("Huggies"));
    }

    @Test
    public void stage_004_testSizeSelections() {
        try {
            CookiePopup cookiePopup = new CookiePopup(browser);
            browser.waitAndClick(cookiePopup.dismissButton);
        } catch (NoSuchElementException | ElementNotInteractableException ignored) {
        }

        SubCategoryPage subCategoryPage = new SubCategoryPage(browser);
        browser.waitAndClick(subCategoryPage.diaperSize4Checkbox);

        Assertions.assertEquals(browser.getCurrentUrl(), NavURL.BRAND_AND_SIZE_FILTERED_URL);

        // Assert correct breadcrumb (must not have changed, sorting selection should not effect the breadcrumb)
        Breadcrumb breadcrumb = new Breadcrumb(browser);
        List<String> expectedBreadcrumb = Arrays.asList("Anasayfa", "Bebek, Oyuncak", "Bebek Bezi");
        Assertions.assertEquals(breadcrumb.getTextList(), expectedBreadcrumb);

        // Size should not affect sidebar
        SidebarTitle sidebarTitle = new SidebarTitle(browser);
        Assertions.assertEquals(sidebarTitle.getTitle(), "Prima Bebek Bezi");
    }

    @Test
    public void stage_005_testFailAtSortingSelection() {
        SortBar sortBar = new SortBar(browser);
        browser.waitAndClick(sortBar.sortDropdownButton);
        // lowest price instead of highest
        browser.waitAndClick(sortBar.sortByLowestPrice);

        Assertions.assertNotEquals(browser.getCurrentUrl(), NavURL.SORTED_BY_HIGHEST_PRICE_URL);

        // Assert correct breadcrumb (must not have changed, sorting selection should not effect the breadcrumb)
        Breadcrumb breadcrumb = new Breadcrumb(browser);
        List<String> expectedBreadcrumb = Arrays.asList("Anasayfa", "Bebek, Oyuncak", "Bebek Bezi");
        Assertions.assertEquals(breadcrumb.getTextList(), expectedBreadcrumb);

        SidebarTitle sidebarTitle = new SidebarTitle(browser);
        Assertions.assertEquals(sidebarTitle.getTitle(), "Prima Bebek Bezi");

        //Assert button is highlighted
        browser.waitAndClick(sortBar.sortDropdownButton);
        // refresh for new state
        sortBar = new SortBar(browser);
        Assertions.assertFalse(sortBar.isSelected(sortBar.sortByHighestPrice));

        ProductCardsList productCardsList = new ProductCardsList(browser);
        System.out.println(productCardsList.getPrices());
        Assertions.assertFalse(productCardsList.isPriceDescending());
    }
}
