package pompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseHRMClass;

public class PomLogin extends BaseHRMClass {
	
	
	@FindBy(xpath="//input[@name='username']") WebElement Username;
	@FindBy(xpath="//input[@name='password']") WebElement Password;
	@FindBy(xpath="//button") WebElement Loginbtn;

	public PomLogin() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void typeusername(String name) {
		Username.sendKeys(name);
	}
	
	public void typepassword(String pass) {
		Password.sendKeys(pass);
	}
	public void clickbtn() {
		Loginbtn.click();
	}
	public String verify() {
		return driver.getTitle();
	}
	
}  
