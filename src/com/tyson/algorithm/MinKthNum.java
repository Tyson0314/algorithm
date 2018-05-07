/**   
* @Title: MinKthNum.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年5月1日 下午11:49:47 
* @version V1.0   
*/
package com.tyson.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

/**  
* @ClassName: MinKthNum  
* @Description: TODO 
* @author Tyson
* @date 2018年5月1日 下午11:49:47  
*    
*/
public class MinKthNum {
	 public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		 ArrayList<Integer> list = new ArrayList<>();
		 if(input == null||k<=0||k>input.length) {
			 return list;
		 }
		 
		 int[] arr = Arrays.copyOfRange(input, 0, k);
		 buildMaxHeap(arr);
		 
		 for(int i=k;i<input.length;i++) {
			 if(input[i]<arr[0]) {
				 arr[0] = input[i];
				 perlocateDown(arr, 0);
			 }
		 }
		 
		 for(int i=0;i<arr.length;i++) {
			 list.add(arr[i]);
		 }
		 return list;
	 }
	 
	 public void buildMaxHeap(int[] arr) {
		 for(int i=arr.length/2;i>=0;i--) {
			 perlocateDown(arr, i);
		 }
	 }
	 
	 public void perlocateDown(int[] arr, int hole) {
		 int child;
		 int tmp = arr[hole];
		 
		 for(;hole*2<=arr.length-1;hole=child) {
			 child = hole*2;
			 if(child<arr.length-1) {
				 if(arr[child]<arr[child+1])
					 child++;
			 }
			 if(arr[child]>tmp) {
				 arr[hole] = arr[child];
			 }
			 else
				 break;
		 }
		 arr[hole] = tmp;
	 }
	 
	 public static void main(String[] args) {
		int[] arr = {12, 56, 45, 23, 89, 3};
		
		ArrayList<Integer> list = new MinKthNum().GetLeastNumbers_Solution(arr, 3);
		
		System.out.println(list);
	}
}
