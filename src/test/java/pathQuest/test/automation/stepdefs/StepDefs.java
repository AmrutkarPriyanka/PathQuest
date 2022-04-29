package pathQuest.test.automation.stepdefs;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pathQuest.test.automation.pageobject.DashboardWidgetPageObjects;
import pathQuest.test.automation.pageobject.GearOptionsPageObject;
import pathQuest.test.automation.pageobject.LoginPageObject;

public class StepDefs {

	WebDriver driver;
	Scenario scn;
	String app_url = "https://uatlogin.pathquest.com/";

	LoginPageObject loginPageObj;
	DashboardWidgetPageObjects dashBoardPageObj;
	GearOptionsPageObject gearOptionPageObj;

	@Before
	public void setUp(Scenario scn) 
	{
		
		this.scn=scn;
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		loginPageObj = new LoginPageObject(driver);
		dashBoardPageObj = new DashboardWidgetPageObjects(driver);
		gearOptionPageObj = new GearOptionsPageObject(driver);
	}

	@After(order=1)
	public void cleanUp()
	{
		driver.quit();
	}

	//screenshot capturing
	@After(order=2)
	public void takescreenShot(Scenario s)
	{
		if (s.isFailed()) 
		{
			TakesScreenshot scrnShot = ((TakesScreenshot)driver);
			byte[] data = scrnShot.getScreenshotAs(OutputType.BYTES);
			scn.attach(data,"image/png","Failed Step name : "+s.getName());
		} 
		else 
		{
			System.out.println("Test case is passed, no screen shot captured");
		}
	}

	@Given("navigation to the url")
	public void navigation_to_the_url() 
	{
		driver.get(app_url);
	}

	@Given("login to the application using username {string} and password {string}")
	public void login_to_the_application_using_username_and_password(String UserName, String Password) 
	{
		loginPageObj.loginToApp(UserName, Password);

	}

	@Then("After Login verify Manage Company page will open")
	public void after_login_verify_manage_company_page_will_open()
	{
		loginPageObj.ManagePage();
	}

	@When("go to Dashboard")
	public void go_to_dashboard()
	{
		dashBoardPageObj.clickOnDashboard();
	}	

	@Then("All the widgets with chart should display")
	public void All_the_widgets_with_chart_should_display()
	{
		dashBoardPageObj.widgetsChartDisplay();
	}

	@When("Click on gear icon at top right side")
	public void Click_on_gear_icon_at_top_right_side() 
	{
		gearOptionPageObj.clickOnGear();
	}

	@Then("Check and verify how many options are there to select")
	public void Check_and_verify_how_many_options_are_there_to_select() 
	{
		gearOptionPageObj.verifyOptions();

	}

}
