package com.cg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PostContent {
    public static  void main (String[] args) throws InterruptedException, IOException
    {
        String dataForPost=null;
        System.setProperty("webdriver.chrome.driver","C:\\Users\\NKADIMEL\\Downloads\\chromedriver_Win32\\chromedriver.exe ");


        WebDriver driver=new ChromeDriver();
         driver.get("https://web.yammer.com/main/capgemini.com");

         driver.manage().window().maximize();
         Thread.sleep(5000);
         //sign in
         driver.findElement(By.xpath("//*[@id=\"i0116\"]")).sendKeys("NIKHIL-VARMA.KADIMELLA@CAPGEMINI.COM");
         driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
         //Thread.sleep(2000);
         //Password
         //driver.findElement(By.xpath("//*[@id=\"i0118\"]")).sendKeys("Kv@adr26k");
         //driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
         //Check Box
         Thread.sleep(10000);
         driver.findElement(By.xpath("//*[@id=\"KmsiCheckboxField\"]")).click();
         driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
         Thread.sleep(10000);

        //Click on OneTeamONeFamily
        driver.findElement(By.linkText("Organization")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String ExcelFile = "./Data/Book1.xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook(ExcelFile);

        XSSFSheet sheet = workbook.getSheet("Sheet1");
       //count no. of rows 
        int rowCount = sheet.getPhysicalNumberOfRows();
     //   System.out.println("No of rows: " +rowCount);



        for (int j = 0; j < rowCount; j++) {
            WebElement content1=driver.findElement(By.xpath("//div[contains(text(),'Share thoughts, ideas, or updates')]"));
            content1.click();

            dataForPost =sheet.getRow(j).getCell(0).getStringCellValue().toString();
            //for periodic post of content
            WebElement postContent= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div/div/div/div/div[3]/div/div/span/div/div[2]/div/div/div/div/span"));
            postContent.sendKeys(dataForPost);

            //for posting
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div/div/div/div/div[5]/div[2]/div/ul/li/div/div/button")).click();

            Thread.sleep(10000);

            driver.navigate().refresh();

            TimeUnit.SECONDS.sleep(20);
        }
    }

        }
