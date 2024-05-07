package tc_1_10;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import testbase.TestBase;

import static org.junit.jupiter.api.Assertions.*;

public class TC06 extends TestBase {

    @Test
    void ContactUsForm() {

      //  1. Launch browser
      //  2. Navigate to url 'http://automationexercise.com'
      //  3. Verify that home page is visible successfully
        assertEquals("https://automationexercise.com/",driver.getCurrentUrl());

      //  4. Click on 'Contact Us' button
        driver.findElement(By.partialLinkText("Contact us")).click();
        cookie1();

      //  5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouch= driver.findElement(By.xpath("(//h2)[2]"));
        assertTrue(getInTouch.isDisplayed());

      //  6. Enter name, email, subject and message
        driver.findElement(By.cssSelector("input[data-qa='name']")).sendKeys(faker.name().firstName(), Keys.TAB,
                faker.internet().emailAddress(),Keys.TAB,
                faker.lorem().word(),Keys.TAB,
                faker.lorem().paragraph());

      //  7. Upload file
        WebElement fileInput=driver.findElement(By.cssSelector("input[name='upload_file']"));
        fileInput.sendKeys("C:\\Users\\humai\\OneDrive\\Masaüstü\\Web Denemesı\\Resimler\\th.jpg");

      //  8. Click 'Submit' button
        driver.findElement(By.cssSelector("input[value='Submit']")).submit();

      //  9. Click OK button
        driver.switchTo().alert().accept();

      //  10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement actualSuccess= driver.findElement(By.cssSelector("div[style='display: block;']"));
        String exceptedSuccess="Success! Your details have been submitted successfully.";
        assertEquals(actualSuccess.getText(),exceptedSuccess);

      //  11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();
        String expectedHomeTitle="Automation Exercise";
        String actualHomeTitle=driver.getTitle();
        assertEquals(expectedHomeTitle,actualHomeTitle);
        cookie1();

    }
}
