package com.coreexamples.CoreJava.examples;
public class Sort_String {
public static void main(String[] args) {
	String s="9568701234";
	char[] ch = s.toCharArray();
	char temp;
	String s2 = "";
	
	for (int i = 0; i < ch.length; i++) {
		for (int j = 0; j < ch.length; j++) {
			if(ch[i] <= ch[j]){
				temp = ch[i];
				ch[i] = ch[j];
				ch[j] =temp;
			}
		}
	}
	System.out.println(ch);
}
}
