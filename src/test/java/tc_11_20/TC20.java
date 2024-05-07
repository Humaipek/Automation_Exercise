package tc_11_20;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testbase.TestBase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TC20 extends TestBase {

    @Test
    void SearchProductsandVerifyCartAfterLogin() {

        emailregistering();

        //  1. Launch browser
//  2. Navigate to url 'http://automationexercise.com'

//  3. Click on 'Products' button
        driver.findElement(By.partialLinkText("Products")).click();

//  4. Verify user is navigated to ALL PRODUCTS page successfully
        assertEquals(driver.getTitle(),"Automation Exercise - All Products");

//  5. Enter product name in search input and click search button
        driver.findElement(By.id("search_product")).sendKeys("dress");

        driver.findElement(By.id("submit_search")).click();
        cookie1();

//  6. Verify 'SEARCHED PRODUCTS' is visible
        String actualText=driver.findElement(By.xpath("//h2[.='Searched Products']")).getText();
        assertEquals(actualText,"SEARCHED PRODUCTS");

//  7. Verify all the products related to search are visible
        List<WebElement> allProducts=driver.findElements(By.xpath("//div[@class='productinfo text-center']/img"));
        for (WebElement w:allProducts){
            assertTrue(w.isDisplayed());
        }

//  8. Add those products to cart
        List<WebElement> addToCart=driver.findElements(By.xpath("//div[@class='productinfo text-center']/a"));
        for (WebElement w:addToCart){
            w.click();
            driver.findElement(By.xpath("//button[.='Continue Shopping']")).click();
        }

//  9. Click 'Cart' button and verify that products are visible in cart
        driver.findElement(By.partialLinkText("Cart")).click();

        List<WebElement> cartList=driver.findElements(By.tagName("tbody"));

        for (WebElement w:cartList){
            assertTrue(w.isDisplayed());
        }
//  10. Click 'Signup / Login' button and submit login details
        driver.findElement(By.partialLinkText("Signup / Login")).click();

        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys(kayitliEmailAdres);
        driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys(kayitliPassword);
        driver.findElement(By.cssSelector("button[data-qa='login-button'] ")).click();

//  11. Again, go to Cart page
        driver.findElement(By.partialLinkText("Cart")).click();

//  12. Verify that those products are visible in cart after login as well
        List<WebElement> etterLoginCartList=driver.findElements(By.tagName("tbody"));
        for (WebElement w:etterLoginCartList){
            assertTrue(w.isDisplayed());
        }
    }
}
