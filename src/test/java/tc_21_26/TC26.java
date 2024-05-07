package tc_21_26;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import testbase.TestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TC26 extends TestBase {

    @Test
    void VerifyScrollUpWithoutArrowButtonAndScrollDownFunctionality() {

     //   1. Launch browser
     //   2. Navigate to url 'http://automationexercise.com'
     //   3. Verify that home page is visible successfully
        assertEquals("https://automationexercise.com/",driver.getCurrentUrl());

     //   4. Scroll down page to bottom
        actions.sendKeys(Keys.END).perform();

     //   5. Verify 'SUBSCRIPTION' is visible
        WebElement subscription= driver.findElement(By.xpath("//h2[.='Subscription']"));
        assertEquals(subscription.getText(),"SUBSCRIPTION");

     //   6. Scroll up page to top
        actions.sendKeys(Keys.UP);

     //   7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
    }
}
