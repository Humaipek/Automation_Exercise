package tc_1_10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC05 extends TestBase{

    @Test
    void test01() {

        driver.get("https://automationexercise.com");
        wait(3);

        String expectedTitle="Automation Exercise";
        String actualTitle=driver.getTitle();
        Assertions.assertEquals(expectedTitle,actualTitle);

        WebElement link= driver.findElement(By.partialLinkText("Signup / Login"));
        link.click();

        WebElement newUserSignUp= driver.findElement(By.xpath("(//h2)[3]"));
        Assertions.assertTrue(newUserSignUp.isDisplayed());

        WebElement name=driver.findElement(By.xpath("//input[@data-qa='signup-name'] "));
        name.sendKeys("korbin");

        WebElement email=driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        email.sendKeys("ensar.jameer@foodfarms.net");

        WebElement enter=driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        enter.click();

        WebElement emailExist= driver.findElement(By.xpath("//*[.='Email Address already exist!']"));
        Assertions.assertTrue(emailExist.isDisplayed());


    }
}
