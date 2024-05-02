package tc_1_10;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import testbase.TestBase;

import static org.junit.jupiter.api.Assertions.*;

public class TC10 extends TestBase {
    @Test
    void test01() {

        String expectedTitle="Automation Exercise";
        String actualTitle=driver.getTitle();
        assertEquals(expectedTitle,actualTitle);

        WebElement subscription= driver.findElement(By.xpath("//h2[.='Subscription']"));
        actions().sendKeys(Keys.END).perform();
        String actualText=subscription.getText();
        assertEquals(actualText,"SUBSCRIPTION");

        WebElement emailAddress= driver.findElement(By.id("susbscribe_email"));
        emailAddress.sendKeys("ziggy.kayson@foodfarms.net");
        WebElement subscriptButton=driver.findElement(By.id("subscribe"));
        subscriptButton.click();

        String actualSuccessfully=driver.findElement(By.xpath("//div[.='You have been successfully subscribed!']")).getText();
        String expectedSuccessfully="You have been successfully subscribed!";
        assertEquals(actualSuccessfully,expectedSuccessfully);

    }
}
