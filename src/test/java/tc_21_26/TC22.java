package tc_21_26;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import testbase.TestBase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TC22 extends TestBase {

    @Test
    void AddToCartFromRecommendedItems() {

       //  1. Launch browser
       //  2. Navigate to url 'http://automationexercise.com'
       //  3. Scroll to bottom of page
        actions=new Actions(driver);
        WebElement recommended=driver.findElement(By.xpath("//*[.='recommended items']"));
        actions.scrollToElement(recommended).perform();

       //  4. Verify 'RECOMMENDED ITEMS' are visible
         assertTrue(recommended.isDisplayed());

       //  5. Click on 'Add To Cart' on Recommended product
        WebElement product= driver.findElement(By.xpath("(//a[@data-product-id='4'])[1]"));
        product.click();

       //  6. Click on 'View Cart' button
        driver.findElement(By.partialLinkText("View Cart")).click();

       //  7. Verify that product is displayed in cart page
        List<WebElement> cartPage=driver.findElements(By.tagName("tbody"));
        String productName="Stylish Dress";
        for (WebElement w:cartPage){
                String products=w.getText();
            if (products.contains(productName)){
                System.out.println("Product is displayed");
            }
        }

    }
}
