package test;

import base.BaseClass;
import base.PageBaseClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObject.Electronics;
import pageObject.LandingPage;
import pageObject.TelevisionsPage;

public class AmazonTest extends BaseClass {

    LandingPage landingPage;
    TelevisionsPage televisionsPage;
    Electronics electronics;

    @Test
    public void openAmazonHomePage(){
        logger = report.createTest("Navigate to amazon home page");
        setUp(getInstanceOfProp().getProperty("Browser"));
        PageBaseClass pageBase = new PageBaseClass(driver,logger);
        PageFactory.initElements(driver,pageBase);
        landingPage= pageBase.openWebPage(getInstanceOfProp().getProperty("URL"));
        landingPage.clickOnHamberMenu()
                .clickOnTVAppliancesElectronics();

        televisionsPage =landingPage.clickOnTelevision();
        televisionsPage.selectBrand()
                .sortByPrice();

        electronics = televisionsPage.clickOnSecondHighestPricedItem();
        electronics.verifyNewWindowItem();

    }
}
