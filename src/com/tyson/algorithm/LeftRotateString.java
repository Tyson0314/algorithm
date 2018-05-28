/**   
* @Title: LeftRotateString.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年5月28日 下午9:41:41 
* @version V1.0   
*/
package com.tyson.algorithm;

/**  
* @ClassName: LeftRotateString  
* @Description: TODO 
* @author Tyson
* @date 2018年5月28日 下午9:41:41  
*    
*/
public class LeftRotateString {
	 public String LeftRotateString(String str,int n) {
	     if(str == null || str.length() == 0)
	    	 return "";
	     if(n>str.length())
	    	 return "";
	     
	     char[] chars = str.toCharArray();
	     reverse(chars, 0, chars.length - 1);
	     reverse(chars, 0, chars.length - n-1);
	     reverse(chars, chars.length - n, chars.length - 1);	 
	     
	     StringBuffer sb = new StringBuffer(chars.length);
	     for(char c: chars)
	    	 sb.append(c);
	     
	     return sb.toString();
	 }
	 
	 public void reverse(char[] arr, int low, int high) {
		 char tmp;
		 while(low<high) {
			 tmp = arr[high];
			 arr[high] = arr[low];
			 arr[low] = tmp;
			 
			 high--;
			 low++;
		 }
	 }
	 
	 public static void main(String[] args) {
		String s = new LeftRotateString().LeftRotateString("tyson", 2);
		
		System.out.println(s);
	}
}
