package entities;

import java.util.LinkedList;
import java.util.function.Predicate;

public class DataRow 
{
    public LinkedList<DataColumn> DataColumns;

    public DataRow() {DataColumns = new LinkedList<>();}


    public String getColumnValue(String columnHeader)
    {
        try
        {
            Predicate<DataColumn> predicate = c-> c.getKey().equals(columnHeader);
            DataColumn obj = DataColumns.stream().filter(predicate).findFirst().get();
            return obj.getValue();
        }
        catch (Exception e)
        {
            // err.PrintIn("[ERROR] could not find column - " + columnHeader + "- in the table row");
            return "";
        }
    }

    public DataColumn getColumn(String columnHeader)
    {
        try 
        {
            Predicate<DataColumn> predicate = c-> c.getKey().equals(columnHeader);
            DataColumn obj = DataColumns.stream().filter(predicate).findFirst().get();
            return obj;
        } 
        catch (Exception e) 
        {
            // err.PrintIn("[ERROR could not find column - " + columnHeader + " - in table row");
            return null;
        }
    }
}
