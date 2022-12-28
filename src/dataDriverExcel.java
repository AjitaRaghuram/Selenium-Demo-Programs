import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriverExcel {

	public static void main(String[] args) throws IOException {
		ArrayList<String> cred=new ArrayList<String>();
		FileInputStream fs=new FileInputStream("/Users/ajitat/Desktop/DemoLogin.numbers");
		XSSFWorkbook xl=new XSSFWorkbook(fs);
		
		int sheets=xl.getNumberOfSheets(); //this will count the number of sheets in the workbook
		
			for (int i=0;i<sheets;i++) {
				
				if(xl.getSheetName(i).equalsIgnoreCase("LoginCredentials")) {
					XSSFSheet sheet=xl.getSheetAt(i); //Access to the sheet is achieved here
					Iterator<Row> rows=sheet.iterator(); //Then get access to all the rows
					Row firstRow=rows.next(); //Go to first row
					
					Iterator<Cell> cl=firstRow.cellIterator();
					int k=0;
					int column = 0;
						while(cl.hasNext()) {
							Cell value=cl.next();
							if(value.getStringCellValue().equalsIgnoreCase("TestCase")) {
								column=k;
							}
							k++;
						}
						while(rows.hasNext()) {
							Row rw=rows.next();
							if(rw.getCell(column).getStringCellValue().equalsIgnoreCase("Valid_Login")){
								Iterator<Cell> cv= rw.cellIterator();
								while(cv.hasNext()) {
								cred.add(cv.next().getStringCellValue());									
								}
							}
						}
						
						System.out.println(cred);
				}
				
			}
		
			xl.close();
			fs.close();
	}

}
