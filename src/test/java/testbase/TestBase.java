package testbase;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class TestBase {
    protected static WebDriver driver;

    @BeforeEach
    void setUp() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://automationexercise.com");
        try {
            driver.findElement(By.xpath("//p[.='Consent']")).click();
        }catch (Exception e){
            System.out.println("Cookie cikmadi");
        }

    }

//   @AfterEach
//   void tearDown() {
//       driver.quit();
//   }


    public void wait(int second) {
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void cookie1(){
        try {
            driver.findElement(By.xpath("//p[.='Consent']")).click();
        }catch (Exception e){
            System.out.println("Cookie cikmadi");
        }
    }
    protected Actions actions;
    protected Faker faker = new Faker();
    protected String kayitliEmailAdres=faker.internet().emailAddress();
    protected String kayitliPassword=faker.internet().password();
    public void emailregistering(){
        driver.findElement(By.partialLinkText("Signup / Login")).click();
        cookie1();

        driver.findElement(By.xpath("//input[@data-qa='signup-name'] ")).sendKeys(faker.name().firstName());
        cookie1();

        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(kayitliEmailAdres);

        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        driver.findElement(By.id("id_gender2")).click();

        WebElement userName=driver.findElement(By.id("name"));
        userName.clear();
        userName.sendKeys(faker.name().firstName());

        driver.findElement(By.id("password")).sendKeys(kayitliPassword);

        driver.findElement(By.id("days")).sendKeys("24", Keys.TAB,"September",Keys.TAB,"1978");

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

        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
        cookie1();
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        cookie1();
        driver.close();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://automationexercise.com");
        try {
            driver.findElement(By.xpath("//p[.='Consent']")).click();
        }catch (Exception e){
            System.out.println("Cookie cikmadi");
        }
    }

    public void selectByIndexTest(WebElement dmm, int index) {
        Select select=new Select(dmm);
        select.selectByIndex(index);

    }
    public void selectByValueTest(WebElement dmm,String value) {
        Select select=new Select(dmm);
        select.selectByValue(value);

    }
    public void selectByVisibleTextTest(WebElement dmm,String visibleName) {
        Select select=new Select(dmm);
        select.selectByVisibleText(visibleName);

    }

    public void printAllTest(WebElement dmm) {
        Select select=new Select(dmm);
        List<WebElement> list= select.getOptions();
        list.forEach(t-> System.out.println(t.getText()));

    }
    public String isOptionPresent(WebElement dmm, String optionText) {
        Select select = new Select(dmm);
        List<WebElement> options = select.getOptions();
        for (WebElement w : options) {
            if (w.getText().equals(optionText)) {
                return w.getText();
            }
        }
        return null;
    }
    public String defaultOptionText(WebElement dmm) {
        Select select = new Select(dmm);
        return select.getFirstSelectedOption().getText();
    }
    public int sizeTest(WebElement dmm) {
        Select select = new Select(dmm);
        List<WebElement> options = select.getOptions();
        return options.size();

    }

}
