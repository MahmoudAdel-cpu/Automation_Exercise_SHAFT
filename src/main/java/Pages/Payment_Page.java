package Pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Payment_Page {
    private SHAFT.GUI.WebDriver driver;


    public Payment_Page(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private final By nameOnCardField = By.xpath("//input[@data-qa=\"name-on-card\"]");
    private final By cardNumberField = By.xpath("//input[@data-qa=\"card-number\"]");
    private final By cvcField = By.xpath("//input[@data-qa=\"cvc\"]");
    private final By expirationMonthField = By.xpath("//input[@data-qa=\"expiry-month\"]");
    private final By expirationYearField = By.xpath("//input[@data-qa=\"expiry-year\"]");
    private final By confirmOrderBTn = By.xpath("//button[@data-qa=\"pay-button\"]");
    private final By successMSG = By.xpath("(//div[@class=\"alert-success alert\"])[1]");
    private final By orderPlacedMSG = By.xpath("//h2[@data-qa=\"order-placed\"]");

    @Step("Fill payment information")
    public Payment_Page fillPaymentInformation(String cardHolder, String cardNumber, String cvcNumber,
                                               String month, String year){
        enterCardHolderName(cardHolder)
                .enterCardNumber(cardNumber)
                .enterCVC(cvcNumber)
                .enterExpiryMonth(month)
                .enterExpiryYear(year);
        return this;
    }
    @Step("Enter card holder name")
    public Payment_Page enterCardHolderName(String cardHolder) {
        driver.element().type(nameOnCardField, cardHolder);
        return this;
    }
    @Step("Enter card number")
    public Payment_Page enterCardNumber(String cardNumber) {
        driver.element().type(cardNumberField, cardNumber);
        return this;
    }
    @Step("Enter CVC number")
    public Payment_Page enterCVC(String cvcNumber) {
        driver.element().type(cvcField, cvcNumber);
        return this;
    }
    @Step("Enter expiry month")
    public Payment_Page enterExpiryMonth(String month) {
        driver.element().type(expirationMonthField, month);
        return this;
    }
    @Step("Enter expiry year")
    public Payment_Page enterExpiryYear(String year) {
        driver.element().type(expirationYearField, year);
        return this;
    }
    @Step("Click on confirm order button")
    public Payment_Page clickOnConfirmBTN() {
        driver.element().click(confirmOrderBTn);
        return this;
    }
    @Step("Validate success msg is displayed")
    public Payment_Page validateSuccessMSG(String successMessage){
        // Wait for the success message to appear
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMSG));
        driver.verifyThat().element(successMSG).text().contains(successMessage).perform();
        return this;
    }
    @Step("Validate order placed successfully")
    public Payment_Page validateOrderPlacedMSG(String orderMSG){
        driver.verifyThat().element(orderPlacedMSG).text().contains(orderMSG);
        return this;
    }
}
