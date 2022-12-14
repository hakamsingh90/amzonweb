package pageObject;

import base.PageBaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends PageBaseClass {

    public LandingPage(WebDriver driver, ExtentTest logger) {
        super(driver, logger);
    }

    @FindBy(id = "nav-hamburger-menu")
    public WebElement HamburgerMenu;

    @FindBy(xpath = "//a[@data-menu-id=9]")
    public WebElement TVAppliancesElectronics;

    @FindBy(xpath = "//*[@id=\"hmenu-content\"]/ul[9]/li[3]/a")
    public WebElement Televisions;

    public LandingPage clickOnHamberMenu() {

        try {
            HamburgerMenu.click();
            logger.log(Status.PASS,"Clicking on hamburger menu");
            waitLoad(1);
        } catch (Exception e) {
            reportFail(e.getMessage());
        }
        LandingPage landingPage = new LandingPage(driver,logger);
        PageFactory.initElements(driver,landingPage);
        return landingPage;
    }

    public LandingPage clickOnTVAppliancesElectronics(){
        try {
            TVAppliancesElectronics.click();
            logger.log(Status.PASS,"Click on the TV, Appliances and Electronics link under Shop by Department section");
        } catch (Exception e) {
            reportFail(e.getMessage());
        }
        LandingPage landingPage = new LandingPage(driver,logger);
        PageFactory.initElements(driver,landingPage);
        return landingPage;
    }

    public TelevisionsPage clickOnTelevision(){
        try {
            Televisions.click();
            logger.log(Status.PASS,"click on Televisions under Tv, Audio & Cameras sub section");
            waitLoad(2);
        } catch (Exception e) {
            reportFail(e.getMessage());
        }

        TelevisionsPage televisionsPage = new TelevisionsPage(driver,logger);
        PageFactory.initElements(driver,televisionsPage);
        return televisionsPage;

    }

}
