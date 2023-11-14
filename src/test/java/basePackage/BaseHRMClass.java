package basePackage;
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

import utility.TimeUtils;

public class BaseHRMClass {

	public static Properties prop = new Properties();
	public static WebDriver driver;
	
	
	//Step 1 - create a constructor to read from config file
	
	public BaseHRMClass() {
		try {
		FileInputStream file = new FileInputStream("C:\\Users\\navjo\\eclipse-workspace\\HRmanagement\\src\\test\\java\\environmentvariables\\Config.properties");
		prop.load(file);//to read properties of file
		} 
		
		catch (FileNotFoundException e) {
			e.printStackTrace();//exception for file not found
		} 
		catch (IOException a) {
			a.printStackTrace();//please throw if file is not there or not able to read data from it
		}
	}
	
	//Step 2 - create a method that will have all common cmds that will used by child classes
	
	public static void initiate() {//static so that other classes can use it
	String webbrowser=prop.getProperty("browser");
	
	if(webbrowser.equals("Firefox")) {
		System.getProperty("WebDriver.gecko.driver", "geckodriver.exe");
		driver= new FirefoxDriver();
	}
	
	else if(webbrowser.equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(TimeUtils.timepage, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	}
	
	
	public static void screenshots(String Filename) {
		
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try{
			FileUtils.copyFile(file, new File ("C:\\Users\\navjo\\eclipse-workspace\\HRmanagement\\src\\test\\java\\Screenshot\\Screenshots" + Filename + ".jpg"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
