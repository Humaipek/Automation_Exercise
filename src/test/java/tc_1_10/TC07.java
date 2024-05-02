package tc_1_10;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testbase.TestBase;

import static org.junit.jupiter.api.Assertions.*;

public class TC07 extends TestBase {

    @Test
    void test01() {

        String expectedTitle="Automation Exercise";
        String actualTitle=driver.getTitle();
        assertEquals(expectedTitle,actualTitle);

        WebElement contactUs= driver.findElement(By.partialLinkText("Test Cases"));
        contactUs.click();

        String actualUrl= driver.getCurrentUrl();
        String exceptedUrl="https://automationexercise.com/test_cases";
        assertEquals(actualUrl,exceptedUrl);
    }
}
