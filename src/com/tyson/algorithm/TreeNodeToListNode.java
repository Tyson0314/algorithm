/**   
* @Title: TreeNodeToListNode.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年6月20日 下午8:45:22 
* @version V1.0   
*/
package com.tyson.algorithm;

import java.util.Stack;

/**  
* @ClassName: TreeNodeToListNode  
* @Description: TODO 
* @author Tyson
* @date 2018年6月20日 下午8:45:22  
*    
*/
public class TreeNodeToListNode {
	public TreeNode1 Convert(TreeNode1 pRootOfTree) {
        if(pRootOfTree == null)
            return null;
        
        Stack<TreeNode1> s = new Stack<>();
        TreeNode1 left = null;
        TreeNode1 right = pRootOfTree;
        
        while(!s.isEmpty() || right != null) {
            while(right != null) {
                s.push(right);
                right = right.left;
            }
            
            if(!s.isEmpty()) {
                right = s.pop();
                if(left != null) {
                    left.right = right;
                    right.left = left;
                }
                left = right;
                right = right.right;
            }
        }
        
        return pRootOfTree;
    }
	public static void main(String[] args) {
		TreeNode1 t1 = new TreeNode1(1);
		TreeNode1 t2 = new TreeNode1(2);
		TreeNode1 t3 = new TreeNode1(3);
		TreeNode1 t4 = new TreeNode1(4);
		TreeNode1 t5 = new TreeNode1(5);
		
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		
		TreeNode1 result = new TreeNodeToListNode().Convert(t1);
		
		while(result.left != null) {
			result = result.left;
		}
		while(result != null) {
			System.out.println(result.val);
			result = result.right;
		}
	}
}

class TreeNode1 {
    int val = 0;
    TreeNode1 left = null;
    TreeNode1 right = null;

    public TreeNode1(int val) {
        this.val = val;

    }
}