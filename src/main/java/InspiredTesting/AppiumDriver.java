package InspiredTesting;

import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import core.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AppiumDriver extends BaseClass{
    
    private AndroidDriver driver;
    private AppiumDriverLocalService appiumService;
    private static int screenShotCounter = 0;
    
    
    AppiumDriver(DesiredCapabilities caps)
    {
        StartServices();
        startDriver(caps);
    }

    //Create Appium Server
    public void StartServices()
    {
        appiumService = AppiumDriverLocalService.buildDefaultService();
        appiumService.start();
        
    }

    //Create Capabilities
    public static DesiredCapabilities setRunCapabilities(String deviceName, String platformVersion, String platformName, String appPackage, String appActivity, String appFilePath) 
    {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("deviceName",deviceName);
        caps.setCapability("automatinName", "uiautomator2");
        caps.setCapability("sendKeyStrategy", "grouped");
        caps.setCapability("platformVersion", platformVersion);
        caps.setCapability("platformName", platformName);
        caps.setCapability("appPackage",appPackage);
        caps.setCapability("appActivity", appActivity);

        caps.setCapability("fullReset", "true");
        caps.setCapability("app", appFilePath);
        return caps;
    }

    //Create Appium Driver
    public void startDriver(DesiredCapabilities caps)
    {
        try 
        {
            this.driver = new AndroidDriver(appiumService, caps);
        } 
        catch (Exception e) 
        {
            
        }
    }

    public boolean validateElementText(By selector, String textToValidate)
    {
        try
        {
            waitForElement(selector);
            WebDriverWait wait = new WebDriverWait(this.driver, 1);
            wait.until(ExpectedConditions.elementToBeClickable(selector));
            WebElement element = this.driver.findElement(selector);
            return element.getText().equals(textToValidate);

        }
        catch (Exception e)
        {
            return false;
        }
    }


    public void shutDown()
    {
        this.driver.closeApp();
        this.driver.close();
        this.appiumService.stop();
    }

    //Create Appium Methods
    public boolean waitForElement(By selector)
    {
        try 
        {
            WebDriverWait wait = new WebDriverWait(this.driver, 5);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(selector));

            return true;
        }
        catch (Exception e) {
            
            return false;
        }
    }

    public boolean clickElement(By selector)
    {
        try
        {
            waitForElement(selector);
            WebDriverWait wait = new WebDriverWait(this.driver, 1);
            wait.until(ExpectedConditions.elementToBeClickable(selector));
            WebElement elementToClick = this.driver.findElement(selector);
            elementToClick.click();

           return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public boolean enterText(By selector, String textToEnter) 
    {
        try
        {
            waitForElement(selector);
            WebDriverWait wait = new WebDriverWait(driver, 1);
            wait.until(ExpectedConditions.elementToBeClickable(selector));
            
            WebElement elementToClick = this.driver.findElement(selector);
            elementToClick.sendKeys(textToEnter);
            return true;
        }
        catch (Exception e) 
        {
            return false;
        }
    }

    public WebDriver getDriver()
    {
        return driver;
    }

    public void pause(int millis)
    {
        try {
            Thread.sleep(millis);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String takeScreenshot(boolean status)
    {
        screenShotCounter++;
        StringBuilder imagePathBuilder = new StringBuilder();
        StringBuilder relativePathBuilder = new StringBuilder();
        try 
        {
            imagePathBuilder.append(getReportDirectory());
            relativePathBuilder.append("Screenshots\\");
            new File (imagePathBuilder.toString()+(relativePathBuilder).toString()).mkdirs();

            relativePathBuilder.append(screenShotCounter+"_");
            if (status)
            {
                relativePathBuilder.append("PASSED");
            }
            else{
                relativePathBuilder.append("FAILED");
            }
            relativePathBuilder.append(".png");

            File screenshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot,new File(imagePathBuilder.append(relativePathBuilder).toString()));

            return "./"+relativePathBuilder.toString();

        } 
        catch (Exception e) 
        {
            return null;
        }
    }
}
