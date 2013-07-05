package test.java.composerwindow.test;

import static org.junit.Assert.*;

import com.thoughtworks.selenium.DefaultSelenium;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.*;


public class ComposerUIStepDefs {
	protected DefaultSelenium seleniumClient = new DefaultSelenium("localhost", 4444, "*googlechrome", "http://localhost:8080");
	private MyWaiter waiter = new MyWaiter(seleniumClient);

	
	@When("^the application starts$")
	public void the_application_starts() throws Throwable {
		seleniumClient.start();
		seleniumClient.open("http://localhost:8080/Composer/");		
	}
	
	@Then("^I see a tree view$")
	public void I_see_a_tree_view() throws Throwable {
		waiter.waitForElement("//div[contains(@class, 'v-tree')]");
		assertTrue(seleniumClient.isElementPresent("//div[contains(@class, 'v-tree')]"));
	}

	@Then("^I see \"([^\"]*)\"$")
	public void I_see(String expectedText) throws Throwable {
		waiter.waitForText(expectedText);
		assertTrue(seleniumClient.isTextPresent(expectedText));
	}
	
	@Then("^I should see a field to use for searching templates$")
	public void I_should_see_a_field_to_use_for_searching_templates() throws Throwable {
	    waiter.waitForElement("//input[@class='v-filterselect-input']");
	    assertTrue(seleniumClient.isElementPresent("//input[@class='v-filterselect-input']"));
	}

	@Then("^I should see a button labeled \"([^\"]*)\"$")
	public void I_should_see_a_button_labeled(String buttonLabel) throws Throwable {
		waiter.waitForElement("//span[contains(@class, 'v-button-wrap')]");
	    assertTrue(seleniumClient.isElementPresent("//span[contains(@class, 'v-button-caption') and text()='" + buttonLabel + "']"));
	}
	
	@After
	public void tearDown(){
		seleniumClient.stop();
	}
	
}
