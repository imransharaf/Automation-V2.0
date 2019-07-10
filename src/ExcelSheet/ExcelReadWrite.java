package ExcelSheet;

	
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

		
	public class ExcelReadWrite {
	
		//Define all the variables for Excel Sheet
		public static int SheetNum, XRows, XCols, ModRows, ModCols, SubMod1Rows, SubMod1Cols,SubMod2Rows, SubMod2Cols,SubMod3Rows, SubMod3Cols,SubMod4Rows, SubMod4Cols, count;
		public static String value;
		public static String ModData[][],SubMod1Data[][],SubMod2Data[][],SubMod3Data[][],SubMod4Data[][] ;
		public static String xPath="C:/Users/Imran/Desktop/Automation/Framework/DataFile.xls";
		public static String xlPath_Res="C:/Users/Imran/Desktop/Automation/Framework/ResultFile.xls";
		
		
	
		//Create HSSFWoorkbook object
		static HSSFWorkbook myworkbook = new HSSFWorkbook();
		
		
//**************** Function to Read Excel Data Workbook and return Sheets************************************		
		
		public static HSSFSheet FileStream(int SheetNum) throws Exception{
			File myxl = new File(xPath);  
			FileInputStream myStream = new FileInputStream(myxl);  
			@SuppressWarnings("resource")
			HSSFWorkbook myworkbook = new HSSFWorkbook(myStream); 
			HSSFSheet mysheet = myworkbook.getSheetAt(SheetNum);
			return mysheet;
		}
		 		

		
		
//**************** Function to Read Data from Data sheet based on Module/Submodules********xlRead(SheetNum, Row, Cols, Data[][]);
		
		public static void ExcelRead() throws Exception {
			xlRead(0, ModRows, ModCols, ModData);
			xlRead(1, SubMod1Rows, SubMod1Cols, SubMod1Data);
			xlRead(2, SubMod2Rows, SubMod2Cols, SubMod2Data);
			xlRead(3, SubMod3Rows, SubMod3Cols, SubMod3Data);
			xlRead(4, SubMod4Rows, SubMod4Cols, SubMod4Data);
		  	
		}
		
		
//********************************** Excel Read  Function******************************************
	
		public static void xlRead(int SheetNum, int Rows, int Cols, String[][] Data) throws Exception{
		
			
			HSSFSheet mysheet = FileStream(SheetNum);
						
			Rows = mysheet.getLastRowNum()+1;
			
					
			Cols = mysheet.getRow(0).getLastCellNum();
			Data = new String[Rows][Cols+1];
			
			
			
			for (int i=0; i<Rows; i++){
				HSSFRow row =mysheet.getRow(i);
					for(int  j=0; j<Cols+1; j++) {
						
						//@SuppressWarnings("deprecation")
						HSSFCell cell = row.getCell(j);
						Data[i][j] = getCellValue(cell);
						//System.out.println(row.getLastCellNum());
						System.out.println("SheetNum: " +SheetNum +"\t");
						System.out.println("Row: " + i +"\t");
						System.out.println("Col: " + j +"\t" );
						System.out.println("Text: " + Data[i][j] +"\n" );
						
						
					}
							
				}
			
			
	
			
			
			
			
			/*
			 * 
			 * 
			 * String FilePath = "C:\\Users\\Imran\\Desktop\\Automation\\Framework\\DataFile.xls";
		FileInputStream fs = new FileInputStream(FilePath);
		Workbook wb = Workbook.getWorkbook(fs);
		
		
		String[][] Data;
		//Data = new String[100][100];

		// TO get the access to the sheet
		Sheet sh = wb.getSheet("SubModule1");

		// To get the number of rows present in sheet
		int totalNoOfRows = sh.getRows();

		// To get the number of columns present in sheet
		int totalNoOfCols = sh.getColumns();
		
		Data = new String[totalNoOfRows][totalNoOfCols];

		for (int row = 0; row < totalNoOfRows; row++) {

			for (int col = 0; col < totalNoOfCols; col++) {
				
				Data[row][col] = sh.getCell(col, row).getContents();
				//System.out.print(sh.getCell(col, row).getContents() + "\t");
				
				System.out.print(Data[row][col]);
			}
			System.out.println();
		}
	}
			 */
			
			
				if (SheetNum == 0){
					ModRows = Rows;
					ModCols = Cols; 
					ModData = Data;
				
				}
						
				else if (SheetNum == 1){
					SubMod1Rows = Rows;
					SubMod1Cols = Cols; 
					SubMod1Data = Data;
					
				}
				
				else if (SheetNum == 2){
					SubMod2Rows = Rows;
					SubMod2Cols = Cols; 
					SubMod2Data = Data;
				}
						
				else if (SheetNum == 3){
					SubMod3Rows = Rows;
					SubMod3Cols = Cols; 
					SubMod3Data = Data;
				}
					
				else if (SheetNum == 4){
					SubMod4Rows = Rows;
					SubMod4Cols = Cols; 
					SubMod4Data = Data;
				}
				
			}
		
	
//**********************This function will convert an object of type excel cell to a string value************************************
	
		private static String getCellValue(HSSFCell cell) {
			    String val = "";
			    if (cell == null)
			        return "";
			    
			    switch (cell.getCellType()) {
			    
			    case HSSFCell.CELL_TYPE_STRING:
			        return cell.getStringCellValue();
			    
			    case HSSFCell.CELL_TYPE_NUMERIC:
			        val = Double.toString(cell.getNumericCellValue());
			        double dphi = cell.getNumericCellValue();
			        	if ((dphi - (int) dphi) * 1000 == 0) {
			            val = (int) dphi + "";
			        	}
			        return val;
			    
			    case HSSFCell.CELL_TYPE_BOOLEAN:
			        return Boolean.toString(cell.getBooleanCellValue());
			    
			    case HSSFCell.CELL_TYPE_FORMULA:
			        return cell.getCellFormula();

			    }
			    return "";
			}
			
		
//*********************Function to extract the cell values for Module/SubModules***************************************
			
			public String ModulegetCellValue(int Row, int Col){
				 
				 String ColName = ModData[Row][Col];
				 return ColName;
			 }
			 
			 public String SubMod1getCellValue(int Row, int Col){
				 
				 String ColName = SubMod1Data[Row][Col];
				 return ColName;
			 }
			 
			 public String SubMod2getCellValue(int Row, int Col){
				 
				 String ColName = SubMod2Data[Row][Col];
				 return ColName;
			 }
			 
			 public String SubMod3getCellValue(int Row, int Col){
				 
				 String ColName = SubMod3Data[Row][Col];
				 return ColName;
			 }
			 
			 public String SubMod4getCellValue(int Row, int Col){
				 
				 String ColName = SubMod4Data[Row][Col];
				 return ColName;
			 }
	
/*			 
//*********************Getters / Setters***************************************			 
			 
			 public Array getData(Array SubModData[][], int Row, int Col){
				 
				 Array ColName = SubModData[Row][Col];
				 return ColName;
			 }
			 
*/			 
			
//******************Function to get the timestamp****************************************
					
				String Get_TimeStamp(){
				Timestamp currentTimestamp1 = new Timestamp(Calendar.getInstance().getTime().getTime());
			    DateFormat df1 = new SimpleDateFormat("dd-MM-YY hh:mm:ss");  
			    String T1 = df1.format(currentTimestamp1);
			    return  T1;
			}
		
			
				
//**********************************Excel Write  Function ***********xlwrite(SheetName, Result file Path, Data Cell Array, Number of Rows, Number of columns)
				
				public static void xlwrite(String SheetName, String xlpath_Res, String[][] xldata, int XlRows, int XlCols) throws Exception {
					File outFile = new File(xlPath_Res);
					HSSFSheet osheet = myworkbook.createSheet(SheetName);
					
					for (int myrow =0; myrow<XlRows; myrow++) {
							HSSFRow row =osheet.createRow(myrow);
							for (short mycol =0; mycol<XlCols; mycol++) {
								@SuppressWarnings("deprecation")
								HSSFCell cell = row.createCell(mycol);
								cell.setCellType(HSSFCell.CELL_TYPE_STRING);
								cell.setCellValue(xldata[myrow][mycol]);
								osheet.autoSizeColumn(mycol);
			
								FileOutputStream fOut = new FileOutputStream(outFile);
								myworkbook.write(fOut);
								
								HSSFCellStyle cellStyle = myworkbook.createCellStyle();
								cell.setCellStyle(cellStyle );
								cellStyle.setWrapText(true);
								
								fOut.flush();
								fOut.close();
								}
						 }
					}
				
				
//**************** Function to Write Data back to Data sheet using xlwrite***************************************	
				
				public static void ExcelWrite() throws Exception {
					
					xlwrite("Module", xlPath_Res, ModData, ModRows, ModCols);
					xlwrite("SubModule1", xlPath_Res, SubMod1Data, SubMod1Rows, SubMod1Cols);
					xlwrite("SubModule2", xlPath_Res, SubMod2Data, SubMod2Rows, SubMod2Cols);
					xlwrite("SubModule3", xlPath_Res, SubMod3Data, SubMod3Rows, SubMod3Cols);
					xlwrite("SubModule4", xlPath_Res, SubMod4Data, SubMod4Rows, SubMod4Cols);
						 	
				}
		
		}




