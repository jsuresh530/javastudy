package com.other.clientserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Scanner;


public class Fahrenheit
{

	public static void main(String[] args) throws NumberFormatException, IOException
	{
		toFahrenheit();
	}

	private static void toFahrenheit() throws NumberFormatException, IOException
	{
		Scanner  sc =new Scanner(System.in);
		System.out.print("Input a degree in Fahrenheit: ");
		Double fahrenheit = sc.nextDouble();
		DecimalFormat dec = new DecimalFormat("#0.00");
		double  celsius =(( 5 *(fahrenheit - 32.0)) / 9.0);
        System.out.println(fahrenheit + " degree Fahrenheit is equal to " + dec.format(celsius) + " in Celsius");
        
        
        double celsius1, fahrenheit1;

        Scanner s = new Scanner(System.in);

        System.out.print("Enter temperature in Fahrenheit:");

        fahrenheit1 = s.nextDouble();

        celsius1 = (fahrenheit1-32)*(0.5556);

        System.out.println("Temperature in Celsius:"+dec.format(celsius1));        
        
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please enter temperature in Celsius : ");
        double celsius11 = Double.parseDouble(reader.readLine());
        double fahrenheit11 = (9.0/5.0)*celsius11 + 32;
        System.out.println("Temperature in Fahrenheit is : "+fahrenheit11);
        
        
        sc.close();
        s.close();
        reader.close();
		
	}
}
