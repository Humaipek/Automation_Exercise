package tc_21_26;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testbase.TestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TC25 extends TestBase {

    @Test
    void VerifyScrollUpUsingArrowButtonAndScrollDownFunctionality() {

      //  1. Launch browser
      //  2. Navigate to url 'http://automationexercise.com'
      //  3. Verify that home page is visible successfully
        assertEquals("https://automationexercise.com/",driver.getCurrentUrl());

      //  4. Scroll down page to bottom
        actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();

      //  5. Verify 'SUBSCRIPTION' is visible
        WebElement subscription= driver.findElement(By.xpath("//h2[.='Subscription']"));
        assertEquals(subscription.getText(),"SUBSCRIPTION");

      //  6. Click on arrow at bottom right side to move upward
        driver.findElement(By.id("scrollUp")).click();

      //  7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
        WebElement s= driver.findElement(By.cssSelector("a[style='position: fixed; z-index: 2147483647; display: none;']"));
        String style="position: fixed; z-index: 2147483647; display: none;";

        assertEquals(s.getAttribute("style"),style);

        assertTrue(driver.findElement(By.xpath("//*[.='Full-Fledged practice website for Automation Engineers']")).isDisplayed());
    }
}
