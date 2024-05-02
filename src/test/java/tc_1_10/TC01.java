package tc_1_10;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import testbase.TestBase;

import static org.junit.jupiter.api.Assertions.*;

public class TC01 extends TestBase {

    @Test
    void tc01() {

        String expectedTitle="Automation Exercise";
        String actualTitle=driver.getTitle();
        assertEquals(expectedTitle,actualTitle);

        driver.findElement(By.partialLinkText("Signup / Login")).click();

        assertTrue(driver.findElement(By.xpath("(//h2)[3]")).isDisplayed());

        driver.findElement(By.xpath("//input[@data-qa='signup-name'] ")).sendKeys("yuniel");

        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("fenton.gray@foodfarms.net");

        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        WebElement enterAccount=driver.findElement(By.xpath("//b[.='Enter Account Information']"));
        assertTrue(enterAccount.isDisplayed());

        driver.findElement(By.id("id_gender2")).click();

        WebElement userName=driver.findElement(By.id("name"));
        userName.clear();
        userName.sendKeys("yuniel");

        driver.findElement(By.id("password")).sendKeys("Dunya1234");

        WebElement ddm= driver.findElement(By.id("days"));
        Select optionsDay=new Select(ddm);
        optionsDay.selectByVisibleText("24");

        WebElement ddm2= driver.findElement(By.id("months"));
        Select optionsMonth=new Select(ddm2);
        optionsMonth.selectByVisibleText("September");

        WebElement ddm3= driver.findElement(By.id("years"));
        Select optionsYear=new Select(ddm3);
        optionsYear.selectByVisibleText("1978");


        driver.findElement(By.id("newsletter")).click();

        driver.findElement(By.id("optin")).click();

        driver.findElement(By.id("first_name")).sendKeys("yuniel");

        driver.findElement(By.id("last_name")).sendKeys("kodey");

       driver.findElement(By.id("company")).sendKeys("kodey");

        driver.findElement(By.id("address1")).sendKeys("kodey");

        driver.findElement(By.id("address2")).sendKeys("kodey");

        WebElement ddm4= driver.findElement(By.id("country"));
        Select optionsCountry=new Select(ddm4);
        optionsCountry.selectByVisibleText("India");

        driver.findElement(By.id("state")).sendKeys("kodey");

        driver.findElement(By.id("city")).sendKeys("kodey");

        driver.findElement(By.id("zipcode")).sendKeys("3244");

        driver.findElement(By.id("mobile_number")).sendKeys("3244226677");

        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

        WebElement accountcreated= driver.findElement(By.xpath("//b[.='Account Created!']"));
        assertTrue(accountcreated.isDisplayed());

        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        WebElement logged= driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        assertTrue(logged.isDisplayed());

        driver.findElement(By.partialLinkText("Delete Account")).click();

        WebElement accountdeleted= driver.findElement(By.xpath("//b[.='Account Deleted!']"));
        assertTrue(accountdeleted.isDisplayed());

    }
}
