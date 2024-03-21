import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class AmazonTests {

    WebDriver driver = new FirefoxDriver();
    Actions action = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeClass
    public void setUp() {

        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
    }

    @Test(priority = 1)
    public void testHomePageTitle() {
        String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(priority = 2)
    public void testLogo() {
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        logo.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.amazon.in/ref=nav_logo");
    }

    @Test(priority = 3)
    public void testSearch() throws InterruptedException {
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Laptop");
        searchBox.submit();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getTitle(),"Amazon.in : Laptop");
    }

    @Test(priority = 4)
    void addToCart() throws InterruptedException{
        WebElement product=driver.findElement(By.xpath("//*[@id='search']/div[1]/div[1]/div/span[1]/div[1]/div[5]/div/div/span/div/div/div/div[2]/div/div/div[1]/h2"));

        action.scrollToElement(product);
        product.click();
        Thread.sleep(5000);

        wait.until(numberOfWindowsToBe(2));
        String originalHandle=driver.getWindowHandle();
        for(String handle:driver.getWindowHandles()) {
            if(!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250)");
        WebElement addtocart=driver.findElement(By.xpath("(//input[@id='add-to-cart-button'])[2]"));
        Thread.sleep(2000);
        addtocart.click();
    }

        @Test
    public void testCart() throws InterruptedException {
        WebElement cartCount = driver.findElement(By.id("nav-cart-count"));
        Assert.assertEquals(cartCount.getText(), "1");
   }

    @AfterClass
    public void AfterLaunch() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
