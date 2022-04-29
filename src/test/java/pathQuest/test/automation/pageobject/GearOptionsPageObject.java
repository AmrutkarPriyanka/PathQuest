package pathQuest.test.automation.pageobject;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GearOptionsPageObject {

	WebDriver driver;
	public GearOptionsPageObject(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	
	public void clickOnGear()
	{
		WebElement gearIcon = driver.findElement(By.xpath("//span[@ptooltip='Settings']"));
		gearIcon.click();
	}
	
	public void verifyOptions()
	{
		int ExpectedNumberOfOptions  = 13;

		List<WebElement> options = driver.findElements(By.xpath("//div[@class='inner-help-desk']//descendant::a"));
		System.out.println("Number of options : "+options.size());

		Assert.assertEquals(ExpectedNumberOfOptions, options.size());

		// print the list of options
		for(int i=0;i<options.size();i++)
		{
			System.out.println(options.get(i).getText());

		}
	}
}
