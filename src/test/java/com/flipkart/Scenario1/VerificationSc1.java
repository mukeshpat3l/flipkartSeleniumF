package com.flipkart.Scenario1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.flipkart.Init.AbstractPage;
import com.flipkart.Init.Common;

public class VerificationSc1 extends AbstractPage {

	public VerificationSc1(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(partialLinkText = "New to Flipkart?")
	WebElement copyRight;

	public boolean verifyFlipkartHomepage() {
		System.out.println("copy right text" + copyRight.getText());
		return copyRight.getText().contains("Flipkart");
	}

	@FindBy(xpath = "(.//div[@class='_2aUbKa'])[1]")
	WebElement userName;

	@FindBy(xpath = ".//a/div[contains(text(),'Logout')]")
	WebElement logout;

	@FindBy(xpath = ".//a/div[contains(.,'My Profile')]")
	WebElement myProfile;

	public boolean verifyUserLoggedIn() {
		Common.mouseHoverUsingJS(driver, userName);

		if (logout.isDisplayed()) {
			// System.out.println("inside if");
			Common.jsClick(driver, myProfile);
			return true;

		} else
			return false;

	}

	@FindBy(xpath = "(//div[@class='_3UZZGt'])[1]")
	WebElement filterDevice;

	public boolean verifySearchRslt(String device) {

		return filterDevice.getText().contains(device);
	}

	public boolean verifyPriceRange() {

		return true;
	}

	public boolean verifyRamApplied() {

		return true;
	}

	public boolean verifyCustomerRating() {

		return true;
	}

	public boolean verifyPriceSorted() {

		return true;
	}

	public boolean verifyDeviceDetails() {

		return true;
	}

	public boolean verifyDeviceAddedCart() {

		return true;
	}

	public boolean verifySearchRslt1() {

		return false;
	}

}
