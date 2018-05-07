/**   
* @Title: BinarySearchTreeToListNode.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年5月4日 下午8:04:32 
* @version V1.0   
*/
package com.tyson.algorithm;

import java.util.Stack;

/**  
* @ClassName: BinarySearchTreeToListNode  
* @Description: TODO 
* @author Tyson
* @date 2018年5月4日 下午8:04:32  
*    
*/
public class BinarySearchTreeToListNode {
	public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null)
        	return null;

        TreeNode result = null;
        result = convertNode(pRootOfTree, null);
        
        while(result != null && result.left != null)
        	result = result.left;
        return result;
    }
	
	
	public TreeNode convertNode(TreeNode current, TreeNode last) {
		if(current == null) 
			return null;
		
		if(current.left!= null)
			last = convertNode(current.left, last);
		
		current.left = last;
		
		if(last != null) 
			last.right = current;
		
		last = current;
		
		if(current.right != null) {
			last = convertNode(current.right, last);
		}
		return last;
	}
	
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(10);
		TreeNode t2 = new TreeNode(5);
		TreeNode t3 = new TreeNode(12);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(7);
		
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		
		TreeNode node = new BinarySearchTreeToListNode().Convert(t1);
		
		while(node != null) {
			System.out.println(node.val);
			node = node.right;
		}
	}
}
