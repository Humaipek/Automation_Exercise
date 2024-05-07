package tc_1_10;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testbase.TestBase;

import static org.junit.jupiter.api.Assertions.*;

public class TC07 extends TestBase {

    @Test
    void VerifyTestCasesPage() {

      //  1. Launch browser
      //  2. Navigate to url 'http://automationexercise.com'
      //  3. Verify that home page is visible successfully
        assertEquals("https://automationexercise.com/",driver.getCurrentUrl());

      //  4. Click on 'Test Cases' button
        driver.findElement(By.partialLinkText("Test Cases")).click();

      //  5. Verify user is navigated to test cases page successfully
        String actualUrl= driver.getCurrentUrl();
        String exceptedUrl="https://automationexercise.com/test_cases";
        assertEquals(actualUrl,exceptedUrl);

    }
}
