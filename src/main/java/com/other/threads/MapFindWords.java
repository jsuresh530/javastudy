package com.other.threads;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

public class MapFindWords
{
	public MapFindWords()
	{
		System.out.println("Inside MapFindWords");
		countWords("hello my name is suresh suresh");
	}
	
	public static void main(String[] args)
	{
		countWords("hello my name is suresh suresh");
		//new MapFindWords();
		
		//getTimeDiff(getTime());
		
		//printMaxValues();
		
		//printValuesForDate("2018-05-17");
		findDuplicateChars("babu");
	}
	static void findDuplicateChars(String s){
		Map<Character, Integer> map = new HashMap<Character, Integer>(16);
		for (int i = 0; i < s.length(); i++) {
			char charArray = s.charAt(i);
			if(map.get(charArray) != null){
				map.put(charArray, map.get(charArray)+1);
			}else{
				map.put(charArray, 1);
			}
		}
		
		System.err.println("------- "+map);
		for (Character entry : map.keySet()) {
			if(map.get(entry) > 1){
				System.err.println(" ------ "+map.get(entry)+" "+entry);
			}
		}
	}
	public static int countWords(String line)
	{
		int word = 0;
		String key = null;
		String[] split = line.split(" ");
		
		System.out.println(split.length);
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String string : split)
		{
			if(map.get(string) != null){
				map.put(string, map.get(string)+1);
			}else{
				map.put(string, 1);
			}
			map.put(string, map.containsKey(string) ? map.get(string)+ 1 : 1);
		}
		
		Collection<Integer> values = map.values();
		for (Integer integer : values) {
			System.err.println("-----------"+integer);
		}
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			if(map.get(string) > 1){
				System.err.println("the word "+string+" appeared "+map.get(string)+" no of times .");
			}
			
		}
		for (Entry<String, Integer> string : map.entrySet())
		{
			key = string.getKey();
			word = string.getValue();
			
			System.out.println(" key ........... "+key+" ---------> value: "+word);
		}
		return word;
	}
	
	
	public static List<String> getTime()
	{
		List<String> list = new ArrayList<String>();
		
		list.add("2018-01-02 09:10:11");
		list.add("2018-01-02 10:33:11");
		list.add("2018-01-02 13:10:11");
		//list.add("2018-01-02 14:10:11");
		//list.add("2018-01-02 18:10:11");
		
		return list;
	}
	
	
	public static Map<String, String> getTimeDiff(List<String> str)
	{
		String userid ="123";
		Map<String, String> diffMap = new HashMap<String, String>();;
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d1 = null;
		Date d2 = null;
		String dif ="";
		try
		{
			long sum =0;
			for (int i = 0; i < str.size(); i++)
			{
				
				d1 = format.parse(str.get(i));
				d2 = format.parse(str.get(i+1));
				
				long diff = d2.getTime() - d1.getTime();
				
				long diffMinutes = diff / (60 * 1000) % 60;
				long diffHours = diff / (60 * 60 * 1000) % 24;
				
				//long diffSeconds = diff / 1000 % 60;
				//long diffDays = diff / (24 * 60 * 60 * 1000);
				
				dif = diffHours+":"+diffMinutes;
				
				sum += diff;
				
				long diffMinutes1 = sum / (60 * 1000) % 60;
				long diffHours1 = sum / (60 * 60 * 1000) % 24;
				
				String dif1 = diffHours1+":"+diffMinutes1;
				
				if(diffMap.containsValue(dif1))
				{
					diffMap.put(userid, String.valueOf(dif1)+1);
				}
				else
				{
					diffMap.put(userid, String.valueOf(dif1));
				}
				
			}
			/*String maxValueInMap=(Collections.max(diffMap.values())); 
	        for (Entry<String, String> entry : diffMap.entrySet()) {  
	            if (entry.getValue().equalsIgnoreCase(maxValueInMap)) {
	                System.out.println(entry.getKey()); 
	            }
	        }
			System.out.println(diffMap);*/
			
		}catch(Exception e)
		{
			
		}
		System.out.println(Collections.max(diffMap.values()));
		System.out.println(diffMap);
		return diffMap;
	}
	
	
	public static Map<String, Integer> printMaxValues()
	{
		Map<String, Integer> map = new TreeMap<String, Integer>();
		
		for (int i = 0; i < 5; i++)
		{
			map.put("one_"+i, 1+i);
		}
		
		System.out.println(map);
		System.out.println(Collections.max(map.values()));
		return map;
	}
	
	public static void printValuesForDate(String date)
	{
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		  try
		{
			Date parse = sdf.parse(date);
			Calendar c =Calendar.getInstance();
			c.setTime(parse);
			//System.out.println(c.get(Calendar.WEEK_OF_MONTH));
			
			String[] strDays = new String[] {"Sunday", "Monday", "Tuesday", "Wednesday", "Thrusday", "Friday", "Saturday"};
		    System.out.println("Current day is : " + strDays[c.get(Calendar.DAY_OF_WEEK) - 1]);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		  
		  
		  
	}

}
