/**   
* @Title: NumberOf1.java 
* @Package com.tyson.offer 
* @Description: TODO 
* @author Tyson
* @date 2018年4月26日 上午7:33:35 
* @version V1.0   
*/
package com.tyson.algorithm;

/**  
* @ClassName: NumberOf1  
* @Description: TODO 
* @author Tyson
* @date 2018年4月26日 上午7:33:35  
*    
*/
public class NumberOf1 {
	public static int numberOfOne(int n) {
		int count = 0;
		while(n!=0) {	//n>0,忽略了负数
			n = n & (n-1);
			count++;
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(numberOfOne(11));
	}
}
