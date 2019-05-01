package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.WelcomePage;

public class WelcomePageTest extends TestBase{
	
	@Test(priority=-1)
	
	public void verifyBtnVisibilityOnWelcomePage() throws IOException {
		
		start();
		
		WelcomePage welcomePage=WelcomePage.getInstance();
		SoftAssert softassert = new SoftAssert(); 
		boolean GMOButtonFlag =welcomePage.isGMOOnlineVisible();
		softassert.assertTrue(GMOButtonFlag);
		boolean isBrowserTestBtnFlag =welcomePage.isBrowserTestPageVisible();
		softassert.assertTrue(isBrowserTestBtnFlag);
		boolean isAboutSiteBtn =welcomePage.isAboutSiteVisible();
		softassert.assertTrue(isAboutSiteBtn);
		softassert.assertAll();
		close();
	}
	
	//Verify after enter URL "GMO OnLine" word is displyed.

	@Test(priority=0)
	
	public void verifyTextGMOOnlineOnWelcomePage() throws IOException {
		start();
		WelcomePage welcomePage=WelcomePage.getInstance();
		SoftAssert softassert = new SoftAssert();
		
		boolean GMOTextflag = welcomePage.isGMOOnlineTextVisible();
		
		softassert.assertTrue(GMOTextflag);
		close();
	}
	
	@Test(priority=2)
	
	public void verifyBtnGMOOnlineisclickableOnWelcomePage() throws IOException {
		start();
		WelcomePage welcomePage=WelcomePage.getInstance();
		SoftAssert softassert = new SoftAssert();
		
		boolean GMOBtnClickableflag = welcomePage.GMOBtnclickableOnWelcomePage();
		
		softassert.assertTrue(GMOBtnClickableflag);
		close();
	}
	
	

}
