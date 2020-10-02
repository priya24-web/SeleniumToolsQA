package Academytoolsqa;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.Logs;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import Resources.Base;
import Resources.WriteExcel_Utility;

public class HomePage2 extends Base  {
	
public static  WebDriver driver;
public static   Logger log = LogManager.getLogger(Base.class.getName());

TakesScreenshot ts = (TakesScreenshot)driver;



@BeforeTest
public void initiateall() throws Exception {
	driver = initializeDriver();
	log.info("Driver is Initialized");
	driver.get(prop.getProperty("url"));
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	log.info("Navigated to home page ");
    driver.switchTo().frame("master-1");
	}

@Test(description="Firsttimerun_code")
public void clickingLinksFirstrun() throws Exception {
	
    List<WebElement> links = driver.findElements(By.tagName("a"));
    int count = links.size(); 

// System.out.println("Total number of page on the webpage:"+ count);
log.info("Successfully counted total numer of links from the page"+count);
ArrayList<String> hrefs = new ArrayList<String>();

for (WebElement link : links) {
    // System.out.println(link.getText()); // used to get text present between the anchor tags
    System.out.println(link.getAttribute("href"));
    hrefs.add(link.getAttribute("href")); 
    System.out.println("************************");
}


//Navigating to each link
int i=0;
for (String href : hrefs) {
    driver.navigate().to(href);
    System.out.println((++i)+": navigated to URL with href: "+href);
    Thread.sleep(3000); // To check if the navigation is happening properly.
    String testName = "Toolsqascrenshot";
	getScreenshotPath(testName);
	log.info("Screenshot taken successfully");
	WriteExcel_Utility excelwrite = new WriteExcel_Utility(System.getProperty("user.dir")+"/src/main/java/Resources/TestDataa.xlsx");	
	excelwrite.setCellData("Credentials",2,1,"PASS");
	
	
	
    }
    
}


@Test(description="Secondtimerun_code")
 public void clickingLinksSecondrun() throws Exception {
    
    List<WebElement> links = driver.findElements(By.tagName("a"));
    int count = links.size(); 

System.out.println("Total number of page on the webpage:"+ count);
ArrayList<String> hrefs = new ArrayList<String>();

for (WebElement link : links) {
    // System.out.println(link.getText()); // used to get text present between the anchor tags
    System.out.println(link.getAttribute("href"));
    hrefs.add(link.getAttribute("href")); 
    System.out.println("*************************************");
}


//Navigating to each link
int i=0;
for (String href : hrefs) {
    driver.navigate().to(href);
    System.out.println((++i)+": navigated to URL with href: "+href);
    Thread.sleep(3000); // To check if the navigation is happening properly.
    String testName = "Toolsqascrenshot";
	getScreenshotPath(testName);
	log.info("Screenshot taken successfully");

	
	//WriteExcel_Utility excelwrite = new WriteExcel_Utility("C://Users//User//git//repository//toolsqa//src//main//java//Resources//TestDataa.xlsx");
	WriteExcel_Utility excelwrite = new WriteExcel_Utility(System.getProperty("user.dir")+"/src/main/java/Resources/TestDataa.xlsx");
	
	excelwrite.setCellData("Credentials",2,2,"PASS");

	
    }
}


public static void  getScreenshotPath(String testName) throws IOException {
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());

	    String currentDir = System.getProperty("user.dir");
	    FileUtils.copyFile(scrFile, new File(currentDir + "\\screenshotsfirst\\" + testName + timestamp + ".png"));		 

 }    


@AfterTest
public void exit() throws Exception {
	driver.quit(); 
}


}

