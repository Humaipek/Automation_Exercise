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

public class TC03 extends TestBase {
    @Test
    void LoginUserWithIncorrectEmailAndPassword()  {

        emailregistering();

        // 1. Launch browser
        //  2. Navigate to url 'http://automationexercise.com'
        // 2. Navigate to url 'http://automationexercise.com'
        // 3. Verify that home page is visible successfully
        assertEquals("https://automationexercise.com/",driver.getCurrentUrl());

        // 4. Click on 'Signup / Login' button
        WebElement link= driver.findElement(By.partialLinkText("Signup / Login"));
        link.click();

        // 5. Verify 'Login to your account' is visible
        WebElement loginAcccount= driver.findElement(By.xpath("//h2[.='Login to your account']"));
        assertTrue(loginAcccount.isDisplayed());

        // 6. Enter incorrect email address and password
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys(kayitliEmailAdres);
        driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys(kayitliPassword);

        // 7. Click 'login' button
        driver.findElement(By.cssSelector("button[data-qa='login-button'] ")).click();

        // 8. Verify error 'Your email or password is incorrect!' is visible
        driver.findElement(By.partialLinkText("Delete Account")).click();

    }
}
