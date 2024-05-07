package tc_1_10;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import testbase.TestBase;

import static org.junit.jupiter.api.Assertions.*;

public class TC10 extends TestBase {
    @Test
    void VerifySubscriptionInHomePage() {

     //   1. Launch browser
     //   2. Navigate to url 'http://automationexercise.com'
     //   3. Verify that home page is visible successfully
        assertEquals("https://automationexercise.com/",driver.getCurrentUrl());

     //   4. Scroll down to footer
        WebElement subscription= driver.findElement(By.xpath("//h2[.='Subscription']"));
        actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();

     //   5. Verify text 'SUBSCRIPTION'
        assertEquals(subscription.getText(),"SUBSCRIPTION");

     //   6. Enter email address in input and click arrow button
        driver.findElement(By.id("susbscribe_email")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("subscribe")).click();

     //   7. Verify success message 'You have been successfully subscribed!' is visible
        String actualSuccessfully=driver.findElement(By.xpath("//div[.='You have been successfully subscribed!']")).getText();
        String expectedSuccessfully="You have been successfully subscribed!";
        assertEquals(actualSuccessfully,expectedSuccessfully);

    }
}
