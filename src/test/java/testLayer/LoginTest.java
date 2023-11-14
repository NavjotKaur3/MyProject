package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseHRMClass;
import pompackage.PomLogin;
import testdata.ExcelSheet;

public class LoginTest extends BaseHRMClass {
	PomLogin Log;
	
	public LoginTest() {//create a constructor
	
		super(); //to call parent class constructor;
	}

	@BeforeMethod
	public void initsetup() throws InterruptedException {
		initiate();//calling initiate method from basehrmclass
		Thread.sleep(3000);
		screenshots("Login");
		 Log=new PomLogin();//need methods from PomLogin, so
		 					//we are creating its object
	}
	
	@Test(priority=1)
	public void Title() {
		String actual = Log.verify();
		System.out.println(actual);
		Assert.assertEquals(actual, "OrangeHRM");
	}
	@DataProvider(name="Mydata")
	public Object[][] Details(){
		Object result[][]=ExcelSheet.readdata("Sheet1");
		return result;
	}
	
	@Test(priority=2, dataProvider="Mydata") 
	public void Login(String name, String password) {
		Log.typeusername(name);
		Log.typepassword(password);
		
	//	Log.clickbtn();
		
	}
	
	
	/*
	 * @Test(priority=2) public void Login() {
	 * Log.typeusername(prop.getProperty("username"));
	 * Log.typepassword(prop.getProperty("password"));
	 * 
	 * //Log.clickbtn(); }
	 */
	@AfterMethod
	public void close() {
		driver.close();
	}





}