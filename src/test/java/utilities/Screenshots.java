package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Screenshots {

	public static void takeScreenshot(WebDriver driver, String fileName) throws IOException {
		fileName = fileName + ".jpg";
		String dir = "C:\\Users\\Ryan\\Desktop\\";
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(dir + fileName));
	}
}
