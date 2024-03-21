import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class TTNScroll{

    WebDriver driver = new ChromeDriver();
    Actions action = new Actions(driver);

    @BeforeClass
    void launch(){
        driver.manage().window().maximize();
        driver.get("https://www.tothenew.com/");
    }

    @Test
    void testScrollDown() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);
    }

    @Test
    void testScrollUp() throws InterruptedException{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
        Thread.sleep(2000);
    }

    @Test
    void testScrolltoElement() throws InterruptedException{
        WebElement footer = driver.findElement(By.xpath("//*[@id=\"block-views-block-our-client-block-1\"]/div/div/div/div[1]/div/div"));
        Actions actions = new Actions(driver);
        actions.scrollToElement(footer).perform();
        sleep(2000);
    }

    @AfterClass
    void terminate(){
        driver.quit();
    }
}
