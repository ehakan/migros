package nav.component;

import nav.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Browser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ProductCardsList extends AbstractPage {
    public ProductCardsList(Browser browser) {
        super(browser);
    }

    // private static final Pattern priceInvalidCharsPattern = Pattern.compile("[(A-Z) ]");
    // private static final Pattern priceCommaPattern = Pattern.compile("[,]");
    private static final String priceInvalidCharsPattern = "[(A-Z) ]";
    private static final String priceCommaPattern = "[,]";

    @FindBy(xpath = "//div[@id='product-list']//div[@class='list']/div")
    public List<WebElement> cardElements;

    @FindBy(xpath = "//div[@id='product-list']//div[@class='list']/div//h5/a")
    public List<WebElement> titleElements;

    @FindBy(xpath = "//div[@id='product-list']//div[@class='list']/div//div[@class='price-tag']/span")
    public List<WebElement> priceElements;

    private List<String> titles = null;
    private List<Double> prices = null;

    public List<String> getTitles() {
        if (titles != null) {
            return titles;
        }
        else {
            List<String> t = new ArrayList<>();

            for (WebElement titleElement : titleElements) {
                t.add(titleElement.getText());
            }

            titles = t;
            return titles;
        }
    }

    public List<Double> getPrices() {
        if (prices != null) {
            return prices;
        }
        else {
            List<Double> p = new ArrayList<>();

            for (WebElement priceElement : priceElements) {
                String sanitized = priceElement.getText()
                        .replaceAll(priceInvalidCharsPattern, "")
                        .replaceAll(priceCommaPattern, ".");
                p.add(Double.valueOf(sanitized));
            }

            prices = p;
            return prices;
        }
    }

    public Boolean titlesContainKeyword(String s) {
        String needle = s.toLowerCase();

        for (String title : getTitles()) {
            String haystack = title.toLowerCase();
            if (haystack.contains(needle)) {
                return true;
            }
        }

        return false;
    }

    public Boolean isPriceDescending() {
        List<Double> prices = getPrices();

        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) < prices.get(i + 1)) {
                return false;
            }
        }

        return true;
    }
}
