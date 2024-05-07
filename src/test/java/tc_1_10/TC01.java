package tc_1_10;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import testbase.TestBase;

import static org.junit.jupiter.api.Assertions.*;

public class TC01 extends TestBase {

    @Test
    void RegisterUser() {

       // 1. Launch browser
       // 2. Navigate to url 'http://automationexercise.com'
       // 3. Verify that home page is visible successfully
        assertEquals("https://automationexercise.com/",driver.getCurrentUrl());

       // 4. Click on 'Signup / Login' button
        driver.findElement(By.partialLinkText("Signup / Login")).click();

       // 5. Verify 'New User Signup!' is visible
        assertTrue(driver.findElement(By.xpath("(//h2)[3]")).isDisplayed());

       // 6. Enter name and email address
        driver.findElement(By.xpath("//input[@data-qa='signup-name'] ")).sendKeys(faker.name().firstName());

        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(faker.internet().emailAddress());

       // 7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

       // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement enterAccount=driver.findElement(By.xpath("//b[.='Enter Account Information']"));
        assertTrue(enterAccount.isDisplayed());

       // 9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.id("id_gender2")).click();

        WebElement userName=driver.findElement(By.id("name"));
        userName.clear();
        userName.sendKeys(faker.name().firstName());

        driver.findElement(By.id("password")).sendKeys(faker.internet().password());

        driver.findElement(By.id("days")).sendKeys("24");

        driver.findElement(By.id("months")).sendKeys("September");

        driver.findElement(By.id("years")).sendKeys("1978");

        // 10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.id("newsletter")).click();

       // 11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.id("optin")).click();

       // 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.id("first_name")).sendKeys(faker.name().firstName(), Keys.TAB,
                faker.name().lastName(),Keys.TAB,
                faker.company().name(),Keys.TAB,
                faker.address().streetAddress(),Keys.TAB,
                faker.address().secondaryAddress(),Keys.TAB,
                "India",Keys.TAB,
                faker.address().state(),Keys.TAB,
                faker.address().city(),Keys.TAB,
                faker.address().zipCode(),Keys.TAB,
                faker.phoneNumber().cellPhone());

       // 13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

       // 14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountcreated= driver.findElement(By.xpath("//b[.='Account Created!']"));
        assertTrue(accountcreated.isDisplayed());

       // 15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

       // 16. Verify that 'Logged in as username' is visible
        WebElement logged= driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        assertTrue(logged.isDisplayed());

       // 17. Click 'Delete Account' button
        driver.findElement(By.partialLinkText("Delete Account")).click();

       // 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

        WebElement accountdeleted= driver.findElement(By.xpath("//b[.='Account Deleted!']"));
        assertTrue(accountdeleted.isDisplayed());

    }
}
