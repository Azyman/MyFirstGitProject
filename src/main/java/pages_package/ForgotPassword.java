package pages_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPassword {
    private WebDriver driver;
    private By forgotPwdEmail = By.id("email");
    private By retrievePwd = By.cssSelector("#form_submit");
    private By errorMsg = By.tagName("h1");
    public ForgotPassword(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email){
        driver.findElement(forgotPwdEmail).sendKeys(email);
    }

    public void clickRetrieveBtn(){
        driver.findElement(retrievePwd).submit();
    }

    public String getErrorMsg(){
        return driver.findElement(errorMsg).getText();
    }
}
