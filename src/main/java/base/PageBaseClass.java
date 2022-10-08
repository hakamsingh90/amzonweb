package base;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageObject.LandingPage;
import utils.DateUtil;

import java.io.File;
import java.io.IOException;

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



    public void scrollToElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void selectDropDownValue(WebElement webElement, String value){
        try {
            Select select = new Select(webElement);
            select.selectByVisibleText(value);
            logger.log(Status.PASS, "Selectd the Value : " + value);
        } catch (Exception e) {
            reportFail(e.getMessage());
        }
    }

    public void reportFail(String reportString) {
        logger.log(Status.FAIL, reportString);
        takeScreenShotOnFailure();
        Assert.fail(reportString);
    }

    public void takeScreenShotOnFailure() {
        TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
        File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);

        File destFile = new File(System.getProperty("user.dir") + "/ScreenShots/" + DateUtil.getTimeStamp() + ".png");
        try {
            FileUtils.copyFile(sourceFile, destFile);
            logger.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + "/ScreenShots/" + DateUtil.getTimeStamp() + ".png");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
