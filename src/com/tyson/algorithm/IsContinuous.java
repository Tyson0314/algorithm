/**   
* @Title: IsContinuous.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年5月26日 下午10:25:39 
* @version V1.0   
*/
package com.tyson.algorithm;

import java.util.Arrays;

/**  
* @ClassName: IsContinuous  
* @Description: TODO 
* @author Tyson
* @date 2018年5月26日 下午10:25:39  
*    
*/
public class IsContinuous {
	public boolean isContinuous(int [] numbers) {
		if(numbers == null || numbers.length == 0)
            return false;
        int count = 0;
        int diff = 0;
        Arrays.sort(numbers);
        
        for(int i=0;i<numbers.length-1;i++) {
            if(numbers[i] == 0) {
                count ++;
                continue;
            }
               if(numbers[i] == numbers[i+1])
                     return false;
            diff += numbers[i+1] - numbers[i] -1;  //diff+=... 
        }
        
        
        if(count >= diff)
            return true;
        return false;
    }
	
	public static void main(String[] args) {
		int[] arr = {1, 3, 2, 6, 4};
		
		boolean b = new IsContinuous().isContinuous(arr);
		
		System.out.println(Arrays.toString(arr));
		System.out.println(b);
	}
}
