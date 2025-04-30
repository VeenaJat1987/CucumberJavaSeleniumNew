package utilities;

import BaseClass.BaseClass;

import java.io.IOException;

public class ExcelDataProvider extends BaseClass {

    public Object[][] getTestData(String sheetname) throws IOException {
        ExcelIO excelio = new ExcelIO(sheetname);

        int rowCount = excelio.getRowCount();
        int columnCount = excelio.getColumnCount();
        System.out.println("row count" + rowCount);
        System.out.println("column count" + columnCount);

        Object data[][] = new Object[rowCount-1][columnCount];

        for(int i=1;i<rowCount;i++){
            for(int j=0;j<=columnCount;j++){
                 String celldata = excelio.getCellDataString(i, j);
                 System.out.println(celldata);
                data[i-1][j] = celldata;
            }
        }
    return data;
    }
}
