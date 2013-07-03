package test.java.composerwindow.test;

import org.junit.Assert;

import com.thoughtworks.selenium.DefaultSelenium;

import cucumber.api.java.en.*;


public class ComposerUIStepDefs {
	protected DefaultSelenium seleniumClient = new DefaultSelenium("localhost", 4444, "*firefox", "http://localhost:8080");

	@When("^the application starts$")
	public void the_application_starts() throws Throwable {
		seleniumClient.start();
		seleniumClient.open("http://localhost:8080/Composer/");
	}

	@Then("^I will see the Click Me button$")
	public void I_will_see_the_Click_Me_button() throws Throwable {
		Assert.assertTrue(seleniumClient.isTextPresent("Fuck"));
	}
}
