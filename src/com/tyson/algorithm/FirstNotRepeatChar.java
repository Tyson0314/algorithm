/**   
* @Title: FirstNotRepeatChar.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年5月6日 下午5:16:33 
* @version V1.0   
*/
package com.tyson.algorithm;

import java.util.LinkedHashMap;

/**  
* @ClassName: FirstNotRepeatChar  
* @Description: TODO 
* @author Tyson
* @date 2018年5月6日 下午5:16:33  
*    
*/
public class FirstNotRepeatChar {
	public int FirstNotRepeatingChar(String str) {
		if(str==null||str.length()==0)
			return -1;
		
		LinkedHashMap<Character, Integer> hash = new LinkedHashMap<>();
		char[] chars = str.toCharArray();
		
		for(char c : chars) 
			if(hash.containsKey(c))
				hash.put(c, hash.get(c) + 1);
			else 
				hash.put(c, 1);
		
		
		for(int i=0;i<chars.length;i++) 
			if(hash.get(chars[i])==1)
				return i;
		
        return -1;
    }
	
	public static void main(String[] args) {
		
	}
}
