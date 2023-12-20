package com.other.threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;


public class ArrayToCollection
{

	public static void main(String[] args)
	{
		getInput();
	}

	private static void getInput()
	{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("How many elements u want to add ? ");
		try
		{
			Integer value  = Integer.valueOf(br.readLine());
			String [] name = new String[value];
			System.out.println("Enter elemtns ------- ");
			for (int i = 0; i < name.length; i++)
			{
				name[i] = br.readLine();
			}
			
			List<String> asList = Arrays.asList(name);
			
			System.out.println(asList.toString());
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
