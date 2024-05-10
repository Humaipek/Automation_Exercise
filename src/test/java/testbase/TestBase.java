package testbase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

     @AfterEach
      void tearDown() {
        // extentReports.flush();
     // driver.quit();
     }

    public void cookie1(){
        try {
            driver.findElement(By.xpath("//p[.='Consent']")).click();
        }catch (Exception e){
            System.out.println("Cookie cikmadi");
        }
    }
    protected Actions actions;
    protected static WebDriverWait webDriverWait =new WebDriverWait(driver, Duration.ofSeconds(5));

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

        driver.findElement(By.id("password")).sendKeys(kayitliPassword,Keys.TAB,
                "24", Keys.TAB,"September",Keys.TAB,"1978");

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
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;


    public void createExtentReport(String testName){
        //Bu objecti raporlari olusturmak ve yönetmek icin kullanacağız
        extentReports = new ExtentReports();

        //Oncelikle olusturmak istedigimiz html report projemizde nerede saklamak istiyorsak bir dosya yolu olusturmaliyz
        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(  LocalDateTime.now());
        String path ="target/extentReport/"+date+"htmlReport.html";
        extentHtmlReporter = new ExtentHtmlReporter(path);

        //ExtentsReports'a html raporlayici ekler,ve bu raporun html formatinda olusturulmasini saglar
        extentReports.attachReporter(extentHtmlReporter);

        //HTML raporun belge basligini ayarlar
        extentHtmlReporter.config().setDocumentTitle("Deneme");

        //Raporda gösterilecek olan genel basligi ayarlar
        extentHtmlReporter.config().setReportName("My Extent Report");

        //Bu html raporunda görmek isteyebileceğimz diger bilgileri asagidaki sekilde ekleyebiliriz
        extentReports.setSystemInfo("Environment","QA");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Test Automation Engineer","Huma Ipek");

        //AmazonTest adinda yeni bir test olusturur ve Test Steps aciklamasini ekler
        extentTest = extentReports.createTest("Automation_Exercise","Test Steps");
    }
    public void uploadFilePath(String dosyaYolu){
        try{
            wait(3); // 3 saniye bekletir. Bu, kodun başka işlemler için hazır olmasını sağlar.
            StringSelection stringSelection = new StringSelection(dosyaYolu);
            //Verilen Dosya yolunu bir StringSelection objectine dönüştürürüz
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
            //verilen stringSelection'i (bu durumda dosya yolu), daha sonra başka bir yere yapıştırmak üzere sistem panosuna kopyalamaktır.
            Robot robot = new Robot();
            // Robot sınıfından bir object olustururuz, Bu class javadan gelir ve klavye ve mouse etkileşimlerini simüle eder.
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            // CTRL+V tuslarina basar dolayisiyla panodaki veriyi yapıştırır.
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            // CTRL ve V tuşlarından elini kaldirir
            robot.delay(3000);
            // 3 saniye bekler, bu süre içerisinde yapıştırılan verinin işlenmesini sağlar.
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            // ENTER tuşuna basarak yapıştırma işlemini onaylar veya diyalog penceresini kapatır.
            robot.delay(3000);
            // Sonraki işlemler için ek 3 saniye bekler.
        }catch (Exception ignored){
            // Herhangi bir hata oluşursa, bu hata yoksayılır.
        }
    }

    //Tüm sayfa screenshot
    public void screenShot(){

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(  LocalDateTime.now());
        String path ="src\\test\\java\\screenshots\\screenShot"+date+".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            Files.write(Paths.get(path),ts.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    //webelement screenshot
    public void screenShotOfWebElement( WebElement webElement){

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(  LocalDateTime.now());
        String path ="src\\test\\java\\screenshots\\webElementSS"+date+".png";
        try {
            Files.write(Paths.get(path),webElement.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Tüm sayfa screenshoti rapora ekleme
    public void addScreenShotToReport(){

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path ="src\\test\\java\\screenshots\\screenShot"+date+".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            Files.write(Paths.get(path),ts.getScreenshotAs(OutputType.BYTES));
            extentTest.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\"+path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    //webelement screenshot
    public void addScreenShotOfWebElementToReport( WebElement webElement){

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(  LocalDateTime.now());
        String path ="src\\test\\java\\screenshots\\webElementSS"+date+".png";
        try {
            Files.write(Paths.get(path),webElement.getScreenshotAs(OutputType.BYTES));
            extentTest.addScreenCaptureFromPath(System.getProperty("user.dir")+"\\"+path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void jsClick(WebElement webElement){
        try {
            webElement.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();",webElement);
        }
    }


}
