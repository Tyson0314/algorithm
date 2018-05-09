/**   
* @Title: MirrorTree.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年4月28日 下午9:38:21 
* @version V1.0   
*/
package com.tyson.algorithm;

import java.util.Stack;

/**  
* @ClassName: MirrorTree  
* @Description: TODO 
* @author Tyson
* @date 2018年4月28日 下午9:38:21  
*    
*/
public class MirrorTree {
    /*运行时间31ms  占用内存9672k*/
	public static void Mirror(TreeNode root) {
		if(root == null) 
			return;
		
		Stack<TreeNode> s = new Stack<>();
		while(root!=null||!s.isEmpty()) {
			while(root!=null) {
				TreeNode tmp = root.left;
				root.left = root.right;
				root.right = tmp;
				s.push(root);
				root = root.left;
			}
			if(!s.isEmpty()) {
				root = s.pop();
				root = root.right;
			}
		}
	}
	/*运行时间16ms, 占用内存9556k*/
	public static void Mirror1(TreeNode root) {
		if(root == null)
			return ;
		
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		
		Mirror(root.left);
		Mirror(root.right);
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(5);
		TreeNode t2 = new TreeNode(6);
		TreeNode t3 = new TreeNode(8);
		TreeNode t4 = new TreeNode(3);
		TreeNode t5 = new TreeNode(2);
		TreeNode t6 = new TreeNode(4);
		TreeNode t7 = new TreeNode(7);

		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t5.right = t7;
		
		MirrorTree.Mirror1(t1);
		TreeNode.print(t1);
	}
}
