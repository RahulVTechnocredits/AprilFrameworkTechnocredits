package pages;

import java.io.IOException;

import Util.PropertyFileOperation;
import base.PredefinedActions;
import constant.ConstantPath;

public class PlaceOrderPage extends PredefinedActions{

	private static PlaceOrderPage placeOrderPage;
	private static PropertyFileOperation propOperation;

	private PlaceOrderPage() throws IOException {
		propOperation = new PropertyFileOperation(ConstantPath.PLACEORDERPAGEPROPERTYPATH);

	}

	/**
	 * @return instance of Place Order page
	 */
	public static PlaceOrderPage getInstance() {

		if (placeOrderPage == null) {
			try {
				placeOrderPage = new PlaceOrderPage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return placeOrderPage;
	}
	/** 
	 *  @return Place Order text is visible on Place Order page
	 */
	public boolean isplaceOrderTextVisible() {
		return visibilityOfElement(propOperation.getValue("placeOrderText"));
		
	}
	
	/**
	 * @return - total price for 1 item of DomeTent for DomeTent on Place Order page
	 */
	public String getTotalPriceOfDomeTent() {

		return getText(propOperation.getValue("totalPriceForDometTentText"));
	}
	
	/**
	 * @return - unit price of DomeTent for DomeTent on Place Order page
	 */
	public String getUnitPriceOfDomeTent() {

		return getText(propOperation.getValue("unitPriceForDometTentText"));
	}

	/**
	 * @return Proceed With Order button is clickable on OnlineCatalog page
	 */
	public boolean proceedWithOrderBtnclickable() {
		return ClickableElement(propOperation.getValue("proceedWithOrderBtn"));
	}

}
