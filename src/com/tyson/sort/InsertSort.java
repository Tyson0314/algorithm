/**   
* @Title: InsertSort.java 
* @Package com.tyson.sort 
* @Description: TODO 
* @author Tyson
* @date 2018年5月8日 下午12:53:24 
* @version V1.0   
*/
package com.tyson.sort;

/**  
* @ClassName: InsertSort  
* @Description: TODO 
* @author Tyson
* @date 2018年5月8日 下午12:53:24  
*    
*/
import java.util.Arrays;

public class InsertSort {
	public void insertSort(int [] arr) {
		int tmp;
		
		for(int i=1;i<arr.length;i++) {
			tmp = arr[i];
			int j=i-1;
			for(;j>0&&arr[j]>tmp;j--) {
				arr[j+1] = arr[j];
			}
			arr[j+1] = tmp;
		}
	}
	public static void main(String [] args) {
		int[] arr = {12, 89, 23, 45, 63 ,57};
		
		new InsertSort().insertSort(arr);
		
		System.out.println(Arrays.toString(arr));
	}
}
