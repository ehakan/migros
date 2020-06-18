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
        Assertions.assertEquals(breadcrumb.getBreadcrumb(), expectedBreadcrumb);
    }

    @Test
    public void stage_002_testSubCategorySelection() {
        CategoryPage categoryPage = new CategoryPage(browser);
        browser.waitAndClick(categoryPage.diaperSubCategory);

        Assertions.assertEquals(browser.getCurrentUrl(), NavURL.SUB_CATEGORY_URL);

        Breadcrumb breadcrumb = new Breadcrumb(browser);
        List<String> expectedBreadcrumb = Arrays.asList("Anasayfa", "Bebek, Oyuncak", "Bebek Bezi");
        Assertions.assertEquals(breadcrumb.getBreadcrumb(), expectedBreadcrumb);
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

        // Assert correct breadcrumb (must not have changed, sorting selection should not effect the breadcrumb)
        Breadcrumb breadcrumb = new Breadcrumb(browser);
        List<String> expectedBreadcrumb = Arrays.asList("Anasayfa", "Bebek, Oyuncak", "Bebek Bezi");
        Assertions.assertEquals(breadcrumb.getBreadcrumb(), expectedBreadcrumb);
    }
}
