package tc_1_10;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testbase.TestBase;

import static org.junit.jupiter.api.Assertions.*;

public class TC08 extends TestBase {

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

        String actualUrl2= driver.getCurrentUrl();
        String exceptedUrl2="https://automationexercise.com/products";
        assertEquals(actualUrl2,exceptedUrl2);

        WebElement wiewProductOfFirst= driver.findElement(By.partialLinkText("View Product"));
        wiewProductOfFirst.click();

        String expectedTitleDeteils="Automation Exercise - Product Details";
        String actualTitleDetails=driver.getTitle();
        assertEquals(expectedTitleDeteils,actualTitleDetails);

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
