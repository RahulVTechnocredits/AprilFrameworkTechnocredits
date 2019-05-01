package testScripts;

import java.io.IOException;

import base.PredefinedActions;
import pages.WelcomePage;

public class TestBase {

	
	void start() throws IOException {
		PredefinedActions.initialization("https://demo.borland.com/gmopost/");
	}
	
	void close() throws IOException {
		PredefinedActions.closeBrowser();
	}
}
