package com.tyson.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinarySearch {
	public <T extends Comparable<? super T>> int binarySearch(T[] tArr, T t) {
		final int NO_FOUND = -1;
		int low=0, high = tArr.length;
		int mid;
		while(low<=high) {
			mid = (low+high)/2;
			
			if(tArr[mid].compareTo(t)>0) {
				high = mid - 1;
			} else if(tArr[mid].compareTo(t)<0) {
				low = mid + 1;
			} else {
				return mid;
			}	
		}
		return NO_FOUND;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		
		while(sc.hasNextInt()) {
			list.add(sc.nextInt());
		}
		Integer[] arrInt = new Integer[list.size()];
		for(int i=0;i<list.size();i++) {
			arrInt[i] = list.get(i);
		}
		int result = new BinarySearch().binarySearch(arrInt, 5);
		System.out.println(result);
	}
}
