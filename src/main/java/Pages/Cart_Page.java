package Pages;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Cart_Page {
     private SHAFT.GUI.WebDriver driver;

    public Cart_Page (SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By cartPricesElements = By.xpath("(//td[@class=\"cart_price\"]/p)");
    private final By checkOutBTN = By.xpath("//a[@class=\"btn btn-default check_out\"]");

    public Checkout_Page validateCartPrices (){
        boolean shoulClickcheckoutBTN = false;
        List < WebElement> prices = driver.getDriver().findElements(cartPricesElements);
        for (int i = 0; i< prices.size(); i++){
            int cartPrice = Integer.parseInt(driver.getDriver()
                    .findElement(By.xpath("(//td[@class=\"cart_price\"]/p)["+(i+1)+"]"))
                    .getText().replaceAll("[^0-9]",""));
            System.out.println("Cart prices are: " + cartPrice);
            if (cartPrice <1000){
                shoulClickcheckoutBTN = true; // this will be true if only the price of product is less than 1000
            }
        }
        if (shoulClickcheckoutBTN){
            driver.element().click(checkOutBTN); //if should
        }
        return new Checkout_Page(driver);
    }
}
