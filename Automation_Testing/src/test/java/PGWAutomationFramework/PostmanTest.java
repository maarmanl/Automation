package PGWAutomationFramework;

import java.awt.AWTException;

public class PostmanTest {

	public static void main(String[] args) throws AWTException, InterruptedException {

//		for (int i = 0; i < 5; i++) {

			eCommerceTest.ImmediatePaymentAddCard();
			eCommerceTest.ImmediatePayment();
			eCommerceTest.InitiateImmediateSplitPaymentAddCard();
			eCommerceTest.InitiateImmediateSplitPayment();
			eCommerceTest.ImmediateDelayedPayment();
			eCommerceTest.ImmediateDelayedSplitPayment(); 
			eCommerceTest.InitiateRecurringPayment(); 
			eCommerceTest.removeCard();
			mCommerceTest.listTokens();
			mCommerceTest.mCommerceSOVPayment(); 
			mCommerceTest.mCommerceCardPayment();
//		}


	}

}
