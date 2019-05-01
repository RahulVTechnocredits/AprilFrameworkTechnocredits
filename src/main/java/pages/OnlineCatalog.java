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
	
	public static OnlineCatalog getInstance() throws IOException {

		if (onlineCatalogPage == null) {
			onlineCatalogPage = new OnlineCatalog();
		}
		return onlineCatalogPage;
	}
	public boolean isResetFormBtnVisible() {
		return visibilityOfElement(propOperation.getValue("resetFormBtn"));
	}
	
	public boolean isPlaceAnOrderBtnVisible() {
		return visibilityOfElement(propOperation.getValue("placeAnOrderBtn"));
	}
	
	public boolean resetFormBtnclickable() {
		return ClickableElement(propOperation.getValue("resetFormBtn"));
	}
	public boolean placeAnOrderBtnclickable() {
		return ClickableElement(propOperation.getValue("placeAnOrderBtn"));
	}
	
	public void enterQuantityForDomeTent(String value) {
		
		setText(propOperation.getValue("domeTentQuantityTextBox"),  value);
		}
	
	public void clickResetFormBtn() {
		
		 click(propOperation.getValue("resetFormBtn"));
	}
	public void clickPlaceAnOrderBtn() {
		 click(propOperation.getValue("placeAnOrderBtn"));
	}
	
public String getFilledQuantityForDomeTent() {
		
	return getValue(propOperation.getValue("domeTentQuantityTextBox"));
		}
	
public String handleAlertOnOnlineCatalog() {
	
	return acceptAlert();
}

public List<String> getItemNames(){

	
	return getTableElements(propOperation.getValue("itemNames"));
}

}
