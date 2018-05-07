/**   
* @Title: ReBuildTree.java 
* @Package com.tyson.offer 
* @Description: TODO 
* @author Tyson
* @date 2018年4月22日 下午8:03:15 
* @version V1.0   
*/
package com.tyson.algorithm;

/**  
* @ClassName: ReBuildTree  
* @Description: TODO 
* @author A18ccms a18ccms_gmail_com  
* @date 2018年4月22日 下午8:03:15  
*    
*/
public class RebuildTree {
	
	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	    TreeNode() {	};
	    public void print() {
	    	print(this);
	    }
	    public void print(TreeNode t) {
	    	System.out.println(t.val);
	    	print(t.left);
	    	print(t.right);
	    }
	}
	
	static class Solution {
	    public TreeNode reConstructBinaryTree(int [] pre,int [] in) throws Exception {
	    	return reConstructBinaryTree(pre, 0, pre.length, in, 0, in.length);
	    }
	    public TreeNode reConstructBinaryTree(int[] pre, int preLeft,int preLength,
	    		int[] in, int inLeft, int inLength) throws Exception {
	    	if(preLength!=inLength) {
	    		throw new Exception("error");
	    	}
	    	if(preLength==1) {
	    		return new TreeNode(in[preLeft]);
	    	}
	    	if(preLength==0) {
	    		return null;
	    	}
	    	TreeNode t1 = new TreeNode(pre[preLeft]);
	    	int i=0;
	    	for(; i<inLength; i++) {
	    		if(in[i]==pre[preLeft]) {
	    			break;
	    		}
	    	}
	    	int x, y, p, q;
	    	x = i-preLeft;
	    	y =  preLeft+1+i-inLeft;
	    	p =  preLength-i+inLeft-1;
	    	t1.left = reConstructBinaryTree(pre, preLeft+1, i-inLeft, in, inLeft, i-inLeft);
	    	t1.right = reConstructBinaryTree(pre, preLeft+1+i-inLeft, preLength-i+inLeft-1, in, i+1, preLength-i+inLeft-1);
	    	return t1;
	    }
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		
		int[] arr1 = {1,2,4,7,3,5,6,8};
		int[] arr2 = {4,7,2,1,5,3,8,6};
		
		TreeNode t = new TreeNode();
		try {
			t = s.reConstructBinaryTree(arr1, arr2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		t.print();
	}
}
