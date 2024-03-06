package base;

import pages.PageObjectManager;

public class PicoTestContext {
	
	//POJO
	
	private BrowserFactory testBase;
	private PageObjectManager pageObjectManager;
	
	public PicoTestContext() {
		testBase = new BrowserFactory();
		pageObjectManager = new PageObjectManager(testBase.launchBrowser());
	}
	
	public BrowserFactory getTestBase() {
		return testBase;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	
}
