package InspiredTesting;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.remote.DesiredCapabilities;
import InspiredTesting.AppiumDriver;
import core.BaseClass;
import entities.DataRow;
import testing.actions.EribankLoginActions;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class appium extends BaseClass {

    @BeforeAll
    public static void init() {
        DesiredCapabilities caps = AppiumDriver.setRunCapabilities("emulator-5554", "8", "Android",
                "com.experitest.ExperiBank", ".LoginActivity",
                "C:\\Users\\dseabela\\Desktop\\Pow\\TestFramework\\EriBank.apk");
        AppiumDriverInstance = new AppiumDriver(caps);
    }

    @BeforeEach
    public void reportInit(TestInfo TestInfo) {
        TestName = TestInfo.getDisplayName();
        Reporting.createTest();
    }

    @AfterAll
    public static void cleanUp() {
        SeleniumDriverInstance.shutDownDriver();
    }

    // @Test
    // public void startUpTest() {
    //     String result = EribankLoginActions.Login("company", "company");
    //     assertTrue(result == null, result);
    // }

    @TestFactory
    Collection<DynamicTest> EriBankAppValidEP()
    {
        List<DynamicTest> tests = new ArrayList<>();
        
        String datapath = System.getProperty("user.dir")+"\\data\\dataset2.xlsx";
        List<DataRow> data = ExcelReader.GetDataSet(datapath, "Names");

        for(DataRow row : data)
        {
           String name = row.getColumnValue("Username");
           tests.add(DynamicTest.dynamicTest(name + " Test", ()-> startUpTest(row.getColumnValue("Username"),
           row.getColumnValue("Password"),
           row.getColumnValue("Phone"),
           row.getColumnValue("Name"),
           row.getColumnValue("Amount"),
           row.getColumnValue("Country"))));
        }

        return tests;
    }

    public void startUpTest(String Username, String Password, String Phone, String Name, String Amount, String Country) 
    {
        String result = EribankLoginActions.Login(Username, Password, Phone, Name, Amount, Country);
        assertTrue(result == null, result);
    }

    //Testing for Boundary Value Analys.
    @TestFactory
    Collection<DynamicTest> EriBankAppInvalidBVA()
    {
        List<DynamicTest> tests = new ArrayList<>();
        
        String datapath = System.getProperty("user.dir")+"\\data\\bva_data.xlsx";
        List<DataRow> data = ExcelReader.GetDataSet(datapath, "Names");

        for(DataRow row : data)
        {
           String name = row.getColumnValue("Username");
           tests.add(DynamicTest.dynamicTest(name + " Test", ()-> BoundaryValueAnalysis(row.getColumnValue("Username"),
           row.getColumnValue("Password"),
           row.getColumnValue("Phone"),
           row.getColumnValue("Name"),
           row.getColumnValue("Amount"),
           row.getColumnValue("Country"))));
        }

        return tests;
    }

    public void BoundaryValueAnalysis(String Username, String Password, String Phone, String Name, String Amount, String Country) 
    {
        String result = EribankLoginActions.BoundaryValueAnalysis(Username, Password, Phone, Name, Amount, Country);
        assertTrue(result == null, result);
    }


    //Testing for equivalence partitioning.
    @TestFactory
    Collection<DynamicTest> EriBankAppInvalidEP()
    {
        List<DynamicTest> tests = new ArrayList<>();
        
        String datapath = System.getProperty("user.dir")+"\\data\\eq_data.xlsx";
        List<DataRow> data = ExcelReader.GetDataSet(datapath, "Names");

        for(DataRow row : data)
        {
           String name = row.getColumnValue("Username");
           tests.add(DynamicTest.dynamicTest(name + " Test", ()-> EquivalencePartitioning(row.getColumnValue("Username"),
           row.getColumnValue("Password"),
           row.getColumnValue("Phone"),
           row.getColumnValue("Name"),
           row.getColumnValue("Amount"),
           row.getColumnValue("Country"))));
        }

        return tests;
    }

    public void EquivalencePartitioning(String Username, String Password, String Phone, String Name, String Amount, String Country) 
    {
        String result = EribankLoginActions.EquivalencePartitioning(Username, Password, Phone, Name, Amount, Country);
        assertTrue(result == null, result);
    }

    @TestFactory
    Collection<DynamicTest> CredentialsValidations()
    {
        List<DynamicTest> tests = new ArrayList<>();
        String datapath = System.getProperty("user.dir")+"\\data\\eribankcredentials.xlsx";

        List<DataRow> data = ExcelReader.GetDataSet(datapath, "Names");

        for(DataRow row : data)
        {
           String name = row.getColumnValue("Username");
           tests.add(DynamicTest.dynamicTest(name + " Test", ()-> Credentials(row.getColumnValue("Username"),
           row.getColumnValue("Password"))));
        }
        return tests;
    }

    public void Credentials(String username, String password)
    {
        String result =  EribankLoginActions.LoginValidations(username, password);
        assertTrue(result == null, result);
    }

}
