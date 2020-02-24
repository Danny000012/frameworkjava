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
import testing.actions.googleHomeActions;

public class Selenium extends BaseClass {

    @BeforeEach
    public void init(TestInfo name) {
        TestName = name.getDisplayName();
        Reporting.createTest();
        SeleniumDriverInstance = new SeleniumDriver(SeleniumDriver.BrowserType.CHROME);
    }

    @AfterEach
    public void cleanUp()
    {
        SeleniumDriverInstance.shutDownDriver();
    }

    @TestFactory
    Collection<DynamicTest> InspiredTesting()
    {
        List<DynamicTest> tests = new ArrayList<>();
        
        String datapath = System.getProperty("user.dir")+"\\data\\dataset1.xlsx";
        List<DataRow> data = ExcelReader.GetDataSet(datapath, "Names");

        for(DataRow row : data)
        {
           String name = row.getColumnValue("SearchTerm");
           tests.add(DynamicTest.dynamicTest(name + " Test", ()-> Test(row.getColumnValue("SearchTerm"))));
        }

        return tests;
    }

    // @Test
    // public void myTest()
    // {
    //     String result = googleHomeActions.Search("Inspired Testing");
    //     assertTrue(result == null, result);
    // }
    public void Test(String firstName)
    {
        String result = googleHomeActions.Search(firstName);
        assertTrue(result == null, result);
    }
    // public void Test()
    // {
    //     String dataPath = System.getProperty("user.dir")+"\\data\\dataset1.xlsx";
    //     List<DataRow> data = ExcelReader.GetDataSet(dataPath, "Names");
    // }

    // @Test
    // public void secondTest()
    // {
    //     String result = googleHomeActions.Search("Dvt");
    //     assertTrue(result == null, result);
    // }

}