package testing.actions;

import InspiredTesting.Reporting;
import core.BaseClass;
import testing.pageobjects.BitnamiObjects;

public class BitnamiActions extends BaseClass 
{
    public static String Search(String firstName, String passWord, String FirstTargetName, String FirstTargetLastName, String StreetAddress, String FAddressStreet,  String FAddressState, String FPostalCode, String FAddressCountry, String STargetName, String STargetLastName, String STargetStreetAddress, 
    String SAddressCity, String SAddressState, String SAddressCode, String SAddressCountry, String TTargetName, String TTargetLastName, String TTargetStreetAddress, String TAddressCity, 
    String TAddressState, String TAddressCode, String TAddressCountry) 
    {
        if (!SeleniumDriverInstance.navigate(BitnamiObjects.url()))
        {
            return Reporting.testFailed("Failed to navigate to" + BitnamiObjects.url());
        }

        if (!SeleniumDriverInstance.enterText(BitnamiObjects.Username(), firstName))
        {
            return Reporting.testFailed("Failed to enter "+firstName+ "to search bar");
        }

        if (!SeleniumDriverInstance.enterText(BitnamiObjects.Password(), passWord))
        {
            return Reporting.testFailed("Failed to enter "+passWord+ "to search bar");
        }

        Reporting.stepPassed("Search Term Entered");

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.LoginButton()))
        {
            return Reporting.testFailed("Failed to click Login button");
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.MarketingTab()))
        {
            return Reporting.testFailed("Failed to click the marketing tab");
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.MarketingTab()))
        {
            return Reporting.testFailed("Failed to click the marketing tab");
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.ClickTargets()))
        {
            return Reporting.testFailed("Failed to click targets");
        }
          
        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.CreateTarget()))
        {
            return Reporting.testFailed("Failed to create targets");
        }

        if (!SeleniumDriverInstance.enterText(BitnamiObjects.FirstName(), FirstTargetName))
        {
            return Reporting.testFailed("Failed to enter First target Name");
        }

        if (!SeleniumDriverInstance.enterText(BitnamiObjects.LastName(), FirstTargetLastName))
        {
            return Reporting.testFailed("Failed to enter First target lastName");
        }

        if (!SeleniumDriverInstance.enterText(BitnamiObjects.AddressStreet(), StreetAddress))
        {
            return Reporting.testFailed("Failed to enter Address Street");
        }

        if (!SeleniumDriverInstance.enterText(BitnamiObjects.AddressCity(), FAddressStreet))
        {
            return Reporting.testFailed("Failed to enter Address City");
        }

        if (!SeleniumDriverInstance.enterText(BitnamiObjects.AddressState(), FAddressState))
        {
            return Reporting.testFailed("Failed to enter Address State");
        }

        if (!SeleniumDriverInstance.enterText(BitnamiObjects.AddressPostalCode(), FPostalCode))
        {
            return Reporting.testFailed("Failed to enter Address Code");
        }

        if (!SeleniumDriverInstance.enterText(BitnamiObjects.AddressCountry(), FAddressCountry))
        {
            return Reporting.testFailed("Failed to enter Address Country");
        }
        
        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.SaveTargets()))
        {
            return Reporting.testFailed("Failed to click element");
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.CreateTarget()))
        {
            return Reporting.testFailed("Failed to create targets");
        }
        
        //Second Target
        if (!SeleniumDriverInstance.enterText(BitnamiObjects.FirstName(), STargetName))
        {
            return Reporting.testFailed("Failed to enter First target Name");
        }

        if (!SeleniumDriverInstance.enterText(BitnamiObjects.LastName(), STargetLastName))
        {
            return Reporting.testFailed("Failed to enter First target lastName");
        }

        if (!SeleniumDriverInstance.enterText(BitnamiObjects.AddressStreet(), STargetStreetAddress))
        {
            return Reporting.testFailed("Failed to enter Address Street");
        }

        if (!SeleniumDriverInstance.enterText(BitnamiObjects.AddressCity(), SAddressCity))
        {
            return Reporting.testFailed("Failed to enter Address City");
        }

        if (!SeleniumDriverInstance.enterText(BitnamiObjects.AddressState(), SAddressState))
        {
            return Reporting.testFailed("Failed to enter Address State");
        }

        if (!SeleniumDriverInstance.enterText(BitnamiObjects.AddressPostalCode(), SAddressCode))
        {
            return Reporting.testFailed("Failed to enter Address Code");
        }

        if (!SeleniumDriverInstance.enterText(BitnamiObjects.AddressCountry(), SAddressCountry))
        {
            return Reporting.testFailed("Failed to enter Address Country");
        }
        
        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.SaveTargets()))
        {
            return Reporting.testFailed("Failed to click element");
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.CreateTarget()))
        {
            return Reporting.testFailed("Failed to create targets");
        }

        //Third Target
         if (!SeleniumDriverInstance.enterText(BitnamiObjects.FirstName(), TTargetName))
        {
            return Reporting.testFailed("Failed to enter First target Name");
        }

        if (!SeleniumDriverInstance.enterText(BitnamiObjects.LastName(), TTargetLastName))
        {
            return Reporting.testFailed("Failed to enter First target lastName");
        }

        if (!SeleniumDriverInstance.enterText(BitnamiObjects.AddressStreet(), TTargetStreetAddress))
        {
            return Reporting.testFailed("Failed to enter Address Street");
        }

        if (!SeleniumDriverInstance.enterText(BitnamiObjects.AddressCity(), TAddressCity))
        {
            return Reporting.testFailed("Failed to enter Address City");
        }

        if (!SeleniumDriverInstance.enterText(BitnamiObjects.AddressState(), TAddressState))
        {
            return Reporting.testFailed("Failed to enter Address State");
        }

        if (!SeleniumDriverInstance.enterText(BitnamiObjects.AddressPostalCode(), TAddressCode))
        {
            return Reporting.testFailed("Failed to enter Address Code");
        }

        if (!SeleniumDriverInstance.enterText(BitnamiObjects.AddressCountry(), TAddressCountry))
        {
            return Reporting.testFailed("Failed to enter Address Country");
        }
        
        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.SaveTargets()))
        {
            return Reporting.testFailed("Failed to click element");
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.CreateTarget()))
        {
            return Reporting.testFailed("Failed to create targets");
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.CreateTargetList()))
        {
            return Reporting.testFailed("Failed to click the targetlist tab");
        }

        //Actions after Target creations
        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.MarketingTab()))
        {
            return Reporting.testFailed("Failed to click the marketing tab");
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.TargetListTab()))
        {
            return Reporting.testFailed("Failed to click the click target list tab");
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.CreateTargetList()))
        {
            return Reporting.testFailed("Failed to click the create target list tab");
        }

        if (!SeleniumDriverInstance.enterText(BitnamiObjects.TargetListName(), "Three targets"))
        {
            return Reporting.testFailed("Failed to enter target list name");
        }

        if (!SeleniumDriverInstance.enterText(BitnamiObjects.TargetListDescription(), "Target list for the 3 three targets"))
        {
            return Reporting.testFailed("Failed to enter target list description");
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.SaveTargetList()))
        {
            return Reporting.testFailed("Failed to save the target list");
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.DropSelect()))
        {
            return Reporting.testFailed("Failed to drop select menu");
        }

        // if (!SeleniumDriverInstance.clickElement(BitnamiObjects.SelectButton()))
        // {
        //     return Reporting.testFailed("Failed to click select button");
        // }

        if (!SeleniumDriverInstance.SwitchWin())
        {
            return Reporting.testFailed("Failed to switch to new window");
        }

        // if (!SeleniumDriverInstance.clickElement(BitnamiObjects.SelectAll()))
        // {
        //     return Reporting.testFailed("Failed to check select all checkbox");
        // }

        // if (!SeleniumDriverInstance.clickElement(BitnamiObjects.TickAllTargets()))
        // {
        //     return Reporting.testFailed("Failed to click tick all targets");
        // }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.MarketingTab()))
        {
            return Reporting.testFailed("Failed to click the marketing tab");
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.ClickTargets()))
        {
            return Reporting.testFailed("Failed to click targets");
        }
        // if (!BitnamiInstance.clickElement(BitnamiObjects.TickAllTargets()))
        // {
        //     return Reporting.testFailed("Failed to tick all targets");
        // }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.SelectAllTargets()))
        {
            return Reporting.testFailed("Failed to click all targets");
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.DeleteAllTargets()))
        {
            return Reporting.testFailed("Failed to click the delete button");
        }

        if (SeleniumDriverInstance.ClickPopup())
        {
            return Reporting.testFailed("Failed to click on the popup message");
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.MarketingTab()))
        {
            return Reporting.testFailed("Failed to click the marketing tab");
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.TargetListTab()))
        {
            return Reporting.testFailed("Failed to click the Targetlist tab");
        }
        
        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.SelectAllTargetLists()))
        {
            return Reporting.testFailed("Failed to click the select all targets button");
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.DeleteAllTargetList()))
        {
            return Reporting.testFailed("Failed to click the delete button");
        }

        if (SeleniumDriverInstance.ClickPopup())
        {
            return Reporting.testFailed("Failed to click on the popup message");
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.Logout()))
        {
            return Reporting.testFailed("Failed to click the logout button");
        }

        // if (!BitnamiInstance.ClickLogout())
        // {
        //     return Reporting.testFailed("Failed to click the logout button");
        // }

        return Reporting.finaliseTest();
    }

    public static String bitnami(String Username, String Password, String FirstName, String LastName, String AddressStreet, String AddressCity, String AddressState, String AddressPostalCode, String AddressCountry)
    {
        if (!SeleniumDriverInstance.navigate(BitnamiObjects.url()))
        {
            return Reporting.testFailed("Failed to navigate to" + BitnamiObjects.url());
        }

        if (!SeleniumDriverInstance.enterText(BitnamiObjects.Username(), Username))
        {
            return Reporting.testFailed("Failed to enter "+Username+ "to search bar");
        }
        
        if (!SeleniumDriverInstance.enterText(BitnamiObjects.Password(), Password))
        {
            return Reporting.testFailed("Failed to enter "+Password+ "to search bar");
        }

        Reporting.stepPassed("Search Term Entered");

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.LoginButton()))
        {
            return Reporting.testFailed("Failed to click Login button");
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.MarketingTab()))
        {
            return Reporting.testFailed("Failed to click the marketing tab");
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.MarketingTab()))
        {
            return Reporting.testFailed("Failed to click the marketing tab");
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.ClickTargets()))
        {
            return Reporting.testFailed("Failed to click targets");
        }
          
        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.CreateTarget()))
        {
            return Reporting.testFailed("Failed to create targets");
        }

        
        if (!SeleniumDriverInstance.enterText(BitnamiObjects.FirstName(), FirstName))
        {
            return Reporting.testFailed("Failed to enter First target Name");
        }

        if (!SeleniumDriverInstance.enterText(BitnamiObjects.LastName(), LastName))
        {
            return Reporting.testFailed("Failed to enter First target lastName");
        }

        if (!SeleniumDriverInstance.enterText(BitnamiObjects.AddressStreet(), AddressStreet))
        {
            return Reporting.testFailed("Failed to enter Address Street");
        }

        if (!SeleniumDriverInstance.enterText(BitnamiObjects.AddressCity(), AddressCity))
        {
            return Reporting.testFailed("Failed to enter Address City");
        }

        if (!SeleniumDriverInstance.enterText(BitnamiObjects.AddressState(), AddressState))
        {
            return Reporting.testFailed("Failed to enter Address State");
        }

        if (!SeleniumDriverInstance.enterText(BitnamiObjects.AddressPostalCode(), AddressPostalCode))
        {
            return Reporting.testFailed("Failed to enter Address Code");
        }

        if (!SeleniumDriverInstance.enterText(BitnamiObjects.AddressCountry(), AddressCountry))
        {
            return Reporting.testFailed("Failed to enter Address Country");
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.SaveTargets()))
        {
            return Reporting.testFailed("Failed to click element");
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.CreateTargetList()))
        {
            return Reporting.testFailed("Failed to click the targetlist tab");
        }

        //Actions after Target creations
        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.MarketingTab()))
        {
            return Reporting.testFailed("Failed to click the marketing tab");
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.TargetListTab()))
        {
            return Reporting.testFailed("Failed to click the click target list tab");
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.CreateTargetList()))
        {
            return Reporting.testFailed("Failed to click the create target list tab");
        }

        if (!SeleniumDriverInstance.enterText(BitnamiObjects.TargetListName(), "Three targets"))
        {
            return Reporting.testFailed("Failed to enter target list name");
        }

        if (!SeleniumDriverInstance.enterText(BitnamiObjects.TargetListDescription(), "Target list for the 3 three targets"))
        {
            return Reporting.testFailed("Failed to enter target list description");
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.SaveTargetList()))
        {
            return Reporting.testFailed("Failed to save the target list");
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.DropSelect()))
        {
            return Reporting.testFailed("Failed to drop select menu");
        }

        // if (!SeleniumDriverInstance.clickElement(BitnamiObjects.SelectButton()))
        // {
        //     return Reporting.testFailed("Failed to click select button");
        // }

        if (!SeleniumDriverInstance.SwitchWin())
        {
            return Reporting.testFailed("Failed to switch to new window");
        }

        // if (!SeleniumDriverInstance.clickElement(BitnamiObjects.SelectAll()))
        // {
        //     return Reporting.testFailed("Failed to check select all checkbox");
        // }

        // if (!SeleniumDriverInstance.clickElement(BitnamiObjects.TickAllTargets()))
        // {
        //     return Reporting.testFailed("Failed to click tick all targets");
        // }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.MarketingTab()))
        {
            return Reporting.testFailed("Failed to click the marketing tab");
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.ClickTargets()))
        {
            return Reporting.testFailed("Failed to click targets");
        }
        // if (!BitnamiInstance.clickElement(BitnamiObjects.TickAllTargets()))
        // {
        //     return Reporting.testFailed("Failed to tick all targets");
        // }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.SelectAllTargets()))
        {
            return Reporting.testFailed("Failed to click all targets");
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.DeleteAllTargets()))
        {
            return Reporting.testFailed("Failed to click the delete button");
        }

        if (SeleniumDriverInstance.ClickPopup())
        {
            return Reporting.testFailed("Failed to click on the popup message");
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.MarketingTab()))
        {
            return Reporting.testFailed("Failed to click the marketing tab");
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.TargetListTab()))
        {
            return Reporting.testFailed("Failed to click the Targetlist tab");
        }
        
        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.SelectAllTargetLists()))
        {
            return Reporting.testFailed("Failed to click the select all targets button");
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.DeleteAllTargetList()))
        {
            return Reporting.testFailed("Failed to click the delete button");
        }

        if (SeleniumDriverInstance.ClickPopup())
        {
            return Reporting.testFailed("Failed to click on the popup message");
        }

        if (!SeleniumDriverInstance.clickElement(BitnamiObjects.Logout()))
        {
            return Reporting.testFailed("Failed to click the logout button");
        }

        return Reporting.finaliseTest();
    }
}