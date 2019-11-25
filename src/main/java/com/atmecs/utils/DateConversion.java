package com.atmecs.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateConversion {
	static String blogdate;
	static List<String> datesList;

	public static List<String> convertDate(String actualDate) {
		try {
			SimpleDateFormat format1 = new SimpleDateFormat("dd MMMMMM yyyy");
			SimpleDateFormat format2 = new SimpleDateFormat("dd-MM-yyyy");
			Date date = format1.parse(actualDate);
			blogdate = (format2.format(date));
			//System.out.println(blogdate);
			String todaysDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			//System.out.println(todaysDate);
			datesList = new ArrayList<String>();
			datesList.add(blogdate);
			datesList.add(todaysDate);

		} catch (Exception e) {
			System.out.println("Exception occured in converting dates");
		}
		return datesList;
	}
}
