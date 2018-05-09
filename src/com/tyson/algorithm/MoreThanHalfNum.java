/**   
* @Title: MoreThanHalfNum.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年4月30日 下午8:47:19 
* @version V1.0   
*/
package com.tyson.algorithm;

/**  
* @ClassName: MoreThanHalfNum  
* @Description: TODO 
* @author Tyson
* @date 2018年4月30日 下午8:47:19  
*    
*/
public class MoreThanHalfNum {
	public int MoreThanHalfNum_Solution(int [] array) {
        int count = 1;
        int maxCount = array[0];
        
        for(int i=1;i<array.length;i++) {
        	if(maxCount!=array[i]) {
        		if(count==0) {
        			maxCount=array[i];
        		} else {
        			count--;
        		}
        	} else {
        		count++;
        	}
        }
        
        count= 0;
        //check the number input
        for(int i=0;i<array.length;i++) {
        	if(array[i]==maxCount) {
        		count++;
        	}
        }
        
        if(count*2>array.length) {
        	return maxCount;
        } else {
        	return 0;
        }
    }
}
