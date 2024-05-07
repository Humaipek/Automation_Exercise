package tc_11_20;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testbase.TestBase;

import static org.junit.jupiter.api.Assertions.*;

public class TC13 extends TestBase {

    @Test
    void VerifyProductQuantityInCart() {
       // 1. Launch browser
       // 2. Navigate to url 'https://automationexercise.com'
       // 3. Verify that home page is visible successfully
        assertEquals("https://automationexercise.com/",driver.getCurrentUrl());

       // 4. Click 'View Product' for any product on home page
        driver.findElement(By.partialLinkText("View Product")).click();

       // 5. Verify product detail is opened
        String actuelTitle= driver.getTitle();
        String exceptedTitle="Automation Exercise - Product Details";
        assertEquals(actuelTitle,exceptedTitle);

       // 6. Increase quantity to 4
        WebElement quantity= driver.findElement(By.xpath("//input[@id='quantity']"));
        quantity.clear();
        quantity.sendKeys("4");

       // 7. Click 'Add to cart' button
        driver.findElement(By.xpath("//button[@type='button']")).click();

       // 8. Click 'View Cart' button
        driver.findElement(By.xpath("//u[.='View Cart']")).click();

       // 9. Verify that product is displayed in cart page with exact quantity
        String actualQuantity=driver.findElement(By.xpath("//button[@class='disabled']")).getText();
        String exceptedQuantity="4";
        assertEquals(actualQuantity,exceptedQuantity);
    }

}
