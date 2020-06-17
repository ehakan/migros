package pages.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import utils.Browser;

public class SubCategoryPage extends AbstractPage
{
    public SubCategoryPage(Browser browser)
    {
        super(browser);
    }

    @FindBy(className = "cookie-popup-dismiss")
    public WebElement cookieDismissButton;

    @FindBy(css = ".sub-category-product-list .list:nth-of-type(1) .product-card-button")
    public WebElement addBasket;

    @FindBy(xpath = "(//a[@class='brands-list-anchor']//span[contains(text(), 'Prima')])[1]/../..")
    public WebElement diaperBrandPrimaCheckbox;

    @FindBy(xpath = "(//a[@class='brands-list-anchor']//span[contains(text(), 'Huggies')])[1]/../..")
    public WebElement diaperBrandHuggiesCheckbox;

    @FindBy(css = ".others-button")
    public WebElement sortDropdown;

    @FindBy(xpath = "(//li[@data-sort-criteria = 'PRICE_DESC'])[2]/a")
    public WebElement sortByHighestPrice;

    @FindBy(xpath = "(//li[@data-sort-criteria = 'PRICE_ASC'])[2]/a")
    public WebElement sortByLowestPrice;

    @FindBy(css = "#membership-modal")
    public WebElement loginModal;

}
