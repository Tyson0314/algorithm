/**   
* @Title: UglyNum.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年5月6日 下午12:10:06 
* @version V1.0   
*/
package com.tyson.algorithm;

/**  
* @ClassName: UglyNum  
* @Description: TODO 
* @author Tyson
* @date 2018年5月6日 下午12:10:06  
*    
*/
public class UglyNum {
	public int GetUglyNumber_Solution(int index) {
		if(index<=0)
			return 0;
		
		int[] arr = new int[index];
		arr[0] = 1;
		int multiply2 = 0;
		int multiply3 = 0;
		int multiply5 = 0;
		
		int min;
		
		for(int i=1;i<index;i++) {
			min = Math.min(arr[multiply2]*2, Math.min(arr[multiply3]*3, arr[multiply5]*5));
			arr[i] = min;
		
			if(arr[multiply2]*2==min)
				multiply2++;
			if(arr[multiply3]*3==min)
				multiply3++;
			if(arr[multiply5]*5==min) 
				multiply5++;
		}
		
        return arr[index-1];
    }
	
	public static void main(String[] args) {
		int max = new UglyNum().GetUglyNumber_Solution(50);
		System.out.println(max);
	}
}
