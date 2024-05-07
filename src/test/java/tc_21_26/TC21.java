package tc_21_26;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import testbase.TestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TC21 extends TestBase {

    @Test
    void AddReviewOnProduct() {

    //    1. Launch browser
    //    2. Navigate to url 'http://automationexercise.com'
    //    3. Click on 'Products' button
        driver.findElement(By.partialLinkText("Products")).click();
        cookie1();

    //    4. Verify user is navigated to ALL PRODUCTS page successfully
        assertEquals(driver.getTitle(),"Automation Exercise - All Products");

    //    5. Click on 'View Product' button
        driver.findElement(By.partialLinkText("View Product")).click();
        cookie1();

    //    6. Verify 'Write Your Review' is visible
        assertTrue(driver.findElement(By.xpath("//a[.='Write Your Review']")).isDisplayed());

    //    7. Enter name, email and review
        driver.findElement(By.id("name")).sendKeys(faker.name().firstName(), Keys.TAB,
                faker.internet().emailAddress(),Keys.TAB,faker.lorem().paragraph());

    //    8. Click 'Submit' button
        driver.findElement(By.id("button-review")).click();
        cookie1();

        //    9. Verify success message 'Thank you for your review.'
        assertTrue(driver.findElement(By.xpath("//span[.='Thank you for your review.']")).isDisplayed());

    }
}
