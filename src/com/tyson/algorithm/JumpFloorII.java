/**   
* @Title: JumpFloorII.java 
* @Package com.tyson.offer 
* @Description: TODO 
* @author Tyson
* @date 2018年4月26日 上午11:43:38 
* @version V1.0   
*/
package com.tyson.algorithm;

/**  
* @ClassName: JumpFloorII  
* @Description: TODO 
* @author Tyson
* @date 2018年4月26日 上午11:43:38  
*    
*/
public class JumpFloorII {
	public int JumpFloorII(int target) {
		if(target == 0) {
        	return 0;
        }
        int result = 1;
        
        result = jumpFloorII(target-1);
        
        return result;
    }
	public static int jumpFloorII(int target) {
        if(target == 1) {
        	return 2;
        }
        if(target == 0) {  //target为0时要判别
        	return 1;
        }
        
        int result = jumpFloorII(target>>1);
        result = result*result;
        
        if((target&0x01)==1) {
        	result = result*2;
        }
        
        return result;
	}

	
	public static void main(String[] args) {
		JumpFloorII jf = new JumpFloorII();
		System.out.println(jf.JumpFloorII(1));
	}
}
