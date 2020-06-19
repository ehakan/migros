package nav.component;

import nav.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Browser;

public class SortBar extends AbstractPage {
    public SortBar(Browser browser) {
        super(browser);
    }

    @FindBy(css = ".others-button")
    public WebElement sortDropdownButton;

    @FindBy(xpath = "(//li[@data-sort-criteria = 'WEEKLY_BEST_SELLER'])[2]/a")
    public WebElement sortByWeeklyBestSeller;

    @FindBy(xpath = "(//li[@data-sort-criteria = 'LAST_ORDERS'])[2]/a")
    public WebElement sortByLastOrders;

    @FindBy(xpath = "(//li[@data-sort-criteria = 'DISCOUNT_PERCENTAGE'])[2]/a")
    public WebElement sortByDiscountPercentage;

    @FindBy(xpath = "(//li[@data-sort-criteria = 'PRICE_ASC'])[2]/a")
    public WebElement sortByLowestPrice;

    @FindBy(xpath = "(//li[@data-sort-criteria = 'PRICE_DESC'])[2]/a")
    public WebElement sortByHighestPrice;

    @FindBy(xpath = "(//li[@data-sort-criteria = 'DISCOUNT_AMOUNT'])[2]/a")
    public WebElement sortByDiscountAmount;

    public Boolean isSelected(WebElement sortElement) {
        WebElement parent = sortElement.findElement(By.xpath("./.."));
        return parent.getAttribute("class").contains("selected");
    }

}
