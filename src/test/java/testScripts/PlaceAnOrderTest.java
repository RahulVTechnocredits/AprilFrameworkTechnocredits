package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.OnlineCatalog;
import pages.PlaceOrderPage;
import pages.WelcomePage;

public class PlaceAnOrderTest extends TestBase{
	
	//Verify user can Place an Order  '3 Person Dome Tent' in quantity of 1. 

	@Test(enabled=false)
	public void verifyUserisAbleToPlaceAnOrderOfDomeTentWithQuantity1OnPlaceOrderPage()  {
		start();
		WelcomePage welcomePage = WelcomePage.getInstance();
		SoftAssert softassert = new SoftAssert();
		OnlineCatalog onlineCatalogPage = OnlineCatalog.getInstance();
		PlaceOrderPage placeorderPage= PlaceOrderPage.getInstance();

		boolean gmoBtnVisibleFlag = welcomePage.isGMOOnlineVisible();
		softassert.assertTrue(gmoBtnVisibleFlag);
		welcomePage.clickOnGmoOnlineBtn();

		onlineCatalogPage.enterQuantityForDomeTent("1");

		

		onlineCatalogPage.clickPlaceAnOrderBtn();
		boolean placeOrderFlag=placeorderPage.isplaceOrderTextVisible();
		softassert.assertTrue(placeOrderFlag);
		

		String actualTotalPrice = placeorderPage.getTotalPriceOfDomeTent();
		System.out.println("Total Price of 1 Dome Tent :" + actualTotalPrice);

		String expectedTotalPrice = "$ 299.99";

		Assert.assertEquals(actualTotalPrice, expectedTotalPrice);
		String actualUnitPrice = placeorderPage.getUnitPriceOfDomeTent();
		System.out.println("Unit Price of 1 Dome Tent :" + actualUnitPrice);

		String expectedUnitPrice = "$ 299.99";
		Assert.assertEquals(actualUnitPrice, expectedUnitPrice);
		
		close();
	}
	
	//Verify 'Proceed With Order' button is clickable
	
	@Test
	public void verifyProceedWithOrderOnPlaceOrderPage() {
		start();
		WelcomePage welcomePage = WelcomePage.getInstance();
		SoftAssert softassert = new SoftAssert();
		OnlineCatalog onlineCatalogPage = OnlineCatalog.getInstance();
		PlaceOrderPage placeorderPage= PlaceOrderPage.getInstance();

		boolean gmoBtnVisibleFlag = welcomePage.isGMOOnlineVisible();
		softassert.assertTrue(gmoBtnVisibleFlag);
		welcomePage.clickOnGmoOnlineBtn();

		onlineCatalogPage.enterQuantityForDomeTent("1");

		

		onlineCatalogPage.clickPlaceAnOrderBtn();
		boolean placeOrderFlag=placeorderPage.isplaceOrderTextVisible();
		softassert.assertTrue(placeOrderFlag);
		
		boolean proceedWithOrderFlag=placeorderPage.proceedWithOrderBtnclickable();
		softassert.assertTrue(proceedWithOrderFlag);
		softassert.assertAll();
		close();
	}


}
