package pageObject;

import base.PageBaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Electronics extends PageBaseClass {
    public Electronics(WebDriver driver, ExtentTest logger) {
        super(driver, logger);
    }


    @FindBy(xpath = "//*[@id=\"feature-bullets\"]/h1")
    WebElement aboutitem;

    @FindBy(id = "feature-bullets")
    WebElement aboutSection;

    public void verifyNewWindowItem(){

        try {

            String mainWindow = switchToWindow();
            scrollToElement(aboutitem);
            waitLoad(2);
            Assert.assertEquals(aboutitem.getText(),"About this item");
            logger.log(Status.PASS,"Assert that “About this item” section is present and log this section text to console/report");
            logger.log(Status.INFO,aboutSection.getText());
            //Close child window
            driver.close();
            //Switch back to main Window
            driver.switchTo().window(mainWindow);

        } catch (Exception e) {
            reportFail(e.getMessage());
        }
    }


}
