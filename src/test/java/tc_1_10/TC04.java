package tc_1_10;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import testbase.TestBase;

import static org.junit.jupiter.api.Assertions.*;

public class TC04 extends TestBase {

    @Test
    void LogoutUser()  {

        emailregistering();
        //  1. Launch browser
       //  2. Navigate to url 'http://automationexercise.com'
       //  3. Verify that home page is visible successfully
        assertEquals("https://automationexercise.com/",driver.getCurrentUrl());

       //  4. Click on 'Signup / Login' button
        driver.findElement(By.partialLinkText("Signup / Login")).click();

       //  5. Verify 'Login to your account' is visible
        WebElement loginAcccount= driver.findElement(By.xpath("//h2[.='Login to your account']"));
        assertTrue(loginAcccount.isDisplayed());

       //  6. Enter correct email address and password
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys(kayitliEmailAdres);
        driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys(kayitliPassword);

       //  7. Click 'login' button
        driver.findElement(By.cssSelector("button[data-qa='login-button'] ")).click();

       //  8. Verify that 'Logged in as username' is visible
        WebElement logged= driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        assertTrue(logged.isDisplayed());

       //  9. Click 'Logout' button
        driver.findElement(By.partialLinkText("Logout")).click();

       //  10. Verify that user is navigated to login page
        String expectedUrl="https://automationexercise.com/login";
        String actualUrl=driver.getCurrentUrl();
        assertEquals(expectedUrl,actualUrl);

    }
}
