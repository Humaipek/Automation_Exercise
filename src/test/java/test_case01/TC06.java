package test_case01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC06 extends TestBase {

    @Test
    void test01() {
        driver.get("https://automationexercise.com");
        wait(3);

        String expectedTitle="Automation Exercise";
        String actualTitle=driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);
        Assertions.assertEquals(expectedTitle,actualTitle);

        WebElement contactUs= driver.findElement(By.xpath("//a[@href='/contact_us']/i"));
        contactUs.click();
        WebElement getInTouch= driver.findElement(By.xpath("(//h2)[2]"));
        Assertions.assertTrue(getInTouch.isDisplayed());

        WebElement name=driver.findElement(By.cssSelector("input[data-qa='name']"));
        name.sendKeys("yuniel");

        WebElement email=driver.findElement(By.cssSelector("input[data-qa='email']"));
        email.sendKeys("kerby.kaidyn@foodfarms.net");

        WebElement subject=driver.findElement(By.cssSelector("input[data-qa='subject']"));
        subject.sendKeys("hello");

        WebElement message=driver.findElement(By.id("message"));
        message.sendKeys("hello world");

       /* WebElement file=driver.findElement(By.name("upload_file"));
        file.sendKeys();*/

        WebElement submit=driver.findElement(By.cssSelector("input[value='Submit']"));
        submit.submit();

        driver.switchTo().alert().accept();

        WebElement actualSuccess= driver.findElement(By.cssSelector("div[style='display: block;']"));
        String exceptedSuccess="Success! Your details have been submitted successfully.";
        Assertions.assertEquals(actualSuccess.getText(),exceptedSuccess);










    }
}
