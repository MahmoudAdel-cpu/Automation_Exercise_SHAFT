import Pages.Home_Page;
import Pages.Login_Page;
import Pages.Tshirts_Page;
import com.shaft.driver.SHAFT;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


@Epic("Automation Exercise")
@Feature("User Management")
@Story("Login")
public class LoginWithValidData {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;


    @Test(description = "Login with valid email and password, and validate home page title after successfully login")
    public void validLoginTest (){
        new Home_Page(driver).clickOnLoginBTN();
        new Login_Page(driver).validLoginSteps(testData.getTestData("email"),
                testData.getTestData("password"))
                .validateHomePageTitle();
    }

    @BeforeClass
    public void beforeClass(){
        testData = new SHAFT.TestData.JSON("testData.json");
    }
    @BeforeMethod
    public void setup(){
        driver = new SHAFT.GUI.WebDriver();
        new Home_Page(driver).navigateToURL();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
