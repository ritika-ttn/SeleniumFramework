import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TravelCompanion{
    WebDriver driver;

    @BeforeTest
    public void launch() {
        driver = new ChromeDriver();
        driver.get("https://www.path2usa.com/travel-companion/");
        driver.manage().window().maximize();
    }

    @Test
    public void testForm() throws InterruptedException, IOException {
        WebElement formBody = driver.findElement(By.xpath("/html/body/div[3]/section[2]/div/div/div/section/div/div/div/div[2]"));
        new Actions(driver).scrollToElement(formBody).perform();

        WebElement from = driver.findElement(By.xpath("//input[@id ='form-field-travel_from']"));
        from.sendKeys("ATLANTA");
        WebElement to = driver.findElement(By.xpath("//input[@id ='form-field-travel_to']"));
        to.sendKeys("HYDERABAD");

        WebElement date = driver.findElement(By.xpath("//*[@id='form-field-travel_comp_date']"));
        date.click();
        driver.findElement(By.xpath("/html/body/div[11]/div[2]/div/div[2]/div/span[33]")).click();

        WebElement time = driver.findElement(By.xpath("//*[@id=\"form-field-travel_comp_date_between\"]"));
        Select stime = new Select(time);
        stime.selectByVisibleText("+ - 2 Weeks");

        WebElement airline = driver.findElement(By.xpath("//*[@id=\"form-field-travel_comp_airline\"]"));
        Select select = new Select(airline);
        select.selectByVisibleText("British Airways");

        WebElement language = driver.findElement(By.xpath("//*[@id=\"form-field-travel_comp_language\"]"));
        Select select1 = new Select(language);
        select1.selectByVisibleText("English");

        WebElement search = driver.findElement(By.xpath("//*[@id='travel_comp_form']/div/div[12]/button/span/span[2]"));
        search.submit();


        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./SeleniumScreenshots/Screen.png"));



    }
    @AfterClass
    public void terminate(){
        driver.quit();
    }

}