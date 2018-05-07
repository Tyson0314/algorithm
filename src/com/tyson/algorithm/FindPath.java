/**   
* @Title: FindPath.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年4月30日 下午6:42:38 
* @version V1.0   
*/
package com.tyson.algorithm;

import java.util.ArrayList;

/**  
* @ClassName: FindPath  
* @Description: TODO 
* @author Tyson
* @date 2018年4月30日 下午6:42:38  
*    
*/
public class FindPath {
	ArrayList<ArrayList<Integer>> listResult = new ArrayList<>();
	ArrayList<Integer> list = new ArrayList<>();
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null)
        	return listResult;
        list.add(root.val);
        target -= root.val;
        
        if(target == 0&&root.left==null&&root.right==null) 
        	listResult.add(new ArrayList<>(list));   //list-->new ArrayList<>(list)
        else {
        	FindPath(root.left, target);
        	FindPath(root.right, target);
        }
        list.remove(list.size()-1);
        
        return listResult;
    }
	
	public static void main(String[] args) {
		/*ArrayList list = new ArrayList();
		list.add(1);
		list.add(2);
		
		list.remove(1);
		System.out.println(list.get(0));*/
		
		TreeNode t1 = new TreeNode(10);
		TreeNode t2 = new TreeNode(5);
		TreeNode t3 = new TreeNode(12);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(7);
		
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		
		ArrayList<ArrayList<Integer>> list = new FindPath().FindPath(t1, 22);
		
		for(ArrayList l : list) {
			System.out.println(l);
		}
	}
}
