package tests.purchase;

import nav.NavURL;
import nav.component.Breadcrumb;
import nav.component.CookiePopup;
import nav.component.ProductCardsList;
import nav.page.CategoryPage;
import nav.page.MainPage;
import nav.page.SubCategoryPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import tests.AbstractTest;

import java.util.Arrays;
import java.util.List;

public class FailAtSizeSelectionTest extends AbstractTest {

    @Test
    public void stage_001_testCategorySelection() {
        MainPage mainPage = new MainPage(browser);
        browser.waitAndClick(mainPage.babyToyMenu);

        // Assert correct url
        Assertions.assertEquals(browser.getCurrentUrl(), NavURL.CATEGORY_URL);

        // Assert correct breadcrumb
        Breadcrumb breadcrumb = new Breadcrumb(browser);
        List<String> expectedBreadcrumb = Arrays.asList("Anasayfa", "Bebek, Oyuncak");
        Assertions.assertEquals(breadcrumb.getTextList(), expectedBreadcrumb);
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
        Assertions.assertEquals(breadcrumb.getTextList(), expectedBreadcrumb);
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

        // Assert correct url
        Assertions.assertEquals(browser.getCurrentUrl(), NavURL.BRAND_FILTERED_URL);

        // Assert correct breadcrumb (should still be the same)
        Breadcrumb breadcrumb = new Breadcrumb(browser);
        List<String> expectedBreadcrumb = Arrays.asList("Anasayfa", "Bebek, Oyuncak", "Bebek Bezi");
        Assertions.assertEquals(breadcrumb.getTextList(), expectedBreadcrumb);

        // Assert brand is correct
        ProductCardsList productCardsList = new ProductCardsList(browser);
        Assertions.assertTrue(productCardsList.titlesContainKeyword("Prima"));
        Assertions.assertFalse(productCardsList.titlesContainKeyword("Canbebe"));
        Assertions.assertFalse(productCardsList.titlesContainKeyword("Molfix"));
        Assertions.assertFalse(productCardsList.titlesContainKeyword("Minies"));
        Assertions.assertFalse(productCardsList.titlesContainKeyword("Huggies"));
    }

    @Test
    public void stage_004_testFailAtSizeSelections() {
        try {
            CookiePopup cookiePopup = new CookiePopup(browser);
            browser.waitAndClick(cookiePopup.dismissButton);
        } catch (NoSuchElementException | ElementNotInteractableException ignored) {
        }

        SubCategoryPage subCategoryPage = new SubCategoryPage(browser);
        browser.waitAndClick(subCategoryPage.diaperSize3Checkbox);

        Assertions.assertNotEquals(browser.getCurrentUrl(), NavURL.BRAND_AND_SIZE_FILTERED_URL);

        // Assert correct breadcrumb (should still be the same)
        Breadcrumb breadcrumb = new Breadcrumb(browser);
        List<String> expectedBreadcrumb = Arrays.asList("Anasayfa", "Bebek, Oyuncak", "Bebek Bezi");
        Assertions.assertEquals(breadcrumb.getTextList(), expectedBreadcrumb);
    }
}
