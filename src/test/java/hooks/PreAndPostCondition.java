package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.BrowserFactory;
import base.PicoTestContext;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class PreAndPostCondition{
	
	/**
	 * For @Before lowest order value will be executed at first.
	 * For @After Higest order value  will be executed at first.
	 */
	private WebDriver driver;
	
	public PreAndPostCondition(PicoTestContext pico) {
		driver = pico.getTestBase().launchBrowser();
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}
	
	@AfterStep
	public void takeScreenShot(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotAs, "image/png", "ScreenFailure");
		}
	}
	
}
