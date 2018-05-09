/**   
* @Title: PrintFromTopToBottom.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年4月30日 下午1:43:03 
* @version V1.0   
*/
package com.tyson.algorithm;

import java.util.ArrayList;
import java.util.Stack;

/**  
* @ClassName: PrintFromTopToBottom  
* @Description: TODO 
* @author Tyson
* @date 2018年4月30日 下午1:43:03  
*    
*/
public class PrintFromTopToBottom {
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        
        if(root == null) 
        	return list;
        
        Queue queue = new Queue();
        queue.enQueue(root);
        
        while(queue.size()!=0) {
        	root = queue.deQueue();
        	list.add(root.val);
        	if(root.left!=null||root.right!=null) {  //while->if
        		if(root.left!=null) 
        			queue.enQueue(root.left);
        		if(root.right!=null) {
        			queue.enQueue(root.right);
        		}
        	}
        }
        
        return list;
    }
	
	public static void main(String[] args) {
		PrintFromTopToBottom p = new PrintFromTopToBottom();
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
		ArrayList<Integer> list = p.PrintFromTopToBottom(t1);
		
		for(int node: list) {
			System.out.println(node);
		}
	}
}

class Queue {
	Stack<TreeNode> s2 = new Stack<>();
	Stack<TreeNode> s1 = new Stack<>();
	
	public void enQueue(TreeNode t) {
		s1.push(t);
	}
	
	public TreeNode deQueue() {
		if(!s2.isEmpty()||!s1.isEmpty()) {
			if(!s2.isEmpty()) {
				return s2.pop();
			} else {
				while(!s1.isEmpty()) {
					s2.push(s1.pop());
				}
				return s2.pop();
			}
		} else {
			return null;
		}
	}
	
	public int size() {
		return s1.size() + s2.size();
	}
}
