/**
 * 
 */
package com.coreexamples.CoreJava;

import java.util.*;
import java.util.Map.Entry;


/**
 * @author sjonnalagadda
 *
 */
public class ReverseString
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		reverseString();
		swap2Nums();
		finalCountWords();
		primeNo();
		checkNumberPalindrome();
		fibonaci();
		secondHeighest();
		printPyramid();
		arrayEquals();
		isAnargam("Keep", "Peek");
		System.err.println("88888888888888888 "+isAnagramMAP("Keep", "Peek"));
		armStrongNumber();
		System.err.println("FACtorial is ::: "+recursionFact(5));
		reverseList();
		
	}

	/**
	 * 
	 */
	private static void reverseList()
	{
		List<String> list = Arrays.asList("C", "C++", "Java");
		for (int i = list.size()-1; i >= 0; i--)
		{
			System.err.print("----> "+list.get(i));
		}
		
		// use ListIterator to iterate List in reverse order
				ListIterator<String> itr = list.listIterator(list.size());

				// hasPrevious() returns true if the list has previous element
				while (itr.hasPrevious()) {
					System.out.println(itr.previous());
				}
				
	}

	/**
	 * 
	 */
	private static int recursionFact(int n)
	{
		if(n == 1) return 1;
		else
			return (n*recursionFact(n-1));
	}

	/**
	 * 
	 */
	private static void armStrongNumber()
	{
		int number =153, temp,total=0, num = number;
		
		/*for(;number!=0;number /= 10){
			temp =number%10;
			total=total+(temp*temp*temp);
		}*/
		while(number > 0){
			temp = number%10;
			total += (temp*temp*temp);
			number = number/10;
		}
		if(num == total)  
		    System.out.println("armstrong number");   
		    else  
		        System.out.println("Not armstrong number");   
	
	}

	static boolean isAnagramMAP(String a, String b) {
        if ((a == null || b == null) || (a.length() != b.length())) {
            return false;
        }
        
        HashMap<Character, Integer> hm =new HashMap<Character, Integer>();
        char[] charArray = a.toUpperCase().toCharArray();
        
        for (int i = 0; i < charArray.length; i++)
		{
			if(hm.containsKey(charArray[i])){
				hm.put(charArray[i], (hm.get(charArray[i])+1));
			}else{
				hm.put(charArray[i], 1);
			}
		}
        
        char[] charArray2 = b.toUpperCase().toCharArray();
        for (int i = 0; i < charArray2.length; i++)
		{
			if(hm.containsKey(charArray2[i])){
				System.err.println("IN");
				int count = hm.get(charArray2[i]);
				if(count == 0){
					return false;
				}else{
					count--;
					hm.put(charArray2[i], count);
				}
			}else{
				System.err.println("here ..............");
				return false;
			}
		}
        
        return true;
    }
	/**
	 * 
	 */
	private static void isAnargam(String s1, String s2)
	{
		boolean status =true;
		if(s1.length() != s2.length()){
			status =false;
		}else{
			char[] charArray = s1.toLowerCase().toCharArray();
			char[] charArray2 = s2.toLowerCase().toCharArray();
			
			Arrays.sort(charArray);  Arrays.sort(charArray2);
			
			status = Arrays.equals(charArray, charArray2);
		}
		
		if(status){
			System.err.println("botha are aagrams "+s1+", "+s2);
		}else{
			System.err.println("NOT are aagrams "+s1+", "+s2);
		}
	}
	/**
	 * 
	 */
	private static void arrayEquals()
	{
		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int[] arrayOne = {2, -5, 1, 7, 4};
        
        int[] arrayTwo = {2, 5, 1, 7, 4};
        
        //common elements in array
        for (int i = 0; i < arrayOne.length; i++)
		{
			for (int j = 0; j < arrayTwo.length; j++)
			{
				if(arrayOne[i] == arrayTwo[j]){
					System.err.print(arrayOne[i]+" ");
				}
			}
		}
        
        boolean equalOrNot = true;
       if(arrayOne.length == arrayTwo.length){
    	   for (int i = 0; i < arrayOne.length; i++)
	   		{
	   			if(arrayOne[i] != arrayTwo[i]){
	   				equalOrNot = false;
	   			}
	   		}
       }else{
    	   System.err.println("NOT equal");
       }
       
       if (equalOrNot)
       {
           System.out.println("Two Arrays Are Equal");
       }
       else
       {
           System.out.println("Two Arrays Are Not equal");
       }
       
       String[] s1 = {"java", "swings", "j2ee", "struts", "jsp", "hibernate"};
       
       String[] s2 = {"java", "struts", "j2ee", "hibernate", "swings", "jsp"};

       Arrays.sort(s1);

       Arrays.sort(s2);

       System.out.println(Arrays.equals(s1, s2));       //Output : true
        
	}

	/**
	 * 
	 */
	private static void printPyramid()
	{
		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int number = 6, rowcount =1;;
		for (int i = number; i > 0; i--)
		{
			for (int j = 1; j <= i; j++)
			{
				System.out.print(" ");
			}
			
			for (int j = 1; j <= rowcount; j++)
			{
				System.out.print("* ");
			}
			System.out.println();
			rowcount++;
		}
		
		
		String[][] s1 = { {"java", "swings", "j2ee" }, { "struts", "jsp", "hibernate"} };
		 
        String[][] s2 = { {"java", "swings", "j2ee" }, { "struts", "jsp", "hibernate"} };
 
        System.out.println(Arrays.deepEquals(s1, s2));     //Output : true
         
        //Calling equals() method on same arrays will return false
         
        System.out.println(Arrays.equals(s1, s2));        //Output : false
         
        //That's why use deepEquals() method to compare multidimensional arrays
		
	}

	/**
	 * 
	 */
	private static void secondHeighest()
	{
		int arr [] = {40,10,400};
		int max =Integer.MIN_VALUE;
		int secMax =Integer.MIN_VALUE;
		
		for (int i = 0; i < arr.length; i++)
		{
			if(arr[i]>max){
				secMax = max;
				max = arr[i];
				
			}else if(arr[i]> secMax){
				secMax =arr[i];
			}	
		}
		System.err.println(" MAX ---> "+max+" Second MAX --> "+secMax);
		
		int min = Integer.MAX_VALUE;
		int secMin = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++)
		{
			if(arr[i] < min){
				secMin = min;
				min = arr[i];
			}else if(arr[i] < secMin){
				secMin =  arr[i];
			}
		}
		
		System.err.println(" MIN ---> "+min+" Second MIN --> "+secMin);
	}

	/**
	 * 
	 */
	private static void fibonaci()
	{
		int a=0,b=0,c=1;
		for (int i = 0; i <= 10; i++)
		{
			a= b;
			b =c;
			c = a+b;
			 System.out.print(a+" ");
		}
		
		//Duplicate chars in a string
		
		String s = "babua";
		int count =0;
		char[] chars = s.toCharArray();
        System.out.println("Duplicate characters are:");
		for (int i = 0; i < s.length(); i++)
		{
			for (int j = i+1; j < s.length(); j++)
			{
				 if (chars[i] == chars[j]) {
                     System.out.println(chars[j]);
                     count++;
                     break;
           }
			}
		}
	}

	/**
	 * 
	 */
	private static void checkNumberPalindrome()
	{
		int number = 121, remainder =0, reverse=0;
		int temp_num = number;
		while (temp_num > 0)
		{
			remainder = temp_num%10;
			// Store number in reverse form
			reverse = reverse*10+remainder;
			//Truncate last digit from number
			temp_num = temp_num/10;
			System.err.println("temp_num "+temp_num);
		}
		if(reverse == number) 			System.out.println("Given number is palindrome");
		else 			System.out.println("Given number is NOT palindrome");
		
		String s = "1217" , reverseStr = "";
		
		for (int i = s.length()-1; i >= 0; i--)
		{
			reverseStr += s.charAt(i);
		}
		if(s.equals(reverseStr)) System.out.println("Given String is palindrome");
		else System.err.println("is NOT palindrome ");
		
	}

	/**
	 * 
	 */
	private static void primeNo()
	{
		boolean isPrime = true;
		int num = 31, temp;
		for (int i = 2; i <= num/2; i++)
		{
			temp =num%i;
			if(temp == 0){
				isPrime =false;
				break;
			}
		}
		if(isPrime)
			System.err.println(num+" is a prime");
		else
			System.err.println(num+" is not a prime");
		// From to to numers printing ...
		for (int i = 2; i < 100; i++)
		{
			int flag = 1;
			for (int j = 2; j <= i/2; j++)
			{
				if(i%j == 0){
					flag =0;break;
				}
			}
			if(flag == 1)
				System.err.print(" "+i);
		}
		// using list
		List<Integer> list =new ArrayList<Integer>();
		
		for (int i = 2; i <= 100; i++)
		{
			int count = 0;
			for (int j = 2; j < i; j++)
			{
				if(i%j == 0){count++;}
			}
			if(count == 0){
				list.add(i);
			}
		}
		
		System.err.println("\n LIST "+list.toString());
	}
	

	/**
	 *  https://www.includehelp.com/java-programs/check-palindrome.aspx
	 *  
	 *  https://javarevisited.blogspot.com/2017/07/top-50-java-programs-from-coding-Interviews.html
	 *  
	 *  https://www.softwaretestinghelp.com/java-coding-interview-programs/
	 */
	private static void finalCountWords()
	{
		String s = "my my babu is suresh babu";
		Map<String, Integer> map =new HashMap<String, Integer>();
		String[] split = s.split(" ");
		for (int i = 0; i < split.length; i++)
		{
			/*if(!map.containsKey(split[i])){
				map.put(split[i], 1);
			}else{
				map.put(split[i], map.get(split[i])+1);
			}*/
			
			map.put(split[i], map.get(split[i]) == null ? 1 : map.get(split[i])+1);
			//map.put(split[i], map.containsKey(split[i]) ? map.get(split[i])+1 : 1);
		}
		
		System.err.println("ppppppppppp "+map.toString());
		
		// ENtry set of iterator
		Iterator<Entry<String, Integer>> iterator = map.entrySet().iterator();
		while (iterator.hasNext())
		{
			Entry<String, Integer> entry = (Entry<String, Integer>) iterator.next();
			System.err.println(entry.getKey()+" "+entry.getValue());
			
		}
		
		// foreach
		for (Entry<String, Integer> string : map.entrySet())
		{
			System.err.println(string.getKey()+" "+string.getValue());
		}
		
		for (String key : map.keySet())
		{
			System.err.println("KEY "+key+" Value: "+map.get(key));
		}
		
		
	}

	/**
	 * 
	 */
	private static final void swap2Nums()
	{
		// With temp 
		int x = 10, y =20, temp;
		System.err.println("\n BEFORE X = "+x+" Y = "+y);
		temp =x;
		x=y;
		y=temp;
		
		System.err.println("X = "+x+" Y = "+y);
		
		// without temp
		x = 10; y =20;
		x = x+y; // 30
		y = x-y; // 10
		x = x-y; // 20
		
		System.err.println("X = "+x+" Y = "+y);
	}

	/**
	 * 
	 */
	private static void reverseString()
	{
		String s ="babu";
		char[] charArray = s.toCharArray();
		for (int i = charArray.length-1; i >=0; i--)
		{
			System.err.print(charArray[i]);
		}
		System.err.println("\n ");
		for (int i = s.length()-1; i >= 0; i--)
		{
			System.err.print(s.charAt(i));
		}
		
	}
}
