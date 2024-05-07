package tc_11_20;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testbase.TestBase;

import static org.junit.jupiter.api.Assertions.*;

public class TC12 extends TestBase {

    @Test
    void AddProductsInCart() {
//  1. Launch browser
//  2. Navigate to url 'http://automationexercise.com'
//  3. Verify that home page is visible successfully
        assertEquals("https://automationexercise.com/",driver.getCurrentUrl());

//  4. Click 'Products' button
        driver.findElement(By.partialLinkText("Products")).click();

//  5. Hover over first product and click 'Add to cart'
        WebElement firstProduct= driver.findElement(By.xpath("//a[@data-product-id='1']"));
        firstProduct.click();

//  6. Click 'Continue Shopping' button
        driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();

//  7. Hover over second product and click 'Add to cart'
        WebElement secondProduct= driver.findElement(By.xpath("//a[@data-product-id='2']"));
        secondProduct.click();

//  8. Click 'View Cart' button
        driver.findElement(By.xpath("//u[.='View Cart']")).click();

//  9. Verify both products are added to Cart
        WebElement first=driver.findElement(By.xpath("//a[@data-product-id='1']"));
        WebElement second=driver.findElement(By.xpath("//a[@data-product-id='2']"));

        assertTrue( first.isDisplayed() && second.isDisplayed() );

//  10. Verify their prices, quantity and total price
        String firstPrice=driver.findElement(By.xpath("(//td[@class='cart_price']/p)[1]")).getText();
        String exceptedFirsPrice="Rs. 500";
        assertEquals(firstPrice,exceptedFirsPrice);

        String secondPrice=driver.findElement(By.xpath("(//td[@class='cart_price']/p)[2]")).getText();
        String exceptedSecondPrice="Rs. 400";
        assertEquals(secondPrice,exceptedSecondPrice);

        String firstQuantity=driver.findElement(By.xpath("(//button[@class='disabled'])[1]")).getText();
        String exceptedFirsQuantity="1";
        assertEquals(firstQuantity,exceptedFirsQuantity);

        String secondQuantity=driver.findElement(By.xpath("(//button[@class='disabled'])[2]")).getText();
        String exceptedSecondQuantity="1";
        assertEquals(secondQuantity,exceptedSecondQuantity);


        String firstPriceTotal=driver.findElement(By.xpath("(//p[@class='cart_total_price'])[1]")).getText();
        String exceptedFirstPriceTotal="Rs. 500";
        assertEquals(firstPriceTotal,exceptedFirstPriceTotal);

        String secondPriceTotal=driver.findElement(By.xpath("(//p[@class='cart_total_price'])[2]")).getText();
        String exceptedSecondPriceTotal="Rs. 400";
        assertEquals(secondPriceTotal,exceptedSecondPriceTotal);


    }
}
