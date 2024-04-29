package test_case01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC07 extends TestBase{

    @Test
    void test01() {
        driver.get("https://automationexercise.com");
        wait(3);

        String expectedTitle="Automation Exercise";
        String actualTitle=driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);
        Assertions.assertEquals(expectedTitle,actualTitle);

        WebElement contactUs= driver.findElement(By.xpath("//a[@href='/test_cases']/i"));
        contactUs.click();

        String actualUrl= driver.getCurrentUrl();
        String exceptedUrl="https://automationexercise.com/test_cases";
        Assertions.assertEquals(actualUrl,exceptedUrl);
    }
}
