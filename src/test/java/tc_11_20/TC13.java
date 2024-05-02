package tc_11_20;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testbase.TestBase;

import static org.junit.jupiter.api.Assertions.*;

public class TC13 extends TestBase {

    @Test
    void test01() {

        String expectedTitle="Automation Exercise";
        String actualTitle=driver.getTitle();
        assertEquals(expectedTitle,actualTitle);

        WebElement viewProduct= driver.findElement(By.partialLinkText("View Product"));
        viewProduct.click();

        String actuelTitle= driver.getTitle();
        String exceptedTitle="Automation Exercise - Product Details";
        assertEquals(actuelTitle,exceptedTitle);

        WebElement quantity= driver.findElement(By.xpath("//input[@id='quantity']"));
        quantity.clear();
        quantity.sendKeys("4");

        WebElement addToCart=driver.findElement(By.xpath("//button[@type='button']"));
        addToCart.click();

        WebElement viewCart=driver.findElement(By.xpath("//u[.='View Cart']"));
        viewCart.click();

        String actualQuantity=driver.findElement(By.xpath("//button[@class='disabled']")).getText();
        String exceptedQuantity="4";
        assertEquals(actualQuantity,exceptedQuantity);

    }

}
