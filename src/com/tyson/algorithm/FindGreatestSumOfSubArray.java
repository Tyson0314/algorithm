/**   
* @Title: FindGreatestSumOfSubArray.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年5月3日 上午12:10:34 
* @version V1.0   
*/
package com.tyson.algorithm;

/**  
* @ClassName: FindGreatestSumOfSubArray  
* @Description: TODO 
* @author Tyson
* @date 2018年5月3日 上午12:10:34  
*    
*/
public class FindGreatestSumOfSubArray {
	 public int FindGreatestSumOfSubArray(int[] array) {
		 int maxSum = array[0];
		 int oldMaxSum = array[0];
	      for(int i=1;i<array.length;i++) {
              if(oldMaxSum<0)
	    		  oldMaxSum = array[i];
	    	  else
	    		  oldMaxSum += array[i];
	    	  if(oldMaxSum>maxSum) 
	    		  maxSum = oldMaxSum;
	      }
	      return maxSum;
	 }
	 
	 public static void main(String[] args) {
		
	}
}
