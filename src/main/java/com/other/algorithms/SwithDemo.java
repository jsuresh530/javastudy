package com.other.algorithms;

public class SwithDemo {

	public static void main(String[] args) {
		enterMonthTogetDays(5);
	}

	public static int enterMonthTogetDays(int month){
		int days = 0;
		int year = 2017;
		
		switch (month) {
			case 1: case 3: case 5: case 7:
			case 8: case 10: case 12:
			days =31;
			break;
			
			case 4: case 6: case 9: case 11:
			days =30;
			break;
			
			case 2:
				if( (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0) )
					days = 29;
				else 
					days =28;
				break;
				
		default:
			System.out.println("Invalid month : "+month);
			break;
		}
		
		System.out.println("No of days in "+month+" is: "+days);
		return days;
	}
	
	
		/*List<String> ids = new ArrayList<String>();
		ids.add("1");
		ids.add("2");
		ids.add("3");
		ids.add("4");

		// CSV format
		String csv = ids.toString().replace("[", "").replace("]", "")
		            .replace(", ", ",");
		String idList = ids.toString();
		String replace = idList.substring(1, idList.length() - 1).replace(", ", ",");

		// CSV format surrounded by single quote 
		// Useful for SQL IN QUERY

		String csvWithQuote = ids.toString().replace("[", "'").replace("]", "'")
		            .replace(", ", "','");
		
		System.out.println(replace);*/
}
