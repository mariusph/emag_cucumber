import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AbstractStep {

    protected WebDriver driver;

    protected WebDriver getDriver(){
        if(driver == null ){

            if(System.getProperty("webdriver.driver").equals("firefox")){
                driver= new FirefoxDriver();
            }else if(System.getProperty("webdriver.driver").equals("firefoxH")){
                FirefoxOptions options= new FirefoxOptions();
                options.addArguments("--headless");
                driver= new FirefoxDriver(options);
            }else if(System.getProperty("webdriver.driver").equals("chrome")){
                driver= new ChromeDriver();
            }else if(System.getProperty("webdriver.driver").equals("chromeH")){
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
                driver= new ChromeDriver(options);
            }else if(System.getProperty("webdriver.driver").equals("edge")){
                driver= new EdgeDriver();
            }else{
                driver= new FirefoxDriver();
            }

        }
        return driver;
    }



}
