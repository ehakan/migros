package pages.ui_components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import utils.Browser;

import java.util.ArrayList;
import java.util.List;

public class Breadcrumb extends AbstractPage {
    public Breadcrumb(Browser browser) {
        super(browser);
    }

    @FindBy(xpath = "//ul[@class='breadcrumb']/li")
    public List<WebElement> rawBreadcrumbList;

    public List<String> getBreadcrumb() {
        List<String> extractedBreadcrumbElements = new ArrayList<>();
        for (WebElement liElement : rawBreadcrumbList) {
            extractedBreadcrumbElements.add(liElement.getText());
        }
        return extractedBreadcrumbElements;
    }
}
