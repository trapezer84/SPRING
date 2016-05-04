package com.ktds.leina.web;

public class Sort {

	public static void main() {
		Sort sort = new Sort();
		int[] index = {5, 6, 1, 3, 8, 4, 9};
		int[] result = sort.insertionSort(index);
		
		for(int i=0; i<result.length; i++) {
			System.out.println(result[i]);
		}
	}

	public int[] insertionSort(int[] index) {
		
		int min = 0;
		
		for (int i = 0; i < index.length; i++) {
			for (int j = i; j < index.length; j++) {
				if ( index[i] <= index[j] ) {
					min = i;
				} else {
					min = j;
				}
				
				int temp = index[i];
				index[i] = index[min];
				index[min] = temp; 
			}
		}
		
		return index;
	}

	public void bubbleSort(int[] index) {
		for (int i = 0; i < index.length; i++) {

		}
	}

	public void selectionSort(int[] index) {

	}
}
