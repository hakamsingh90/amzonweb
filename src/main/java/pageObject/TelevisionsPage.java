package pageObject;

import base.PageBaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TelevisionsPage extends PageBaseClass {

    public TelevisionsPage(WebDriver driver, ExtentTest logger) {
        super(driver, logger);
    }

    @FindBy(xpath = "//*[@id=\"s-refinements\"]//span[contains(text(),\"Samsung\")]")
    WebElement brand;

    @FindBy(xpath = "//*[@class=\"a-dropdown-container\"]//select")
    WebElement dropDown;

    @FindBy(xpath = "//*[@data-index='2']//img")
    WebElement secondHighPriceTV;






    public TelevisionsPage selectBrand(){
        try {
            scrollToElement(brand);
            brand.click();
            logger.log(Status.PASS,"Scroll down and filter the results by Brand Samsung");
        } catch (Exception e) {
            reportFail(e.getMessage());
        }
        TelevisionsPage televisionsPage = new TelevisionsPage(driver,logger);
        PageFactory.initElements(driver,televisionsPage);
        return televisionsPage;

    }

    public TelevisionsPage sortByPrice(){
        selectDropDownValue(dropDown,"Price: High to Low");
        TelevisionsPage televisionsPage = new TelevisionsPage(driver,logger);
        PageFactory.initElements(driver,televisionsPage);
        return televisionsPage;
    }

    public Electronics clickOnSecondHighestPricedItem(){

        try {
            secondHighPriceTV.click();
            logger.log(Status.PASS,"Click on the second highest priced item");

        } catch (Exception e) {
            reportFail(e.getMessage());
        }

        Electronics electronics = new Electronics(driver,logger);
        PageFactory.initElements(driver,electronics);
        return electronics;

    }

}

