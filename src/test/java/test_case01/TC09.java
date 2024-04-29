package test_case01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC09 extends TestBase{

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

        WebElement searchInput= driver.findElement(By.id("search_product"));
        searchInput.sendKeys("Blue Top");

        WebElement searchButton= driver.findElement(By.id("submit_search"));
        searchButton.click();

        WebElement searchProducts= driver.findElement(By.xpath("//h2[.='Searched Products']"));
        Assertions.assertTrue(searchProducts.isDisplayed());


        WebElement productPrice= driver.findElement(By.xpath("(//h2)[4]"));
        Assertions.assertTrue(productPrice.isDisplayed());

        WebElement productName= driver.findElement(By.xpath("(//p)[5]"));
        Assertions.assertTrue(productName.isDisplayed());

    }
}
