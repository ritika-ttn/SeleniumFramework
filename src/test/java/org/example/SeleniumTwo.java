package org.example;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTwo {
    WebDriver driver = new FirefoxDriver();

    @BeforeClass
    void launch() {

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
    }

    @Test
    void fetchAlert() throws InterruptedException {
        WebElement al = driver.findElement(By.id("alertbtn"));
        al.click();
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("Alert Text: " + alertText);
    }

    @Test
    void dismissAlert(){
        WebElement al = driver.findElement(By.id("alertbtn"));
        al.click();
        driver.switchTo().alert().dismiss();
    }

    @Test
    void acceptAlert(){
        WebElement al = driver.findElement(By.id("alertbtn"));
        al.click();
        driver.switchTo().alert().accept();
    }

}

