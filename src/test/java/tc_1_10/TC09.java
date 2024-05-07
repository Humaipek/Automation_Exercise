package tc_1_10;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testbase.TestBase;

import java.util.List;

public class TC09 extends TestBase {

    @Test
    void SearchProduct() {

      //  1. Launch browser
      //  2. Navigate to url 'http://automationexercise.com'
      //  3. Verify that home page is visible successfully
        assertEquals("https://automationexercise.com/",driver.getCurrentUrl());

      //  4. Click on 'Products' button
        driver.findElement(By.partialLinkText("Products")).click();

      //  5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement actualAllProducts= driver.findElement(By.xpath("//*[.='All Products']"));
        String exceptedAllProducts="ALL PRODUCTS";
        assertEquals(actualAllProducts.getText(),exceptedAllProducts);

      //  6. Enter product name in search input and click search button
        driver.findElement(By.id("search_product")).sendKeys("dress");
        driver.findElement(By.id("submit_search")).click();

      //  7. Verify 'SEARCHED PRODUCTS' is visible
        WebElement actualText=driver.findElement(By.xpath("//h2[.='Searched Products']"));
        String expectedText="SEARCHED PRODUCTS";
        assertEquals(actualText.getText(),expectedText);

      //  8. Verify all the products related to search are visible
        List<WebElement> allProducts=driver.findElements(By.xpath("//div[@class='product-image-wrapper']"));
        for (WebElement w:allProducts){
            assertTrue(w.isDisplayed());
        }

    }
}
