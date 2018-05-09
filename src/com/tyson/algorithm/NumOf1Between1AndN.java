/**   
* @Title: NumOf1Between1AndN.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年5月3日 下午12:35:49 
* @version V1.0   
*/
package com.tyson.algorithm;

/**  
* @ClassName: NumOf1Between1AndN  
* @Description: TODO 
* @author Tyson
* @date 2018年5月3日 下午12:35:49  
*    
*/
public class NumOf1Between1AndN {
	public int NumberOf1Between1AndN_Solution(int n) {
		if(n<0)
			n = -n;
		if(n>0&&n<10) {
			return 1;
		}
		if(n==0) {
			return 0;
		}
		String s = String.valueOf(n);
		
		int firstNum = Integer.parseInt(s.substring(0, 1));
		
		int numFirstDigit = 0;
		if(firstNum>1) {
			numFirstDigit = (int) Math.pow(10, s.length()-1);
		} 
		if(firstNum==1){
			numFirstDigit = Integer.parseInt(s.substring(1)) + 1;
		}
		
		int numOtherDigit = 0;
		numOtherDigit = (int) (firstNum * (s.length()-1) * Math.pow(10, s.length()-2));
		
		int numRecursive = NumberOf1Between1AndN_Solution(Integer.parseInt(s.substring(1)));
	    return numFirstDigit + numOtherDigit + numRecursive;
    }
	
	public static void main(String[] args) {
		/*int n = 897;
		String s = String.valueOf(n);
		System.out.println(String.valueOf(n));
		System.out.println(s.indexOf(8+48));*/
		
		int num = new NumOf1Between1AndN().NumberOf1Between1AndN_Solution(231);
		System.out.println(num);
	}
}
