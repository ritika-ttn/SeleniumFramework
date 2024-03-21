package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        //System.out.println(driver);


        driver.get("https://demo.automationtesting.in/Register.html");


        driver.manage().window().maximize();

        WebElement firstname = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        WebElement lastname = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        WebElement address = driver.findElement(By.xpath("//textarea[@rows='3']"));
        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        WebElement gender = driver.findElement(By.xpath("//input[@value='FeMale']"));
        WebElement hobbies = driver.findElement(By.xpath("//input[@value='Movies']"));
        WebElement phone = driver.findElement(By.xpath("//input[@type='tel']"));
        WebElement skills = driver.findElement(By.xpath("//select[@id='Skills']"));
        Select obj = new Select(skills);
        obj.selectByValue("Java");
        WebElement img = driver.findElement(By.xpath("//img[@id='imagetrgt']"));
        img.click();
//        WebElement country = driver.findElement(By.xpath("//select[@id='countries']"));
//        Select c = new Select(country);
//        c.selectByValue("Select Country");

        WebElement languagediv = driver.findElement(By.xpath("//div[@id='msdd']"));
        languagediv.click();
        WebElement lang1 = driver.findElement(By.xpath("//a[text()='English']"));
        lang1.click();
        WebElement lang2 = driver.findElement(By.xpath("//a[text()='Hindi']"));
        lang2.click();

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
        firstname.click();
        firstname.sendKeys("Ritika");
        lastname.sendKeys("Mallik");
        address.sendKeys("Delhi");
        email.sendKeys("ritika.mallik@tothenew.com");
        phone.sendKeys("9811948924");
        gender.click();
        hobbies.click();
        skills.click();
        submit.click();
        Thread.sleep(5000);
        driver.quit();
    }
}