package pages_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage {
    private WebDriver driver;
    private By formAuthenticationLink = By.linkText("Form Authentication");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickFormAuthenticationForm(String linktText){
        //driver.findElement(formAuthenticationLink).click();
        clickLinkText(linktText);
        return new LoginPage(driver);
    }

    public void clickLinkText(String linktText){
        driver.findElement(By.linkText(linktText)).click();
    }

    public ForgotPassword clickForgotPwd(String linktText){
        clickLinkText(linktText);
        return new ForgotPassword(driver);
    }
}
