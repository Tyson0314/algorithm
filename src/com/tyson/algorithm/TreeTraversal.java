/**   
* @Title: TreePrint.java 
* @Package com.tyson.offer 
* @Description: TODO 
* @author Tyson
* @date 2018年4月23日 下午4:25:10 
* @version V1.0   
*/
package com.tyson.algorithm;

import java.util.Stack;

/**  
* @ClassName: Tree
* @Description: 非递归实现树的遍历
* @author Tyson  
* @date 2018年4月23日 下午4:25:10  
*    
*/
public class TreeTraversal {
	private TreeNode root;
	
	/**
	 * 
	* @ClassName: TreeNode  
	* @Description: 节点类 
	* @author Tyson
	* @date 2018年4月23日 下午7:44:18  
	*
	 */
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		public TreeNode() {
			
		}
		public TreeNode(int _val) {
			val = _val;
		}
		public TreeNode(int _val, TreeNode _left, TreeNode _right) {
			val = _val;
			left = _left;
			right = _right;
		}
	}
	
	public void insert(int x) {
		root = insert(x, root);
	}
	
	public TreeNode insert(int x, TreeNode t) {
		if(t == null)
			return new TreeNode(x);
		if(x > t.val) 
			t.right = insert(x, t.right);
		else 
			t.left = insert(x, t.left);
		return t;
	}
	
	public void preOrderTraversal() {
		preOrderTraversal(root);
	}
	/**
	 * 
	* @Title: preOrderTraversal  
	* @Description: 前序遍历 
	* @param     
	* @return void  
	* @throws
	 */
	public void preOrderTraversal(TreeNode t) {
		if(t == null)
			return;
		//存放节点
		Stack<TreeNode> stack = new Stack<>();
		
		while(t != null || stack.size()!=0) {
			while(t!=null) {
				stack.push(t);
				System.out.print(t.val+" ");
				t = t.left;
			}
			
			if(stack.size()!=0) {
				t = stack.pop();
				t = t.right;
			}
		}
	}
	
	public void inOrderTraversal() {
		inOrderTraversal(root);
	}
	/**
	 * 
	* @Title: inOrderTraversal  
	* @Description: 中序遍历 
	* @param     
	* @return void  
	* @throws
	 */
	public void inOrderTraversal(TreeNode t) {
		if(t == null)
			return;
		//存放节点
		Stack<TreeNode> stack = new Stack<>();
		
		while(t != null || stack.size()!=0) {
			while(t!=null) {
				stack.push(t);
				t = t.left;
			}
			
			if(stack.size()!=0) {
				t = stack.pop();
				System.out.print(t.val+" ");
				t = t.right;
			}
		}
	}

	
	public void postOrderTraversal() {
		postOrderTraversal(root);
	}
	/**
	 * 
	* @Title: postOrderTraversal  
	* @Description: 后序遍历
	* @param @param t    
	* @return void  
	* @throws
	 */
	public void postOrderTraversal(TreeNode t) {
		Stack<TreeNode> s = new Stack<>();
		TreeNode lastVisited = null;	//上一次访问的节点
		if(t == null)
			return;
		while(t != null) {
			s.push(t);
			t = t.left;
		}
		while(!s.isEmpty()) {
			t = s.pop();
			if(t.right!=null&&t.right!=lastVisited) {
				s.push(t);
				t = t.right;
				s.push(t);
				t = t.left;
				while(t != null) {
					s.push(t);
					t = t.left;
				}
			} else {
				System.out.print(t.val+" ");
				lastVisited = t;
			}
		}
	}
	
	public void levelOrderTraversal() {
		levelOrderTraversal(root);
	}
	/**
	 * 
	* @Title: levelOrderTraversal  
	* @Description: 层次遍历，用队列实现
	* @param @param t    
	* @return void  
	* @throws
	 */
	public void levelOrderTraversal(TreeNode t) {
		if(t == null) 
			return;
		Queue queue = new Queue();
		queue.enQueue(t);
		
		while(queue.size()!=0) {
			TreeNode t1 = queue.deQueue();
			System.out.print(t1.val + " ");
			if(t1.left!=null)
				queue.enQueue(t1.left);
			if(t1.right!=null) {
				queue.enQueue(t1.right);
			}
		}
	}
	/**
	 * 
	* @ClassName: Queue  
	* @Description: 队列实现
	* @author Tyson
	* @date 2018年4月23日 下午7:50:16  
	*
	 */
	class Queue {
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		
		public int size() {
			return s1.size() + s2.size();
		}
		
		public void enQueue(TreeNode t) {
			s1.push(t);
		}
		
		public TreeNode deQueue() {
			if(size()==0) 
				return null;
			if(s2.size()==0) {
				while(s1.size()!=0) {
					s2.push(s1.pop());
				}
			}
			return s2.pop();
		}
	}
	
	public static void main(String[] args) {
		TreeTraversal tree = new TreeTraversal();
		int[] arr = {5, 8, 12 , 1 , 4 , 7, 6, 10};
		
		for(int i=0; i<arr.length;i++) {
			tree.insert(arr[i]);
		}
		
		tree.preOrderTraversal();  //前序遍历
		System.out.println();      
		tree.inOrderTraversal();   //中序遍历
		System.out.println();
		tree.postOrderTraversal(); //后序遍历
		System.out.println();
		tree.levelOrderTraversal();//层次遍历
	}
}


