package pages.purchase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import utils.Browser;

public class BasketPage extends AbstractPage
{
    public BasketPage(Browser browser)
    {
        super(browser);
    }

    @FindBy(linkText = "Ürün Notu")
    public WebElement purchaseNote;

    @FindBy(className = "product_note")
    public WebElement inputNote;

    @FindBy(id = "summaryRevenue")
    public WebElement basketTotal;

    @FindBy(id = "in-cart-next-button")
    public WebElement approveBasket;
}
