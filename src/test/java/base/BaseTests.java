package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import pages_package.HomePage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;
    String BASEURL = "https://the-internet.herokuapp.com/";
@BeforeMethod
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        //System.setProperty("webdriver.gecko.driver","Resources/geckodriver");
        //driver = new FirefoxDriver();
        //System.setProperty("webdriver.chrome.driver","Resources/chromedriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(BASEURL);
        homePage = new HomePage(driver);
    }


    @AfterMethod
    public void captureScreenShots(ITestResult testResult){

    if(ITestResult.FAILURE == testResult.getStatus()){

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(System.getProperty("user.dir")+"/Resources/screenshots/Failed/"+testResult.getName()+"_"+testResult.getStartMillis()+".png");
        try {
            FileHandler.copy(source,destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    else if (ITestResult.SUCCESS == testResult.getStatus()) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(System.getProperty("user.dir")+"/Resources/screenshots/Passed/"+testResult.getName()+"_"+testResult.getStartMillis()+".png");
        try {
            FileHandler.copy(source,destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    }

    @AfterMethod
    public void tearDown(){
        //driver.quit();
    }

}
