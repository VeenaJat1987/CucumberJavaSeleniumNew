package utilities;

import BaseClass.BaseClass;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelIO extends BaseClass {

    XSSFWorkbook workbook;
    XSSFSheet sheet;

    public ExcelIO(String sheetName) throws IOException {
        workbook = new XSSFWorkbook(excelpath2);
        sheet = workbook.getSheet(sheetName);
     }

    public int getRowCount(){
        int rowCount = sheet.getPhysicalNumberOfRows();
        return rowCount;
    }

    public int getColumnCount(){
        int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
        return columnCount;
    }

    public String getCellDataString(int rowNum, int columnNum){
    String cellData = sheet.getRow(rowNum).getCell(columnNum).getStringCellValue();
    return cellData;
    }





}
