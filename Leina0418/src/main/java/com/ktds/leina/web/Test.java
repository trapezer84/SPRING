package com.ktds.leina.web;

import java.util.Scanner;

public class Test {
	
	public static int A = 0; 
	public static int B = 0;
	
	public void start(int num) {
		this.fibonacci(num);
	}
	
	public static int fibonacci(int num) {
		if ( num == 0) {
			A ++;
			return 0;
		}
		else if ( num == 1) {
			B ++;
			return 1; 
		}
		else {
			return fibonacci(num-1) + fibonacci(num-2);
		}
	}
	
	
	public static void main(String[] args) {
		Test test = new Test();
		Scanner scanner = new Scanner(System.in);
		
		for (int i = 0 ; i < 4 ; i ++) {
			int num = scanner.nextInt();
			A = 0; 
			B = 0;
			test.start(num);
			System.out.println(A);
			System.out.println(B);
		}
	}
}
