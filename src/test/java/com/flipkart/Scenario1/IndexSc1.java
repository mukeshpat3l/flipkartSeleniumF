package com.flipkart.Scenario1;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.flipkart.Init.Common;
import com.flipkart.Init.SeleniumInit;

public class IndexSc1 extends SeleniumInit {

	@Test
	void searchMobileFilter() {
		int numOfFailure = 0;
		int step = 1;

		logCase("To verify User can Add Electronics device to Cart.");
		logStep(step++, "Open Flipkart URL : " + testUrl);

		Common.Pause(3);

		log("Verify Flipkart site has been opened successfully");
		if (verificationSc1.verifyFlipkartHomepage()) {
			logStatus(1, " Flipkart Homepage opened sucessfully.");
		} else {
			logStatus(2, " Flipkart Homepage NOT opened sucessfully");
			numOfFailure++;
		}
		/*
		 * logStep(step++, "Enter Email/Mobile number: " + testEmail + " and Password: "
		 * + testPswd); verificationSc1 = indexPageSc1.doLogin(testEmail, testPswd);
		 * 
		 * log("Entered Email ID: " + testEmail); log("Entered Password: " + testPswd);
		 * 
		 * Common.Pause(3); log("Verify user logged in with " + testEmail +
		 * " email address."); if (verificationSc1.verifyUserLoggedIn()) { logStatus(1,
		 * " User successfully logged in."); } else { logStatus(2,
		 * " User not logged in successfully."); numOfFailure++; }
		 */
		logStep(step++, "Close the Login Pop up.");
		verificationSc1 = indexPageSc1.closePopup();

		String device = "Realme";

		logStep(step++, "Select Electronics menu > Mobile > " + device + " device.");
		verificationSc1 = indexPageSc1.selectDevice(device);

		log(device + " selected from Electronics menu > Mobile category");

		Common.Pause(3);
		log("Verify Search result page shows correct Filtered result after selecting device "+device);
		if (verificationSc1.verifySearchRslt(device)) {
			logStatus(1, " Search result page shows correct Filtered result after selecting device "+device);
		} else {
			logStatus(2, " Search result page DOES NOT shows correct Filtered result after selecting device "+device);
			numOfFailure++;
		}

		String minPrice = "10000";
		String maxPrice = "30000";

		logStep(step++, "Apply minimum and maximum Price range.");
		verificationSc1 = indexPageSc1.applymPriceRange(minPrice, maxPrice);

		log("Minimum value set to: " + minPrice + " and Maximum value set to " + maxPrice);

		Common.Pause(3);
		
		log("Verify Search result page shows correct Filtered result after selecting Price range "+minPrice+ " to "+maxPrice);
		if (verificationSc1.verifyPriceRange()) {
			logStatus(1, " Search result page shows correct Filtered result after selecting Price range "+minPrice+ " to "+maxPrice);
		} else {
			logStatus(2, " Search result page DOES NOT shows correct Filtered result after selecting Price range "+minPrice+ " to "+maxPrice);
			numOfFailure++;
		}
		 

		String ram1 = "4 GB";
		String ram2 = "6 GB & Above";

		logStep(step++, "Apply RAM filter.");
		verificationSc1 = indexPageSc1.applymRamFilter(ram1, ram2);

		log("Applied RAM filter for " + ram1 + " and " + ram2);

		Common.Pause(3);
		log("Verify Search result page shows correct Filtered result after selecting RAM "+ram1+ " and "+ram2);
		if (verificationSc1.verifyRamApplied()) {
			logStatus(1, " Search result page shows correct Filtered result after selecting RAM "+ram1+ " and "+ram2);
		} else {
			logStatus(2, " Search result page DOES NOT shows correct Filtered result after selecting RAM "+ram1+ " and "+ram2);
			numOfFailure++;
		}
		String custRating = "4";

		logStep(step++, "Apply CUSTOMER RATINGS filter.");
		verificationSc1 = indexPageSc1.applyCustRating(custRating);

		log("Customer rating set for " + custRating + " and above stars.");

		Common.Pause(3);

		log("Verify Search result page shows correct Filtered result after Customer Ratings applied "+ custRating + " and above stars.");
		if (verificationSc1.verifyCustomerRating()) {
			logStatus(1, " Search result page shows correct Filtered result after Customer Ratings applied "+ custRating + " and above stars.");
		} else {
			logStatus(2, " Search result page DOES NOT shows correct Filtered resul tafter Customer Ratings applied "+ custRating + " and above stars.");
			numOfFailure++;
		}
		logStep(step++, "Sort the search result by Price -- High to Low.");
		verificationSc1 = indexPageSc1.sortPriceHtoL();

		log("Clicked on the Price High to Low sorting tab.");

		Common.Pause(3);
		log("Verify Search result page shows correct Filtered result after Price High to Low sorted");
		if (verificationSc1.verifyPriceSorted()) {
			logStatus(1, " Search result page shows correct Filtered result after Price High to Low sorted");
		} else {
			logStatus(2, " Search result page DOES NOT shows correct Filtered result after Price High to Low sorted");
			numOfFailure++;
		}

		logStep(step++, "Click the Title of Largest Price device.");
		verificationSc1 = indexPageSc1.largestPriceClick();

		log("Clicked on the largest price Mobile details.");

		Common.Pause(3);

		log("Verify Successfully clicked on the highest price device.");
		if (verificationSc1.verifyDeviceDetails()) {
			logStatus(1, " Successfully clicked on the highest price device.");
		} else {
			logStatus(2, " Something went worng during highest price device click event.");
			numOfFailure++;
		}

		logStep(step++, "Click the 'Add to Cart' button.");
		verificationSc1 = indexPageSc1.addToCart();

		log("Clicked on the Add to Cart button.");

		Common.Pause(3);

		log("Verify Device successfully added to cart.");
		if (verificationSc1.verifyDeviceAddedCart()) {
			logStatus(1, " Device successfully added to cart.");
		} else {
			logStatus(2, " Something went wrong while clicking on 'Add to cart' button.");
			numOfFailure++;
		}

		if (numOfFailure > 0) {
			Assert.assertTrue(false);
		}
	}

	@Test
	void failed() {
		int numOfFailure = 0;
		int step = 1;

		logCase("To verify User can Add Electronics device to Cart.");
		logStep(step++, "Open Flipkart URL : " + testUrl);

		Common.Pause(3);

		log("Verify Flipkart site has been opened successfully");
		if (verificationSc1.verifySearchRslt1()) {
			logStatus(1, " Flipkart Homepage opened sucessfully.");
		} else {
			logStatus(2, " Flipkart Homepage NOT opened sucessfully");
			numOfFailure++;
		}
		
		if (numOfFailure > 0) {
			Assert.assertTrue(false);
		}
	}
	
}
