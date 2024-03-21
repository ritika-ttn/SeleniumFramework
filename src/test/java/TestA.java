import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestA {
    WebDriver driver;

    @BeforeClass
    void fill() throws InterruptedException {
        driver = new FirefoxDriver();
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();

        WebElement firstname = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        firstname.sendKeys("Ritika");
        WebElement lastname = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        lastname.sendKeys("Mallik");
        WebElement address = driver.findElement(By.xpath("//textarea[@rows='3']"));
        address.sendKeys("Delhi");
        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("ritika.mallik@tothenew.com");
        WebElement phone = driver.findElement(By.xpath("//input[@type='tel']"));
        phone.sendKeys("9811948924");
        WebElement gender = driver.findElement(By.xpath("//input[@value='FeMale']"));
        gender.click();
        WebElement hobbies = driver.findElement(By.xpath("//input[@value='Movies']"));
        hobbies.click();
        WebElement skills = driver.findElement(By.xpath("//select[@id='Skills']"));
        Select obj = new Select(skills);
        obj.selectByValue("Java");
        skills.click();
        WebElement img = driver.findElement(By.xpath("//img[@id='imagetrgt']"));
        img.click();

        WebElement languagediv = driver.findElement(By.xpath("//div[@id='msdd']"));
        languagediv.click();
        WebElement lang1 = driver.findElement(By.xpath("//a[text()='English']"));
        lang1.click();
        WebElement lang2 = driver.findElement(By.xpath("//a[text()='Hindi']"));
        lang2.click();
        WebElement img1 = driver.findElement(By.xpath("//img[@id='imagetrgt']"));
        img1.click();

        WebElement year = driver.findElement(By.xpath("//select[@id='yearbox']"));
        Select obj1 = new Select(year);
        obj1.selectByValue("2001");

        WebElement month = driver.findElement(By.xpath("//select[@placeholder='Month']"));
        Select obj2 = new Select(month);
        obj2.selectByValue("January");

        WebElement day = driver.findElement(By.xpath("//select[@id='daybox']"));
        Select obj3 = new Select(day);
        obj3.selectByValue("9");

        WebElement pw = driver.findElement(By.xpath("//input[@id='firstpassword']"));
        pw.sendKeys("abcdefg");
        WebElement cpw = driver.findElement(By.xpath("//input[@id='secondpassword']"));
        cpw.sendKeys("abcdefg");

        WebElement submit = driver.findElement(By.xpath("//button[@value='sign up']"));
        submit.click();
        Thread.sleep(5000);
    }

    @Test
    void val_gender() throws InterruptedException{
        WebElement female = driver.findElement(By.xpath("//input[@value='FeMale']"));
        Assert.assertTrue(female.isSelected());
    }

    @Test
    void val_title(){
        Assert.assertEquals(driver.getTitle(), "Register");
        driver.close();
    }

    @Test
    void val_header(){
            WebElement header = driver.findElement(By.tagName("h1"));
            String headerText = header.getText();
            Assert.assertEquals(headerText, "Automation Demo Site");
        }
    }

