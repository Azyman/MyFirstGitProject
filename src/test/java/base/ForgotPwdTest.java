package base;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages_package.ForgotPassword;

public class ForgotPwdTest extends BaseTests{
    @Test(priority = 1, dataProvider = "testData")
    public void forgotPwdTest(String email, boolean Success){
        ForgotPassword forgotPassword = homePage.clickForgotPwd("Forgot Password");
        forgotPassword.enterEmail(email);
        forgotPassword.clickRetrieveBtn();
        Assert.assertTrue(Success,forgotPassword.getErrorMsg());
    }

    @DataProvider(name = "testData")
    public Object[][] LoginData(){
        Object[][] data = new Object[4][2];
        data[0][0] = "azorykavhuru@gmail.com";data[0][1] =  true;
        data[1][0] = "azory.kavhuru@gmail.com";data[1][1] =  true;
        data[2][0] = "tomsmith1";data[2][1] =  false;
        data[3][0] = "tomsmith1";data[3][1] =  false;
        return data;
    }
}