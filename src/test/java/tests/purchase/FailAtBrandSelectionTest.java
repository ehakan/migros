package tests.purchase;

import nav.component.CookiePopup;
import nav.component.ProductCardsList;
import nav.component.SidebarTitle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import nav.NavURL;
import nav.page.CategoryPage;
import nav.page.MainPage;
import nav.page.SubCategoryPage;
import nav.component.Breadcrumb;
import tests.AbstractTest;

import java.util.Arrays;
import java.util.List;

public class FailAtBrandSelectionTest extends AbstractTest {

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

        Breadcrumb breadcrumb = new Breadcrumb(browser);
        List<String> expectedBreadcrumb = Arrays.asList("Anasayfa", "Bebek, Oyuncak", "Bebek Bezi");
        Assertions.assertEquals(breadcrumb.getTextList(), expectedBreadcrumb);

        SidebarTitle sidebarTitle = new SidebarTitle(browser);
        Assertions.assertEquals(sidebarTitle.getTitle(), "Bebek Bezi");
    }

    @Test
    public void stage_003_testFailAtBrandSelection() {
        try {
            CookiePopup cookiePopup = new CookiePopup(browser);
            browser.waitAndClick(cookiePopup.dismissButton);
        } catch (NoSuchElementException | ElementNotInteractableException ignored) {
        }
        SubCategoryPage subCategoryPage = new SubCategoryPage(browser);
        browser.waitAndClick(subCategoryPage.diaperBrandHuggiesCheckbox);

        Assertions.assertNotEquals(browser.getCurrentUrl(), NavURL.BRAND_FILTERED_URL);

        // Assert correct breadcrumb (must not have changed, sorting selection should not effect the breadcrumb)
        Breadcrumb breadcrumb = new Breadcrumb(browser);
        List<String> expectedBreadcrumb = Arrays.asList("Anasayfa", "Bebek, Oyuncak", "Bebek Bezi");
        Assertions.assertEquals(breadcrumb.getTextList(), expectedBreadcrumb);

        SidebarTitle sidebarTitle = new SidebarTitle(browser);
        Assertions.assertNotEquals(sidebarTitle.getTitle(), "Prima Bebek Bezi");

        // Assert Prima brand is not in the products
        ProductCardsList productCardsList = new ProductCardsList(browser);
        Assertions.assertFalse(productCardsList.titlesContainKeyword("Prima"));
        Assertions.assertFalse(productCardsList.titlesContainKeyword("Canbebe"));
        Assertions.assertFalse(productCardsList.titlesContainKeyword("Molfix"));
        Assertions.assertFalse(productCardsList.titlesContainKeyword("Minies"));
        Assertions.assertTrue(productCardsList.titlesContainKeyword("Huggies"));
    }
}
