package tests.purchase;

import nav.component.CookiePopup;
import nav.component.SidebarTitle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import nav.NavURL;
import nav.page.CategoryPage;
import nav.page.MainPage;
import nav.component.Breadcrumb;
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
        Assertions.assertEquals(breadcrumb.getTextList(), expectedBreadcrumb);

        SidebarTitle sidebarTitle = new SidebarTitle(browser);
        Assertions.assertEquals(sidebarTitle.getTitle(), "Bebek, Oyuncak");
    }

    @Test
    public void stage_002_testFailAtSubCategorySelection() {
        try {
            CookiePopup cookiePopup = new CookiePopup(browser);
            browser.waitAndClick(cookiePopup.dismissButton);
        } catch (NoSuchElementException | ElementNotInteractableException ignored) {
        }
        CategoryPage categoryPage = new CategoryPage(browser);
        browser.waitAndClick(categoryPage.toySubCategory);

        Assertions.assertNotEquals(browser.getCurrentUrl(), NavURL.SUB_CATEGORY_URL);

        Breadcrumb breadcrumb = new Breadcrumb(browser);
        List<String> expectedBreadcrumb = Arrays.asList("Anasayfa", "Bebek, Oyuncak", "Bebek Bezi");
        Assertions.assertNotEquals(breadcrumb.getTextList(), expectedBreadcrumb);

        SidebarTitle sidebarTitle = new SidebarTitle(browser);
        Assertions.assertNotEquals(sidebarTitle.getTitle(), "Bebek Bezi");
    }
}
