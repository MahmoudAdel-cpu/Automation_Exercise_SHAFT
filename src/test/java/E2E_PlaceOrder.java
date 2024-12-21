import Pages.Home_Page;
import Pages.Login_Page;
import com.shaft.driver.SHAFT;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@Epic("Automation Exercise")
@Feature("Checkout order")
@Story("Place an order after successfully login")
public class E2E_PlaceOrder {
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testData;

    @Test
    public void placeAnOrderWithValidUser(){
        new Login_Page(driver).validLoginSteps(testData.getTestData("email"),
                testData.getTestData("password"))
                .validateHomePageTitle()
                .getShirtsPage()
                .validateTshirtsPageName()
                .addTshirtsToCart()
                .getCartPage()
                .validateCartPrices()
                .validateCheckoutPageDetails(testData.getTestData("name"))
                .fillPaymentInformation(testData.getTestData("cardHolder"),
                        testData.getTestData("cardNumber"),
                        testData.getTestData("CVC"),
                        testData.getTestData("expiryMonth"),
                        testData.getTestData("expiryYear"))
                .clickOnConfirmBTN()
                .validateOrderPlacedMSG(testData.getTestData("orderPlacedMsg"));
    }

    @BeforeClass
    public void beforeClass(){
        testData = new SHAFT.TestData.JSON("testData.json");

    }
    @BeforeMethod
    public void beforeMethod(){
        driver = new SHAFT.GUI.WebDriver();
        new Home_Page(driver).navigateToURL()
                .clickOnLoginBTN();
    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

}
