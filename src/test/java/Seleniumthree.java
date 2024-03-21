import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Seleniumthree {

    WebDriver driver = new ChromeDriver();

    @BeforeClass
    void launch(){
        driver.get("https://demoqa.com/droppable");
        driver.manage().window().maximize();
    }

    @Test
    void testDragDrop(){
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions action = new Actions(driver);
        action.scrollByAmount(0,250);
        action.dragAndDrop(drag, drop).perform();
    }

    @Test
    void testRightClick() throws InterruptedException {
        WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
        Actions action = new Actions(driver);
        action.contextClick(drop).perform();
        Thread.sleep(5000);

    }
    @AfterClass
    void afterLaunch() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
