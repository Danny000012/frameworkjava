package testing.actions;

import InspiredTesting.Reporting;
import core.BaseClass;
import testing.pageobjects.googlePageObjects;


public class googleHomeActions extends BaseClass{

    public static String Search(final String searchTerm)
    {
        if (!SeleniumDriverInstance.navigate(googlePageObjects.url()))
        {
            return Reporting.testFailed("Failed to navigate to" + googlePageObjects.url());
        }

        if (!SeleniumDriverInstance.enterText(googlePageObjects.searchBar(), searchTerm))
        {
            return Reporting.testFailed("Failed to enter "+searchTerm+ "to search bar");
        }

        Reporting.stepPassed("Search Term Entered");

        if (!SeleniumDriverInstance.clickElement(googlePageObjects.searchButton()))
        {
            return Reporting.testFailed("Failed to click search button");
        }

        if (SeleniumDriverInstance.validateElementText(googlePageObjects.validateSearch(searchTerm), searchTerm))
        {
            return Reporting.testFailed("Failed to validate search term");
        }

        return Reporting.finaliseTest();
    }
}


