/**   
* @Title: HasSubTree.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年4月28日 下午8:19:05 
* @version V1.0   
*/
package com.tyson.algorithm;

/**  
* @ClassName: HasSubTree  
* @Description: TODO 
* @author Tyson
* @date 2018年4月28日 下午8:19:05  
*    
*/
public class HasSubtree {
	public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
		boolean result = false;
		
		if(root2 != null && root1 != null) {
			if(root1.val == root2.val) {
				result = doesTree1HasTree2(root1, root2);
			} 
			if(!result) {
				return HasSubtree(root1.left,root2) || HasSubtree(root1.right, root2);
			}
		}

		return result;
	}
	public static boolean doesTree1HasTree2(TreeNode node1, TreeNode node2) {
		if(node2 == null) {  //注意顺序！！！
			return true;
		}
		if(node1 == null) {
			return false;
		}
		if(node1.val != node2.val) {
			return false;
		}
		return doesTree1HasTree2(node1.left, node2.left) && 
				doesTree1HasTree2(node1.right, node2.right);
	}
	
	/**  
	* @Title: main  
	* @Description: TODO 
	* @param @param args    
	* @return void  
	* @throws  
	*/
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
		
		TreeNode t8 = new TreeNode(5, t4, t5);
		
		boolean b = HasSubtree.HasSubtree(t1, t8);
		TreeNode.print(t1);
		
		System.out.println(b);
	}
}

class TreeNode {
	int val;
	TreeNode left = null;
	TreeNode right = null;
	
	TreeNode(int val) {
		this.val = val;
		left = null;
		right = null;
	}
	
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	public static void print(TreeNode t) {
		if(t!=null) {
			System.out.print(t.val + " ");
			print(t.left);
			print(t.right);
		}
	}
}
