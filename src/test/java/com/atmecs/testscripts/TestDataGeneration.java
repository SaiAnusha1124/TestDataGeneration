package com.atmecs.testscripts;

import java.util.Calendar;
import org.testng.annotations.Test;

import com.atmecs.actions.PageActions;
import com.atmecs.constants.ConstantsFilePaths;
import com.atmecs.utils.WriteExcelSheet;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestDataGeneration {
	String days, Aftermonth, Beforemonth;
	PageActions page = new PageActions();

	@Test
	public void dateGeneration() throws Exception {
		WriteExcelSheet write = new WriteExcelSheet(ConstantsFilePaths.TESTDATA_FILE1);
		DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDateTime now = LocalDateTime.now();
		String systemDate = (dateformat.format(now));
		System.out.println("User given Date: " + systemDate);
		SimpleDateFormat dateformat1 = new SimpleDateFormat("MM/dd/yyy");
		Calendar getDate = Calendar.getInstance();

		getDate.setTime(dateformat1.parse(systemDate));
		days = page.getdata_fromExcel("TestData", "duration", "Days");
		int afterdays = Integer.parseInt(days);
		getDate.add(Calendar.DATE, afterdays);
		String newDate = dateformat1.format(getDate.getTime());
		System.out.println("Date after 10 days: " + newDate);
		write.setCellData("TestData", "EffectiveData", 2, newDate);

		getDate.setTime(dateformat1.parse(systemDate));
		Aftermonth = page.getdata_fromExcel("TestData", "duration", "Aftermonth");
		int aftermonth = Integer.parseInt(Aftermonth);
		getDate.add(Calendar.MONTH, aftermonth);
		String onemonthafter = dateformat1.format(getDate.getTime());
		System.out.println("Date after one month" + onemonthafter);
		write.setCellData("TestData", "EffectiveData", 3, onemonthafter);

		getDate.setTime(dateformat1.parse(systemDate));
		Beforemonth = page.getdata_fromExcel("TestData", "duration", "Beforemonth");
		int beforemonth = Integer.parseInt(Beforemonth);
		getDate.add(Calendar.MONTH, beforemonth);
		String onemonthbefore = dateformat1.format(getDate.getTime());
		System.out.println("Date before one month" + onemonthbefore);
		write.setCellData("TestData", "EffectiveData", 4, onemonthbefore);
	}
}