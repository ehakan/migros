package nav.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import nav.AbstractPage;
import utils.Browser;

public class SubCategoryPage extends AbstractPage
{
    public SubCategoryPage(Browser browser)
    {
        super(browser);
    }


    @FindBy(css = ".sub-category-product-list .list:nth-of-type(1) .product-card-button")
    public WebElement addBasket;

    @FindBy(xpath = "(//a[@class='brands-list-anchor']//span[contains(text(), 'Prima')])[1]/../..")
    public WebElement diaperBrandPrimaCheckbox;

    @FindBy(xpath = "(//a[@class='brands-list-anchor']//span[contains(text(), 'Huggies')])[1]/../..")
    public WebElement diaperBrandHuggiesCheckbox;

    @FindBy(xpath = "(//a[@class='brands-list-anchor' and @data-monitor-ga-label='4 Beden'])[1]")
    public WebElement diaperSize4Checkbox;

    @FindBy(xpath = "(//a[@class='brands-list-anchor' and @data-monitor-ga-label='3 Beden'])[1]")
    public WebElement diaperSize3Checkbox;

    @FindBy(css = ".others-button")
    public WebElement sortDropdown;

    @FindBy(xpath = "(//li[@data-sort-criteria = 'PRICE_DESC'])[2]/a")
    public WebElement sortByHighestPrice;

    @FindBy(xpath = "(//li[@data-sort-criteria = 'PRICE_ASC'])[2]/a")
    public WebElement sortByLowestPrice;
}
