package com.wangwang.conver;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conver {
	public Conver() {
		
	}
	
	public static String ConverToString(Date date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = df.format(date);
		return strDate;
	}
	
	public static Date ConverToDate(String strDate) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = df.parse(strDate);
	
		
		return date;
	}
}
