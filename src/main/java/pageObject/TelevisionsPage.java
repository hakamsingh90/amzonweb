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


    public TelevisionsPage selectBrand(){
        logger.log(Status.PASS,"Scroll down and filter the results by Brand Samsung");
        waitLoad(1);
        scrollToElement(brand);
        brand.click();
        TelevisionsPage televisionsPage = new TelevisionsPage(driver,logger);
        PageFactory.initElements(driver,televisionsPage);
        return televisionsPage;

    }

    public void sortByPrice(){
        logger.log(Status.PASS,"Sort the Samsung results with price High to Low");
        waitLoad(1);
        selectDropDownValue(dropDown,"Price: High to Lw");
    }
}

