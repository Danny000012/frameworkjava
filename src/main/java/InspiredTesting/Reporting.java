package InspiredTesting;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import core.BaseClass;

   public class Reporting extends BaseClass
   {
        private static ExtentReports report;
        private static ExtentTest currentTest;

   private static void setup()
   {
       setReportDirectory(System.getProperty("user.dir")+"\\Reports\\"+ TestName+"\\"+getCurrentTime()+"\\");
       new File(getReportDirectory()).mkdirs();
       report = new ExtentReports();
       ExtentHtmlReporter html = new ExtentHtmlReporter(getReportDirectory() + "ExtentReport.html");
       report.attachReporter(html);
       report.setAnalysisStrategy(AnalysisStrategy.TEST);

       report.flush();
   }

   public static void createTest()
   {
       try 
       {
           if(report == null) setup();
           if (currentTest == null || !currentTest.getModel().getName().equals(TestName))
           {
               currentTest = report.createTest(TestName);
           } 
       } 
       catch (Exception e) 
       {
           System.out.println(e.getMessage());
       }
   }

   public static void stepPassed(String message)
   {
       if (currentTest == null) createTest();
       currentTest.pass(message);
       System.out.println("[SUCCESS] -"+message);

       report.flush();
   }

   
   public static void info(String message)
   {
       if (currentTest == null) createTest();
       currentTest.info(message);
       System.out.println("[INFO] - "+message);

       report.flush();
   }

   
   public static void warning(String message)
   {
       if (currentTest == null) createTest();
       currentTest.warning(message);
       System.out.println("[WARNING] -"+message);

       report.flush();
   }


   public static void stepPassedWithScreenShot(String message)
   {
       if (currentTest == null) createTest();
       try 
        {
           currentTest.pass(message, MediaEntityBuilder.createScreenCaptureFromPath(SeleniumDriverInstance.takeScreenshot(true)).build());
        } 
        catch (Exception e) 
        {
           currentTest.pass(message + " - screenshot capture failure");
        }

        System.out.println(message);
        report.flush();
   }

   public static String testFailed(String message)
   {
       
       if (currentTest == null) createTest();
       try 
       {
           currentTest.fail(message, MediaEntityBuilder.createScreenCaptureFromPath(SeleniumDriverInstance.takeScreenshot(false)).build());
       } 
       catch (Exception e) 
       {
           currentTest.fail(message + " - screenshot capture failure");
       }
       return message;
   }

   public static String finaliseTest()
   {
       if (currentTest == null) createTest();
       try 
       {
           currentTest.pass("Test Complete!", MediaEntityBuilder.createScreenCaptureFromPath(SeleniumDriverInstance.takeScreenshot(true)).build());
       } 
       catch (Exception e) 
       {
           currentTest.pass("Test Complete!");
       }
       System.out.println("[COMPLETE] - Test Complete");
       
       report.flush();
       return null;
   }

   public static String getCurrentTime()
   {
       Date date = new Date();
       SimpleDateFormat ft = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");

       return ft.format(date);
       
   }

}
