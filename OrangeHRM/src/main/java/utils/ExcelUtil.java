package utils;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    // Constructor
    public ExcelUtil(String filePath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
        fis.close();
    }

    // Get number of rows
    public int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    // Get number of columns
    public int getColumnCount() {
        return sheet.getRow(0).getPhysicalNumberOfCells();
    }

    // Get cell data
    public String getCellData(int row, int column) {
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(sheet.getRow(row).getCell(column));
    }

    // Get cell data using column name
    public String getCellData(int row, String columnName) {

        int column = getColumnIndex(columnName);

        return getCellData(row, column);
    }

    // Get column index using column name
    public int getColumnIndex(String columnName) {
        for (int i = 0; i < getColumnCount(); i++) {
            String header = getCellData(0, i);
            if (header.equalsIgnoreCase(columnName)) {
                return i;
            }
        }
        return -1;
    }

    // Close workbook
    public void closeWorkbook() throws IOException {
        workbook.close();
    }
}