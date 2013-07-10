package test.java.composerwindow.test;

import static org.junit.Assert.assertTrue;

import com.thoughtworks.selenium.DefaultSelenium;

import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class ComposerUIStepDefs {
	protected DefaultSelenium seleniumClient = new DefaultSelenium("localhost", 4444, "*googlechrome", "http://localhost:8080");
	private MyWaiter waiter = new MyWaiter(seleniumClient);
	private String emailHeaderFromEntry = "a@b.c";
	private String emailHeaderReplyToEntry = "B@b.c, a@b.c";
	private String emailHeaderSubjectEntry = "Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaan Email";
	private String emailHeaderCCEntry = "theemailofthecustomer@customer.com";
	private String emailHeaderBCCEntry = "ReallylongWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWemail@customer.com";
	private String emailHeaderToEntry = "Plain old subject";

	
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
	
	@Then("^I should see the header area$")
	public void I_should_see_the_header_area() throws Throwable {
		waiter.waitForElement("//textarea[@id='emailHeader']");
	    assertTrue(seleniumClient.isElementPresent("//textarea[@id='emailHeader']"));
	}
	
	@Then("^I should see the email editor$")
	public void verifyEmailEditor() throws Throwable {
		waiter.waitForElement("//div[@id='emailBody']");
	    assertTrue(seleniumClient.isElementPresent("//div[@id='emailBody']"));
	}
	
	@When("^I apply a template$")
	public void I_apply_a_template() throws Throwable {
	    seleniumClient.click("//div[contains(@id, 'gwt-uid')]/span[text()='Venus']");
	    seleniumClient.click("//div[@id='applyTemplateButton']");
	}

	@Then("^the appropriate template is displayed in the Email Editor$")
	public void the_appropriate_template_is_displayed_in_the_Email_Editor() throws Throwable {
	    seleniumClient.selectFrame("//iframe[@class='gwt-RichTextArea']");
		assertTrue(seleniumClient.getText("//html//body").equals("Venus"));
	}
	
	@Then("^I should see the email header$")
	public void I_should_see_a_email_header() throws Throwable {
		waiter.waitForElement("//div[@id='fromSection']");
		assertTrue(seleniumClient.isElementPresent("//div[@id='fromSection']"));
		waiter.waitForElement("//div[@id='replyToSection']");
		assertTrue(seleniumClient.isElementPresent("//div[@id='replyToSection']"));
		waiter.waitForElement("//div[@id='subjectSection']");
		assertTrue(seleniumClient.isElementPresent("//div[@id='subjectSection']"));
		waiter.waitForElement("//div[@id='ccSection']");
		assertTrue(seleniumClient.isElementPresent("//div[@id='ccSection']"));
		waiter.waitForElement("//div[@id='bccSection']");
		assertTrue(seleniumClient.isElementPresent("//div[@id='bccSection']"));
	}
	
	@When("^I edit the email header$")
	public void I_edit_the_email_header() throws Throwable {
		clickEmailHeaderSection("//div[@id='fromSection']");
		typeTextInEditor("//input[@id='fromEditor']", this.emailHeaderFromEntry);
		clickEmailHeaderSection("//div[@id='replyToSection']");
		typeTextInEditor("//input[@id='replyToEditor']", this.emailHeaderReplyToEntry);
		clickEmailHeaderSection("//div[@id='subjectSection']");
		typeTextInEditor("//input[@id='subjectEditor']", this.emailHeaderSubjectEntry);
		clickEmailHeaderSection("//div[@id='toSection']");
		typeTextInEditor("//input[@id='toEditor']", this.emailHeaderToEntry);
		clickEmailHeaderSection("//div[@id='ccSection']");
		typeTextInEditor("//input[@id='ccEditor']", this.emailHeaderCCEntry);
		clickEmailHeaderSection("//div[@id='bccSection']");
		typeTextInEditor("//input[@id='bccEditor']", this.emailHeaderBCCEntry);
	}

	@Then("^the email header displays my edit$")
	public void the_email_header_displays_my_edit() throws Throwable {
		verifyEmailSectionLabelText("//div[@id='fromDisplay']", this.emailHeaderFromEntry);
		verifyEmailSectionLabelText("//div[@id='replyToDisplay']", this.emailHeaderReplyToEntry);
		verifyEmailSectionLabelText("//div[@id='subjectDisplay']", this.emailHeaderSubjectEntry);
		verifyEmailSectionLabelText("//div[@id='toDisplay']", this.emailHeaderToEntry);
		verifyEmailSectionLabelText("//div[@id='ccDisplay']", this.emailHeaderCCEntry);
		verifyEmailSectionLabelText("//div[@id='bccDisplay']", this.emailHeaderBCCEntry);
	}

	private void typeTextInEditor(String editorLocator, String textToType) throws InterruptedException {
		waiter.waitForElement(editorLocator);
		seleniumClient.focus(editorLocator);
		seleniumClient.type(editorLocator, textToType);
		seleniumClient.fireEvent(editorLocator, "blur");
	}

	private void clickEmailHeaderSection(String locator) throws InterruptedException {
		waiter.waitForElement(locator);
		seleniumClient.mouseDown(locator);
		seleniumClient.mouseUp(locator);
	}

	
	private void verifyEmailSectionLabelText(String emailSectionLabelLocator, String textToVerify) throws InterruptedException {
		waiter.waitForElement(emailSectionLabelLocator);
	    assertTrue(seleniumClient.getText(emailSectionLabelLocator).equals(textToVerify));
	}

	@After
	public void tearDown(){
		seleniumClient.stop();
	}
	
}
