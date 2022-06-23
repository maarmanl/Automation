package PGWAutomationFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import Utilities.PageObjects;
import Utilities.SeleniumDriverUtilities;

public class eCommerceTest extends SeleniumDriverUtilities{

	SeleniumDriverUtilities utilities = new SeleniumDriverUtilities();

	public static void InitiateBrowser() {
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

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.eCommerceQA())) {
			System.out.println("Failed to wait for eCommerce QA tab");

		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.eCommerceQA())) {
			System.out.println("Failed to click eCommerce QA tab");

		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.eCommerce())) {
			System.out.println("Failed to wait for eCommerce");

		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.eCommerce())) {
			System.out.println("Failed to click eCommerce");

		}
	}

	public static boolean ImmediatePayment() throws InterruptedException {

		InitiateBrowser();

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.immediatePayment())) {
			System.out.println("Failed to wait for eCommerce InitiateImediatePayment");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.immediatePayment())) {
			System.out.println("Failed to click eCommerce InitiateImediatePayment");
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


		if (!SeleniumDriverUtilities.waitForElement(PageObjects.singlePayment(),getTimeout())) {
			System.out.println("Failed to wait for eCommerce payment pages single payment");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.singlePayment())) {
			System.out.println("Failed to click eCommerce payment pages single payment");
			return false;
		}

		//Select card
//		WebElement element = getDriver().findElement(By.xpath(PageObjects.cardList()));
//		List<WebElement> select = element.findElements(By.tagName("div"));
//		select.get(3).click();
		
		if (!SeleniumDriverUtilities.waitForElement(PageObjects.singlepaymentCard())) {
			System.out.println("Failed to wait for eCommerce continue to pay Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.singlepaymentCard())) {
			System.out.println("Failed to click eCommerce continue to pay Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.continueToPayBtn())) {
			System.out.println("Failed to wait for eCommerce continue to pay Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.continueToPayBtn())) {
			System.out.println("Failed to click eCommerce continue to pay Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.cvvText())) {
			System.out.println("Failed to wait for cvv text");
			return false;
		}

		//Extract cvv
		String text = SeleniumDriverUtilities.retrieveElementText(PageObjects.cvvText()).trim();
		String cvv = text.substring(3, text.length());

		if (!SeleniumDriverUtilities.enterText(PageObjects.cvvInput(), cvv)) {
			System.out.println("Failed to enter cvv");
			return false;

		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.payBtn())) {
			System.out.println("Failed to wait for eCommerce 3D secure continue Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.payBtn())) {
			System.out.println("Failed to click 3D secure continue to pay Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.secureBtn(),getTimeout())) {
			System.out.println("Failed to wait for 3D secure continue to pay Btn");
			return false;
		}



		if (!SeleniumDriverUtilities.clickElement(PageObjects.secureBtn())) {
			System.out.println("Failed to click 3D secure continue to pay Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.secureContinueBtn())) {
			System.out.println("Failed to wait for eCommerce payment pages split payment");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.secureContinueBtn())) {
			System.out.println("Failed to click eCommerce payment pages split payment");
			return false;
		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.lastResponse(),5000)) {
			System.out.println("Failed to wait for respone message");
			return false;
		}
		Thread.sleep(1000);
		String responseMessage = SeleniumDriverUtilities.retrieveElementText(PageObjects.lastResponse()).trim();

		if (!responseMessage.equals("Approved or completed successfully")) {

			System.out.println(responseMessage + " : Test Fail");
			return false;
		}else {
			System.out.println(responseMessage + " : TEST PASS!");
		}
		getDriver().quit();
		return false;
	}

	public static boolean InitiateImmediateSplitPayment() throws InterruptedException {

		InitiateBrowser();

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.immediatePayment())) {
			System.out.println("Failed to wait for eCommerce InitiateImediatePayment");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.immediatePayment())) {
			System.out.println("Failed to click eCommerce InitiateImediatePayment");
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

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.splitPayment(),getTimeout())) {
			System.out.println("Failed to wait for eCommerce payment pages split payment");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.splitPayment())) {
			System.out.println("Failed to click eCommerce payment pages split payment");
			return false;
		}

		//Select card
//		WebElement element = getDriver().findElement(By.xpath(PageObjects.splitPaymentCardList()));
//		List<WebElement> select = element.findElements(By.tagName("div"));
//		select.get(3).click();
		
		if (!SeleniumDriverUtilities.waitForElement(PageObjects.splitPaymentCard1())) {
			System.out.println("Failed to wait for eCommerce payment pages split payment");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.splitPaymentCard1())) {
			System.out.println("Failed to click eCommerce payment pages split payment");
			return false;
		}

		if (!SeleniumDriverUtilities.enterText(PageObjects.amount(), "1000")) {
			System.out.println("Failed to enter amount");
			return false;
		}

		if (!SeleniumDriverUtilities.enterText(PageObjects.cvvTextInput(), "427")) {
			System.out.println("Failed to enter cvv");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.doneBtn())) {
			System.out.println("Failed to click done Btn");
			return false;
		}

