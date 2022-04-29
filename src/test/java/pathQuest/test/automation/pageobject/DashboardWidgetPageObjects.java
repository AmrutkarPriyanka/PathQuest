package pathQuest.test.automation.pageobject;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardWidgetPageObjects {

	WebDriver driver;

	public DashboardWidgetPageObjects(WebDriver driver) 
	{
		this.driver = driver;
	}

	public void clickOnDashboard()
	{
		WebElement dashboard = driver.findElement(By.xpath("//p[text()=' Dashboard ']"));
		dashboard.click();
	}

	public void widgetsChartDisplay()
	{
		List<WebElement> WidgetsAndCharts = driver.findElements(By.xpath("//div[contains(@class,'grid-stack-item-co')]"));
		System.out.println("Number of widgets and charts : "+WidgetsAndCharts.size());
		for(int i=0;i<WidgetsAndCharts.size();i++)
		{
			if(WidgetsAndCharts.get(i).isDisplayed())
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.fail();
			}
		}
	}
}
