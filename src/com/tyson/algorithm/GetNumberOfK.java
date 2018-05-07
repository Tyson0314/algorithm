/**   
* @Title: GetNumberOfK.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年5月7日 上午8:38:42 
* @version V1.0   
*/
package com.tyson.algorithm;

/**  
* @ClassName: GetNumberOfK  
* @Description: TODO 
* @author Tyson
* @date 2018年5月7日 上午8:38:42  
*    
*/
public class GetNumberOfK {
	public int GetNumberOfK(int [] array , int k) {
		if(array==null||array.length==0)
			return 0;
		int left, right;
		int pos = binarySearch(array, 0, array.length-1, k);
		
		left = pos;
		right = pos;
		int result = 0;
		for(int i=pos;i>=0;i--)
			if(array[i]==k)
				result++;
			else 
				break;
		for(int i=pos+1;i<array.length;i++)
			if(array[i]==k)
				result++;
			else
				break;
		
		/*while(right < array.length&&array[right+1] == k)
			right = binarySearch(array, right, array.length-1, k);*/
		
		return result;
    }
	public int binarySearch(int [] arr, int left, int right, int target) {
		if(left>right)
			return -1;
		if(left == right) 
			return arr[left]==target?left:-1;
		int mid = (left + right)/2;
		
		if(arr[mid] > target)
			return binarySearch(arr, left, mid-1, target);
		else if(arr[mid] < target)
			return binarySearch(arr, mid+1, right, target);
		else 
			return mid;
	}
	
	public static void main(String[] args) {
		int[] arr = {3,3,3,3,4,5};
		
		int num = new GetNumberOfK().GetNumberOfK(arr, 3);
		
		System.out.println(num);
	}
}
