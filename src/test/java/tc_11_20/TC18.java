package tc_11_20;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import testbase.TestBase;

import static org.junit.jupiter.api.Assertions.*;


public class TC18 extends TestBase {

    @Test
    void ViewCategoryProducts() {

    //   1. Launch browser
    //   2. Navigate to url 'http://automationexercise.com'
    //   3. Verify that categories are visible on left side bar
        assertTrue(driver.findElement(By.xpath("//h2[.='Category']")).isDisplayed());

    //   4. Click on 'Women' category
        driver.findElement(By.cssSelector("a[href='#Women']")).click();

    //   5. Click on any category link under 'Women' category, for example: Dress
        driver.findElement(By.xpath("//a[.='Dress '][1]")).click();

    //   6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        WebElement actualText = driver.findElement(By.xpath("//h2[.='Women - Dress Products']"));
        assertEquals(actualText.getText(),"WOMEN - DRESS PRODUCTS");

    //   7. On left side bar, click on any sub-category link of 'Men' category
        driver.findElement(By.cssSelector("a[href='#Men']")).click();

        driver.findElement(By.xpath("(//a[.='Tshirts '])[1]")).click();
        cookie1();

    //   8. Verify that user is navigated to that category page
        assertEquals(driver.getTitle(),"Automation Exercise - Tshirts Products");
    }
}