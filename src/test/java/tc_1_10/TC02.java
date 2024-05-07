package tc_1_10;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import testbase.TestBase;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class TC02 extends TestBase {

    @Test
    void LoginUserWithCorrectEmailAndPassword() {

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

    //  9. Click 'Delete Account' button
        WebElement delete= driver.findElement(By.partialLinkText("Delete Account"));
        delete.click();

    //  10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement accountdeleted= driver.findElement(By.xpath("//b[.='Account Deleted!']"));
        assertTrue(accountdeleted.isDisplayed());
    }


}
