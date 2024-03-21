package org.example;
//
//import org.checkerframework.checker.units.qual.C;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class SeleniumDemo {
//    public static void main(String[] args) throws InterruptedException {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.google.com/");
//        driver.manage().window().maximize();
//
//        WebElement searchbar = driver.findElement(By.xpath("//textarea[@name='q']"));
//        searchbar.sendKeys("To The New");
//        WebElement button = driver.findElement(By.xpath("//input[@value='Google Search']"));
//        button.submit();
//    }
//}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.tothenew.com/");
//        driver.manage().window().maximize();
//
//        String URL = driver.getCurrentUrl();
//        System.out.println("URL of the Contact Us page: " + URL);

//        String tl = driver.getTitle();
//        System.out.println("Title of the Contact Us page: " + tl);

        WebElement contact = driver.findElement(By.xpath("(//a[@id='h-contact-us'])[2]"));
        Thread.sleep(2000);
        contact.click();
        WebElement contact1 = driver.findElement(By.id("h-contact-us"));
        contact1.click();
        Thread.sleep(2000);


    }
}

