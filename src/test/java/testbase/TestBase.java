package testbase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class TestBase {
    protected WebDriver driver;

    @BeforeEach
    void setUp() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://automationexercise.com");
        wait(3);
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


    public Actions actions() {
        Actions actions=new Actions(driver);
        return actions;
    }
}
