/**
 * 
 */
package com.other.algorithms;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;


/**
 * @author sjonnalagadda
 *
 */
public class WeekStartDay
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		LocalDate today1 = LocalDate.now();
		
		LocalDate monday = today1;
		
		while (monday.getDayOfWeek() != DayOfWeek.MONDAY)
		{
			monday = monday.minusDays(1);
		}
		
		LocalDate sunday = today1;
	    while (sunday.getDayOfWeek() != DayOfWeek.SUNDAY) {
	      sunday = sunday.plusDays(1);
	    }
	    
	    String valueOf = String.valueOf(monday);
	    
	    System.err.println("valueOf "+valueOf.replaceAll("-", "/"));
	    System.out.println("Today: " + today1);
	    System.out.println("Monday of the Week: " + monday);
	    System.out.println("Sunday of the Week: " + sunday);
	    
	    String lastWeekBounds = getLastWeekBounds(Calendar.getInstance());
	    
	    System.err.println(lastWeekBounds);
	    
	}
	
	
	public static String getLastWeekBounds(Calendar c) {
		int cdow = c.get(Calendar.DAY_OF_WEEK);
		Calendar lastMon = (Calendar) c.clone();
		lastMon.add(Calendar.DATE, -7 - (cdow - Calendar.MONDAY));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String lastMonday = sdf.format(lastMon.getTime());
		//System.out.println("lastMonday  "+lastMonday);
		
		Calendar lastSun = (Calendar) lastMon.clone();
		lastSun.add(Calendar.DATE, 6);
		sdf = new SimpleDateFormat("yyyy/MM/dd");
		String lastSunday = sdf.format(lastSun.getTime());
		//System.out.println("lastSunday --> "+lastSunday);
		
		return lastMonday+" - "+lastSunday;
	}
	
	
}
