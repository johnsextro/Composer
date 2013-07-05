package test.java.composerwindow.test;

import com.thoughtworks.selenium.DefaultSelenium;

public class MyWaiter {
	public static final int HALF_SECOND = 500;
	public static final int ONE_SECOND = 1000;
	public static final int QUARTER_SECOND = 250;
	public static final int ONE_TENTH_SECOND = 100;
	
	private DefaultSelenium seleniumClient;

	public MyWaiter(DefaultSelenium seleniumClient) {
		super();
		this.seleniumClient = seleniumClient;
	}
	
	public void waitForElement(String locator) throws InterruptedException {
		waitForElement(locator, 10, ONE_TENTH_SECOND);
	}
	
	public void waitForElement(String locator, int maxRetryAttempts, int millsToWaitBetweenAttempts) throws InterruptedException {
		int attempt = 0;
		while (!seleniumClient.isElementPresent(locator) && attempt < maxRetryAttempts){
			attempt++;
			Thread.sleep(millsToWaitBetweenAttempts);
		}
	}

	public void waitForText(String textToWaitFor) throws InterruptedException {
		waitForText(textToWaitFor, 10, ONE_TENTH_SECOND);
	}
	
	public void waitForText(String textToWaitFor, int maxRetryAttempts, int millsToWaitBetweenAttempts) throws InterruptedException {
		int attempt = 0;
		while (!seleniumClient.isTextPresent(textToWaitFor) && attempt < maxRetryAttempts){
			attempt++;
			Thread.sleep(millsToWaitBetweenAttempts);
		}
	}
}
