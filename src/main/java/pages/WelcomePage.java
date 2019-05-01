package pages;

import java.io.IOException;

import Util.PropertyFileOperation;
import base.PredefinedActions;
import constant.ConstantPath;

public class WelcomePage extends PredefinedActions {

	private static WelcomePage welcomePage;
	private static PropertyFileOperation propOperation;

	private WelcomePage() throws IOException {
		propOperation = new PropertyFileOperation(ConstantPath.WELCOMEPAGEPROPERTYPATH);

	}

	public static WelcomePage getInstance() throws IOException {

		if (welcomePage == null) {
			welcomePage = new WelcomePage();
		}
		return welcomePage;
	}

	/**
	 * 
	 * @return page Title of welcomePage
	 */

	public String getTitleOfWelcomePage() {
		return getPageTitle();
	}

	public boolean visibilityOnWelcomePage(String locator) {
		return visibilityOfElement(locator);
	}
	
	public boolean GMOBtnclickableOnWelcomePage() {
		return ClickableElement(propOperation.getValue("gmoOnlineText"));
	}
	
	public boolean isGMOOnlineTextVisible() {
		return visibilityOnWelcomePage(propOperation.getValue("gmoOnlineText"));
		
	}

	public boolean isGMOOnlineVisible() {
		return visibilityOnWelcomePage(propOperation.getValue("gmoOnlineBtn"));
	}

	public boolean isAboutSiteVisible() {
		return visibilityOnWelcomePage(propOperation.getValue("aboutGmoSiteBtn"));
	}

	public boolean isBrowserTestPageVisible() {
		return visibilityOnWelcomePage(propOperation.getValue("browserTestPageBtn"));
	}
	
	public void clickOnGmoOnlineBtn() {
		
		 click(propOperation.getValue("gmoOnlineBtn"));
	}
}
