package pages_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {
    private WebDriver driver;
    private By flash_message = By.id("flash");
    private By logOutBtn = By.xpath("//div[@class='example']/a");
    public SecureAreaPage(WebDriver driver){
        this.driver = driver;}

    public String getFlashMessage(){
        return driver.findElement(flash_message).getText();
    }

    public LoginPage clickLogOutBtn(){
        driver.findElement(logOutBtn).click();
        return null;
    }
}
