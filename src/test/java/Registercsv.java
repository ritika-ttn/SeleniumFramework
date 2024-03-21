import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class Registercsv {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void launch() {
        driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();
        try {
            FileInputStream fis = new FileInputStream("C:/Users/Ritika Mallik/Desktop/Book1.xls");
            HSSFWorkbook hw = new HSSFWorkbook(fis);
            HSSFSheet hs = hw.getSheetAt(0);
            HSSFRow hr = hs.getRow(0);
            WebElement firstname = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
            firstname.sendKeys(hr.getCell(0).getStringCellValue());

            WebElement lastname = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
            lastname.sendKeys(hr.getCell(1).getStringCellValue());

            WebElement address = driver.findElement(By.xpath("//textarea[@rows='3']"));
            address.sendKeys(hr.getCell(2).getStringCellValue());

            WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
            email.sendKeys(hr.getCell(3).getStringCellValue());

            WebElement phone = driver.findElement(By.xpath("//input[@type='tel']"));
            phone.sendKeys(String.valueOf((long) hr.getCell(4).getNumericCellValue()));

            WebElement gender = driver.findElement(By.xpath("//input[@value='FeMale']"));
            gender.sendKeys(hr.getCell(5).getStringCellValue());

            WebElement year = driver.findElement(By.xpath("//select[@id='yearbox']"));
            phone.sendKeys(String.valueOf((long) hr.getCell(7).getNumericCellValue()));

            WebElement month = driver.findElement(By.xpath("//select[@placeholder='Month']"));
            phone.sendKeys(String.valueOf((long) hr.getCell(8).getNumericCellValue()));

            WebElement day = driver.findElement(By.xpath("//select[@id='daybox']"));
            day.sendKeys(String.valueOf((long) hr.getCell(9).getNumericCellValue()));

            WebElement pw = driver.findElement(By.xpath("//input[@id='firstpassword']"));
            pw.sendKeys(hr.getCell(10).getStringCellValue());

            WebElement cpw = driver.findElement(By.xpath("//input[@id='secondpassword']"));
            cpw.sendKeys(hr.getCell(11).getStringCellValue());


            fis.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterTest
    public void terminate() {
        driver.quit();
    }
}
