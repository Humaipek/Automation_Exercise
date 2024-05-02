package tc_11_20;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import testbase.TestBase;

import static org.junit.jupiter.api.Assertions.*;

public class TC14 extends TestBase {

//  1. Launch browser
//  2. Navigate to url 'http://automationexercise.com'
//              3. Verify that home page is visible successfully
//  4. Click 'View Product' for any product on home page
//  5. Verify product detail is opened
//  6. Increase quantity to 4
//              7. Click 'Add to cart' button
//  8. Click 'View Cart' button
//  9. Verify that product is displayed in cart page with exact quantity
//      Test Case 14: Place Order: Register while Checkout
//  1. Launch browser
//  2. Navigate to url 'http://automationexercise.com'
//              3. Verify that home page is visible successfully
//  4. Add products to cart
//  5. Click 'Cart' button
//  6. Verify that cart page is displayed
//  7. Click Proceed To Checkout
//  8. Click 'Register / Login' button
//  9. Fill all details in Signup and create account
//  10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
//  11. Verify ' Logged in as username' at top
//  12.Click 'Cart' button
//  13. Click 'Proceed To Checkout' button
//  14. Verify Address Details and Review Your Order
//  15. Enter description in comment text area and click 'Place Order'
//              16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
//  17. Click 'Pay and Confirm Order' button
//  18. Verify success message 'Your order has been placed successfully!'
//              19. Click 'Delete Account' button
//  20. Verify 'ACCOUNT DELETED!' and click 'Continue' button

    @Test
    void test01() {

        String expectedTitle="Automation Exercise";
        String actualTitle=driver.getTitle();
        assertEquals(expectedTitle,actualTitle);

        driver.findElement(By.partialLinkText("Add to cart")).click();

        driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();
        driver.findElement(By.partialLinkText("Cart")).click();

        assertTrue(driver.findElement(By.xpath("//*[.='Shopping Cart']")).isDisplayed());

        driver.findElement(By.partialLinkText("Proceed To Checkout")).click();
        wait(2);
        driver.findElement(By.partialLinkText("Register / Login")).click();
        wait(2);

        driver.findElement(By.name("name")).sendKeys("ayotunde");
        driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys("yonathan.ren@foodfarms.net");
        driver.findElement(By.xpath("//button[.='Signup']")).click();
        wait(3);

        WebElement titleMrs= driver.findElement(By.id("id_gender2"));
        titleMrs.click();

        WebElement userName=driver.findElement(By.id("name"));
        userName.clear();
        userName.sendKeys("ayotunde");

        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("Dunya1234");

        WebElement ddm= driver.findElement(By.id("days"));
        Select optionsDay=new Select(ddm);
        optionsDay.selectByVisibleText("24");

        WebElement ddm2= driver.findElement(By.id("months"));
        Select optionsMonth=new Select(ddm2);
        optionsMonth.selectByVisibleText("September");

        WebElement ddm3= driver.findElement(By.id("years"));
        Select optionsYear=new Select(ddm3);
        optionsYear.selectByVisibleText("1978");


        WebElement checkBox=driver.findElement(By.id("newsletter"));
        checkBox.click();

        WebElement receive=driver.findElement(By.id("optin"));
        receive.click();

        WebElement firstName=driver.findElement(By.id("first_name"));
        firstName.sendKeys("yuniel");

        WebElement lastName=driver.findElement(By.id("last_name"));
        lastName.sendKeys("kodey");

        WebElement companyName=driver.findElement(By.id("company"));
        companyName.sendKeys("kodey");

        WebElement address1=driver.findElement(By.id("address1"));
        address1.sendKeys("kodey");

        WebElement address2=driver.findElement(By.id("address2"));
        address2.sendKeys("kodey");

        WebElement ddm4= driver.findElement(By.id("country"));
        Select optionsCountry=new Select(ddm4);
        optionsCountry.selectByVisibleText("India");

        WebElement state=driver.findElement(By.id("state"));
        state.sendKeys("kodey");

        WebElement city=driver.findElement(By.id("city"));
        city.sendKeys("kodey");

        WebElement zipcode=driver.findElement(By.id("zipcode"));
        zipcode.sendKeys("3244");

        WebElement mobil=driver.findElement(By.id("mobile_number"));
        mobil.sendKeys("3244226677");

        WebElement create=driver.findElement(By.xpath("//button[@data-qa='create-account']"));
        create.click();
        wait(2);

        WebElement accountcreated= driver.findElement(By.xpath("//b[.='Account Created!']"));
        assertTrue(accountcreated.isDisplayed());

        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        wait(2);

        WebElement logged= driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        assertTrue(logged.isDisplayed());

        driver.findElement(By.partialLinkText("Cart")).click();
        wait(2);

        driver.findElement(By.partialLinkText("Proceed To Checkout")).click();
        wait(2);

        assertTrue(
                driver.findElement(By.xpath("//*[.='Address Details']")).isDisplayed() &&
                driver.findElement(By.xpath("//*[.='Review Your Order']")).isDisplayed());

        driver.findElement(By.name("message")).sendKeys("siparis ver");
        driver.findElement(By.partialLinkText("Place Order")).click();
        wait(2);

        driver.findElement(By.name("name_on_card")).sendKeys("yuniel");
        driver.findElement(By.name("card_number")).sendKeys("1234567890");
        driver.findElement(By.name("cvc")).sendKeys("111");
        driver.findElement(By.name("expiry_month")).sendKeys("11");
        driver.findElement(By.name("expiry_year")).sendKeys("2200");

        driver.findElement(By.id("submit")).click();
        wait(5);

        String exceptedMessage="Your order has been placed successfully!";

        String actualMessage=driver.findElement(By.id("success_message")).getText();
        System.out.println("actualMessage = " + actualMessage);
        WebElement a=driver.findElement(By.id("success_message"));
        assertTrue(a.isDisplayed());



        driver.findElement(By.partialLinkText("Delete Account")).click();









    }
}
