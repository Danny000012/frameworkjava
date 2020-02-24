package InspiredTesting;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entities.DataColumn;
import entities.DataRow;




public class ExcelReader
{
    public static XSSFWorkbook getWorkBook(String filepath)
    {
        try 
        {
            FileInputStream excelFile = new FileInputStream(new File(filepath));
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);

            return workbook;
        }
        catch (Exception e) 
        {
            return null;
        }
    }

    public static XSSFSheet getWorkSheet(XSSFWorkbook workbook, String sheetName)
    {
        try 
        {
            XSSFSheet sheet = workbook.getSheet(sheetName);

            return sheet;
        } 
        catch (Exception e) 
        {
            return null;
        }
    }

    public static XSSFSheet getWorkSheet(String filepath, String sheetName)
    {
        try 
        {
            XSSFWorkbook workbook = getWorkBook(filepath);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            return sheet;
        } 
        catch (Exception e) 
        {
            return null;
        }
    }

    public static List<DataRow> GetDataSet(String filepath, String sheetName)
    {
        try 
        {
            XSSFSheet sheet = getWorkSheet(filepath, sheetName);
            List<DataRow> DataRows = new ArrayList<>();

            //Get Headers
            Row headerRow = sheet.getRow(0);
            List<String> headers = new ArrayList<>();
            for (int i = 0; i < headerRow.getLastCellNum(); i ++)
            {
                Cell cell = headerRow.getCell(i);
                headers.add(cell.getStringCellValue());
            }

            //Get Rows
            for (Row row: sheet)
            {
                if (row.getRowNum() > 0 && !row.getCell(0).equals(""))
                {
                    DataRow curRow = new DataRow();
                    for (int j = 0; j < row.getLastCellNum(); j++)
                    {
                        Cell cell = row.getCell(j);
                        DataColumn curColumn = new DataColumn(headers.get(j), cell.getStringCellValue());
                        curRow.DataColumns.add(curColumn);
                    }
                    DataRows.add(curRow);
                }
                
            }
            return DataRows;
        } 
        catch (Exception e) 
        {
            return null;
        }
    }
}

