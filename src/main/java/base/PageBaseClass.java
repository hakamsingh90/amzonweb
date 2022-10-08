package base;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObject.LandingPage;

public class PageBaseClass extends BaseClass{
    public ExtentTest logger;

    public PageBaseClass(WebDriver driver, ExtentTest logger){
        this.driver = driver;
        this.logger = logger;
    }

    // Open web page

    public LandingPage openWebPage(){
        logger.log(Status.INFO,"Opening the amazon site");
        driver.get("https://www.amazon.in/");
        logger.log(Status.PASS, "Successfully amazon page opened");
        LandingPage landingPage = new LandingPage(driver,logger);
        PageFactory.initElements(driver,landingPage);
        return landingPage;

    }
}
