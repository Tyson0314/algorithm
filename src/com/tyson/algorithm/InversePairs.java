/**   
* @Title: InversePairs.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年5月6日 下午5:27:25 
* @version V1.0   
*/
package com.tyson.algorithm;

import java.util.Arrays;

/**  
* @ClassName: InversePairs  
* @Description: TODO 
* @author Tyson
* @date 2018年5月6日 下午5:27:25  
*    
*/
public class InversePairs {
	private int reversePair = 0;
	 public int InversePairs(int [] array) {
		 int[] tmpArr = new int[array.length];
		 mergeSort(array, tmpArr, 0, array.length-1);
		 return reversePair;
	 }
	 
	 public void mergeSort(int[] arr, int[] tmpArr, int left, int right) {
		 if(left>=right)
			 return;
		 int mid = (left+right)/2;
		 mergeSort(arr, tmpArr, left, mid);
		 mergeSort(arr, tmpArr, mid+1, right);
		 merge(arr,tmpArr, left, mid, right);
	 }
	 
	 public void merge(int[] arr, int[] tmpArr, int leftPos, int leftEnd, int rightEnd) {
		 int rightPos = leftEnd + 1;
		 int tmpPos = leftPos;
		 int length = rightEnd - leftPos + 1;
		 
		 while(leftPos<=leftEnd&&rightPos<=rightEnd) {
			 if(arr[leftPos]<=arr[rightPos])
				 tmpArr[tmpPos++] = arr[leftPos++];
			 else {
				 tmpArr[tmpPos++] = arr[rightPos++];
				 reversePair += leftEnd + 1 -leftPos;
				 reversePair %= 1000000007;
			 } 
		 }
		 while(leftPos<=leftEnd)
			 tmpArr[tmpPos++] = arr[leftPos++];
		 while(rightPos<=rightEnd)
			 tmpArr[tmpPos++] = arr[rightPos++];
		 
		 for(int i=length;i>0;i--, rightEnd--) {
			 arr[rightEnd] = tmpArr[rightEnd];
		 }
	 }
	 
	 public static void main(String[] args) {
		int[] arr = {8,5, 3, 4, 98, 23, 45};
		new InversePairs().InversePairs(arr);
		
		System.out.println(Arrays.toString(arr));
	}
}
