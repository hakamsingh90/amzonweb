package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import utils.ExtentReportManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseClass {

    public WebDriver driver;

    public ExtentReports report = ExtentReportManager.getReportInstance();
    public ExtentTest logger;

    // setup browser
    public void setUp(String browserName) {

        try {

            if (browserName.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("Mozila")) {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("Opera")) {
                System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") + "/drivers/operadriver");
                driver = new OperaDriver();
            } else if (browserName.equalsIgnoreCase("IE")) {
                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/drivers/IEDriverServer");
                driver = new InternetExplorerDriver();
            } else {
                driver = new SafariDriver();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        driver.manage().window().maximize();


    }


    @AfterMethod
    public void flushReports() {
        report.flush();
        driver.quit();
    }


    public void waitForPageLoad() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        int i = 0;
        while (i != 180) {
            String pageState = (String) js.executeScript("return document.readyState;");
            if (pageState.equals("complete")) {
                break;
            } else {
                waitLoad(1);
            }
        }

        waitLoad(2);

        i = 0;
        while (i != 180) {
            Boolean jsState = (Boolean) js.executeScript("return window.jQuery != undefined && jQuery.active == 0;");
            if (jsState) {
                break;
            } else {
                waitLoad(1);
            }
        }
    }

    public void waitLoad(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Properties getInstanceOfProp() {

        Properties prop = new Properties();
        InputStream readFile = null;

        {
            try {
                readFile = new FileInputStream(System.getProperty("user.dir") +"/config/config.properties");
                prop.load(readFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return prop;
    }

}
