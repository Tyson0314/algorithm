/**   
* @Title: FindNumsAppearOnce.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年5月7日 下午4:37:05 
* @version V1.0   
*/
package com.tyson.algorithm;

/**  
* @ClassName: FindNumsAppearOnce  
* @Description: TODO 
* @author Tyson
* @date 2018年5月7日 下午4:37:05  
*    
*/
public class FindNumsAppearOnce {
	public void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array==null || array.length==0)
        	return;
        
        int num = array[0];
        for(int i=1;i<array.length;i++) {
        	num ^= array[i];
        }
        int indexOfBit1 = findFirstBit(num);
        
        num1[0] = 0;
        num2[0] = 0;
        for(int i=0;i<array.length;i++) {
        	if(((array[i]>>indexOfBit1)&1)==0) {
        		num1[0] ^= array[i];
        	} 
        	else 
        		num2[0] ^= array[i];
        }
    }
	public int findFirstBit(int num) {
		int indexOfBit1 = 0;
		while((num&1)==0) {
			num = num >> 1;
			indexOfBit1 ++;
		}
		return indexOfBit1;
	}
	
	public static void main(String[] args) {
		int x = new FindNumsAppearOnce().findFirstBit(8);
		
		System.out.println(x);
	}
}
