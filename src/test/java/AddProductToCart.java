import Pages.Cart_Page;
import Pages.Home_Page;
import Pages.Tshirts_Page;
import com.shaft.driver.SHAFT;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@Epic("Automation Exercise")
@Feature("Add Items To Cart")
@Story("Add T-shirts with price less than 1000 to cart")

public class AddProductToCart {
   private SHAFT.GUI.WebDriver driver;
   private SHAFT.TestData.JSON testData;


   @Test (description = "Verify adding products to cart")
    public void addShirtsToCart(){
       new Tshirts_Page(driver).validateTshirtsPageName()
               .addTshirtsToCart()
               .getCartPage()
               .validateCartPrices();
   }
    @BeforeClass
    public void bforeClass(){
       testData = new SHAFT.TestData.JSON("testData.json");
    }
   @BeforeMethod
    public void beforeMethod(){
       driver = new SHAFT.GUI.WebDriver();
       new Home_Page(driver).navigateToURL()
               .clickOnLoginBTN()
       .validLoginSteps(testData.getTestData("email"),
               testData.getTestData("password"))
               .validateHomePageTitle()
               .getShirtsPage();
   }
   @AfterMethod
    public void afterMethod(){
       driver.quit();
   }
}
