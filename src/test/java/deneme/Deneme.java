package deneme;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import testbase.TestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Deneme extends TestBase {

    @Test
    void name() {

        //   1. Launch browser
        //   2. Navigate to url 'http://automationexercise.com'
        //   3. Verify that home page is visible successfully
        assertEquals("https://automationexercise.com/",driver.getCurrentUrl());
        // 4. Click on 'Signup / Login' button
        driver.findElement(By.partialLinkText("Signup / Login")).click();


        //   4. Scroll down page to bottom
        actions=new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        actions.sendKeys(Keys.HOME).perform();
    }

}
