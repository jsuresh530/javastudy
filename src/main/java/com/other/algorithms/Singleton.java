package com.other.algorithms;

import java.util.*;
import java.util.Map.Entry;

public class Singleton {
//Insanity: doing the same thing over and over again and expecting different results.
	private static Singleton mySingleton;
	static{
		//mySingleton = new Singleton();
    }
	private Singleton(){}
	
	public static Singleton getInstance(){
        return mySingleton;
    }
     
    public void testMe(){
        System.out.println("Hey.... it is working!!!");
    }
    
	public static void main(String[] args) {
		new Singleton().testMe();
		sortMAPByValue();
	}

	private static void sortMAPByValue()
	{
		Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("java", 20);
        map.put("C++", 45);
        map.put("Java2Novice", 2);
        map.put("Unix", 67);
        map.put("MAC", 26);
        map.put("Why this kolavari", 93);
        Set<Entry<String, Integer>> set = map.entrySet();
        Set<String> keySet = map.keySet();
        
        System.out.println("keySet "+keySet);
        List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(map.entrySet());
        
        Collections.sort( list, new Comparator<Entry<String, Integer>>()
        {
            public int compare( Entry<String, Integer> o1, Entry<String, Integer> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        });
        
        //Collections.reverse(list);
        for(Entry<String, Integer> entry:list){
            System.out.println(entry.getKey()+" ==== "+entry.getValue());
        }
	}
}
