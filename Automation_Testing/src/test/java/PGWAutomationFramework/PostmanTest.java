package PGWAutomationFramework;

import java.awt.AWTException;

public class PostmanTest {

	public static void main(String[] args) throws AWTException, InterruptedException {

		for (int i = 0; i < 5; i++) {

			eCommerceTest.ImmediatePayment();
			eCommerceTest.InitiateImmediateSplitPaymentAddCard();
			eCommerceTest.InitiateImmediateSplitPayment();
			eCommerceTest.ImmediateDelayedPayment();
			eCommerceTest.ImmediateDelayedSplitPayment(); 
			eCommerceTest.InitiateRecurringPayment(); 
			mCommerceTest.listTokens();
			mCommerceTest.mCommerceSOVPayment(); 
			mCommerceTest.mCommerceCardPayment();
		}


	}

}
