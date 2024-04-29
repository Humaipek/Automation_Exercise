package test_case01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC08 extends TestBase{

    @Test
    void test01() {

        driver.get("https://automationexercise.com");
        wait(3);

        String expectedTitle="Automation Exercise";
        String actualTitle=driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);
        Assertions.assertEquals(expectedTitle,actualTitle);

        WebElement contactUs= driver.findElement(By.xpath("//a[@href='/products']/i"));
        contactUs.click();

        WebElement actualAllProducts= driver.findElement(By.xpath("//*[.='All Products']"));
        String exceptedAllProducts="ALL PRODUCTS";
        Assertions.assertEquals(actualAllProducts.getText(),exceptedAllProducts);

        String actualUrl2= driver.getCurrentUrl();
        String exceptedUrl2="https://automationexercise.com/products";
        Assertions.assertEquals(actualUrl2,exceptedUrl2);

        WebElement wiewProductOfFirst= driver.findElement(By.xpath("//a[@href='/product_details/1']/i"));
        wiewProductOfFirst.click();

        String expectedTitleDeteils="Automation Exercise - Product Details";
        String actualTitleDetails=driver.getTitle();
        Assertions.assertEquals(expectedTitleDeteils,actualTitleDetails);

        WebElement productName= driver.findElement(By.xpath("(//h2)[3]"));
        Assertions.assertTrue(productName.isDisplayed());

        WebElement productCategory= driver.findElement(By.xpath("(//p)[3]"));
        Assertions.assertTrue(productCategory.isDisplayed());

        WebElement productPrice= driver.findElement(By.xpath("(//span)[13]"));
        Assertions.assertTrue(productPrice.isDisplayed());

        WebElement productAvailability= driver.findElement(By.xpath("//*[.='Availability:']"));
        Assertions.assertTrue(productAvailability.isDisplayed());

        WebElement productCondition= driver.findElement(By.xpath("//*[.='Condition:']"));
        Assertions.assertTrue(productCondition.isDisplayed());

        WebElement productBrand= driver.findElement(By.xpath("//*[.='Brand:']"));
        Assertions.assertTrue(productBrand.isDisplayed());

    }
}
