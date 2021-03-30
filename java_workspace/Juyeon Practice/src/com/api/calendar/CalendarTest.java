package com.api.calendar;

import java.util.Calendar;

public class CalendarTest {
	public static void main(String[] args) {
		CalendarTest c = new  CalendarTest();
		c.test1();
	}
	public void test1() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(now);
		
		System.out.println(cal);
		
		
		
	}

}
