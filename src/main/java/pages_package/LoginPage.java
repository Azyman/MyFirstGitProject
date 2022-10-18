package pages_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    //fields
    private WebDriver driver;
    private By username = By.id("username");
    private By password = By.id("password");
    private By submitButton = By.cssSelector("#login button");
    private By logOutBtn = By.xpath("//div[@class='example']/a");
    private By logOutFlashMsg = By.id("flash");


    //Constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //input username method
    public void setUsername(String name){
        driver.findElement(username).sendKeys(name);
    }

    //input password method
    public void setPassword(String passWord) {
        driver.findElement(password).sendKeys(passWord);
    }

    //Click the login button
    public SecureAreaPage clickSubmitButton(){
        driver.findElement(submitButton).click();
        return new SecureAreaPage(driver);
    }

    public SecureAreaPage clickLogOutBtn(){
        driver.findElement(logOutBtn).click();
        return null;
    }

    public String getLogOutMsg(){
       return driver.findElement(logOutFlashMsg).getText();
    }

}
