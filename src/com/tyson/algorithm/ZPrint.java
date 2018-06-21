/**   
* @Title: ZhiPrint.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年6月3日 下午5:13:11 
* @version V1.0   
*/
package com.tyson.algorithm;

import java.util.ArrayList;
import java.util.Stack;

/**  
* @ClassName: ZPrint  
* @Description: TODO 
* @author Tyson
* @date 2018年6月3日 下午5:13:11  
*    
*/
public class ZPrint {
	public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> listResult = new ArrayList<>();
        
      
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        
        s1.push(pRoot);
        int layer = 1;
        while(!s1.empty() || !s2.empty()) {
            if(layer%2 != 0) {
                ArrayList<Integer> list = new ArrayList<>();
                
                while(!s1.empty()) {
                    pRoot = s1.pop();
                    
                    if(pRoot!=null) {
                        list.add(pRoot.val);
                        System.out.print(pRoot.val + " ");
                        if(pRoot.left != null)
                            s2.push(pRoot.left);
                        if(pRoot.right != null) 
                            s2.push(pRoot.right);  //s1 --> s2
                    }
                }
                if(!list.isEmpty()) {
                    listResult.add(list);
                    layer++;
                    System.out.println();
                }
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                
                while(!s2.empty()) {
                    pRoot = s2.pop();
                  
                    if(pRoot != null) {                       
                        list.add(pRoot.val);
                        System.out.print(pRoot.val + " ");
                        if(pRoot.right != null)
                            s1.push(pRoot.right);
                        if(pRoot.left != null) 
                            s1.push(pRoot.left);
                    }
                }
                if(list.size() != 0) {
                        listResult.add(list);
                        layer++;
                        System.out.println();
                    }
            }

        }
        
        return listResult;
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
		t3.right = t7;
		
		ArrayList<ArrayList<Integer>> listResult = new ArrayList<>();
		
		listResult = new ZPrint().Print(t1);
		
		Integer[] arr = new Integer[100];
	
		for(int i=0;i<listResult.size();i++)
			System.out.println(listResult.get(i));
	}
}
