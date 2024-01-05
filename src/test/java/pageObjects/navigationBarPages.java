package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import ConfigDefinition.ConfigReader;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.cfg.ConfigFeature;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class navigationBarPages {

	private WebDriver driver;
	
	public navigationBarPages(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	
	public void verifyTheTitle(String titleName) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, titleName);	
		//
	}

//	private By _navBarbuttons= By.xpath("//a[text()='About Us']");
	private String navBarButtonString = "//a[text()='%s']";
//	private String parentWindowString = driver.getWindowHandle();
//	private String childWindowString = driver.getWindowHandles().iterator().next();

	public void navBarButtons(String btnName) 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		
		By clickNavButtonBy = By.xpath(String.format(navBarButtonString, btnName));
		driver.findElement(clickNavButtonBy).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void switchWindowToLast() 
	{
		String mainWindowHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                // Switch to the new tab
                driver.switchTo().window(handle);
            }
            }
       
	}
	
	
	
	public void switchWindowToMain() throws InterruptedException 
	{
		String mainWindowHandle = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
        		driver.close();
        		Thread.sleep(5000);
                driver.switchTo().window(handle);
            }
            }		
	}
}


