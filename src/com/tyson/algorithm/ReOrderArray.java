/**   
* @Title: reOrderArray.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年4月27日 下午2:43:32 
* @version V1.0   
*/
package com.tyson.algorithm;

import java.util.Arrays;

/**  
* @ClassName: reOrderArray  
* @Description: TODO 
* @author Tyson
* @date 2018年4月27日 下午2:43:32  
*    
*/
public class ReOrderArray {
	public static void reOrderArray(int[] array) {
		if(array == null) {
			return;
		}
		int left = 0;
		int right = array.length - 1;
		
		while(left<right) {
			while(left<right&&isEven(array[left])) left++;
			while(left<right&&!isEven(array[right])) right--;
			
			if(left<right) 
				swap(array, left, right);
		}
	}
	
	public static void reOrderArray1(int [] array) {
		for(int i=0;i<array.length;i++) {
			if((array[i]&0x01)==1) continue;
			else {
				int j = i + 1;
				while(j<array.length&&(array[j]&0x01)!=1) j++;
				if(j==array.length-1&&(array[j]&0x01)==0)
					break;
				else {
					int tmp = array[i];
					
					//for(int m=j;m>)
				}
					
			}
		}
	}
	
	public static boolean isEven(int n) {
		if((n&0x01)==1) 
			return true;
		else
			return false;
	}
	public static void swap(int [] arr, int x, int y) {
		int tmp;
		tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}
	public static void main(String[] args) {
		int[] arr = {4, 23 , 5, 89 , 78};
		reOrderArray1(arr);
	
		//System.out.println(Arrays.toString(arr));
	}
	
}
