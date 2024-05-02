package tc_1_10;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testbase.TestBase;

import static org.junit.jupiter.api.Assertions.*;

public class TC06 extends TestBase {

    @Test
    void test01() {

        String expectedTitle="Automation Exercise";
        String actualTitle=driver.getTitle();
        assertEquals(expectedTitle,actualTitle);

        WebElement contactUs= driver.findElement(By.partialLinkText("Contact us"));
        contactUs.click();
        WebElement getInTouch= driver.findElement(By.xpath("(//h2)[2]"));
        assertTrue(getInTouch.isDisplayed());

        WebElement name=driver.findElement(By.cssSelector("input[data-qa='name']"));
        name.sendKeys("yuniel");

        WebElement email=driver.findElement(By.cssSelector("input[data-qa='email']"));
        email.sendKeys("kerby.kaidyn@foodfarms.net");

        WebElement subject=driver.findElement(By.cssSelector("input[data-qa='subject']"));
        subject.sendKeys("hello");

        WebElement message=driver.findElement(By.id("message"));
        message.sendKeys("hello world");

        WebElement fileInput=driver.findElement(By.cssSelector("input[name='upload_file']"));
        fileInput.sendKeys("C:\\Users\\humai\\OneDrive\\Masaüstü\\Web Denemesı\\Resimler\\th.jpg");

        WebElement submit=driver.findElement(By.cssSelector("input[value='Submit']"));
        submit.submit();

        driver.switchTo().alert().accept();

        WebElement actualSuccess= driver.findElement(By.cssSelector("div[style='display: block;']"));
        String exceptedSuccess="Success! Your details have been submitted successfully.";
        assertEquals(actualSuccess.getText(),exceptedSuccess);

    }
}
