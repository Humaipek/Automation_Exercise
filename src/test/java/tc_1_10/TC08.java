package tc_1_10;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testbase.TestBase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TC08 extends TestBase {

    @Test
    void VerifyAllProductsAndProductDetailPage() {

     //   1. Launch browser
     //   2. Navigate to url 'http://automationexercise.com'
     //   3. Verify that home page is visible successfully
        assertEquals("https://automationexercise.com/",driver.getCurrentUrl());

     //   4. Click on 'Products' button
        driver.findElement(By.partialLinkText("Products")).click();
        cookie1();

     //   5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement actualAllProducts= driver.findElement(By.xpath("//*[.='All Products']"));
        String exceptedAllProducts="ALL PRODUCTS";
        assertEquals(actualAllProducts.getText(),exceptedAllProducts);

     //   6. The products list is visible
        List<WebElement> allProducts=driver.findElements(By.xpath("//div[@class='productinfo text-center']/img"));
        for (WebElement w:allProducts){
            assertTrue(w.isDisplayed());
        }

        //   7. Click on 'View Product' of first product
        driver.findElement(By.partialLinkText("View Product")).click();

     //   8. User is landed to product detail page
        String expectedTitleDeteils="Automation Exercise - Product Details";
        String actualTitleDetails=driver.getTitle();
        assertEquals(expectedTitleDeteils,actualTitleDetails);

     //   9. Verify that detail is visible: product name, category, price, availability, condition, brand
        WebElement productName= driver.findElement(By.xpath("(//h2)[3]"));
        assertTrue(productName.isDisplayed());

        WebElement productCategory= driver.findElement(By.xpath("(//p)[3]"));
        assertTrue(productCategory.isDisplayed());

        WebElement productPrice= driver.findElement(By.xpath("(//span)[13]"));
        assertTrue(productPrice.isDisplayed());

        WebElement productAvailability= driver.findElement(By.xpath("//*[.='Availability:']"));
        assertTrue(productAvailability.isDisplayed());

        WebElement productCondition= driver.findElement(By.xpath("//*[.='Condition:']"));
        assertTrue(productCondition.isDisplayed());

        WebElement productBrand= driver.findElement(By.xpath("//*[.='Brand:']"));
        assertTrue(productBrand.isDisplayed());

    }
}
