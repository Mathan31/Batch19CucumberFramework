package steps;

import java.util.List;
import java.util.Map;

import base.BrowserFactory;
import base.PicoTestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonPage;

public class AmazonSearchSD extends BrowserFactory {

	AmazonPage amazonPage;

	public AmazonSearchSD(PicoTestContext pico) {
		amazonPage = pico.getPageObjectManager().getAmazonPage();
	}

	@Given("User should navigate to Amazon")
	public void user_should_navigate_to_amazon() {
		amazonPage.navigateToAmazon();
	}

	@When("User search with multiple products in Amazon called")
	public void user_search_with_multiple_products_called(DataTable dataTable) {
		List<Map<String, String>> searchs = dataTable.asMaps();
		for (Map<String, String> search : searchs) {
			amazonPage.enterProductName(search.get("ProdName"));
			amazonPage.selectProductCatagory(search.get("ProdCat"));
			amazonPage.clickSearchButton();
		}
	}

	@Then("Validate the Amazon search result")
	public void validate_the_search_result() {
		String sResult = amazonPage.getsearchResult(); // 530,000
		System.out.println("Result is : " + sResult);

	}

}