//		element = getDriver().findElement(By.xpath(PageObjects.splitPaymentCardList()));
//		List<WebElement> select2 = element.findElements(By.tagName("div"));
//		select2.get(21).click();
		
		if (!SeleniumDriverUtilities.waitForElement(PageObjects.splitPaymentCard2())) {
			System.out.println("Failed to wait for eCommerce payment pages split payment");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.splitPaymentCard2())) {
			System.out.println("Failed to click eCommerce payment pages split payment");
			return false;
		}

		if (!SeleniumDriverUtilities.enterText(PageObjects.cvvTextInput(), "178")) {
			System.out.println("Failed to enter cvv");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.scndCardDoneBtn())) {
			System.out.println("Failed to click done Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.splitPaymentPayBtn())) {
			System.out.println("Failed to wait for eCommerce payment pages split payment");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.splitPaymentPayBtn())) {
			System.out.println("Failed to click eCommerce payment pages split payment");
			return false;
		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.secureBtn())) {
			System.out.println("Failed to wait for eCommerce payment pages split payment");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.secureBtn())) {
			System.out.println("Failed to click eCommerce payment pages split payment");
			return false;
		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.secureContinueBtn())) {
			System.out.println("Failed to wait for eCommerce payment pages split payment");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.secureContinueBtn())) {
			System.out.println("Failed to click eCommerce payment pages split payment");
			return false;
		}


		if (!SeleniumDriverUtilities.waitForElement(PageObjects.secureBtn())) {
			System.out.println("Failed to wait for eCommerce payment pages split payment");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.secureBtn())) {
			System.out.println("Failed to click eCommerce payment pages split payment");
			return false;
		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.secureContinueBtn())) {
			System.out.println("Failed to wait for eCommerce payment pages split payment");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.secureContinueBtn())) {
			System.out.println("Failed to click eCommerce payment pages split payment");
			return false;
		}

		Thread.sleep(5000);
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
		getDriver().quit();
		return false;
	}

	public static boolean ImmediateDelayedPayment() throws InterruptedException {

		InitiateBrowser();

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.delayedPayment())) {
			System.out.println("Failed to wait for delayed payment tab");
			return false;

		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.delayedPayment())) {
			System.out.println("Failed to click delayed payment tab");
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


		if (!SeleniumDriverUtilities.waitForElement(PageObjects.singlePayment(),getTimeout())) {
			System.out.println("Failed to wait for eCommerce payment pages single payment");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.singlePayment())) {
			System.out.println("Failed to click eCommerce payment pages single payment");
			return false;
		}

		//Select card
//		WebElement element = getDriver().findElement(By.xpath(PageObjects.cardList()));
//		List<WebElement> select = element.findElements(By.tagName("div"));
//		select.get(3).click();
		
		if (!SeleniumDriverUtilities.waitForElement(PageObjects.singlepaymentCard())) {
			System.out.println("Failed to wait for eCommerce continue to pay Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.singlepaymentCard())) {
			System.out.println("Failed to click eCommerce continue to pay Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.continueToPayBtn())) {
			System.out.println("Failed to wait for eCommerce continue to pay Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.continueToPayBtn())) {
			System.out.println("Failed to click eCommerce continue to pay Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.cvvText())) {
			System.out.println("Failed to wait for cvv text");
			return false;
		}

		//Extract cvv
		String text = SeleniumDriverUtilities.retrieveElementText(PageObjects.cvvText()).trim();
		String cvv = text.substring(3, text.length());

		if (!SeleniumDriverUtilities.enterText(PageObjects.cvvInput(), cvv)) {
			System.out.println("Failed to enter cvv");
			return false;

		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.payBtn())) {
			System.out.println("Failed to wait for eCommerce 3D secure continue Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.payBtn())) {
			System.out.println("Failed to click 3D secure continue to pay Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.secureBtn(),getTimeout())) {
			System.out.println("Failed to wait for 3D secure continue to pay Btn");
			return false;
		}



		if (!SeleniumDriverUtilities.clickElement(PageObjects.secureBtn())) {
			System.out.println("Failed to click 3D secure continue to pay Btn");
			return false;
		}

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
		getDriver().quit();
		return false;
	}

	public static boolean ImmediateDelayedSplitPayment() throws InterruptedException {
		InitiateBrowser();

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.delayedPayment())) {
			System.out.println("Failed to wait for delayed payment tab");
			return false;

		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.delayedPayment())) {
			System.out.println("Failed to click delayed payment tab");
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

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.splitPayment(),getTimeout())) {
			System.out.println("Failed to wait for eCommerce payment pages split payment");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.splitPayment())) {
			System.out.println("Failed to click eCommerce payment pages split payment");
			return false;
		}

		//Select card
