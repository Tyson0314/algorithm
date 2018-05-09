/**   
* @Title: TreeDepth.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年5月4日 上午12:03:27 
* @version V1.0   
*/
package com.tyson.algorithm;

/**  
* @ClassName: TreeDepth  
* @Description: TODO 
* @author Tyson
* @date 2018年5月4日 上午12:03:27  
*    
*/
public class TreeDepth {
	public int TreeDepth(TreeNode root) {
		if (root == null)
		return 0;
		int left = TreeDepth(root.left);
		int right = TreeDepth(root.right);
		return left > right ? left + 1 : right + 1;
	}
}
