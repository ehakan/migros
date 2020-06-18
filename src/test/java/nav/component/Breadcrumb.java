package nav.component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import nav.AbstractPage;
import utils.Browser;

import java.util.ArrayList;
import java.util.List;

public class Breadcrumb extends AbstractPage {
    public Breadcrumb(Browser browser) {
        super(browser);
    }

    @FindBy(xpath = "//ul[@class='breadcrumb']/li")
    public List<WebElement> rawBreadcrumbList;

    public List<String> getTextList() {
        List<String> extractedBreadcrumbElements = new ArrayList<>();
        for (WebElement liElement : rawBreadcrumbList) {
            extractedBreadcrumbElements.add(liElement.getText());
        }
        return extractedBreadcrumbElements;
    }
}
