package Pages;
import com.shaft.driver.SHAFT;
import io.qameta.allure.*;
import org.openqa.selenium.By;

public class Checkout_Page {
    private SHAFT.GUI.WebDriver driver;

    public Checkout_Page(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }
    private final By addressDetailsText = By.xpath("//h2[text()=\"Address Details\"]");
    private final By customerName = By.xpath("(//li[@class=\"address_firstname address_lastname\"])[1]");
    private final By placeOrderBTN = By.xpath("//div//a[@class=\"btn btn-default check_out\"]");

    @Step("Place an order")
    public Payment_Page validateCheckoutPageDetails(String name){
        driver.browser().captureScreenshot();
        validatePageTitle()
                .validateAddressText()
                .validateCustomerName(name)
                .validatePlaceOrderBTN();
        return new Payment_Page(driver);
    }

    @Step("Validate page title is equal to Checkout page")
    public Checkout_Page validatePageTitle (){
        driver.browser().verifyThat().title().contains("Checkout");
        return this;
    }
    @Step("Validate Address Details text is visible")
    public Checkout_Page validateAddressText(){
        driver.element().verifyThat(addressDetailsText).isVisible().perform();
        driver.verifyThat().element(addressDetailsText).text().isEqualTo("Address Details").perform();
        return this;
    }
    @Step("Validate the visibility of place order button")
    public Checkout_Page validatePlaceOrderBTN(){
        driver.element().verifyThat(placeOrderBTN).isVisible().perform();
        driver.element().verifyThat(placeOrderBTN).isEnabled().perform();
        driver.element().click(placeOrderBTN);
        return this;
    }
    @Step("Verifying user name")
    public Checkout_Page validateCustomerName (String name){
        driver.verifyThat().element(customerName).text().contains(name);
        return this;
    }

}
