/**   
* @Title: BinarySort.java 
* @Package com.tyson.sort 
* @Description: TODO 
* @author Tyson
* @date 2018年5月20日 下午10:55:56 
* @version V1.0   
*/
package com.tyson.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**  
* @ClassName: BinarySort  
* @Description: TODO 
* @author Tyson
* @date 2018年5月20日 下午10:55:56  
*    
*/
public class BinarySort {
	public void binarySort(int[] arr) {
		if(arr == null || arr.length == 0) 
			return;
		
		int i=0;
		for(;i<arr.length - 1;i++) {
			if(arr[i] > arr[i+1])
				break;
		}
		
		for(int m=i+1;m<arr.length;m++) {
			int left = 0;
			int right = m - 1;
			int tmp = arr[m];
			
			while(left <= right) {
				int mid = (left + right)/2;
				if(arr[mid] > tmp)
					right = mid - 1;
				else
					left = mid + 1;
			}
			
			for(int j=m;j>left;j--) {
				arr[j] = arr[j-1];
			}
			
			arr[left] = tmp;
		}
		
	}
	
	public static void main(String[] args) {
		int[] arr = {12, 56, 89, 25, 36, 8};
		
		BinarySort bs = new BinarySort();
		bs.binarySort(arr);
		
		System.out.println(Arrays.toString(arr));
	}
}
