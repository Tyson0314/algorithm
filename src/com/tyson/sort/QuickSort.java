package com.tyson.sort;

import java.util.Random;

public class QuickSort<Anytype extends Comparable<? super Anytype>> {
	private final int CUTOFF = 3;
	
	public void quickSort(Anytype[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}
	private void quickSort(Anytype[] arr, int left, int right) {
		
		if(left+CUTOFF<right) {
			Anytype median = median3(arr, left, right);
			
			int i=left, j=right-1;
			
			while(true) {
				while(arr[++i].compareTo(median)<0) {}
				while(arr[--j].compareTo(median)>0) {}
				
				if(i<j) {
					swap(arr, i, j);
				} else {
					break;
				}
			}
			swap(arr, i, right-1);
			quickSort(arr, left, i-1);
			quickSort(arr, i+1, right);
		} else {
			insertionSort(arr, left, right);
		}
		
	}
	private Anytype median3(Anytype[] arr, int left, int right) {
		int center = (left + right)/2;
		
		if(arr[left].compareTo(arr[center])>0) {
			swap(arr, left, center);
		}
		if(arr[left].compareTo(arr[right])>0) {
			swap(arr, left, right);
		}
		if(arr[center].compareTo(arr[right])>0) {
			swap(arr, center, right);
		}
		
		swap(arr, center, right-1);
		
		return arr[right-1];
	}
	private void swap(Anytype[] arr, int x, int y) {
		Anytype tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}
	private void insertionSort(Anytype[] arr, int left, int right) {
		
		for(int i=left+1;i<=right;i++) {
			Anytype tmp = arr[i];
			int j;
			for(j=i;j>left&&arr[j-1].compareTo(tmp)>0;j--) {
				arr[j] = arr[j-1];
			}
			arr[j] = tmp;
		}
	}
	
	public static void main(String[] args) {
		final int NUM = 1000000;
		Random rand = new Random();
		QuickSort<Integer> qs = new QuickSort<Integer>();
		
		Integer[] arr = new Integer[NUM];
		for(int i=0;i<NUM;i++) {
			arr[i] = rand.nextInt(NUM);
		}
		
		long startTime = System.currentTimeMillis();
		qs.quickSort(arr);
		long endTime = System.currentTimeMillis();
		
		/*for(int i=0;i<NUM;i++) {
			//arr[i] = rand.nextInt(NUM);
			System.out.print(arr[i] + " ");
		}*/
		System.out.println();
		System.out.println(endTime-startTime);
	}
}
