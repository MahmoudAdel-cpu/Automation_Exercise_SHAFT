package Pages;
import com.shaft.driver.SHAFT;
import io.qameta.allure.*;
import org.openqa.selenium.By;

public class Login_Page {
    SHAFT.GUI.WebDriver driver;

    public Login_Page (SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }
    private final By emailField = By.xpath("//input[@data-qa=\"login-email\"]");
    private final By passwordField = By.xpath("//input[@data-qa=\"login-password\"]");
    private final By submitLoginBTN = By.xpath("//button[@data-qa=\"login-button\"]");

    @Step("Enter Valid email and password")
    public Home_Page validLoginSteps(String email, String password){
        driver.element().type(emailField, email)
                .and().type(passwordField, password)
                .and().click(submitLoginBTN);
        return new Home_Page(driver);
    }

}
