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

	public static WelcomePage getInstance() {

		if (welcomePage == null) {
			try {
				welcomePage = new WelcomePage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
	
	/**
	 * @return visibility of element on welcomePage
	 */

	public boolean visibilityOnWelcomePage(String locator) {
		return visibilityOfElement(locator);
	}
	
	/** 
	 *  @return  GMOButton is clickable on welcomePage
	 */
	public boolean GMOBtnclickableOnWelcomePage() {
		return ClickableElement(propOperation.getValue("gmoOnlineText"));
	}
	
	/** 
	 *  @return GMO Online text is visible on welcomePage
	 */
	public boolean isGMOOnlineTextVisible() {
		return visibilityOnWelcomePage(propOperation.getValue("gmoOnlineText"));
		
	}
	/** 
	 *  @return GMO Online text is visible on welcomePage
	 */
	public boolean isGMOOnlineVisible() {
		return visibilityOnWelcomePage(propOperation.getValue("gmoOnlineBtn"));
	}
	/** 
	 *  @return About Site button is visible on welcomePage
	 */
	public boolean isAboutSiteVisible() {
		return visibilityOnWelcomePage(propOperation.getValue("aboutGmoSiteBtn"));
	}
	/** 
	 *  @return About Browser Test Page is visible on welcomePage
	 */
	public boolean isBrowserTestPageVisible() {
		return visibilityOnWelcomePage(propOperation.getValue("browserTestPageBtn"));
	}
	/** 
	 *  @see - click on GMO Online button
	 */
	public void clickOnGmoOnlineBtn() {
		
		 click(propOperation.getValue("gmoOnlineBtn"));
	}
}
