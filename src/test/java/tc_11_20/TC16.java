package tc_11_20;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import testbase.TestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TC16 extends TestBase {

    @Test
    void PlaceOrderLoginBeforeCheckout() {

        emailregistering();

     //  1. Launch browser
     //  2. Navigate to url 'http://automationexercise.com'
     //  3. Verify that home page is visible successfully
        assertEquals("https://automationexercise.com/",driver.getCurrentUrl());

     //  4. Click 'Signup / Login' button
        driver.findElement(By.partialLinkText("Signup / Login")).click();

     //  5. Fill email, password and click 'Login' button
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys(kayitliEmailAdres);
        driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys(kayitliPassword);
        driver.findElement(By.cssSelector("button[data-qa='login-button'] ")).click();

     //  6. Verify 'Logged in as username' at top
        WebElement logged= driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        assertTrue(logged.isDisplayed());

     //  7. Add products to cart
        driver.findElement(By.partialLinkText("Add to cart")).click();

     //  8. Click 'Cart' button
        driver.findElement(By.partialLinkText("Cart")).click();
        cookie1();

     //  9. Verify that cart page is displayed
        assertTrue(driver.findElement(By.xpath("//*[.='Shopping Cart']")).isDisplayed());

     //  10. Click Proceed To Checkout
        driver.findElement(By.partialLinkText("Proceed To Checkout")).click();
        cookie1();

     //  11. Verify Address Details and Review Your Order
        assertTrue(
                driver.findElement(By.xpath("//*[.='Address Details']")).isDisplayed() &&
                        driver.findElement(By.xpath("//*[.='Review Your Order']")).isDisplayed());

        //  12. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.name("message")).sendKeys(faker.lorem().paragraph());

        driver.findElement(By.partialLinkText("Place Order")).click();
        cookie1();

     //  13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.name("name_on_card")).sendKeys(faker.name().firstName(), Keys.TAB,
                faker.number().digits(16),Keys.TAB,
                faker.number().digits(3),Keys.TAB,
                faker.number().digits(1),Keys.TAB,
                faker.number().digits(4));

     //  14. Click 'Pay and Confirm Order' button
        driver.findElement(By.id("submit")).click();
        cookie1();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("setTimeout(function(){}, 100000);");


        //  15. Verify success message 'Your order has been placed successfully!'
        assertTrue(driver.findElement(By.id("success_message")).isDisplayed());

     //  16. Click 'Delete Account' button
        driver.findElement(By.partialLinkText("Delete Account")).click();
        cookie1();

     //  17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        assertTrue(driver.findElement(By.xpath("//b[.='Account Deleted!']")).isDisplayed());

        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();

    }
}
