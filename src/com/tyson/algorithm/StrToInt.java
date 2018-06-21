/**   
* @Title: StrToInt.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年6月8日 下午5:24:49 
* @version V1.0   
*/
package com.tyson.algorithm;

/**  
* @ClassName: StrToInt  
* @Description: TODO 
* @author Tyson
* @date 2018年6月8日 下午5:24:49  
*    
*/
public class StrToInt {
	public int strToInt(String str) {
		if(str == null || str.length() == 0)
            return 0;
        
        int index = 0;
        
        char[] chars = str.toCharArray();
        if(chars[index] == '+' || chars[index] == '-')
            index ++;
        
        int sum = 0;
        for(int i=index;i<chars.length;i++) {
            if(chars[i]<48 || chars[i]>57)
                return 0;
            int num = ((int)chars[i] - 48);
            double num10 = Math.pow(10, chars.length-1-i);
            sum += num*num10;
        }
        
        if(chars[0] == '-')
            return -sum;
        
        return sum;
	}
	
	public static void main(String[] args) {
		StrToInt si = new StrToInt();
		StringBuffer sb = new StringBuffer("");
		
		int num = si.strToInt("-2147483648");
		
		System.out.println(num);
		System.out.println(String.valueOf('c'));
	}
}
