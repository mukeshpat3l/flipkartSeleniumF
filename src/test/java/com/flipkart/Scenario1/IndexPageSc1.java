package com.flipkart.Scenario1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.flipkart.Init.AbstractPage;
import com.flipkart.Init.Common;

public class IndexPageSc1 extends AbstractPage {

	public IndexPageSc1(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = ".//span[contains(.,'Enter Email/Mobile number')]/../../input")
	WebElement emailInput;

	@FindBy(xpath = ".//span[contains(.,'Enter Password')]/../../input")
	WebElement paswdInput;

	@FindBy(xpath = ".//span[contains(.,'Login')]/../../button[@type='submit']")
	WebElement loginSubmit;

	public VerificationSc1 doLogin(String email, String pswd) {

		Common.clickableElement(emailInput, driver);
		emailInput.sendKeys(email);

		Common.clickableElement(paswdInput, driver);
		paswdInput.sendKeys(pswd);

		Common.clickOn(driver, loginSubmit);

		return new VerificationSc1(driver);
	}

	@FindBy(xpath = ".//button[@class='_2AkmmA _29YdH8']")
	WebElement closePop;

	public VerificationSc1 closePopup() {
		Common.clickableElement(closePop, driver);
		Common.clickOn(driver, closePop);
		return new VerificationSc1(driver);
	}

	@FindBy(xpath = "//span[contains(text(),'Electronics')]")
	WebElement electronics;

	public VerificationSc1 selectDevice(String device) {

		Common.mouseHoverUsingJS(driver, electronics);
		System.out.println("After Common.mouseHoverUsingJS");

		WebElement deviceE = driver.findElement(By.xpath("//a[contains(text(),'" + device + "')]"));
		System.out.println("After find element");

		Common.jsClick(driver, deviceE);
		// Common.clickOn(driver, deviceE);

		return new VerificationSc1(driver);

	}

	@FindBy(xpath = "//div[@class='_1qKb_B']//select[@class='fPjUPw']")
	WebElement minPriceDrpDown;

	@FindBy(xpath = "//div[@class='_1YoBfV']//select[@class='fPjUPw']")
	WebElement maxPriceDrpDown;

	public VerificationSc1 applymPriceRange(String minPrice, String maxPrice) {

		Select minSelect = new Select(minPriceDrpDown);

		minSelect.selectByValue(minPrice);

		Common.pause(2);

		Select maxcSelect = new Select(maxPriceDrpDown);

		maxcSelect.selectByValue(maxPrice);

		return new VerificationSc1(driver);
	}

	public VerificationSc1 applymRamFilter(String ram1, String ram2) {
		// .//section[@class='_1gjf4c
		// D_NGuZ']/..//div[contains(.,'RAM')]/..//div[@class='_36jUgy']/..//label/input

		List<WebElement> chkBx_RAM = driver.findElements(By.xpath(
				".//section[@class='_1gjf4c D_NGuZ']/..//div[contains(.,'RAM')]/..//label/..//div[@class='_1GEhLw']"));
		int iSize = chkBx_RAM.size();

		for (int i = 0; i < iSize; i++) {

			String ramLabel = chkBx_RAM.get(i).getText();
			System.out.println(ramLabel);

			if (ramLabel.equalsIgnoreCase(ram1) || ramLabel.equalsIgnoreCase(ram2)) {
				Common.Pause(3);

				chkBx_RAM.get(i).click();
				Common.Pause(5);
			}
		}

		return new VerificationSc1(driver);
	}

	public VerificationSc1 applyCustRating(String custRating) {

		List<WebElement> chkBx_CsRatings = driver.findElements(By.xpath(
				".//section[@class='_1gjf4c D_NGuZ']/..//div[contains(.,'Customer Ratings')]/..//label/..//div[@class='_1GEhLw']"));
		int iSize = chkBx_CsRatings.size();

		for (int i = 0; i < iSize; i++) {

			String custRatingLabel = chkBx_CsRatings.get(i).getText();
			System.out.println(custRatingLabel);

			if (custRatingLabel.contains(custRating)) {
				chkBx_CsRatings.get(i).click();
				Common.Pause(5);
				break;
			}
		}
		return new VerificationSc1(driver);
	}

	@FindBy(xpath = ".//span[contains(text(),'Sort By')]/..//div[contains(.,'Price -- High to Low')]")
	WebElement priceHighToLow;

	public VerificationSc1 sortPriceHtoL() {

		Common.clickOn(driver, priceHighToLow);

		return new VerificationSc1(driver);
	}

	@FindBy(xpath = "(//div[@class='_3wU53n'])[1]")
	WebElement firstNode;

	public VerificationSc1 largestPriceClick() {

		ArrayList<String> obtainedList = new ArrayList<>();
		List<WebElement> prices = driver.findElements(By.xpath(".//div[@class='_1vC4OE _2rQ-NK']"));

		for (int i = 1; i < prices.size(); i++) {

			String price = driver.findElement(By.xpath("(.//div[@class='_1vC4OE _2rQ-NK'])[" + i + "]")).getText();
			obtainedList.add(price.replaceAll("/[^0-9]/g", ""));
		}
		Collections.sort(obtainedList, Collections.reverseOrder());
		String max = Collections.max(obtainedList);

		
		WebElement max2 = driver.findElement(By.xpath(".//div[@class='_1vC4OE _2rQ-NK' and contains(.,'" + max + "')]"));

		Common.clickOn(driver, max2);
		return new VerificationSc1(driver);
	}

	@FindBy(xpath = ".//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")
	WebElement addToCartBtn;

	public VerificationSc1 addToCart() {

		Common.SwitchtoTab(driver, 1);

		Common.clickOn(driver, addToCartBtn);

		return new VerificationSc1(driver);
	}

}