//		WebElement element = getDriver().findElement(By.xpath(PageObjects.splitPaymentCardList()));
//		List<WebElement> select = element.findElements(By.tagName("div"));
//		select.get(3).click();
		
		if (!SeleniumDriverUtilities.waitForElement(PageObjects.splitPaymentCard1())) {
			System.out.println("Failed to wait for eCommerce payment pages split payment");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.splitPaymentCard1())) {
			System.out.println("Failed to click eCommerce payment pages split payment");
			return false;
		}

		if (!SeleniumDriverUtilities.enterText(PageObjects.amount(), "1000")) {
			System.out.println("Failed to enter amount");
			return false;
		}

		if (!SeleniumDriverUtilities.enterText(PageObjects.cvvTextInput(), "427")) {
			System.out.println("Failed to enter cvv");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.doneBtn())) {
			System.out.println("Failed to click done Btn");
			return false;
		}

//		element = getDriver().findElement(By.xpath(PageObjects.splitPaymentCardList()));
//		List<WebElement> select2 = element.findElements(By.tagName("div"));
//		select2.get(21).click();

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.splitPaymentCard2())) {
			System.out.println("Failed to wait for eCommerce payment pages split payment");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.splitPaymentCard2())) {
			System.out.println("Failed to click eCommerce payment pages split payment");
			return false;
		}
		
		if (!SeleniumDriverUtilities.enterText(PageObjects.cvvTextInput(), "178")) {
			System.out.println("Failed to enter cvv");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.scndCardDoneBtn())) {
			System.out.println("Failed to click done Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.splitPaymentPayBtn())) {
			System.out.println("Failed to wait for eCommerce payment pages split payment");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.splitPaymentPayBtn())) {
			System.out.println("Failed to click eCommerce payment pages split payment");
			return false;
		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.secureBtn())) {
			System.out.println("Failed to wait for eCommerce payment pages split payment");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.secureBtn())) {
			System.out.println("Failed to click eCommerce payment pages split payment");
			return false;
		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.secureContinueBtn())) {
			System.out.println("Failed to wait for eCommerce payment pages split payment");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.secureContinueBtn())) {
			System.out.println("Failed to click eCommerce payment pages split payment");
			return false;
		}


		if (!SeleniumDriverUtilities.waitForElement(PageObjects.secureBtn())) {
			System.out.println("Failed to wait for eCommerce payment pages split payment");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.secureBtn())) {
			System.out.println("Failed to click eCommerce payment pages split payment");
			return false;
		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.secureContinueBtn())) {
			System.out.println("Failed to wait for eCommerce payment pages split payment");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.secureContinueBtn())) {
			System.out.println("Failed to click eCommerce payment pages split payment");
			return false;
		}

		Thread.sleep(5000);
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
		getDriver().quit();
		return false;
	}

	public static boolean InitiateRecurringPayment() throws InterruptedException {
		InitiateBrowser();
		if (!SeleniumDriverUtilities.waitForElement(PageObjects.delayedPayment())) {
			System.out.println("Failed to wait for delayed payment tab");
			return false;

		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.delayedPayment())) {
			System.out.println("Failed to click delayed payment tab");
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


		if (!SeleniumDriverUtilities.waitForElement(PageObjects.singlePayment(),getTimeout())) {
			System.out.println("Failed to wait for eCommerce payment pages single payment");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.singlePayment())) {
			System.out.println("Failed to click eCommerce payment pages single payment");
			return false;
		}

		//Select card
//		WebElement element = getDriver().findElement(By.xpath(PageObjects.cardList()));
//		List<WebElement> select = element.findElements(By.tagName("div"));
//		select.get(3).click();
		
		if (!SeleniumDriverUtilities.waitForElement(PageObjects.singlepaymentCard())) {
			System.out.println("Failed to wait for eCommerce continue to pay Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.singlepaymentCard())) {
			System.out.println("Failed to click eCommerce continue to pay Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.continueToPayBtn())) {
			System.out.println("Failed to wait for eCommerce continue to pay Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.continueToPayBtn())) {
			System.out.println("Failed to click eCommerce continue to pay Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.cvvText())) {
			System.out.println("Failed to wait for cvv text");
			return false;
		}

		//Extract cvv
		String text = SeleniumDriverUtilities.retrieveElementText(PageObjects.cvvText()).trim();
		String cvv = text.substring(3, text.length());

		if (!SeleniumDriverUtilities.enterText(PageObjects.cvvInput(), cvv)) {
			System.out.println("Failed to enter cvv");
			return false;

		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.payBtn())) {
			System.out.println("Failed to wait for eCommerce 3D secure continue Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.clickElement(PageObjects.payBtn())) {
			System.out.println("Failed to click 3D secure continue to pay Btn");
			return false;
		}

		if (!SeleniumDriverUtilities.waitForElement(PageObjects.secureBtn(),getTimeout())) {
			System.out.println("Failed to wait for 3D secure continue to pay Btn");
			return false;
		}



		if (!SeleniumDriverUtilities.clickElement(PageObjects.secureBtn())) {
			System.out.println("Failed to click 3D secure continue to pay Btn");
			return false;
		}

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
		getDriver().quit();
		return false;
	}

}
