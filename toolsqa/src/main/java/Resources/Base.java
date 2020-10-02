package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {
	
	public WebDriver driver;
	public 	 Properties prop;

	 

 public WebDriver initializeDriver() throws IOException 
 {
	prop = new Properties(); 
	

	// FileInputStream fis = new FileInputStream("C:\\Users\\User\\git\\repository\\toolsqa\\src\\main\\java\\Resources\\data.properties");
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/Resources/data.properties");

	prop.load(fis);
	 String browser =prop.getProperty("browser");
	 
	 System.out.println(browser);
	 
	 if(browser.equals("chrome"))	
	 {
		 System.setProperty("webdriver.chrome.driver","C:\\Chromedriver\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();	



	 }
	 else if (browser.equals("firefox"))
	 {
		
		
			 driver = new FirefoxDriver();

	 }
	 else if (browser.equals("IE"))
	 {
		 
			 driver = new InternetExplorerDriver();

	 }
	return driver;

	 
	 	
 }
 


}
