/**   
* @Title: BinarySearch.java 
* @Package com.tyson.offer 
* @Description: TODO 
* @author Tyson
* @date 2018年4月26日 下午12:11:34 
* @version V1.0   
*/
package com.tyson.algorithm;

/**  
* @ClassName: BinarySearch  
* @Description: TODO 
* @author Tyson
* @date 2018年4月26日 下午12:11:34  
*    
*/
public class BinaryInsert {
	public static void binaryInsert(int[] arr) {
		int i =0;
		for(;i<arr.length;i++) {
			if(arr[i]>arr[i+1])
				break;
		}
		
		
		int left;
		int right;
		int mid;
		int tmp;
		for(; i<arr.length-1;i++) {   //i写成right
			left = 0;
			right = i;
			tmp= arr[i+1];
			
			while(left<=right) {
				mid = (left+right)/2;
				if(arr[mid]>tmp)
					right = mid - 1;
				else
					left = mid + 1;
			}
			  
			for(int j=i;j>=left;j--) {
				arr[j+1] = arr[j];
			}
			
			arr[left] = tmp;
		}
	}
	public static void main(String[] args) {
		int[] arr = {4, 6, 88, 1, 23, 12, 5};
		binaryInsert(arr);
		
		for(int i = 0; i<arr.length;i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
