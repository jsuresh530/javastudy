package com.other.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class StrangeStringThing {
	private static Random rnd = new Random();
    private static final int MEGA = 1024*1024;
  
    private static String createRandomStr(int length){
        StringBuilder sb = new StringBuilder(length);
        for(int i=0;i<length;i++)
            sb.append((char)('a'+rnd.nextInt('z'-'a'+1)));
        return sb.toString();
    }
  
    public static void main(String[] args){
    	
    	/*Long maxMemory = Runtime.getRuntime().maxMemory();
    	System.out.println(maxMemory);
    	
    	int[] matrix = new int[(int) (maxMemory + 1)];
		for(int i = 0; i < matrix.length; ++i)
			matrix[i] = i+1;
	
        List<String> substrings = new ArrayList<String>();
        for(int i=0;i<100;i++){
            String randomStr = createRandomStr(MEGA);
            String subStr = randomStr.substring(1000,1004);
            substrings.add(subStr);
        }
        
        System.out.println(substrings.toString());
    }*/
    	
    	 Map<Integer, String> map =new HashMap<Integer, String>();
    	 
    	 map.put(5, "testdg");
    	 map.put(6, "kkkk");
    	 map.put(7, null);
    	 map.put(8, null);
    	 map.put(9, null);
    	 map.put(null, null);
    	 map.put(null, null);
    	 map.put(1, "kkk");
    	 map.put(2, "test");
    	 map.put(3, "test");
    	 
    	 for (Entry<Integer, String> mp : map.entrySet())
		{
			System.out.println(mp.getKey()+" "+mp.getValue()+" "+mp.hashCode());
		}
    	 System.out.println(map.toString()+" ");
    	 
}

}