package Pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.jline.utils.Log;
import org.openqa.selenium.By;

public class Home_Page {
    SHAFT.GUI.WebDriver driver;
    public Home_Page (SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private static By loignBTN = By.cssSelector("a[href='/login']");
    private static By menSection = By.xpath("//a[normalize-space()='Men']");
    private static By tshirtsPage = By.xpath("//a[@href=\"/category_products/3\"][contains(.,\"Tshirts\")]");


    public Home_Page navigateToURL(){
        driver.browser().navigateToURL("https://automationexercise.com");
        return this;
    }
    public Login_Page clickOnLoginBTN(){
        driver.element().click(loignBTN);
        return new Login_Page(driver);
    }
    public Tshirts_Page getShirtsPage(){
        driver.element().click(menSection)
                .and().click(tshirtsPage);
        return new Tshirts_Page(driver);
    }
    @Step("Validate home page title")
    public Home_Page validateHomePageTitle(){
        driver.browser().verifyThat().title().equals("Automation Exercise");
        return this;
    }

}
