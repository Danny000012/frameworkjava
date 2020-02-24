package testing.actions;

import InspiredTesting.Reporting;
import core.BaseClass;
import testing.pageobjects.EribankObjects;

public class EribankLoginActions extends BaseClass{
    public static String Login(String Username, String Password, String Phone, String Name, String Amount, String Country)
    {
        // if (!AppiumDriverInstance.clickElement(EribankObjects.EriMsgBox()))
        // {
        //     return Reporting.testFailed("Failed to click OK on the message box");
        // }

        if (!AppiumDriverInstance.enterText(EribankObjects.Username(),Username))
        {
            return Reporting.testFailed("Failed to enter username");
        }

        if (!AppiumDriverInstance.enterText(EribankObjects.Password(), Password))
        {
            return Reporting.testFailed("Failed to enter password");
        }

        if (!AppiumDriverInstance.clickElement(EribankObjects.Login()))
        {
            return Reporting.testFailed(("Failed to click login"));
        }

        if (!AppiumDriverInstance.clickElement(EribankObjects.MakePaymentBtn()))
        {
            return Reporting.testFailed("Failed to click the make payment button");
        }

        if (!AppiumDriverInstance.enterText(EribankObjects.Phone(), Phone))
        {
            return Reporting.testFailed("Failed to enter phone numbers");
        }

        if (!AppiumDriverInstance.enterText(EribankObjects.Name(), Name))
        {
            return Reporting.testFailed("Failed to enter the Name");
        }

        if (!AppiumDriverInstance.enterText(EribankObjects.Amount(), Amount))
        {
            return Reporting.testFailed("Failed to enter the Amount");
        }

        if (!AppiumDriverInstance.enterText(EribankObjects.Country(), Country))
        {
            return Reporting.testFailed("Failed to enter the Country");
        }

        if (!AppiumDriverInstance.clickElement(EribankObjects.SendPayment()))
        {
            return Reporting.testFailed("Failed to send the payment");
        }

        if (!AppiumDriverInstance.clickElement(EribankObjects.EribankMsgYes()))
        {
            return Reporting.testFailed("Failed to click the yes option");
        }

        if (!AppiumDriverInstance.clickElement(EribankObjects.LogoutBtn()))
        {
            return Reporting.testFailed("Failed to click the logout button");
        }
        return Reporting.finaliseTest();
    }

    public static String BoundaryValueAnalysis(String Username, String Password, String Phone, String Name, String Amount, String Country)
    {
        // if (!AppiumDriverInstance.clickElement(EribankObjects.EriMsgBox()))
        // {
        //     return Reporting.testFailed("Failed to click OK on the message box");
        // }

        if (!AppiumDriverInstance.enterText(EribankObjects.Username(),Username))
        {
            return Reporting.testFailed("Failed to enter username");
        }

        if (!AppiumDriverInstance.enterText(EribankObjects.Password(), Password))
        {
            return Reporting.testFailed("Failed to enter password");
        }

        if (!AppiumDriverInstance.clickElement(EribankObjects.Login()))
        {
            return Reporting.testFailed(("Failed to click login"));
        }

        if (!AppiumDriverInstance.clickElement(EribankObjects.MakePaymentBtn()))
        {
            return Reporting.testFailed("Failed to click the make payment button");
        }

        if (!AppiumDriverInstance.enterText(EribankObjects.Phone(), Phone))
        {
            return Reporting.testFailed("Failed to enter phone numbers");
        }

        if (!AppiumDriverInstance.enterText(EribankObjects.Name(), Name))
        {
            return Reporting.testFailed("Failed to enter the Name");
        }

        if (!AppiumDriverInstance.enterText(EribankObjects.Amount(), Amount))
        {
            return Reporting.testFailed("Failed to enter the Amount");
        }

        if (!AppiumDriverInstance.enterText(EribankObjects.Country(), Country))
        {
            return Reporting.testFailed("Failed to enter the Country");
        }

        if (!AppiumDriverInstance.clickElement(EribankObjects.SendPayment()))
        {
            return Reporting.testFailed("Failed to send the payment");
        }

        if (!AppiumDriverInstance.clickElement(EribankObjects.EribankMsgYes()))
        {
            return Reporting.testFailed("Failed to click the yes option");
        }

        if (!AppiumDriverInstance.clickElement(EribankObjects.LogoutBtn()))
        {
            return Reporting.testFailed("Failed to click the logout button");
        }

        return Reporting.finaliseTest();
    }

    public static String EquivalencePartitioning(String Username, String Password, String Phone, String Name, String Amount, String Country)
    {
        // if (!AppiumDriverInstance.clickElement(EribankObjects.EriMsgBox()))
        // {
        //     return Reporting.testFailed("Failed to click OK on the message box");
        // }

        if (!AppiumDriverInstance.enterText(EribankObjects.Username(),Username))
        {
            return Reporting.testFailed("Failed to enter username");
        }

        if (!AppiumDriverInstance.enterText(EribankObjects.Password(), Password))
        {
            return Reporting.testFailed("Failed to enter password");
        }

        if (!AppiumDriverInstance.clickElement(EribankObjects.Login()))
        {
            return Reporting.testFailed(("Failed to click login"));
        }

        if (!AppiumDriverInstance.clickElement(EribankObjects.MakePaymentBtn()))
        {
            return Reporting.testFailed("Failed to click the make payment button");
        }

        if (!AppiumDriverInstance.enterText(EribankObjects.Phone(), Phone))
        {
            return Reporting.testFailed("Failed to enter phone numbers");
        }

        if (!AppiumDriverInstance.enterText(EribankObjects.Name(), Name))
        {
            return Reporting.testFailed("Failed to enter the Name");
        }

        if (!AppiumDriverInstance.enterText(EribankObjects.Amount(), Amount))
        {
            return Reporting.testFailed("Failed to enter the Amount");
        }

        if (!AppiumDriverInstance.enterText(EribankObjects.Country(), Country))
        {
            return Reporting.testFailed("Failed to enter the Country");
        }

        if (!AppiumDriverInstance.clickElement(EribankObjects.SendPayment()))
        {
            return Reporting.testFailed("Failed to send the payment");
        }

        if (!AppiumDriverInstance.clickElement(EribankObjects.EribankMsgYes()))
        {
            return Reporting.testFailed("Failed to click the yes option");
        }

        if (!AppiumDriverInstance.clickElement(EribankObjects.LogoutBtn()))
        {
            return Reporting.testFailed("Failed to click the logout button");
        }
        
        return Reporting.finaliseTest();
    }

    public static String LoginValidations(String username, String password)
    {
        // if (!AppiumDriverInstance.clickElement(EribankObjects.EriMsgBox()))
        // {
        //     return Reporting.testFailed("Failed to click OK on the message box");
        // }

        if (!AppiumDriverInstance.enterText(EribankObjects.username("company"), username))
        {
            return Reporting.testFailed("Failed to validate the username");
        }

        if (!AppiumDriverInstance.enterText(EribankObjects.password("company"), password))
        {
            return Reporting.testFailed("Failed to validate the password");
        }

        return Reporting.finaliseTest();
    }
}