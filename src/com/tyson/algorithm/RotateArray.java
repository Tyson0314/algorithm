/**   
* @Title: RotateArray.java 
* @Package com.tyson.offer 
* @Description: TODO 
* @author Tyson
* @date 2018年4月24日 下午10:11:12 
* @version V1.0   
*/
package com.tyson.algorithm;

/**  
* @ClassName: RotateArray  
* @Description: TODO 
* @author Tyson
* @date 2018年4月24日 下午10:11:12  
*    
*/
public class RotateArray {
	public static void bubbleSort(int[] arr) {
		int tmp;
		int length = arr.length;
		for(int i=length-1;i>0;i--) 
			for(int j=0;j<i;j++) {
				if(arr[j]>arr[j+1]) {
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
	}
	
	public int minNumberInRotateArray(int [] arr) {
		int min = minNumberInRotateArray1(arr, 0, arr.length-1);
		return min;
	}
	
	public int minNumberInRotateArray1(int [] arr, int left, int right) {
		int mid = 0;
		
		while(!(arr[mid] == arr[left]&&arr[mid] == arr[right])) {
			mid = (left + right)/2;
			if(arr[mid]>arr[left]) {
				left = mid;
			}
			if(arr[mid]<arr[right]) {
				right = mid;
			}
		}
		
		/*if(arr[mid]>=arr[left]&&arr[mid]>=arr[right]) return arr[mid];
		if(arr[mid]<=arr[left]&&arr[left]>=arr[right]) return arr[left];
		if(arr[right]>=arr[left]&&arr[right]>=arr[mid]) return arr[right];
*/		
		if (arr[left] == arr[mid] && arr[mid] == arr[right]) {
			if (arr[left+1] != arr[right-1]) {
				mid = arr[left+1] < arr[right-1] ? left+1:right-1;
				} else {
					left++;
					right--;
				}
				} else {
				if (arr[left] <= arr[mid]) {
					left = mid;
				} else {
					right = mid;
				}
			}
		return 0;
	}
	//myMethod
	public int minNumberInRotateArray2(int [] arr) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i] < arr[arr.length-1]) {
				return arr[i];
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 56 , 89 , 7, 9, 23, 5, 12, 45};
		RotateArray ra = new RotateArray();
		
		bubbleSort(arr);
		int min = ra.minNumberInRotateArray(arr);
		
		System.out.println(min);
		
		/*for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}*/
	}
}
