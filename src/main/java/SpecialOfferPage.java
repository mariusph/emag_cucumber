import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpecialOfferPage extends  AbstractPage{

    public SpecialOfferPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css= "a.back-button")
    private WebElement backToSiteButton;


    public void clickOnBackToSiteButton() {

        //this special offer page might not be present all the time
//        try {
            if (driver.findElements(By.cssSelector("a.back-button")).size() > 0) {
                backToSiteButton.click();
            } else {
                System.out.println("there is no offer page!");
            }
//       takeScreenshot(getClass().getName().toString());
//        }catch(Exception e){
//            takeScreenshot(new Object(){}.getClass().getEnclosingMethod().getName().toString());
//        }
    }


}
