/**   
* @Title: FibonacciSequence.java 
* @Package com.tyson.offer 
* @Description: TODO 
* @author Tyson
* @date 2018年4月25日 下午9:39:46 
* @version V1.0   
*/
package com.tyson.algorithm;

/**  
* @ClassName: FibonacciSequence  
* @Description: TODO 
* @author Tyson
* @date 2018年4月25日 下午9:39:46  
*    
*/
public class FibonacciSequence {
	public int Fibonacci(int n) {
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		
		int preOne = 1;
		int preTwo = 0;
		int current = 0;
		
		int i = 2;
		while(i<=n) {
			current = preOne + preTwo;
			preTwo = preOne; //次序颠倒，数据覆盖导致出错
			preOne = current; 
			i++;
		}
		
		return current;
	}
	
	public static int rectangle(int n) {
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		if(n == 2) {
			return 2;
		}
		
		int i = 3;
		
		int two = 2;
		int one = 1;
		int num = 0;
		
		while(i<=n) {
			num = one + two;
			one = two;
			two = num;
			i++;
		}
		return num;
	}
	
	public static void main(String[] args) {
		FibonacciSequence fs = new FibonacciSequence();
		
		//System.out.println(fs.Fibonacci(5));
		System.out.println(rectangle(4));
		
	}
}
