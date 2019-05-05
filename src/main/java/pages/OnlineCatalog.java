package pages;

import java.io.IOException;
import java.util.List;

import Util.PropertyFileOperation;
import base.PredefinedActions;
import constant.ConstantPath;

public class OnlineCatalog extends PredefinedActions {

	private static OnlineCatalog onlineCatalogPage;
	private static PropertyFileOperation propOperation;

	private OnlineCatalog() throws IOException {
		propOperation = new PropertyFileOperation(ConstantPath.ONLINECATALOGPAGEPROPERTYPATH);

	}

	/**
	 * @return instance of OnlineCatalog page
	 */
	public static OnlineCatalog getInstance() {

		if (onlineCatalogPage == null) {
			try {
				onlineCatalogPage = new OnlineCatalog();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return onlineCatalogPage;
	}

	/**
	 * @return Reset Form button is visible OnlineCatalog page
	 */
	public boolean isResetFormBtnVisible() {
		return visibilityOfElement(propOperation.getValue("resetFormBtn"));
	}

	/**
	 * @return Place An Order button is visible on OnlineCatalog page
	 */
	public boolean isPlaceAnOrderBtnVisible() {
		return visibilityOfElement(propOperation.getValue("placeAnOrderBtn"));
	}

	/**
	 * @return Reset Form button is clickable on OnlineCatalog page
	 */
	public boolean resetFormBtnclickable() {
		return ClickableElement(propOperation.getValue("resetFormBtn"));
	}

	/**
	 * @return Place An Order button is clickable on OnlineCatalog page
	 */
	public boolean placeAnOrderBtnclickable() {
		return ClickableElement(propOperation.getValue("placeAnOrderBtn"));
	}

	/**
	 * @see - enter quantity of items for 3 person Dome Tent on OnlineCatalog page
	 */
	public void enterQuantityForDomeTent(String value) {

		setText(propOperation.getValue("domeTentQuantityTextBox"), value);
	}

	/**
	 * @see - Reset Form button is clicked on OnlineCatalog page
	 */
	public void clickResetFormBtn() {

		click(propOperation.getValue("resetFormBtn"));
	}

	/**
	 * @see - Place An Order button is clicked on OnlineCatalog page
	 */
	public void clickPlaceAnOrderBtn() {
		click(propOperation.getValue("placeAnOrderBtn"));
	}

	/**
	 * @return - quantities entered for DomeTent on OnlineCatalog page
	 */
	public String getFilledQuantityForDomeTent() {

		return getValue(propOperation.getValue("domeTentQuantityTextBox"));
	}

	/**
	 * @return - alert text on OnlineCatalog page
	 */
	public String handleAlertOnOnlineCatalog() {

		return acceptAlert();
	}

	/**
	 * @return - list of Item names on OnlineCatalog page
	 */
	public List<String> getItemNames() {

		return getTableElements(propOperation.getValue("itemNames"));
	}

	public boolean domeTentLinkClikable() {

		return ClickableElement(propOperation.getValue("domTentLink"));

	}

	public boolean blackpackLinkClikable() {

		return ClickableElement(propOperation.getValue("blackpackLink"));

	}
	public boolean GlassesLinkClikable() {

		return ClickableElement(propOperation.getValue("glassesLink"));

	}
	
	public boolean paddedSocksLinkClikable() {

		return ClickableElement(propOperation.getValue("paddedSocksLink"));

	}
	
	public boolean hikingBootsLinkClikable() {

		return ClickableElement(propOperation.getValue("hinkingBootsLink"));

	}
	public boolean shortsLinkClickable() {
		return ClickableElement(propOperation.getValue("shortLink"));
	}
	
	/**
	 * @see - Person Dome Tent is clicked on OnlineCatalog page
	 */
	public void clickdomeTentLink() {

		click(propOperation.getValue("domTentLink"));
	}
	
	/**
	 * @see - Blackpack Tent is clicked on OnlineCatalog page
	 */
	public void clickBackpackLink() {

		click(propOperation.getValue("blackpackLink"));
	}
	/**
	 * @see - Sun Glasses is clicked on OnlineCatalog page
	 */
	public void clickSunGlassesLink() {

		click(propOperation.getValue("glassesLink"));
	}
	/**
	 * @see - Padded socks is clicked on OnlineCatalog page
	 */
	public void clickPaddedSocksLink() {

		click(propOperation.getValue("paddedSocksLink"));
	}
	/**
	 * @see - Hiking Boots is clicked on OnlineCatalog page
	 */
	public void clickHinkingBootsLink() {

		click(propOperation.getValue("hinkingBootsLink"));
	}
	/**
	 * @see - Back Country Shorts is clicked on OnlineCatalog page
	 */
	public void clickBackCountryShortsLink() {

		click(propOperation.getValue("shortLink"));
	}
}
