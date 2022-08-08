package com.cg;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MostLikedPost {

        public static void main(String[] args) throws InterruptedException {

            System.setProperty("webdriver.chrome.driver","C:\\Users\\NKADIMEL\\Downloads\\Chromedriver_win32\\chromedriver.exe" );

            WebDriver driver = new ChromeDriver();
            driver.get("https://web.yammer.com/main/org/capgemini.com");

            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            driver.findElement(By.xpath("//*[@id=\"i0116\"]")).sendKeys("NIKHIL-VARMA.KADIMELLA@CAPGEMINI.COM");
            driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
          //Thread.sleep(2000);
            //Password
            //driver.findElement(By.xpath("//*[@id=\"i0118\"]")).sendKeys("Kv@adr26k");
            //driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();
            //Check Box

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.findElement(By.xpath("//*[@id=\"KmsiCheckboxField\"]")).click();

            Thread.sleep(9000);
            driver.findElement(By.id("idSIButton9")).click();


            driver.findElement(By.xpath("//div[contains(text(),'OneTeamOneFamily')]")).click();

            WebElement list = null;
            List list1 = new ArrayList();
            Map<Integer , WebElement> map = new HashMap<Integer, WebElement>();

          for(int i=2; i<4 ; i++ ) {

              list = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/ul/li["+i+"]/div/div/div/div/div/div/div[1]/div[5]/div[2]/div/div/div/div/div[2]/div/div/div/button/span/div"));

              WebElement e = list;

              WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));

                String a=list.getText().substring(0, 2).replaceAll(" ","");
                JavascriptExecutor executor= (JavascriptExecutor) driver;
                executor.executeScript("window.scrollBy(0,2000)");

                Thread.sleep(3000);
                int num=Integer.parseInt(a);
                list1.add(num);
                map.put(num, e);
                Thread.sleep(2000);
        }
        Collections.sort(list1);
        System.out.println(list1);
        Object numberOfLike = (list1.get(list1.size()-1));

        int numberOfLikeOfMostLikedPost = (Integer) (numberOfLike);
        System.out.println("Number of like of most liked post is: "+(numberOfLikeOfMostLikedPost+1));

        WebElement mostLikedLocator = map.get(list1.get(list1.size()-1));

        
        JavascriptExecutor executor= (JavascriptExecutor) driver;

        String mostLikedPostStringPath = mostLikedLocator.toString().substring(80, 153);

        WebElement mostLikedPostLocator = driver.findElement(By.xpath(mostLikedPostStringPath));

    }
