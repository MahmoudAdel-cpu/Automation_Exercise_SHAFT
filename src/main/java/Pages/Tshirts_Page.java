package Pages;
import com.shaft.driver.SHAFT;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Tshirts_Page {
    SHAFT.GUI.WebDriver driver;
    public Tshirts_Page (SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }
    private final By tshirts = By.xpath("//div[@class=\"productinfo text-center\"]");
    private final By continueBTN = By.xpath("//button[@class=\"btn btn-success close-modal btn-block\"]");
    private final By cartBTN = By.xpath("(//a[@href=\"/view_cart\"])[1]");

    @Step("Add only T-shirts that are < 1000 to cart")
    public Tshirts_Page addTshirtsToCart (){
        //To get all products in list
        List <WebElement> products = driver.getDriver().findElements(tshirts);
        try {
            //Loop to get all prices
            for (int i=0; i<products.size(); i++){
                int tshirtPrice = Integer.parseInt(driver.getDriver()
                        .findElement(By.xpath("(//div[@class=\"productinfo text-center\"]/h2)["+(i+1)+"]"))
                        .getText().replaceAll("[^0-9]",""));
                System.out.println("T-shirts price is: " + tshirtPrice);
                //add only products that are < 1000 to cart
                if (tshirtPrice <1000){
                    driver.element().click(By.xpath("(//div[@class=\"productinfo text-center\"])["+(i+1)+"]/a")); //dynamic
                    visibiltyOfBTN(continueBTN);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return this;
    }
    @Step("Click on cart icon to get cart page")
    public Cart_Page getCartPage(){
        driver.element().click(cartBTN);
        return new Cart_Page(driver);
    }
    @Step("Validate page title")
    public Tshirts_Page validateTshirtsPageName(){
        driver.browser().verifyThat().title().contains("Tshirts Products");
        System.out.println(driver.browser().getCurrentWindowTitle());
        return this;
    }
    @Step("Validate Continue Shopping BTN is exist")
    public void visibiltyOfBTN (By element){
        driver.element().verifyThat(element).exists().perform();
        driver.element().click(element);
    }


}
