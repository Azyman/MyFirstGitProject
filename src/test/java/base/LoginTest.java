package base;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages_package.LoginPage;
import pages_package.SecureAreaPage;

public class LoginTest extends BaseTests{

    @Test(priority = 1, dataProvider = "LoginData")
    public void loginSuccessfulTest(String Username, String Password, boolean Success){
    LoginPage loginPage = homePage.clickFormAuthenticationForm("Form Authentication");
    loginPage.setUsername(Username);
    loginPage.setPassword(Password);
    SecureAreaPage secureAreaPage = loginPage.clickSubmitButton();
    Assert.assertTrue(Success,secureAreaPage.getFlashMessage());

    //LoginPage logoutPage = secureAreaPage.clickLogOutBtn();
    //Assert.assertTrue(Success,logoutPage.getLogOutMsg());
    loginPage.clickLogOutBtn();
    Assert.assertTrue(loginPage.getLogOutMsg().contains("You logged out of the secure area!"));
    }

    @DataProvider
    public Object[][] LoginData(){
        Object[][] data = new Object[4][3];
        data[0][0] = "tomsmith";data[0][1] = "SuperSecretPassword!";data[0][2] =  true;
        data[1][0] = "tomsmith1";data[1][1] = "SuperSecretPassword!2";data[1][2] =  true;
        data[2][0] = "tomsmith1";data[2][1] = "SuperSecretPassword!2";data[2][2] =  true;
        data[3][0] = "tomsmith";data[3][1] = "SuperSecretPassword!";data[3][2] =  true;
        data[4][0] = "tomsmith";data[4][1] = "SuperSecretPassword!";data[4][2] =  true;
        return data;
    }
}
