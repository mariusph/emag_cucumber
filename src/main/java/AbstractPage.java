import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class AbstractPage {

	public WebDriver driver;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
//	public void waitForElementMappedById(String mapping){
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By
//				.id(mapping)));
//	}
//	
//	public void waitForElementMappedByCss(String mapping){
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By
//				.cssSelector(mapping)));
//	}
	
	public LandingPage intacctLoginPage(){
		return new LandingPage(driver);
	}
	
	public WebElement elementMappedById(String mapping){
		WebElement element = driver
				.findElement(By.id(mapping));
		return element;
	}
	
	public WebElement elementMappedByCss(String mapping){
		WebElement element = driver
				.findElement(By.cssSelector(mapping));
		return element;
	}
	
	public void switchToIamainFrame(){
		driver.switchTo().frame(driver.findElement(By.id("iamain")));
	}
	
	public void switchToYuiResizeMonitorFrame(){
		driver.switchTo().frame(driver.findElement(By.id("_yuiResizeMonitor")));
	}
	
	public void switchToPickerFrame(){
		driver.switchTo().frame(driver.findElement(By.id("picker_iframe")));
	}
	
	 public static Double getRandomDouble(Double min, Double max) {
	        Random random = new Random();
	        DecimalFormat decimalFormat = new DecimalFormat("#.##");
	        Double randomNumber = Double.valueOf(decimalFormat.format(min + ((random.nextDouble() * (max - min)))));
	        return randomNumber;
	    }

	public boolean elementIsVisible(By cssOrXpathLocatorString){
		boolean flag= false;
		int i=1;
		do{
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			if(driver.findElements(cssOrXpathLocatorString).size()>0) {
				flag = true;
			}
			i++;
		}while(flag != true || i>10);
		return flag;
	}

	public void takeScreenshot(String name){
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File("C:\\screenshots\\"+name+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	
}
