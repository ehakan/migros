package tests.purchase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import pages.NavURL;
import pages.common.CategoryPage;
import pages.common.MainPage;
import pages.ui_components.Breadcrumb;
import tests.AbstractTest;

import java.util.Arrays;
import java.util.List;

public class FailAtSubCategorySelection extends AbstractTest {

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
    public void stage_002_testFailAtSubCategorySelection() {
        CategoryPage categoryPage = new CategoryPage(browser);
        try {
            browser.waitAndClick(categoryPage.cookieDismissButton);
        } catch (NoSuchElementException | ElementNotInteractableException ignored) {
        }
        browser.waitAndClick(categoryPage.toySubCategory);

        Assertions.assertNotEquals(browser.getCurrentUrl(), NavURL.SUB_CATEGORY_URL);

        Breadcrumb breadcrumb = new Breadcrumb(browser);
        List<String> expectedBreadcrumb = Arrays.asList("Anasayfa", "Bebek, Oyuncak", "Bebek Bezi");
        Assertions.assertNotEquals(breadcrumb.getBreadcrumb(), expectedBreadcrumb);
    }
}
