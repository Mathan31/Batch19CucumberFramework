package steps;

import java.util.List;
import java.util.Map;

import base.PicoTestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.EbayPage;

public class EbaySearchSD {
	
	EbayPage ebayPage;
	
	public EbaySearchSD(PicoTestContext pico) {
		ebayPage = pico.getPageObjectManager().getEbayPage();
	}
	
	@Given("Navigate to Ebay Page")
	public void navigate_to_ebay_page() {
		ebayPage.navigateToEbay();
	}

	@When("Enter the product name and Select the catagory")
	public void enter_the_product_name_and_select_the_catagory() {
		ebayPage.enterSearchText("iPhone");
		ebayPage.selectProdCatagory("Cell Phones & Accessories");
	}

	
	@When("Enter the product name and Select the catagory from the below data table as map")
	public void enter_the_product_name_and_select_the_catagory_from_the_below_data_table_as_map(DataTable dataTable) {
	    List<Map<String, String>> asMaps = dataTable.asMaps();
	    for (Map<String, String> map : asMaps) {
	    	String prodName = map.get("productname");
	    	String prodCat = map.get("productcatagory");
	    	ebayPage.enterSearchText(prodName);
			ebayPage.selectProdCatagory(prodCat);		
		}
	}

	@When("Click on Search button")
	public void click_on_search_button() {
		ebayPage.clickOnSearchButton();
	}

	@Then("User should able to see the search results")
	public void user_should_able_to_see_the_search_results() {
		String resultText = ebayPage.getSearchResult();
		System.out.println("Result Text is : "+resultText);
	}

}
