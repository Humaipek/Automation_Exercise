package tc_11_20;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tc_1_10.TestBase;

public class TC12 extends TestBase {
//      Test Case 12: Add Products in Cart
//  1. Launch browser
//  2. Navigate to url 'http://automationexercise.com'
//              3. Verify that home page is visible successfully
//  4. Click 'Products' button
//  5. Hover over first product and click 'Add to cart'
//              6. Click 'Continue Shopping' button
//  7. Hover over second product and click 'Add to cart'
//              8. Click 'View Cart' button
//  9. Verify both products are added to Cart
//  10. Verify their prices, quantity and total price


    @Test
    void test01() {

        driver.get("http://automationexercise.com");
        wait(3);

        String expectedTitle="Automation Exercise";
        String actualTitle=driver.getTitle();
        Assertions.assertEquals(expectedTitle,actualTitle);

        WebElement productButton= driver.findElement(By.partialLinkText("Products"));
        productButton.click();

        WebElement firstProduct= driver.findElement(By.xpath("//a[@data-product-id='1']"));
        firstProduct.click();

        WebElement continueShopping= driver.findElement(By.xpath("//button[.='Continue Shopping']"));
        continueShopping.click();

        WebElement secondProduct= driver.findElement(By.xpath("//a[@data-product-id='2']"));
        secondProduct.click();

        WebElement viewButton= driver.findElement(By.xpath("//u[.='View Cart']"));
        viewButton.click();

        WebElement first=driver.findElement(By.xpath("//a[@data-product-id='1']"));
        WebElement second=driver.findElement(By.xpath("//a[@data-product-id='2']"));

        Assertions.assertTrue( first.isDisplayed() && second.isDisplayed() );

        String firstPrice=driver.findElement(By.xpath("(//td[@class='cart_price']/p)[1]")).getText();
        String exceptedFirsPrice="Rs. 500";
        Assertions.assertEquals(firstPrice,exceptedFirsPrice);

        String secondPrice=driver.findElement(By.xpath("(//td[@class='cart_price']/p)[2]")).getText();
        String exceptedSecondPrice="Rs. 400";
        Assertions.assertEquals(secondPrice,exceptedSecondPrice);

        String firstPriceTotal=driver.findElement(By.xpath("(//p[@class='cart_total_price'])[1]")).getText();
        String exceptedFirstPriceTotal="Rs. 500";
        Assertions.assertEquals(firstPriceTotal,exceptedFirstPriceTotal);

        String secondPriceTotal=driver.findElement(By.xpath("(//p[@class='cart_total_price'])[2]")).getText();
        String exceptedSecondPriceTotal="Rs. 400";
        Assertions.assertEquals(secondPriceTotal,exceptedSecondPriceTotal);


    }
}
