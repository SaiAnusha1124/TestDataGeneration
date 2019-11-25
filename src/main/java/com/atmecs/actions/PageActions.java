package com.atmecs.actions;

import com.atmecs.constants.ConstantsFilePaths;
import com.atmecs.dataproviders.ReadExcelFile;

public class PageActions {
	ReadExcelFile reader = getsheet(ConstantsFilePaths.TESTDATA_FILE1);

	public ReadExcelFile getsheet(String sheetname) {
		ReadExcelFile read = new ReadExcelFile();
		try {
			read.setPath(sheetname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return read;
	}

	public String getdata_fromExcel(String string, String columnname, String string2) {

		String datavalue = reader.getCellDataByColumnName(string, columnname, string2);
		return datavalue;
	}
}
