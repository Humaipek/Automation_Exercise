package tc_1_10;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testbase.TestBase;
import static org.junit.jupiter.api.Assertions.*;

public class TC05 extends TestBase {

    @Test
    void RegisterUserWithExistingEmail() {

       emailregistering();

       //  1. Launch browser
       //  2. Navigate to url 'http://automationexercise.com'
       //  3. Verify that home page is visible successfully
        assertEquals("https://automationexercise.com/",driver.getCurrentUrl());

       //  4. Click on 'Signup / Login' button
        driver.findElement(By.partialLinkText("Signup / Login")).click();
        cookie1();

       //  5. Verify 'New User Signup!' is visible
        WebElement newUserSignUp= driver.findElement(By.xpath("(//h2)[3]"));
        assertTrue(newUserSignUp.isDisplayed());

       //  6. Enter name and already registered email address
        driver.findElement(By.xpath("//input[@data-qa='signup-name'] ")).sendKeys(faker.name().firstName());

        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(kayitliEmailAdres);

       //  7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

       //  8. Verify error 'Email Address already exist!' is visible
        WebElement emailExist= driver.findElement(By.xpath("//*[.='Email Address already exist!']"));
        assertTrue(emailExist.isDisplayed());

    }
}
