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

public class TC15 extends TestBase {

    @Test
    void PlaceOrderRegisterBeforeCheckout() {

    //   1. Launch browser
    //   2. Navigate to url 'http://automationexercise.com'
    //   3. Verify that home page is visible successfully
        assertEquals("https://automationexercise.com/",driver.getCurrentUrl());

    //   4. Click 'Signup / Login' button
        driver.findElement(By.partialLinkText("Signup / Login")).click();

    //   5. Fill all details in Signup and create account
        driver.findElement(By.name("name")).sendKeys(faker.name().firstName());
        String email=faker.internet().emailAddress();
        driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys(email);

        driver.findElement(By.xpath("//button[.='Signup']")).click();
        cookie1();

        driver.findElement(By.id("id_gender2")).click();

        WebElement userName=driver.findElement(By.id("name"));
        userName.clear();
        userName.sendKeys(faker.name().firstName());

        String password=faker.internet().password();
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("days")).sendKeys("24", Keys.TAB,"September",Keys.TAB,"1978");

        driver.findElement(By.id("newsletter")).click();

        driver.findElement(By.id("optin")).click();

        driver.findElement(By.id("first_name")).sendKeys(faker.name().firstName(), Keys.TAB,
                faker.name().lastName(),Keys.TAB,
                faker.company().name(),Keys.TAB,
                faker.address().streetAddress(),Keys.TAB,
                faker.address().secondaryAddress(),Keys.TAB,
                "India",Keys.TAB,
                faker.address().state(),Keys.TAB,
                faker.address().city(),Keys.TAB,
                faker.address().zipCode(),Keys.TAB,
                faker.phoneNumber().cellPhone());

        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
        cookie1();

    //   6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement accountcreated= driver.findElement(By.xpath("//b[.='Account Created!']"));
        assertTrue(accountcreated.isDisplayed());

        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        cookie1();

    //   7. Verify ' Logged in as username' at top
        WebElement logged= driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        assertTrue(logged.isDisplayed());

    //   8. Add products to cart
        driver.findElement(By.partialLinkText("Add to cart")).click();

    //   9. Click 'Cart' button
        driver.findElement(By.partialLinkText("Cart")).click();
        cookie1();

    //   10. Verify that cart page is displayed
        assertTrue(driver.findElement(By.xpath("//*[.='Shopping Cart']")).isDisplayed());

    //   11. Click Proceed To Checkout
        driver.findElement(By.partialLinkText("Proceed To Checkout")).click();
        cookie1();

    //   12. Verify Address Details and Review Your Order
        assertTrue(
                driver.findElement(By.xpath("//*[.='Address Details']")).isDisplayed() &&
                        driver.findElement(By.xpath("//*[.='Review Your Order']")).isDisplayed());

        //   13. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.name("message")).sendKeys(faker.lorem().paragraph());

        driver.findElement(By.partialLinkText("Place Order")).click();
        cookie1();

    //   14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.name("name_on_card")).sendKeys(faker.name().firstName(),Keys.TAB,
                faker.number().digits(16),Keys.TAB,
                faker.number().digits(3),Keys.TAB,
                faker.number().digits(1),Keys.TAB,
                faker.number().digits(4));

    //   15. Click 'Pay and Confirm Order' button
        driver.findElement(By.id("submit")).click();
        cookie1();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("setTimeout(function(){}, 100000);");


        //   16. Verify success message 'Your order has been placed successfully!'
        assertTrue(driver.findElement(By.id("success_message")).isDisplayed());

    //   17. Click 'Delete Account' button
        driver.findElement(By.partialLinkText("Delete Account")).click();

    //   18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        assertTrue(driver.findElement(By.xpath("//b[.='Account Deleted!']")).isDisplayed());

        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();


    }
}
