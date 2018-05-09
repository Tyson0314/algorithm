/**   
* @Title: IsBalancedTree.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年5月4日 上午12:07:16 
* @version V1.0   
*/
package com.tyson.algorithm;

/**  
* @ClassName: IsBalancedTree  
* @Description: TODO 
* @author Tyson
* @date 2018年5月4日 上午12:07:16  
*    
*/
public class IsBalancedTree {
	private boolean isBalanced = true;
	public boolean IsBalanced_Solution(TreeNode root) {
		if(root==null)
			return true;
		
		getHeight(root);
		
		return isBalanced;
    }
	
	public int getHeight(TreeNode root) {
		if(root == null)
			return 0;
		else {
			int left, right;
			left = getHeight(root.left);
			right = getHeight(root.right);
			
			if(right-left>1||left-right>1)
				isBalanced = false;
			
			return left>right?left+1:right+1;
		}	
			
	}
}
