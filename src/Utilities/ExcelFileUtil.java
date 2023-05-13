package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelFileUtil {
XSSFWorkbook wb;
public   ExcelFileUtil(String excelpath) throws Throwable {
FileInputStream fi = new FileInputStream(excelpath);
wb = new XSSFWorkbook(fi);	
}
public int rowcount(String sheetName) {
	return wb.getSheet(sheetName).getLastRowNum();
	
}
public int cellcount(String sheetName) {
	
	return wb.getSheet(sheetName).getRow(0).getLastCellNum();	
}
public String getCellData(String sheetName, int row, int column) { 
	String data = "";
if (wb.getSheet(sheetName).getRow(row).getCell(column).getCellType()==Cell.CELL_TYPE_NUMERIC) 
{
int  celldata = (int)wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
      data = String.valueOf(celldata);
}
else {
	

	data =wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
}

	return data	;
}


public void setCellData(String sheetName, int row, int column, String status, String writeexcel) {
	
	XSSFSheet ws = wb.getSheet(sheetName);
	XSSFRow r = ws.getRow(row);
	XSSFCell c = r.createCell(column);
	c.setCellValue(status);

if (status.equalignorecase("pass")) {
	
XSSFCellStyle style =wb.createCellStyle();
XSSFFont font =wb.createFont();
font.setColor(IndexedColors.BRIGHT_GREEN.getIndex());
font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
style.setFont(font);
ws.getRow(row).getCell(column).setCellStyle(style);
}
else if (status.equalignorecase("fail")){
	XSSFCellStyle style =wb.createCellStyle();
	XSSFFont font =wb.createFont();
	font.setColor(IndexedColors.BLUE.getIndex());
	font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
	style.setFont(font);
	ws.getRow(row).getCell(column).setCellStyle(style);

}
else if (status.equalignorecase("Blocked")) {
	XSSFCellStyle style =wb.createCellStyle();
	XSSFFont font =wb.createFont();
	font.setColor(IndexedColors.RED.getIndex());
	font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
	style.setFont(font);
	ws.getRow(row).getCell(column).setCellStyle(style);

}


FileOutputStream fo = new FileOutputStream(writeexcel);
wb.write(fo);

}

