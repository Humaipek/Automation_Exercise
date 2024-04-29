package test_case01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TC10 extends TestBase{
    @Test
    void test01() {
        driver.get("https://automationexercise.com");
        wait(3);

        String expectedTitle="Automation Exercise";
        String actualTitle=driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);
        Assertions.assertEquals(expectedTitle,actualTitle);



    }
}
