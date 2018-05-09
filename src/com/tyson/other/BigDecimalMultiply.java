/**   
* @Title: BigDecimalMultiply.java 
* @Package com.tyson.other 
* @Description: TODO 
* @author Tyson
* @date 2018年5月5日 下午7:51:09 
* @version V1.0   
*/
package com.tyson.other;

import java.math.BigDecimal;
import java.util.Scanner;

/**  
* @ClassName: BigDecimalMultiply  
* @Description: TODO 
* @author Tyson
* @date 2018年5月5日 下午7:51:09  
*    
*/
public class BigDecimalMultiply {
	
	
	public BigDecimal[] splitString(String s) {
		String[] strArr = s.split(" ");	
		BigDecimal[] bigArr = new BigDecimal[2];
		bigArr[0] = new BigDecimal(strArr[0]);
		bigArr[1] = new BigDecimal(strArr[1]);
		
		return bigArr;
	}
	
	public BigDecimal product(BigDecimal b1, BigDecimal b2) {
		return b1.multiply(b2);
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		BigDecimalMultiply b = new BigDecimalMultiply();
		
		BigDecimal[] bd = b.splitString(s);
		
		BigDecimal bd1 = b.product(bd[0], bd[1]);
		
		System.out.println(bd1);
	}
}

