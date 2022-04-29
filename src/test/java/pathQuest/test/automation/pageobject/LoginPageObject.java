package pathQuest.test.automation.pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject {

	WebDriver driver;
	public LoginPageObject(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public void loginToApp(String userName,String pwd)
	{
		
		WebElement username = driver.findElement(By.xpath("//input[@name='txtUserName']"));
		username.sendKeys(userName);

		WebElement password = driver.findElement(By.xpath("//input[@name='txtPassword']"));
		password.sendKeys(pwd);

		WebElement LoginNow = driver.findElement(By.xpath("//button[@type='button']"));
		LoginNow.click();
	}
	
	public void ManagePage()
	{
		WebElement ManageCompnay = driver.findElement(By.xpath("//p[text()='Manage Your companies']"));
		String ExpectedText = "Manage Your companies";

		Assert.assertEquals(ExpectedText,ManageCompnay.getText());
		System.out.println("ManageCompany Page opened");
	}
}
