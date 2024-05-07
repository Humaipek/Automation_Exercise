package tc_11_20;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testbase.TestBase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TC17 extends TestBase {
    @Test
    void RemoveProductsFromCart() {

//    1. Launch browser
//    2. Navigate to url 'http://automationexercise.com'
//    3. Verify that home page is visible successfully
        assertEquals("https://automationexercise.com/",driver.getCurrentUrl());

//    4. Add products to cart
        driver.findElement(By.cssSelector("a[data-product-id='3']")).click();
        cookie1();

        driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();
        cookie1();

        driver.findElement(By.cssSelector("a[data-product-id='2']")).click();
        cookie1();

        driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();
        cookie1();

        driver.findElement(By.cssSelector("a[data-product-id='1']")).click();
        cookie1();

        driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();
        cookie1();

//    5. Click 'Cart' button
        driver.findElement(By.partialLinkText("Cart")).click();
        cookie1();

//    6. Verify that cart page is displayed
        assertTrue(driver.findElement(By.xpath("//*[.='Shopping Cart']")).isDisplayed());
        cookie1();

//    7. Click 'X' button corresponding to particular product
        driver.findElement(By.cssSelector("a[data-product-id='3']")).click();

//    8. Verify that product is removed from the cart
        List<WebElement> productsList=driver.findElements(By.tagName("tbody"));
        assertEquals(productsList.size(),1);

    }
}
