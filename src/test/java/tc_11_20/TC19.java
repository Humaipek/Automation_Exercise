package tc_11_20;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testbase.TestBase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TC19 extends TestBase {

    @Test
    void ViewCartBrandProducts() {
       // 1. Launch browser
       // 2. Navigate to url 'http://automationexercise.com'
       // 3. Click on 'Products' button
        driver.findElement(By.partialLinkText("Products")).click();

       // 4. Verify that Brands are visible on left side bar
        assertTrue(driver.findElement(By.xpath("//*[.='Brands']")).isDisplayed());
       cookie1();

       // 5. Click on any brand name
        driver.findElement(By.xpath("//a[@href='/brand_products/Polo']")).click();
        cookie1();

       // 6. Verify that user is navigated to brand page and brand products are displayed
        assertEquals(driver.getTitle(),"Automation Exercise - Polo Products");

        List<WebElement> allProducts=driver.findElements(By.xpath("//div[@class='productinfo text-center']/img"));
        for (WebElement w:allProducts){
            assertTrue(w.isDisplayed());
        }

       // 7. On left side bar, click on any other brand link
        driver.findElement(By.xpath("//a[@href='/brand_products/H&M']")).click();
        cookie1();

       // 8. Verify that user is navigated to that brand page and can see products
        assertEquals(driver.getTitle(),"Automation Exercise - H&M Products");
        cookie1();

        List<WebElement> allProductsOtherPage=driver.findElements(By.xpath("//div[@class='productinfo text-center']/img"));
        for (WebElement w:allProductsOtherPage){
            assertTrue(w.isDisplayed());
        }
    }
}
