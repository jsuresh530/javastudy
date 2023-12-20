package com.coreexamples.CoreJava;
/**
 * 
 */
/**
 * @author sjonnalagadda
 *
 */
public class FindDuplicateCount
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String s = "count the duplicate numbers";
		
		/*for (int i = 0; i < s.length(); i++)
		{
			System.err.println(s.charAt(i));
		}*/
		findDuplicateCount(s);
		
		//breakAndContinue();
	}

	/**
	 * @param s
	 */
	private static void findDuplicateCount(String s)
	{
		int count =0 ;
		char[] charArray = s.toCharArray();
		
		for (int i = 0; i < s.length(); i++)
		{
			for (int j = i+1; j < s.length()-1; j++)
			{
				if(charArray[i] == charArray[j] && !Character.isWhitespace(charArray[i])){
					count++;
					
					System.out.println(charArray[j] +" "+(count));
					break;
				}
			}
		}
	}
	
	public static void breakAndContinue(){
		
		int arr [] = {10,20,30,40,50};
		
		for (int i = 0; i < arr.length; i++)
		{
			if(arr[i] == 30)
				continue;
			System.err.println(arr[i]);
		}
		
	}
}
