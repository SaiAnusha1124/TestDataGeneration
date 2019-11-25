package com.atmecs.dataproviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {
	private Workbook workBook = null;
	private Sheet sheet = null;
	private Row row = null;
	private Cell cell = null;
	private String cellValue;
	public String path = null;
	private FileInputStream fileInputStream = null;
	private String fileExtensionName;

	public void setPath(String path) throws IOException {
		this.path = path;
		verifyExcelWorkBook(path);
	}

	private void verifyExcelWorkBook(String filePath) throws IOException {

		File file = new File(filePath);
		fileInputStream = new FileInputStream(file);
		fileExtensionName = FilenameUtils.getExtension(filePath);
		if (fileExtensionName.equals("xlsx")) {
			workBook = new XSSFWorkbook(fileInputStream);
		} else if (fileExtensionName.equals("xls")) {
			workBook = new HSSFWorkbook(fileInputStream);
		}
		fileInputStream.close();
	}

	public String getCellDataByColumnName(String string, String columnName, String string2) {
		int columnIndex = -1;
		try {
			int index = workBook.getSheetIndex(string);
			sheet = workBook.getSheetAt(index);
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(columnName.trim())) {
					columnIndex = i;
				}
			}
			if (columnIndex == -1) {
				return "Column doesn't exist with given name " + columnName;
			}
			String rowI = findRow(sheet, string2);
			int rowInd = Integer.parseInt(rowI);
			return verifyCellData(rowInd, columnIndex);
		} catch (Exception exception) {

			return "row " + string2 + " or column " + columnIndex + " does not exist  in xlsx";
		}
	}

	private String findRow(Sheet sheet, String string2) {
		for (Row row : sheet)
			for (Cell cell : row)
				if (cell.getCellType() == CellType.STRING)
					if (cell.getRichStringCellValue().getString().trim().equals(string2)) {
						return row.getRowNum() + "";
					}
		return sheet + " doesn't exist with given name " + string2;
	}

	@SuppressWarnings("deprecation")
	private String verifyCellData(int rowIndex, int columnIndex) {
		row = sheet.getRow(rowIndex);
		if (row == null) {
			return "Data doesn't exist in given row";
		}
		cell = row.getCell(columnIndex);
		if (cell == null) {
			return "Data doesn't exist in given cell";
		}
		switch (cell.getCellTypeEnum()) {
		case STRING:
			cellValue = cell.getStringCellValue();
			break;
		case NUMERIC:
			cellValue = String.valueOf(cell.getNumericCellValue());
			break;
		case FORMULA:
			cellValue = String.valueOf(cell.getNumericCellValue());
			break;
		case BLANK:
			cellValue = "";
			break;
		case BOOLEAN:
			cellValue = String.valueOf(cell.getBooleanCellValue());
			break;

		default:
			cellValue = "Invalid data type";
			break;
		}
		return cellValue;
	}
}