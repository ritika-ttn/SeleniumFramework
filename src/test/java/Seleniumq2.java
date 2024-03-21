import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Seleniumq2 {

    WebDriver driver = new FirefoxDriver();

    @BeforeClass
    void launch(){
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().window().maximize();
    }

    @Test
    void checkRadio(){
        WebElement roundTrip = driver.findElement(By.xpath("//input[@value='RoundTrip']"));
        roundTrip.click();
    }

    @Test
    void dynamicDrpdown() throws InterruptedException {
        WebElement fromCity = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_originStation1_CTXT\"]"));
        fromCity.click();
        WebElement city1 = driver.findElement(By.xpath("//*[@id=\"dropdownGroup1\"]/div/ul[1]/li[11]/a"));
        Thread.sleep(1000);
        city1.click();
        WebElement toCity = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_destinationStation1_CTXT\"]"));
        toCity.click();
        WebElement city2 = driver.findElement(By.xpath("/html/body/form/div[4]/div[2]/div/div[5]/div[2]/div[2]/div[2]/div[3]/div/div[3]/div/div[2]/div[2]/div/table/tbody/tr[2]/td[2]/div[3]/div[1]/div/ul[3]/li[8]/a"));
        Thread.sleep(1000);
        city2.click();
    }


    @Test
    void enterDetails() throws InterruptedException {
        WebElement oneWay = driver.findElement(By.xpath("//input[@value='OneWay']"));
        oneWay.click();
        WebElement fromCity = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_originStation1_CTXT\"]"));
        fromCity.click();
        WebElement city1 = driver.findElement(By.xpath("//*[@id=\"dropdownGroup1\"]/div/ul[1]/li[11]/a"));
        Thread.sleep(1000);
        city1.click();
        WebElement toCity = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_ddl_destinationStation1_CTXT\"]"));
        toCity.click();
        WebElement city2 = driver.findElement(By.xpath("/html/body/form/div[4]/div[2]/div/div[5]/div[2]/div[2]/div[2]/div[3]/div/div[3]/div/div[2]/div[2]/div/table/tbody/tr[2]/td[2]/div[3]/div[1]/div/ul[3]/li[8]/a"));
        Thread.sleep(1000);
        city2.click();
        WebElement dod = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_view_date1\"]"));
        dod.click();
        WebElement selectdod = driver.findElement(By.xpath(" //*[@id=\"ui-datepicker-div\"]/div[2]/table/tbody/tr[1]/td[6]/a"));
        selectdod.click();
        Thread.sleep(2000);
//        WebElement dor = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_view_date2\"]"));
//        dor.click();
//        WebElement selectdor = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[5]/td[3]/a"));
//        selectdor.click();
        WebElement category = driver.findElement(By.xpath("//*[@id=\"StudentDiv\"]/label"));
        category.click();
        WebElement noOfPassengers = driver.findElement(By.xpath("//*[@id=\"divpaxinfo\"]"));
        noOfPassengers.click();
        WebElement adult = driver.findElement(By.xpath("//*[@id=\"hrefIncAdt\"]"));
        adult.click();
        adult.click();
        WebElement submitBtn = driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_btn_FindFlights\"]"));
        submitBtn.submit();
    }

    @AfterClass
    void afterLaunch() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }


    }
