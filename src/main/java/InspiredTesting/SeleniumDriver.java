package InspiredTesting;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import core.BaseClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import testing.pageobjects.BitnamiObjects;

public class SeleniumDriver extends BaseClass
{
    private WebDriver driver;
    public enum BrowserType{CHROME, IE, FIREFOX, EDGE}
    private BrowserType currentBrowser;
    private static int screenShotCounter = 0;


    public SeleniumDriver(BrowserType browser)
    {
        this.currentBrowser = browser;
        LaunchDriver();
    }

   public boolean SwitchWin()
    {
        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();

        // Perform the click operation that opens new window
        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.SelectButton()))
        {
            return true;
        }

        // Switch to new window opened
        for(String winHandles : driver.getWindowHandles()){
            driver.switchTo().window(winHandles);
        }

        // Perform the actions on new window
        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.SelectAll()))
        {
            return true;
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.TickAllTargets()))
        {
            return true;
        }

        // Close the new window, if that window no more required
        // driver.close();

        // Switch back to original browser (first window)
        driver.switchTo().window(winHandleBefore);

        return true;
        // Continue with original browser (first window)
   }

   public boolean ClickPopup()
   {
        try
        {
            driver.switchTo().alert().accept();
        }
        catch(Throwable e)
        {
            System.err.println("Error came while waiting for the alert popup. "+e.getMessage());
        }

        return false;
   }


    public boolean LaunchDriver()
    {
        switch(this.currentBrowser)
        {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                this.driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().arch32().setup();
                this.driver = new FirefoxDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().arch32().setup();
                this.driver = new EdgeDriver();
                break;
            case IE:
                WebDriverManager.iedriver().arch32().setup();
                InternetExplorerOptions opts = new InternetExplorerOptions();
                opts.introduceFlakinessByIgnoringSecurityDomains();
                opts.ignoreZoomSettings();
                this.driver = new InternetExplorerDriver(opts);
                break;
            default:
                break;
        }

        this.driver.manage().window().maximize();

        return true;
    }

   
    public boolean shutDownDriver()
    {
        try
        {
            this.driver.close();
            this.driver.quit();
            return true;
        }
        catch (Exception e)
        {
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

    public boolean navigate(String url)
    {
        try
        {
           this.driver.navigate().to(url);

           return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public String getTextFromElement(By selector)
    {
        try
        {
            waitForElement(selector);
            WebDriverWait wait = new WebDriverWait(this.driver, 1);
            wait.until(ExpectedConditions.elementToBeClickable(selector));
            WebElement element = this.driver.findElement(selector);
            return element.getText();

        }
        catch (Exception e)
        {
            return "";
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

    public boolean waitForElement(By selector)
    {
        boolean found = false;
        int counter = 0; 
        try
        {
            while (!found && counter < 30)
            {
                try 
                {
                    WebDriverWait wait = new WebDriverWait(this.driver, 1);
                    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(selector));
                    found = true;

                } catch (Exception e) {
                    
                    counter ++;
                    pause(10000);
                }
            }
            return found;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public void pause(int millis)
    {
        try {
            Thread.sleep(millis);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebDriver getDriver()
    {
        return driver;
    }

    public BrowserType getCurrentBrowser()
    {
        return currentBrowser;
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