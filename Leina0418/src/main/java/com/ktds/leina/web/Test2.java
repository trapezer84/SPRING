package com.ktds.leina.web;

public class Test2 {

	public static void main(String[] args) {
		Test2 test = new Test2();
		System.out.println(test.isPowerOfThree(27));
		
		int[] index = {6, 3, 8, 1, 9, 0, 2};
		int i, j, temp;
		
	}

	public boolean isPowerOfThree(int n) {
		if (n % 4 != 0 || n == 0) {
			return false;
		} else {
			if (n / 4 > 4) {
				return isPowerOfThree(n / 4);
			} else {
				return true;
			}
		}
	}
	
	public void bubbleSort(int[] index) {
		for(int i=0; i<index.length; i++) {
			
		}
	}
}