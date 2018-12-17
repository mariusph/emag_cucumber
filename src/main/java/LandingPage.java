import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class LandingPage extends AbstractPage{
	public LandingPage(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);
	}
    
	private By searchInput = By.id("searchboxTrigger");

	@FindBy(id = "searchboxTrigger")
	private WebElement searchInput2;

	WebDriverWait wait = new WebDriverWait(driver, 30);

	
	public void naviagteToIntacctPage(String url){
		System.out.println("the url is: "+url);
		System.out.println("driver: "+driver.toString());
		driver.manage().window().maximize();
		driver.get(url);
		
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		System.out.println("XXX "+cap.getBrowserName());
	}
	
//	public LandingPage fillTheCompany(String company){
////		driver.findElement(By.id("company")).sendKeys(company);
//		driver.findElement(companyInput).sendKeys(company);
//		return new LandingPage(driver);
//	}
	



// old implementation, without PageFactory
//	public void fillTheSearchTerm(String company){
//		wait.until(visibilityOfElementLocated(searchInput));
//		driver.findElement(searchInput).sendKeys(company);
//		System.out.println(driver.findElement(searchInput).getAttribute("value"));
//	}

	public void fillTheSearchTerm(String company){
		wait.until(visibilityOf(searchInput2));
//		elementIsVisible(By.id("searchboxTrigger"));
		searchInput2.sendKeys(company);
		System.out.println(searchInput2.getAttribute("value"));
	}
	
	}
