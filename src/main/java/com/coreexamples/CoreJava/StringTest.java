package com.coreexamples.CoreJava;

class A
{
	
}
public class StringTest {

	public static void main(String[] args) {
		
		
		String pp = "/C:/Workspaces/prod/V21product/runtime/pos/config/aesdkconfig";
		
		System.err.println(pp.replaceAll("/", "\\\\"));
		
		A a = new A();
		System.err.println(a);
		
		String s = new String("suresh");
		System.err.println(s);
		
		try {
			
		} catch (NullPointerException e) {
		}
		catch (Exception e1) {
		}
		//catch (ArithmeticException e2) {
			// TODO: handle exception
		//}
	}

}
