package test.java.composerwindow.test;

import org.junit.Before;

import static org.junit.Assert.*;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.thoughtworks.selenium.DefaultSelenium;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class ComposerUIStepDefs {
	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//	capabilities.setCapability("chrome.binary", "/Applications/Google Chrome");
	protected DefaultSelenium seleniumClient = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080");
	
	@Before
	public void setUp() {
		seleniumClient.start();
	}
	
	@When("^the application starts$")
	public void the_application_starts() throws Throwable {
	    seleniumClient.open("http://localhost:8080/Composer");
	}

	@Then("^I will see the Click Me button$")
	public void I_will_see_the_Click_Me_button() throws Throwable {
		
		assertTrue(seleniumClient.isTextPresent("Click me"));
	}
}
