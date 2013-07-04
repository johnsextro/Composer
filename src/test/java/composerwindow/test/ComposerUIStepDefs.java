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

	@Then("^I see the Click Me button$")
	public void checkClickMe() throws Throwable {
		int attempt = 0;
		while (!seleniumClient.isElementPresent("//span[contains(@class, 'v-button-wrap')]") && attempt < 10){
			attempt++;
			Thread.sleep(500);
		}
		assertTrue(seleniumClient.isElementPresent("//span[contains(@class, 'v-button-wrap')]"));
	}
	
	@When("^I click the Click Me button$")
	public void I_click_the_Click_Me_button() throws Throwable {
		seleniumClient.click("//*[@id='Composer-534698688']/div/div[2]/div[1]/div");
	}

	@Then("^I will see Thank you for clicking$")
	public void I_will_see_Thank_you_for_clicking() throws Throwable {
	    assertTrue(seleniumClient.isTextPresent("Thank you for clicking"));
	}
	
	@After
	public void tearDown(){
		seleniumClient.stop();
	}
	
}
