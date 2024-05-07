package tc_21_26;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import testbase.TestBase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TC23 extends TestBase {

    @Test
    void VerifyAddressDetailsInCheckoutPage() {

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

        String name=faker.name().firstName();
        String lastName=faker.name().lastName();
        String companyName=faker.company().name();
        String streetAddress=faker.address().streetAddress();
        String streetAddress2=faker.address().secondaryAddress();
        String state=faker.address().state();
        String city=faker.address().city();
        String zipCode=faker.address().zipCode();
        String phoneNumber=faker.phoneNumber().cellPhone();

        driver.findElement(By.id("first_name")).sendKeys(name, Keys.TAB,lastName,Keys.TAB,
                companyName,Keys.TAB, streetAddress,Keys.TAB, streetAddress2,Keys.TAB,
                "India",Keys.TAB,state,Keys.TAB,city,Keys.TAB,zipCode,Keys.TAB,phoneNumber);

        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
        cookie1();

     //   6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement accountcreated= driver.findElement(By.xpath("//b[.='Account Created!']"));
        assertTrue(accountcreated.isDisplayed());

        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

     //   7. Verify ' Logged in as username' at top
        WebElement logged= driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        assertTrue(logged.isDisplayed());

     //   8. Add products to cart
        driver.findElement(By.partialLinkText("Add to cart")).click();
        driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();

     //   9. Click 'Cart' button
        driver.findElement(By.partialLinkText("Cart")).click();
        cookie1();

     //   10. Verify that cart page is displayed
        assertTrue(driver.findElement(By.xpath("//*[.='Shopping Cart']")).isDisplayed());

     //   11. Click Proceed To Checkout
        driver.findElement(By.partialLinkText("Proceed To Checkout")).click();
        cookie1();

     //   12. Verify that the delivery address is same address filled at the time registration of account
        List<WebElement> actualDeliveryAddress=driver.findElements(By.id("address_delivery"));
        for (WebElement w:actualDeliveryAddress){
               assertTrue(w.getText().contains(name));
               assertTrue(w.getText().contains(lastName));
               assertTrue(w.getText().contains(companyName));
               assertTrue(w.getText().contains(streetAddress));
               assertTrue(w.getText().contains(streetAddress2));
               assertTrue(w.getText().contains(state));
               assertTrue(w.getText().contains(city));
               assertTrue(w.getText().contains(zipCode));
               assertTrue(w.getText().contains(phoneNumber));
        }
     //   13. Verify that the billing address is same address filled at the time registration of account
        List<WebElement> actualBillingAddress=driver.findElements(By.id("address_invoice"));
        for (WebElement w:actualBillingAddress){
            assertTrue(w.getText().contains(name));
            assertTrue(w.getText().contains(lastName));
            assertTrue(w.getText().contains(companyName));
            assertTrue(w.getText().contains(streetAddress));
            assertTrue(w.getText().contains(streetAddress2));
            assertTrue(w.getText().contains(state));
            assertTrue(w.getText().contains(city));
            assertTrue(w.getText().contains(zipCode));
            assertTrue(w.getText().contains(phoneNumber));
        }
     //   14. Click 'Delete Account' button
        driver.findElement(By.partialLinkText("Delete Account")).click();

     //   15. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        assertTrue(driver.findElement(By.xpath("//b[.='Account Deleted!']")).isDisplayed());

        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();
    }
}
