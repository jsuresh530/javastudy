package com.other.algorithms;


public class ApowerB
{

	public static void main(String[] args)
	{
		//power1(4, 4);
		
		//System.out.println(power(4, 4));
		
		sumNumbers(22245);
	}
	
	public static double power1(double x, int n){
		 if(n==0){
			  return 1;
		 }
		 int ans = 1;
		 
		 for(int i =0;i<n;i++){
			 ans*= x;
		 }
		 System.out.println(ans);
		 return ans;
	}
	
	public static double power(double x, int n){
		 if(n==0){
			  return 1;
		 }

		 if(n<0){
			 x = 1.0/x;                      
			 n = -n;
		 }
		  
		 double ret = power(x,n/2);
		 ret = ret * ret;
		 
		 if(n%2 != 0){
		   ret = ret * x;
		 }
		 return ret;
	}
	
	
	public static void sumNumbers(int num)
	{
		int ans =0;
		String numStr = num + "";
		while(numStr.length() != 1)
		{
			ans =0;
			while(num > 0)
			{
				ans += num%10;
				num = num/10;
			}
			numStr = ans + "";
			num = ans;
		}
		System.out.println("num "+ans);		
	}
	
}
