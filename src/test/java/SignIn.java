import dev.failsafe.internal.util.Durations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignIn {
    WebDriver driver;
    @BeforeMethod
    void launch(){
        driver=new ChromeDriver();
        driver.get("https://www.udemy.com/");
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Durations)
    }
    @Test
    public void login() throws InterruptedException{
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//span[text()='Log in'])[1]")).click();
        Thread.sleep(5000);

    }
    @Test
    public void signup() throws InterruptedException{
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//span[text()='Sign up])[1]")).click();
        Thread.sleep(5000);
    }
}