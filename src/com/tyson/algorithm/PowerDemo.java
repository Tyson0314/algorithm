/**   
* @Title: PowerDemo.java 
* @Package com.tyson.offer 
* @Description: TODO 
* @author Tyson
* @date 2018年4月26日 上午7:40:33 
* @version V1.0   
*/
package com.tyson.algorithm;

/**  
* @ClassName: PowerDemo  
* @Description: TODO 
* @author Tyson
* @date 2018年4月26日 上午7:40:33  
*    
*/
public class PowerDemo {
	public static double Power(double base, int exponent) {
		boolean invalidInput = false;
		if(equal(base, 0)&&exponent == 0) {
			invalidInput = true;
			return 0;
		}
		if(equal(base, 0)) {
			return 0;
		}
		
		double result = 1;
		
		int exponentAbs = Math.abs(exponent);
		result = power(base, exponentAbs);
		
		if(exponent < 0) {
			result = 1/result;
		}
		return result;
	}
	
	public static double power(double base, int exponent) {
		if(exponent==1) {
			return base;
		}
		if(exponent==0) {
			return 1;
		}
		
		double result;
		result = power(base, exponent>>1);
		result = result * result;
		if((exponent&0x01)==1) {
			result = result * base;
		}
		return result;
	}
	
	public static boolean equal(double x, double y) {
		if(x - y<0.0000001&&y - x <0.000001) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(Power(5, 3));
	}
}
