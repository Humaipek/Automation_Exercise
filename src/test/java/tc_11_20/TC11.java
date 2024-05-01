package tc_11_20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import tc_1_10.TestBase;

public class TC11 extends TestBase {

    @Test
    void test01() {
        driver.get("https://automationexercise.com");
        wait(3);

        String expectedTitle="Automation Exercise";
        String actualTitle=driver.getTitle();
        Assertions.assertEquals(expectedTitle,actualTitle);

        WebElement cartButton= driver.findElement(By.partialLinkText("Cart"));
        cartButton.click();
        actions().sendKeys(Keys.END);
        WebElement subscription= driver.findElement(By.xpath("//h2[.='Subscription']"));
        String actualText=subscription.getText();
        Assertions.assertEquals(actualText,"SUBSCRIPTION");

        WebElement emailAddress= driver.findElement(By.id("susbscribe_email"));
        emailAddress.sendKeys("ziggy.kayson@foodfarms.net");
        WebElement subscriptButton=driver.findElement(By.id("subscribe"));
        subscriptButton.click();

        String actualSuccessfully=driver.findElement(By.xpath("//div[.='You have been successfully subscribed!']")).getText();
        String expectedSuccessfully="You have been successfully subscribed!";
        Assertions.assertEquals(actualSuccessfully,expectedSuccessfully);

    }

}
