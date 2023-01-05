package com.debug;

public class Debug {

	public static void main(String[] args) {

		System.out.println("start");
		
		int a = 5;
		
		add();
		
		if(a>10) {
		
		System.out.println("true");
		
		}else {
		 
			System.out.println("false");
		}
	
		System.out.println("stop");
	}
	
	static void add() {
		
		System.out.println("Method start");
		
		int b=10,c=20;
		int d=b+c;
		
		System.out.println(d);
		
		System.out.println("Method stop");
	}
	
	

}
