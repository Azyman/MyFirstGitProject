package pages_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
    private WebDriver driver;
    WebElement column_A_box = driver.findElement(By.id("column-a"));
    WebElement column_B_box = driver.findElement(By.id("column-b"));
    public DragAndDrop(WebDriver driver) {
        this.driver = driver;
    }

    public void DragFrom_boxA_to_boxB(){
        Actions actions = new Actions(driver);
        actions.dragAndDrop(column_A_box,column_B_box).build().perform();
    }
}
