package pages;

import java.io.IOException;

import Util.PropertyFileOperation;
import base.PredefinedActions;
import constant.ConstantPath;

public class ProductsPage extends PredefinedActions {

	private static ProductsPage productsPage;
	private static PropertyFileOperation propOperation;

	private ProductsPage() throws IOException {
		propOperation = new PropertyFileOperation(ConstantPath.PRODUCTSPAGEPROPERTYPATH);

	}
	
	/**
	 * @return instance of Products page
	 */
	public static ProductsPage getInstance(){

		if (productsPage == null) {
			try {
				productsPage = new ProductsPage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return productsPage;
	}
	
	/** 
	 *  @return 3 Person Dome Tent text is visible on Products page
	 */
	public boolean isdomeTentProductNameTextVisible() {
		return visibilityOfElement(propOperation.getValue("domeTentProductNameText"));
		
	}
	
	/** 
	 *  @return External Frame Backpack text is visible on Products page
	 */
	public boolean isBackpackProductNameTextVisible() {
		return visibilityOfElement(propOperation.getValue("backpackProductNameText"));
		
	}
	/** 
	 *  @return Glacier Sun Glasses text is visible Products page
	 */
	public boolean isGlassesProductNameTextVisible() {
		return visibilityOfElement(propOperation.getValue("sunglassesProductNameText"));
	
	}
	/** 
	 *  @return Padded Socks text is visible on Products page
	 */
	public boolean isSocksProductNameTextVisible() {
		return visibilityOfElement(propOperation.getValue("socksProductNameText"));
	
	}
	
	/** 
	 *  @return Hiking Boots text is visible on Products page
	 */
	public boolean isHinkingBootsProductNameTextVisible() {
		return visibilityOfElement(propOperation.getValue("hinkingProductNameText"));
	
	}
	/** 
	 *  @return Back Country Shorts text is visible on Products page
	 */
	public boolean isCountryShortsProductNameTextVisible() {
		return visibilityOfElement(propOperation.getValue("shortsProductNameText"));
	
	}
}
