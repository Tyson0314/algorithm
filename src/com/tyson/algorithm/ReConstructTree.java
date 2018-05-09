/**   
* @Title: ReConstructTree.java 
* @Package com.tyson.offer 
* @Description: TODO 
* @author Tyson
* @date 2018年4月22日 下午10:16:59 
* @version V1.0   
*/
package com.tyson.algorithm;

import java.util.Arrays;

import com.tyson.algorithm.RebuildTree.TreeNode;

/**  
* @ClassName: ReConstructTree  
* @Description: TODO 
* @author A18ccms a18ccms_gmail_com  
* @date 2018年4月22日 下午10:16:59  
*    
*/
public class ReConstructTree {
	//private static TreeNode root;
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
		TreeNode() {};
		
		 public void print() {
		    	print(this);
		    }
	    public void print(TreeNode t) {
	    	if(t != null) {
		    	print(t.left);
		    	print(t.right);
		    	System.out.println(t.val);
	    	}
	    }
		}
		public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
			/*if (pre == null || in == null) {
				return null;
			}*/
			if (pre.length == 0 || in.length == 0) {
				return null;
			}
			if (pre.length != in.length) {
				return null;
			}
			TreeNode root = new TreeNode(pre[0]);
			
			for (int i = 0; i < pre.length; i++) {
				if (pre[0] == in[i]) {
					root.left = reConstructBinaryTree(
					Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
					root.right = reConstructBinaryTree(
					Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
					break;
				}
			}
			return root;
		}
		
		public static void main(String[] args) {
			TreeNode t = new TreeNode();
			
			int[] arr1 = {1,2,4,7,3,5,6,8};
			int[] arr2 = {4,7,2,1,5,3,8,6};
			
			ReConstructTree r = new ReConstructTree();
			t = r.reConstructBinaryTree(arr1, arr2);

			t.print();
		}
}
