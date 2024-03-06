package pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	/**
	 * POJO - Plain Old java Object
	 * POJO --> A class which has only private data members and to access them outside of class 
	 *          we will be using publiic Getter and Setter methods.
	 */
	
	private WebDriver driver;
	private AmazonPage amazonPage;
	private EbayPage ebayPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public EbayPage getEbayPage() {
		if(ebayPage == null) {
			ebayPage = new EbayPage(driver);
		}
		return ebayPage;
	}
	
	public AmazonPage getAmazonPage() {
		if(amazonPage == null) {
			amazonPage = new AmazonPage(driver);
		}
		return amazonPage;
	}

}
