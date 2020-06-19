package tests.purchase;

import nav.component.SidebarTitle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import nav.NavURL;
import nav.page.MainPage;
import nav.component.Breadcrumb;
import tests.AbstractTest;

import java.util.Arrays;
import java.util.List;

public class FailAtCategorySelectionTest extends AbstractTest {

    @Test
    public void stage_001_testFailAtCategorySelection() {
        MainPage mainPage = new MainPage(browser);
        browser.waitAndClick(mainPage.meatFishChickenMenu);

        Assertions.assertNotEquals(browser.getCurrentUrl(), NavURL.CATEGORY_URL);

        Breadcrumb breadcrumb = new Breadcrumb(browser);
        List<String> expectedBreadcrumb = Arrays.asList("Anasayfa", "Bebek, Oyuncak");
        Assertions.assertNotEquals(breadcrumb.getTextList(), expectedBreadcrumb);

        SidebarTitle sidebarTitle = new SidebarTitle(browser);
        Assertions.assertNotEquals(sidebarTitle.getTitle(), "Bebek, Oyuncak");
    }

}
