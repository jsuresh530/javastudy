/**
 * 
 */
package com.other.algorithms.asymetric;


/**
 * @author sjonnalagadda
 *
 */
public class PrimeExample
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int l =0, h =20;
		boolean flag =false;
		while (l < h){
			for (int i = 2; i <= l/2; i++)
			{
				if(l%i == 0){
					flag = true;
					break;
				}
			}
			
			if (!flag)
                System.out.print(l+ " ");

            l++;
		}
		
		//isPrime(4);
	}

	/**
	 * @param i
	 */
	private static void isPrime(int num)
	{
		boolean isFlag = false;
		for (int j = 2; j <= num/2; j++)
		{
			//System.err.println("here");
			if(num%j == 0){
				isFlag = true; 
				break;
			}
		}
		
		if(isFlag)
			System.err.println("Is not prime Number "+num);
		else
			System.err.println(num+" Is a prime no.");
		
		
		
		//Print no between 10 and 20 
		
		
	}
}
