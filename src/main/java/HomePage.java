import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class HomePage extends AbstractPage{

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	private By findButton= By.cssSelector("button[class*='searchbox-submit-button']");
	private By resultsTitle= By.cssSelector(".page-container h1");

	@FindBy(css="button[class*='searchbox-submit-button']")
	private WebElement findButton2;

	@FindBy(css=".page-container h1")
	private WebElement resultsTitle2;

	WebDriverWait wait = new WebDriverWait(driver, 30);


	public void clickFindButton() {
//		wait.until(visibilityOfElementLocated(findButton));
//		driver.findElement(findButton).click();
		wait.until(visibilityOf(findButton2));
		findButton2.click();
	}

	public void verifyTheResults(String term, String number) {
//		wait.until(visibilityOfElementLocated(resultsTitle));
//		WebElement elem= driver.findElement(resultsTitle);
//		Assert.assertTrue("the term is not found, but "+elem.getText(), elem.getText().contains(term));
//		Assert.assertTrue("the results are not found, but "+elem.getText(), elem.getText().contains(number));

		wait.until(visibilityOf(resultsTitle2));
		Assert.assertTrue("the term is not found, but "+resultsTitle2.getText(), resultsTitle2.getText().contains(term));
		Assert.assertTrue("the results are not found, but "+resultsTitle2.getText(), resultsTitle2.getText().contains(number));
	}
}
