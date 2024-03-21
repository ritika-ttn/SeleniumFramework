import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToTheNewServices {

    WebDriver driver = new ChromeDriver();
    Actions action = new Actions(driver);

    @BeforeClass
     void launch(){
        driver.manage().window().maximize();
        driver.get("https://www.tothenew.com/");
     }

     @Test
    public void testServices() {
        WebElement dropdown = driver.findElement(By.xpath("(//a[@id='h-Services'])[2]"));
        Actions action = new Actions(driver);
        action.moveToElement(dropdown).perform();

        String[] services = {"Digital Engineering", "Cloud & DevOps", "OTT Solutions & Services", "Data & Analytics", "CX & Content", "Digital Marketing"};
        List<WebElement> options = driver.findElements(By.xpath("(//li[@class='menu-item menu-expanded'])[4]//child::ul//child::li"));
        for(int i = 0; i <6; i++){
            System.out.println(options.get(i).getText());
            Assert.assertEquals(options.get(i).getText(), services[i]);
        }
    }

    @AfterClass
    void terminate(){
        driver.quit();
     }
}
