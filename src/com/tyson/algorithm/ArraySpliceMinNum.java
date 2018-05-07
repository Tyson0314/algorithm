/**   
* @Title: ArraySpliceMinNum.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年5月6日 上午11:56:03 
* @version V1.0   
*/
package com.tyson.algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**  
* @ClassName: ArraySpliceMinNum  
* @Description: TODO 
* @author Tyson
* @date 2018年5月6日 上午11:56:03  
*    
*/
public class ArraySpliceMinNum {
	 public String PrintMinNumber(int [] numbers) {
		 if(numbers==null||numbers.length==0)
			 return "";
		 String[] str = new String[numbers.length];
		 StringBuffer sb = new StringBuffer();
		 
		 for(int i=0;i<numbers.length;i++) {
			 str[i] = String.valueOf(numbers[i]);
		 }
		 
		 Arrays.sort(str, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				// TODO Auto-generated method stub
				String s = s1 + s2;
				String ss = s2 + s1;
				return s.compareTo(ss);
			}
		 });
		 
		 for(int i=0;i<numbers.length;i++) {
			 sb.append(str[i]);
		 }
		 
		 return sb.toString();
	 }
	 
}
