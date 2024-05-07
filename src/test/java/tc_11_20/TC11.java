package tc_11_20;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import testbase.TestBase;

import static org.junit.jupiter.api.Assertions.*;

public class TC11 extends TestBase {

    @Test
    void VerifySubscriptionInCartPage() {
      // 1. Launch browser
      // 2. Navigate to url 'http://automationexercise.com'
      // 3. Verify that home page is visible successfully
        assertEquals("https://automationexercise.com/",driver.getCurrentUrl());

      // 4. Click 'Cart' button
        WebElement cartButton= driver.findElement(By.partialLinkText("Cart"));
        cartButton.click();

      // 5. Scroll down to footer
        actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();

      // 6. Verify text 'SUBSCRIPTION'
        WebElement subscription= driver.findElement(By.xpath("//h2[.='Subscription']"));
        assertEquals(subscription.getText(),"SUBSCRIPTION");

      // 7. Enter email address in input and click arrow button
        driver.findElement(By.id("susbscribe_email")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("subscribe")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("setTimeout(function(){}, 10000);");


      // 8. Verify success message 'You have been successfully subscribed!' is visible
        String actualSuccessfully=driver.findElement(By.xpath("//div[.='You have been successfully subscribed!']")).getText();
        String expectedSuccessfully="You have been successfully subscribed!";
        assertEquals(actualSuccessfully,expectedSuccessfully);

    }

}
