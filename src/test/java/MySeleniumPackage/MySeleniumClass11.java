package MySeleniumPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MySeleniumClass11 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\sabya\\Documents\\MyExcel_Selenium.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet("Sheet1");
		for (int r=0; r<=sheet.getLastRowNum(); r++) {
			XSSFRow row=sheet.getRow(r);
			if (row==null) continue;
			for (int c=0; c<=sheet.getRow(r).getLastCellNum(); c++) {
				XSSFCell cell=row.getCell(c);
				if (cell==null) continue;
				System.out.print(cell.toString()+" ");
			}
			System.out.println();
		}
		wb.close();
		fis.close();
	}

}
