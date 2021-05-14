package suite.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Excel Utilities for the automation suite
 * 
 * @author kuldeepl
 *
 */
public class ExcelUtil {

	private XSSFWorkbook workbook;
	private  XSSFSheet sheet;

	/**
	 * Input the excel path 
	 * 
	 * @param excelPath path of the excel file
	 */
	public XSSFWorkbook ExcelDataConfig(String excelPath) {
        try {
            File filePath = new File(excelPath);
            FileInputStream Inputfile = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(Inputfile);
            return workbook;
        }
        catch (Exception e) {
        	e.printStackTrace();
        }
        return workbook;
    }

	/**
	 * Get data from cell of given sheet, row and column Number
	 * 
	 * @param sheetNumber  Index of the worksheet
	 * @param rowNumber    Row Number of the given worksheet
	 * @param columnNumber Row Number of the given worksheet
	 * @return value present inside the excel cell of given sheet based on the given
	 *         row and column Number
	 */
	public Object getCellValue(int sheetNumber, int rowNumber, int columnNumber) {

		return workbook.getSheetAt(sheetNumber).getRow(rowNumber).getCell(columnNumber).getStringCellValue();
	}

	/**
	 * Get number of rows of the given worksheet
	 * 
	 * @param sheetIndex Index of the work sheet
	 * @return number of rows of the given sheet
	 */
	public int getRowCountFor(int sheetIndex) {

		return workbook.getSheetAt(sheetIndex).getLastRowNum() + 1;
	}
	
	
	
	/**
	 * get row count
	 * @return row count
	 */
	public  int getRowCount()
    {
        int rowCount = sheet.getPhysicalNumberOfRows();
        System.out.println("no. of rows: "+rowCount);
        return rowCount;
    }
    
	
	/**
	 * get column count
	 * 
	 * @return column count
	 */
    public  int getColCount()
    {
    	
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        System.out.println("no. of columns:" +colCount);
        return colCount;
    }

 /**
  * get cell count string
  * @param row Number
  * @param column Number
  * @return cell data
  */

    public  String  getCellCountString(int rowNum, int colNum)
    {
        String cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
        return cellData;
    }
	
	
	
	
	
	
	
	
}