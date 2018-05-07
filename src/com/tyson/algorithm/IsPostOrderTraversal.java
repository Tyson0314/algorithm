/**   
* @Title: IsPostOrderTraversal.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年4月30日 下午6:01:28 
* @version V1.0   
*/
package com.tyson.algorithm;

/**  
* @ClassName: IsPostOrderTraversal  
* @Description: TODO 
* @author Tyson
* @date 2018年4月30日 下午6:01:28  
*    
*/
public class IsPostOrderTraversal {
	public boolean VerifySquenceOfBST(int [] sequence) {
		if(sequence.length == 0) 
			return false;
		return isPostOrderTraversal(sequence, 0, sequence.length-1);
    }
	public boolean isPostOrderTraversal(int [] arr, int left, int right) {
		if(left>=right) {
			return true;
		}
		int root = arr[right];
		
		int i=0;
		for(;i<right;i++) {
			if(arr[i]>root)
				break;
		}
		
		for(int j=i;j<right;j++) {
			if(arr[i]>root&&arr[j]<root)
				return false;
		}
		
		return isPostOrderTraversal(arr, left, i-1)&&
				isPostOrderTraversal(arr, i, right-1);
	}
}
