package InspiredTesting;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.TestInfo;
import core.BaseClass;
import entities.DataRow;
import testing.actions.BitnamiActions;


public class BitnamiTest extends BaseClass
{
    @BeforeEach
    public void init(TestInfo name) {
        TestName = name.getDisplayName();
        Reporting.createTest();
    }

    @AfterEach
    public void cleanUp()
    {
        SeleniumDriverInstance.shutDownDriver();
    }

    @TestFactory
    Collection<DynamicTest> BitnamiChrome()
    {
        SeleniumDriverInstance = new SeleniumDriver(SeleniumDriver.BrowserType.CHROME);
        List<DynamicTest> tests = new ArrayList<>();
        
        String datapath = System.getProperty("user.dir")+"\\bitnamidata\\bitdata.xlsx";
        List<DataRow> data = ExcelReader.GetDataSet(datapath, "Names");

        for(DataRow row : data)
        {
           String name = row.getColumnValue("SearchTerm");
           tests.add(DynamicTest.dynamicTest(name + " Test", ()-> Test(row.getColumnValue("SearchTerm"), 
           row.getColumnValue("SearchTerm1"), 
           row.getColumnValue("FirstTargetName"), 
           row.getColumnValue("FirstTargetLastName"), 
           row.getColumnValue("FTargetStreetAddress"), 
           row.getColumnValue("FAddressStreet"),
           row.getColumnValue("FAddressState"), 
           row.getColumnValue("FPostalCode"),
           row.getColumnValue("FAddressCountry"), 
           row.getColumnValue("STargetName"), 
           row.getColumnValue("STargetLastName"),
           row.getColumnValue("STargetStreetAddress"),
           row.getColumnValue("SAddressCity"), 
           row.getColumnValue("SAddressState"), 
           row.getColumnValue("SAddressCode"), 
           row.getColumnValue("SAddressCountry"), 
           row.getColumnValue("TTargetName"),
           row.getColumnValue("TTargetLastName"), 
           row.getColumnValue("TTargetStreetAddress"), 
           row.getColumnValue("TAddressCity"), 
           row.getColumnValue("TAddressState"), 
           row.getColumnValue("TAddressCode"),
           row.getColumnValue("TAddressCountry"))));
        }

        return tests;
    }


    
    @TestFactory
    Collection<DynamicTest> BitnamiIE()
    {
        SeleniumDriverInstance = new SeleniumDriver(SeleniumDriver.BrowserType.IE);
        List<DynamicTest> tests = new ArrayList<>();
        
        String datapath = System.getProperty("user.dir")+"\\bitnamidata\\bitdata.xlsx";
        List<DataRow> data = ExcelReader.GetDataSet(datapath, "Names");

        for(DataRow row : data)
        {
           String name = row.getColumnValue("SearchTerm");
           tests.add(DynamicTest.dynamicTest(name + " Test", ()-> Test(row.getColumnValue("SearchTerm"), 
           row.getColumnValue("SearchTerm1"), 
           row.getColumnValue("FirstTargetName"), 
           row.getColumnValue("FirstTargetLastName"), 
           row.getColumnValue("FTargetStreetAddress"), 
           row.getColumnValue("FAddressStreet"),
           row.getColumnValue("FAddressState"), 
           row.getColumnValue("FPostalCode"),
           row.getColumnValue("FAddressCountry"), 
           row.getColumnValue("STargetName"), 
           row.getColumnValue("STargetLastName"),
           row.getColumnValue("STargetStreetAddress"),
           row.getColumnValue("SAddressCity"), 
           row.getColumnValue("SAddressState"), 
           row.getColumnValue("SAddressCode"), 
           row.getColumnValue("SAddressCountry"), 
           row.getColumnValue("TTargetName"),
           row.getColumnValue("TTargetLastName"), 
           row.getColumnValue("TTargetStreetAddress"), 
           row.getColumnValue("TAddressCity"), 
           row.getColumnValue("TAddressState"), 
           row.getColumnValue("TAddressCode"),
           row.getColumnValue("TAddressCountry"))));
        }

        return tests;
    }

    public void Test(String firstName, String passWord, 
    String FirstTargetName, String FirstTargetLastName, 
    String StreetAddress, String FAddressStreet, 
    String FAddressState, String FPostalCode, String FAddressCountry, 
    String STargetName, String STargetLastName, String STargetStreetAddress, 
    String SAddressCity, String SAddressState, String SAddressCode, String SAddressCountry,
    String TTargetName, String TTargetLastName, String TTargetStreetAddress, String TAddressCity, 
    String TAddressState, String TAddressCode, String TAddressCountry)
    {
        String result = BitnamiActions.Search(firstName, passWord, FirstTargetName, FirstTargetLastName, StreetAddress, FAddressStreet,  FAddressState, FPostalCode, FAddressCountry, STargetName, STargetLastName, STargetStreetAddress, SAddressCity, SAddressState, SAddressCode, SAddressCountry, TTargetName, TTargetLastName, TTargetStreetAddress, TAddressCity, TAddressState, TAddressCode, TAddressCountry);
        assertTrue(result == null, result);
    }


    
    @TestFactory
    Collection<DynamicTest> InspiredTestingTest()
    {
        
        SeleniumDriverInstance = new SeleniumDriver(SeleniumDriver.BrowserType.CHROME);
        List<DynamicTest> tests = new ArrayList<>();
        
        String datapath = System.getProperty("user.dir")+"\\data\\dataset_4.xlsx";
        List<DataRow> data = ExcelReader.GetDataSet(datapath, "Names");

        for(DataRow row : data)
        {
           String name = row.getColumnValue("Username");
           tests.add(DynamicTest.dynamicTest(name + " Test", ()-> Test_1(row.getColumnValue("Username"),
           row.getColumnValue("Password"),
           row.getColumnValue("FirstName"),
           row.getColumnValue("LastName"),
           row.getColumnValue("AddressStreet"),
           row.getColumnValue("AddressCity"),
           row.getColumnValue("AddressState"),
           row.getColumnValue("AddressPostalCode"),
           row.getColumnValue("AddressCountry"))));
        }

        return tests;
    }

    public void Test_1(String Username, String Password, String FirstName, String LastName, String AddressStreet, String AddressCity, String AddressState, String AddressPostalCode, String AddressCountry)
    {
        String result = BitnamiActions.bitnami(Username, Password, FirstName, LastName, AddressStreet, AddressCity, AddressState, AddressPostalCode, AddressCountry);
        assertTrue(result == null, result);
    }
}

