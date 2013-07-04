package test.java.composerwindow.test;

import static org.junit.Assert.*;

import com.thoughtworks.selenium.DefaultSelenium;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;


public class ComposerUIStepDefs {
	protected DefaultSelenium seleniumClient = new DefaultSelenium("localhost", 4444, "*firefox", "http://localhost:8080");

	@When("^the application starts$")
	public void the_application_starts() throws Throwable {
		seleniumClient.start();
		seleniumClient.open("http://localhost:8080/Composer/");		
	}

	@Then("^I will see the Click Me button$")
	public void checkClickMe() throws Throwable {
		int attempt = 0;
		while (!seleniumClient.isElementPresent("//div[contains(@class, 'v-button')]") && attempt < 10){
			attempt++;
			Thread.sleep(500);
		}
		assertTrue(seleniumClient.isElementPresent("//div[contains(@class, 'v-button')]"));
		System.out.println("Then step");
	}
	
	@After
	public void tearDown(){
		seleniumClient.stop();
	}
	
}
