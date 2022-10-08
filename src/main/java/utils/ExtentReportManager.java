package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;


public class ExtentReportManager {


    public static ExtentReports report;

    public static ExtentReports getReportInstance(){

        if(report == null){
            String reportName = DateUtil.getTimeStamp() + ".html";
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/testoutput/" + reportName);
            report =  new ExtentReports();
            report.attachReporter(htmlReporter);

            report.setSystemInfo("OS", "macOS");
            report.setSystemInfo("Environment", "local");
            report.setSystemInfo("Browser", "Chrome");

            htmlReporter.config().setDocumentTitle("Local amazon page result");
            htmlReporter.config().setReportName("UI Test Report");
            htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
            htmlReporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
        }

        return report;
    }
}
