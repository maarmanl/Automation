package PGWAutomationFramework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.PageObjects;
import Utilities.SeleniumDriverUtilities;

public class mCommerceTest extends SeleniumDriverUtilities {
	static SeleniumDriverUtilities utilities = new SeleniumDriverUtilities();
	static WebElement element;
	public static void initiatemCommerceBrowser() {

		if (!SeleniumDriverUtilities.navigateToURL(PageObjects.url())) {
			System.out.println("Failed to navigate");

		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.Username())) {
			System.out.println("Failed to wait for username field");


		}

		if (!SeleniumDriverUtilities.enterText(PageObjects.Username(), "luke.maarman@traderoot.com")) {
			System.out.println("Failed to enter username");


		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.Password())) {
			System.out.println("Failed to wait for password field");


		}

		if (!SeleniumDriverUtilities.enterText(PageObjects.Password(), "Leatherman123")) {
			System.out.println("Failed to enter password");


		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.loginBtn())) {
			System.out.println("Failed to wait for login btn");


		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.loginBtn())) {
			System.out.println("Failed to click login btn");


		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.workSpaceTab(), getTimeout())) {
			System.out.println("Failed to wait for work space tab");

		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.workSpaceTab())) {
			System.out.println("Failed to click work space tab");

		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.myWorkSpace(), getTimeout())) {
			System.out.println("Failed to wait for my work space tab");

		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.myWorkSpace())) {
			System.out.println("Failed to click my work space tab");

		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.mCommerceQA())) {
			System.out.println("Failed to wait for mCommerce QA tab");

		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.mCommerceQA())) {
			System.out.println("Failed to click mCommerce QA tab");

		}
	}

	public static boolean mCommerceSOVPayment() throws InterruptedException {
		initiatemCommerceBrowser();
		String parent = Driver.getWindowHandle();
		Actions hold = new Actions(getDriver());
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		if (!SeleniumDriverUtilities.clickElement(PageObjects.environmentSelect())) {
			System.out.println("Failed to click environment");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.environment())) {
			System.out.println("Failed to select environment");
			return false;
		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.authenitcateTab(), getTimeout())) {
			System.out.println("Failed to wait for authenticate token tab");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.authenitcateTab())) {
			System.out.println("Failed to click authenticate tab");
			return false;
		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.initiateAuthenticateToken())) {
			System.out.println("Failed to wait for initiate authenticate token");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.initiateAuthenticateToken())) {
			System.out.println("Failed to click initiate authenticate token");
			return false;
		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.sendBtn())) {
			System.out.println("Failed to wait for eCommerce send Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.sendBtn())) {
			System.out.println("Failed to click eCommerce send Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.paymentPages(),getTimeout())) {
			System.out.println("Failed to wait for eCommerce payment pages url");
			return false;
		}

		//Navigate to paymentPages in new tab
		String URL = SeleniumDriverUtilities.retrieveElementText(PageObjects.paymentPages()).trim();
		String navigateURL = URL.substring(18, URL.length()-1);

		WebDriver newTab = getDriver().switchTo().newWindow(WindowType.TAB);

		newTab.get(navigateURL);

		Thread.sleep(10000);

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.lastResponse(),5000)) {
			System.out.println("Failed to wait for respone message");
			return false;
		}

		String responseMessage = SeleniumDriverUtilities.retrieveElementText(PageObjects.lastResponse()).trim();

		if (!responseMessage.equals("Approved or completed successfully")) {

			System.out.println(responseMessage + " : Test Fail");
			return false;
		}else {
			System.out.println(responseMessage + " : TEST PASS!");
		}

		//Switch back to parent window
		newTab.close();
		getDriver().switchTo().window(parent);

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.paymentToken())) {
			System.out.println("Failed to wait for payment token");
			return false;
		}

		String paymentToken = SeleniumDriverUtilities.retrieveElementText(PageObjects.paymentToken());
		paymentToken = paymentToken.substring(21, paymentToken.length()-2);
		System.out.println(paymentToken);

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.copyToken(paymentToken))) {
			System.out.println("Failed to wait for payment token to copy");
			return false;
		}else {
			element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PageObjects.copyToken(paymentToken))));
			hold.doubleClick(element).build().perform();

			hold.keyDown(Keys.CONTROL).sendKeys("c").build().perform();
			hold.keyUp(Keys.CONTROL).build().perform();
			Thread.sleep(1000);
		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.closeTab())) {
			System.out.println("Failed to wait for close tab Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.closeTab())) {
			System.out.println("Failed to click for close tab Btn");
			return false;
		}


		if (!SeleniumDriverUtilities.waitForElement(PageObjects.paymentAuthTab())) {
			System.out.println("Failed to wait for payment auth tab");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.paymentAuthTab())) {
			System.out.println("Failed to click payment auth tab");
			return false;
		}

		Thread.sleep(1000);

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.closeTab())) {
			System.out.println("Failed to wait for close tab Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.closeTab())) {
			System.out.println("Failed to click for close tab Btn2");
			return false;
		}


		if (!SeleniumDriverUtilities.waitForElement(PageObjects.AuthRequest())) {
			System.out.println("Failed to wait for payment auth tab");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.AuthRequest())) {
			System.out.println("Failed to click payment auth tab");
			return false;
		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.bodyIcon())) {
			System.out.println("Failed to wait for body icon");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.bodyIcon())) {
			System.out.println("Failed to click body icon");
			return false;
		}

		String paymentToken1 = SeleniumDriverUtilities.retrieveElementText(PageObjects.paymentTokenscnd());
		paymentToken1 = paymentToken1.substring(21, paymentToken1.length()-2);

		if(paymentToken1.equals(paymentToken)) {
			System.out.println("Payment token match");
		}else {
			element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='view-line'][6]//span[contains(text(),'"+paymentToken1+"')]")));
			hold.doubleClick(element).build().perform();

			hold.keyDown(Keys.CONTROL).sendKeys("v").build().perform();
			hold.keyUp(Keys.CONTROL).build().perform();

		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.sendDownload())) {
			System.out.println("Failed to wait for send Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.sendDownload())) {
			System.out.println("Failed to click send Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.sendDownloadBtn())) {
			System.out.println("Failed to wait for send Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.sendDownloadBtn())) {
			System.out.println("Failed to click send Btn");
			return false;
		}

		Thread.sleep(3000);

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.closeTab())) {
			System.out.println("Failed to wait for close tab Btn3");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.closeTab())) {
			System.out.println("Failed to click for close tab Btn3");
			return false;
		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.finAdviceTab())) {
			System.out.println("Failed to wait for fin advice tab Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.finAdviceTab())) {
			System.out.println("Failed to click fin advice tab Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.bodyIcon())) {
			System.out.println("Failed to wait for body icon");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.bodyIcon())) {
			System.out.println("Failed to click body icon");
			return false;
		}

		paymentToken1 = SeleniumDriverUtilities.retrieveElementText(PageObjects.paymentTokenscnd());
		paymentToken1 = paymentToken1.substring(21, paymentToken1.length()-2);

		if(paymentToken1.equals(paymentToken)) {
			System.out.println("Payment token match");
		}else {
			element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='view-line'][6]//span[contains(text(),'"+paymentToken1+"')]")));
			hold.doubleClick(element).build().perform();

			hold.keyDown(Keys.CONTROL).sendKeys("v").build().perform();
			hold.keyUp(Keys.CONTROL).build().perform();

		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.sendDownload())) {
			System.out.println("Failed to wait for send Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.sendDownload())) {
			System.out.println("Failed to click send Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.sendDownloadBtn())) {
			System.out.println("Failed to wait for send Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.sendDownloadBtn())) {
			System.out.println("Failed to click send Btn");
			return false;
		}

		Thread.sleep(3000);
		getDriver().quit();
		return false;
	}


}
