package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setBaseUrl(){
        browserSetUp(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //click on the ‘Sign In’ link
        clickOnElement(By.linkText("Sign In"));
        //Verify the text ‘Welcome Back!’
        //Expected text
        String expectedText = "Welcome Back!";
        String actualText = getTextFromElement(By.xpath("//h1[@class=\"page__heading\"]"));
        //Verify actual and expected text
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void verifyTheErrorMessage(){
        //click on the ‘Sign In’ link
        clickOnElement(By.linkText("Sign In"));
        //Enter invalid username
        sendTextToElement(By.id("user[email]"),"admin1234@gmail.com");
        // Enter invalid password
        sendTextToElement(By.id("user[password]"),"admin1234");
        //Click on Sign in button
        clickOnElement(By.xpath("//input[@type=\"submit\"]"));
        //Verify the error message ‘Invalid email or password.'
        //expected text
        String expectedText = "Invalid email or password.";
        //find Element and get text
        String actualText = getTextFromElement(By.xpath("//li[contains(text(),\"Invalid email or password.\")]"));
        //Validate actual and expect
        Assert.assertEquals(expectedText,actualText);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
