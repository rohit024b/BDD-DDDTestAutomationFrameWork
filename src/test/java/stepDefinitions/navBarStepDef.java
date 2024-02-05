package stepDefinitions;

import java.awt.image.BufferedImage;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.navigationBarPages;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class navBarStepDef{
	private WebDriver driver;
	
	private navigationBarPages _navigationBarPages;

	public navBarStepDef()
	{
		driver = new ChromeDriver();
		_navigationBarPages = new navigationBarPages(driver);
	}
		//https://services.aeromegh.com/login
	String base_URLString = "https://leverageedu.com/course-finder/";
//	String base_URLString = "https://services.aeromegh.com/login";
	

	Scenario scn;
	@Before
	public void setup() 
	{
		driver.get(base_URLString);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterStep
	public void setUpAfterStep(Scenario s)
	{
		// to take screenshots after every step executed	
		this.scn = s ;
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		byte[] data = screenshot.getScreenshotAs(OutputType.BYTES);
        scn.attach(data,"image/png","ScreenShot Is Taken");
        
	}
	
	@After
	public void teardown() 
	{
		// Close the WebDriver after each scenario
		if (driver != null) 
		{
			driver.quit();
		}
	}

	@Given("verify the title as {string} is displayed")
	public void verify_the_title_as_is_displayed(String navBarOption)
	{
		_navigationBarPages.verifyTheTitle(navBarOption);
//		System.out.println(ConfigReader.getValue("Abc"+"_username"));
		
	}

	@When("user clicks on navigation button {string}")
	public void user_clicks_on_navigation_button(String string) 
	{
		_navigationBarPages.navBarButtons(string);
		_navigationBarPages.switchWindowToLast();
	}

	@Then("verify the title as {string}")
	public void verify_the_title_as(String title) throws InterruptedException 
	{
		
		_navigationBarPages.verifyTheTitle(title);
		_navigationBarPages.switchWindowToMain();
	}

}
