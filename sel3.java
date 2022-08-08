package com.cg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

public class MostActiveUsers {
    public static  void main (String[] args) throws InterruptedException 
    {
        String dataForPost=null;
        System.setProperty("webdriver.chrome.driver","C:\\Users\\NKADIMEL\\Downloads\\chromedriver_win32\\chromedriver.exe ");

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
         driver.findElement(By.xpath("//div[contains(text(),'OneTeamOneFamily')]")).click();

            Thread.sleep(5000);

            WebElement usersLocator;
            WebElement dateLocator;
            String user;

            //        JavascriptExecutor executor= (JavascriptExecutor) driver;
            //        System.out.println("Maximum scroll size: "+executor.executeScript("Math.max( document.body.scrollHeight, document.body.offsetHeight,document.documentElement.clientHeight, document.documentElement.scrollHeight, document.documentElement.offsetHeight)"));
            //        int verticalWindowSize = driver.manage().window().getSize().height;

            ArrayList<String> userNames = new ArrayList<String>();

            try {
                for(int j=1;j<20;j++) {
                    usersLocator= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul/li["+j+"]/div/div/div/div/div/div/div[1]/div[2]/div/div[1]/div/div[2]/div[1]/div/span/div/div[1]/div/div/a/span/span"));
                    user = usersLocator.getText().replace(",","");
                    userNames.add(user);
                    dateLocator = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul/li[1]/div/div/div/div/div/div/div[1]/div[2]/div/div[1]/div/div[2]/div[2]/div/div[1]/a/time"));

                    ////*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul/li["+j+"]/div/div/div/div/div/div/div[1]/div[2]/div/div[1]/div/div[2]/div[2]/ul/li[1]/a/time
                    System.out.println("post no."+j +" -> "+user+": "+dateLocator.getText());
                    JavascriptExecutor executor= (JavascriptExecutor) driver;
                    executor.executeScript("window.scrollBy(0,2000)");
                    Thread.sleep(2000);
                    //System.out.println("running "+j);
                }
            }
            catch (Exception e) {
            //    System.out.println("Some exception occur...");
             //    System.out.println(e.getMessage());
                e.printStackTrace();
            }

            finally {

                //            for(String s: userNames) {
                //            System.out.println(s);}
                System.out.println("=====User name and Post Count=====");
                Set<String> unique = new HashSet<String>(userNames);
                for (String key : unique) {
                    List<Integer> count =  new ArrayList<Integer>();
                    count.add(Collections.frequency(userNames, key ));
                    System.out.println(key + ": " + Collections.frequency(userNames, key ));
                Integer maximum = Collections.max(count);
                //System.out.println(maximum);
                int Ar[] = new int[20];
                    for(int i =0 ; i< 20 ; i++) {

                        Ar[i] = maximum;
                        }


                }
                }

            }

        }
