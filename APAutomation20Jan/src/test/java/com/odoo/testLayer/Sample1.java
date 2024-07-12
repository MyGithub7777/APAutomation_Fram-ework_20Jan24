package com.odoo.testLayer;

public class Sample1 {
	
	public static void test(int a, int b)
	{
		System.out.println(a+b);
	}

	public static void main(String[] args) {
		Sample1.test(10,20);
		Sample1.test(100,50);
		
		String s1 = "Harry";
		String s2 = "Harry";
		
		s1.equals(s2);
	}
}
