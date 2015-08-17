package in.somecompany.evaluation.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataList {

	private DataList()
	{
		
	}
	
	private static HashMap<String, String> dataMap;
	
	private static void load()
	{

		List studentList = new ArrayList();
		
		String FILE_PATH = "C:/Users/g656736/Desktop/Workspaces/Training/Mukundh/Sample/Resources/Input.xlsx"; 
		
		        FileInputStream fis = null;
		        
		        String tempKey = "";
		        
		        String tempValue = "";
		        
		        int cellCount = 0;
		
		        try {
		
		            fis = new FileInputStream(FILE_PATH);
		
		 
		
		            // Using XSSF for xlsx format, for xls use HSSF
		
		            Workbook workbook = new XSSFWorkbook(fis);
		
		 
		
		            int numberOfSheets = workbook.getNumberOfSheets();
		
		 
		
		            //looping over each workbook sheet
		
		            for (int i = 0; i < numberOfSheets; i++) {
		
		                Sheet sheet = workbook.getSheetAt(i);
		
		                Iterator rowIterator = sheet.iterator();
		
		 
		
		                //iterating over each row
		
		                while (rowIterator.hasNext()) {
		
		 
		
		                    
		
		                    Row row = (Row)rowIterator.next();
		
		                    Iterator cellIterator = row.cellIterator();
		
		 
		
		                    //Iterating over each cell (column wise)  in a particular row.
		
		                    while (cellIterator.hasNext()) {
		
		
		
		                        Cell cell = (Cell)cellIterator.next();
		
		                        //The Cell Containing String will is name.
		
		                        if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
		                    		
		                        	if(cellCount ==0)
		                        		tempKey = new Integer(new Double(cell.getNumericCellValue()).intValue()).toString();
		                        	else
		                        		tempValue = cell.getStringCellValue();
		                            cellCount++;
		
		 
		
		                            
		
		                        } 
		                        else if (Cell.CELL_TYPE_STRING == cell.getCellType()) {
		
		                        	if(cellCount ==0)
		                        		tempKey = cell.getStringCellValue();
		                        	else
		                        		tempValue = cell.getStringCellValue();
		                            cellCount++;
		
		 
		
		                            //The Cell Containing numeric value will contain marks
		
		                        } 
		
		                        }
		                    
		                    cellCount = 0;
		                    
		                    dataMap.put(tempKey, tempValue);
		
		                    }
		
		                    //end iterating a row, add all the elements of a row in list
		
		                    
		
		                }
		
		            
		
		 
		
		            fis.close();
		
		 
		
		        } catch (FileNotFoundException e) {
		
		            e.printStackTrace();
		
		        } catch (IOException e) {
		
		            e.printStackTrace();
		
		        }
		
		     
	
	}
	
	public static String getData(String key)
	{
		if(dataMap == null)
		{
			dataMap = new HashMap<String, String>();
			load();
		}
		
		return dataMap.get(key);
	}
	
	/*public static void main(String[] args)
	{
		System.out.println(DataList.getData("1"));
	}*/
}
