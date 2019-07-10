package TestData;



import java.util.ArrayList;

import ExcelSheet.ExcelReadWrite;


@SuppressWarnings("unused")
public class TestData extends ExcelReadWrite {

	
	public TestData(){
		try {
			ExcelReadWrite.ExcelRead();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Define object so that Excel file runs before we figure out what test cases need to be run
	static ExcelReadWrite objExcelReadWrite = new ExcelReadWrite();
	
	
	//**************Gather Test Data for Test Cases. Save and Return an Array*************************
	
	public static String[] TestCase1() throws Exception{
		
		return new String[]{objExcelReadWrite.SubMod1getCellValue(1, 3), objExcelReadWrite.SubMod1getCellValue(1, 4)};
	}
	
	  
	public static String[] TestCase2() throws Exception{
		
		return new String[]{objExcelReadWrite.SubMod1getCellValue(3, 3), objExcelReadWrite.SubMod1getCellValue(3, 4), objExcelReadWrite.SubMod1getCellValue(3, 5), objExcelReadWrite.SubMod1getCellValue(3, 6),objExcelReadWrite.SubMod1getCellValue(3, 7), objExcelReadWrite.SubMod1getCellValue(3, 8), objExcelReadWrite.SubMod1getCellValue(3, 9),objExcelReadWrite.SubMod1getCellValue(3, 10),objExcelReadWrite.SubMod1getCellValue(3, 11)};
	}
	
	
	public static String[] TestCase3() throws Exception{
		
		return new String[]{objExcelReadWrite.SubMod1getCellValue(5, 3), objExcelReadWrite.SubMod1getCellValue(5, 4), objExcelReadWrite.SubMod1getCellValue(5, 5), objExcelReadWrite.SubMod1getCellValue(5, 6),objExcelReadWrite.SubMod1getCellValue(5, 7), objExcelReadWrite.SubMod1getCellValue(5, 8)};
	}
	
/*	
	
	public static ArrayList<String> TestCase2() throws Exception{
		
		ArrayList<String> TC2Data = new ArrayList<String>();
		String [] Data = {objExcelReadWrite.SubMod1getCellValue(3, 3), objExcelReadWrite.SubMod1getCellValue(3, 4), objExcelReadWrite.SubMod1getCellValue(3, 5), objExcelReadWrite.SubMod1getCellValue(3, 6),objExcelReadWrite.SubMod1getCellValue(3, 7), objExcelReadWrite.SubMod1getCellValue(3, 8), objExcelReadWrite.SubMod1getCellValue(3, 9),objExcelReadWrite.SubMod1getCellValue(3, 10),objExcelReadWrite.SubMod1getCellValue(3, 11)};
		
		for (int i=0;i<Data.length;i++) {
			TC2Data.add(Data[i]);
	       }
		
		return TC2Data;

	}
	
	/*
	
	
	public static ArrayList<String> TestCase3() throws Exception{
		
		ArrayList<String> TC3Data = new ArrayList<String>();
		String [] Data = {objExcelReadWrite.SubMod1getCellValue(5, 3), objExcelReadWrite.SubMod1getCellValue(5, 4), objExcelReadWrite.SubMod1getCellValue(5, 5), objExcelReadWrite.SubMod1getCellValue(5, 6),objExcelReadWrite.SubMod1getCellValue(5, 7), objExcelReadWrite.SubMod1getCellValue(5, 8)};
		
		for (int i=0;i<Data.length;i++) {
			TC3Data.add(Data[i]);
	       }
		
		return TC3Data;

	}
    */
	
	
	

}
