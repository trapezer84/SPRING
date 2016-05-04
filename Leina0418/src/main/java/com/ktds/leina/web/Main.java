package com.ktds.leina.web;

import java.util.Scanner;

public class Main {

	public void start() {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		System.out.println(this.isPowerOfFour(num));
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.start();
	}

    public boolean isPowerOfFour(int num) {
    	num = Math.abs(num);
    	
    	if (-4 < num && num <= 4) {
    		return true;
    	}
    	else if (num/4 < 4 && num%4 != 0) {
    		return false;
    	}
    	else if (num/4 >= 4 && num%4 == 0) {
    		return true;
    	}
    	else if (num%4 !=0) {
    		return false;
    	}
    	else {
    		return true;
    	}
     }

}
