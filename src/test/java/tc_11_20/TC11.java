package tc_11_20;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import testbase.TestBase;

import static org.junit.jupiter.api.Assertions.*;

public class TC11 extends TestBase {

    @Test
    void test01() {

        String expectedTitle="Automation Exercise";
        String actualTitle=driver.getTitle();
        assertEquals(expectedTitle,actualTitle);

        WebElement cartButton= driver.findElement(By.partialLinkText("Cart"));
        cartButton.click();
        actions().sendKeys(Keys.END);
        WebElement subscription= driver.findElement(By.xpath("//h2[.='Subscription']"));
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
