package tc_1_10;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testbase.TestBase;

import java.util.List;

public class TC09 extends TestBase {

    @Test
    void test01() {

        String expectedTitle="Automation Exercise";
        String actualTitle=driver.getTitle();
        assertEquals(expectedTitle,actualTitle);

        WebElement contactUs= driver.findElement(By.partialLinkText("Products"));
        contactUs.click();

        WebElement actualAllProducts= driver.findElement(By.xpath("//*[.='All Products']"));
        String exceptedAllProducts="ALL PRODUCTS";
        assertEquals(actualAllProducts.getText(),exceptedAllProducts);

        WebElement searchInput= driver.findElement(By.id("search_product"));
        searchInput.sendKeys("dress");

        WebElement searchButton= driver.findElement(By.id("submit_search"));
        searchButton.click();

        List<WebElement> productList=driver.findElements(By.xpath("//div[@class='product-image-wrapper']"));
        assertFalse(productList.isEmpty());


    }
}
