import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Steps2 extends AbstractStep{

    WebDriver driver= getDriver();

	AbstractPage page= new AbstractPage(driver);
	LandingPage landingPage = new LandingPage(driver);
	HomePage home= new HomePage(driver);
	SpecialOfferPage offerPage= new SpecialOfferPage(driver);

	private Scenario scenario;

    @Before
    public Scenario getScenario(Scenario s){
        String sc= s.getName();
        scenario=s;
        System.out.println("scenario running: "+sc);
        return s;
    }

    @After
    public void closeDriver() {

        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                String testName = scenario.getName();

                scenario.embed(screenshot, "image/png");
                scenario.write(testName);
            } catch (Exception ex) {
//                ex.printStackTrace();
            }
        }

        driver.quit();

    }

	
	@Given("^Navigate to \"([^\"]*)\" app$")
	public void Navigate_to_app(String url) throws Throwable {
//		driver.manage().window().maximize();
//	    driver.get(url);

		url= System.getProperty("webdriver.base.url");
		 landingPage.naviagteToIntacctPage(url);
	}

//	@When("^I insert the company as \"([^\"]*)\"$")
//	public void I_insert_the_company_as(String company) throws Throwable {
////		driver.findElement(By.id("company")).sendKeys(arg2);
//		landingPage.fillTheCompany(company);
//	}


    @When("^I search the \"([^\"]*)\"$")
    public void i_search_the(String term) throws Throwable {
        landingPage.fillTheSearchTerm(term);
    }

    @When("^i click on find button$")
    public void i_click_on_find_button() throws Throwable {
       home.clickFindButton();
    }

    @When("^it should be dispalyed the \"([^\"]*)\" and number of \"([^\"]*)\"$")
    public void it_should_be_dispalyed_the_and_number_of(String term, String number) throws Throwable {
        home.verifyTheResults(term, number);
    }

    @Given("^we might be redirected to special offer page$")
    public void we_might_be_redirected_to_special_offer_page() throws Throwable {
        offerPage.clickOnBackToSiteButton();
    }

}
