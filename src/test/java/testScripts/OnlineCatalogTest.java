package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.OnlineCatalog;
import pages.WelcomePage;

public class OnlineCatalogTest extends TestBase {

	// Verify on "online-catalog" page 'Reset Form' and 'Place An Order' button is
	// visible and clickable.

	@Test(enabled = false)
	public void verifyButtonsResetFormAndPlaceAndOrderOnOnlineCatalogPage() throws IOException {

		start();
		WelcomePage welcomePage = WelcomePage.getInstance();
		SoftAssert softassert = new SoftAssert();
		OnlineCatalog onlineCatalogPage = OnlineCatalog.getInstance();

		boolean gmoBtnVisibleFlag = welcomePage.isGMOOnlineVisible();
		softassert.assertTrue(gmoBtnVisibleFlag);
		welcomePage.clickOnGmoOnlineBtn();
		boolean BtnPlaceAnOrderFlag = onlineCatalogPage.isPlaceAnOrderBtnVisible();
		softassert.assertTrue(BtnPlaceAnOrderFlag);
		boolean BtnResetFormFlag = onlineCatalogPage.isResetFormBtnVisible();
		softassert.assertTrue(BtnResetFormFlag);

		boolean BtnPlaceAnOrderClickableFlag = onlineCatalogPage.placeAnOrderBtnclickable();
		softassert.assertTrue(BtnPlaceAnOrderClickableFlag);

		boolean BtnResetFormClickableFlag = onlineCatalogPage.resetFormBtnclickable();
		softassert.assertTrue(BtnResetFormClickableFlag);

		close();
	}

	// Verify using 'Reset Form' user is able to Reset filled value for 'OnLine
	// Catalog' form.

	@Test
	public void verifyUserisAbleToResetfilledValueUsingResetFormBtnOnOnlineCatalogPage() throws IOException {
		start();
		WelcomePage welcomePage = WelcomePage.getInstance();
		SoftAssert softassert = new SoftAssert();
		OnlineCatalog onlineCatalogPage = OnlineCatalog.getInstance();

		boolean gmoBtnVisibleFlag = welcomePage.isGMOOnlineVisible();
		softassert.assertTrue(gmoBtnVisibleFlag);
		welcomePage.clickOnGmoOnlineBtn();

		onlineCatalogPage.enterQuantityForDomeTent("1");

		String filledQuntity = onlineCatalogPage.getFilledQuantityForDomeTent();
		System.out.println("No of filled quantities: " + filledQuntity);

		onlineCatalogPage.clickResetFormBtn();

		String actualAfterReset = onlineCatalogPage.getFilledQuantityForDomeTent();
		System.out.println("actual value after reset is :" + actualAfterReset);

		String expected = "0";

		Assert.assertEquals(actualAfterReset, expected);
		close();
	}

	// Verify user is not able to place an order without selecting any products.

	@Test(enabled = false)
	public void verifyUserisUnableToPlaceOrderWithoutSelectingProductOnOnlineCatalogPage() throws IOException {

		start();
		WelcomePage welcomePage = WelcomePage.getInstance();
		SoftAssert softassert = new SoftAssert();
		OnlineCatalog onlineCatalogPage = OnlineCatalog.getInstance();

		boolean gmoBtnVisibleFlag = welcomePage.isGMOOnlineVisible();
		softassert.assertTrue(gmoBtnVisibleFlag);
		welcomePage.clickOnGmoOnlineBtn();

		onlineCatalogPage.clickPlaceAnOrderBtn();

		String actual = onlineCatalogPage.handleAlertOnOnlineCatalog();
		String expected = "Please Order Something First";
		Assert.assertEquals(actual, expected, "text on alert is not matching");
		close();
	}
	// Verify total 6 Item name is displayed on 'OnLine Catalog' form.

	@Test(enabled = false)
	public void verify6ItemsDisplayedOnOnlineCatalogPage() throws IOException {
		start();
		WelcomePage welcomePage = WelcomePage.getInstance();
		SoftAssert softassert = new SoftAssert();
		OnlineCatalog onlineCatalogPage = OnlineCatalog.getInstance();

		boolean gmoBtnVisibleFlag = welcomePage.isGMOOnlineVisible();
		softassert.assertTrue(gmoBtnVisibleFlag);
		welcomePage.clickOnGmoOnlineBtn();

		java.util.List<String> al = onlineCatalogPage.getItemNames();
		int expected = al.size();
		int actual = 6;
		Assert.assertEquals(actual, expected, "size of elements is not matching");
		System.out.println(al);
		close();
	}
}
