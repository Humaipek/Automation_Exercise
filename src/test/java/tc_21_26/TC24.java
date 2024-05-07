package tc_21_26;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import testbase.TestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TC24 extends TestBase {

    @Test
    void DownloadInvoiceAfterPurchaseOrder() {
    //   1. Launch browser
    //   2. Navigate to url 'http://automationexercise.com'
    //   3. Verify that home page is visible successfully
        assertEquals("https://automationexercise.com/",driver.getCurrentUrl());

    //   4. Add products to cart
        driver.findElement(By.partialLinkText("Add to cart")).click();
        driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();

    //   5. Click 'Cart' button
        driver.findElement(By.partialLinkText("Cart")).click();
        cookie1();

    //   6. Verify that cart page is displayed
        assertTrue(driver.findElement(By.xpath("//*[.='Shopping Cart']")).isDisplayed());

    //   7. Click Proceed To Checkout
        driver.findElement(By.partialLinkText("Proceed To Checkout")).click();
        cookie1();

    //   8. Click 'Register / Login' button
        driver.findElement(By.xpath("//u[.='Register / Login']")).click();

    //   9. Fill all details in Signup and create account
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

    //   10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement accountcreated= driver.findElement(By.xpath("//b[.='Account Created!']"));
        assertTrue(accountcreated.isDisplayed());

        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

    //   11. Verify ' Logged in as username' at top
        WebElement logged= driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        assertTrue(logged.isDisplayed());

    //   12.Click 'Cart' button
        driver.findElement(By.partialLinkText("Cart")).click();
        cookie1();

    //   13. Click 'Proceed To Checkout' button
        driver.findElement(By.partialLinkText("Proceed To Checkout")).click();
        cookie1();

    //   14. Verify Address Details and Review Your Order
        WebElement addressDetails= driver.findElement(By.xpath("//h2[.='Address Details']"));
        assertTrue(addressDetails.isDisplayed());

        WebElement reviewOrder= driver.findElement(By.xpath("//h2[.='Review Your Order']"));
        assertTrue(reviewOrder.isDisplayed());

    //   15. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.name("message")).sendKeys(faker.lorem().sentence());
        driver.findElement(By.partialLinkText("Place Order")).click();

    //   16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.name("name_on_card")).sendKeys(faker.name().firstName(),Keys.TAB,
                faker.number().digits(16),Keys.TAB,
                faker.number().digits(3),Keys.TAB,
                faker.number().digits(1),Keys.TAB,
                faker.number().digits(4));

    //   17. Click 'Pay and Confirm Order' button
        driver.findElement(By.id("submit")).click();

    //   18. Verify success message 'Your order has been placed successfully!'
        assertTrue(driver.findElement(By.id("success_message")).isDisplayed());
        wait(3);

    //   19. Click 'Download Invoice' button and verify invoice is downloaded successfully.

    //   20. Click 'Continue' button

    //   21. Click 'Delete Account' button
        driver.findElement(By.partialLinkText("Delete Account")).click();

    //   22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        assertTrue(driver.findElement(By.xpath("//b[.='Account Deleted!']")).isDisplayed());

        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();
    }
}
