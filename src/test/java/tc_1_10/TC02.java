package tc_1_10;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import testbase.TestBase;

import static org.junit.jupiter.api.Assertions.*;

public class TC02 extends TestBase {

    @Test
    void tc02_1() {

        String expectedTitle="Automation Exercise";
        String actualTitle=driver.getTitle();
        assertEquals(expectedTitle,actualTitle);

        WebElement link= driver.findElement(By.partialLinkText("Signup / Login"));
        link.click();

        WebElement name=driver.findElement(By.xpath("//input[@data-qa='signup-name'] "));
        name.sendKeys("yuniel");

        WebElement email=driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        email.sendKeys("kerby.kaidyn@foodfarms.net");

        WebElement enter=driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        enter.click();

        WebElement titleMrs= driver.findElement(By.id("id_gender2"));
        titleMrs.click();

        WebElement userName=driver.findElement(By.id("name"));
        userName.clear();
        userName.sendKeys("yuniel");

        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("Dunya1234");

        WebElement ddm= driver.findElement(By.id("days"));
        Select optionsDay=new Select(ddm);
        optionsDay.selectByVisibleText("24");

        WebElement ddm2= driver.findElement(By.id("months"));
        Select optionsMonth=new Select(ddm2);
        optionsMonth.selectByVisibleText("September");

        WebElement ddm3= driver.findElement(By.id("years"));
        Select optionsYear=new Select(ddm3);
        optionsYear.selectByVisibleText("1978");


        WebElement checkBox=driver.findElement(By.id("newsletter"));
        checkBox.click();

        WebElement receive=driver.findElement(By.id("optin"));
        receive.click();

        WebElement firstName=driver.findElement(By.id("first_name"));
        firstName.sendKeys("yuniel");

        WebElement lastName=driver.findElement(By.id("last_name"));
        lastName.sendKeys("kodey");

        WebElement companyName=driver.findElement(By.id("company"));
        companyName.sendKeys("kodey");

        WebElement address1=driver.findElement(By.id("address1"));
        address1.sendKeys("kodey");

        WebElement address2=driver.findElement(By.id("address2"));
        address2.sendKeys("kodey");

        WebElement ddm4= driver.findElement(By.id("country"));
        Select optionsCountry=new Select(ddm4);
        optionsCountry.selectByVisibleText("India");

        WebElement state=driver.findElement(By.id("state"));
        state.sendKeys("kodey");

        WebElement city=driver.findElement(By.id("city"));
        city.sendKeys("kodey");

        WebElement zipcode=driver.findElement(By.id("zipcode"));
        zipcode.sendKeys("3244");

        WebElement mobil=driver.findElement(By.id("mobile_number"));
        mobil.sendKeys("3244226677");

        WebElement create=driver.findElement(By.xpath("//button[@data-qa='create-account']"));
        create.click();
    }

    @Test
    void tc02() {

        String expectedTitle="Automation Exercise";
        String actualTitle=driver.getTitle();
        assertEquals(expectedTitle,actualTitle);

        WebElement link= driver.findElement(By.partialLinkText("Signup / Login"));
        link.click();

        WebElement loginAcccount= driver.findElement(By.xpath("//h2[.='Login to your account']"));
        assertTrue(loginAcccount.isDisplayed());

        WebElement email=driver.findElement(By.cssSelector("input[data-qa='login-email']"));
        email.sendKeys("kerby.kaidyn@foodfarms.net");

        WebElement password=driver.findElement(By.cssSelector("input[data-qa='login-password']"));
        password.sendKeys("Dunya1234");

        WebElement enter=driver.findElement(By.cssSelector("button[data-qa='login-button'] "));
        enter.click();

        WebElement logged= driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        assertTrue(logged.isDisplayed());

        WebElement delete= driver.findElement(By.partialLinkText("Delete Account"));
        delete.click();

        WebElement accountdeleted= driver.findElement(By.xpath("//b[.='Account Deleted!']"));
        assertTrue(accountdeleted.isDisplayed());

    }
}
