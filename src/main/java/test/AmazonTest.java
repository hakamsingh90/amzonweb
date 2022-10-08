package test;

import base.BaseClass;
import base.PageBaseClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObject.LandingPage;
import pageObject.TelevisionsPage;

public class AmazonTest extends BaseClass {

    LandingPage landingPage;
    TelevisionsPage televisionsPage;

    @Test
    public void openAmazonHomePage(){
        logger = report.createTest("navigate to amazon home page");
        setUp("Chrome");
        PageBaseClass pageBase = new PageBaseClass(driver,logger);
        PageFactory.initElements(driver,pageBase);
        landingPage= pageBase.openWebPage();
        landingPage.clickOnHamberMenu()
                .clickOnTVAppliancesElectronics();

        televisionsPage =landingPage.clickOnTelevision();
        televisionsPage.selectBrand()
                .sortByPrice();







    }
}
