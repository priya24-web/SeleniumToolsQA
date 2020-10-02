package Academytoolsqa;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class ScreenshotCompare {

		// TODO Auto-generated method stub
	@Test
	public void imageCompare() throws IOException {
			
	
		BufferedImage expectedImage= ImageIO.read(new File(System.getProperty("user.dir")+"/screenshotsfirst/Toolsqascrenshot2020_10_01__01_05_29.png"));
		
		BufferedImage actualImage= ImageIO.read(new File(System.getProperty("user.dir")+"/screenshotsfirst/Toolsqascrenshot2020_10_01__03_34_47.png"));

		ImageDiffer imgDiff = new ImageDiffer();
		ImageDiff diff= imgDiff.makeDiff(expectedImage, actualImage);
		
		// Assert.assertFalse(diff.hasDiff(),"Images are same");
		
		
		Assert.assertFalse(diff.hasDiff(),"Result of Image comparsion");
		System.out.println("Images Compared Sucesfully");
		
		}	
	
	
	}

