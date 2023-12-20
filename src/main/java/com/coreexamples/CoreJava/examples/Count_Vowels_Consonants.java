package com.coreexamples.CoreJava.examples;
import java.util.Scanner;

public class Count_Vowels_Consonants {
public static void main(String[] args) {
	System.out.println("Enter String...");
	String s = new Scanner(System.in).next();
	char[] ch = s.toCharArray();
	
	int vowels = 0;
	int consonant = 0;
	
	for (int i = 0; i < ch.length; i++) {
		if(ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u' || ch[i] == 'A' || ch[i] == 'E' || ch[i] == 'I' || ch[i] == 'O' || ch[i] == 'U'){
			vowels++;
		}else{
			consonant++;
		}
	}
	System.out.println("In " + s + ", Vowels - " + vowels + ", Consonant - " + consonant );
}
}
