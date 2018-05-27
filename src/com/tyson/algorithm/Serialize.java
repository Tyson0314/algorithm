/**   
* @Title: Serialize.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年5月26日 下午8:13:24 
* @version V1.0   
*/
package com.tyson.algorithm;

import java.util.Stack;

/**  
* @ClassName: Serialize  
* @Description: TODO 
* @author Tyson
* @date 2018年5月26日 下午8:13:24  
*    
*/
public class Serialize {
	private int index = -1;
	String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer("");
        
        if(root == null) {
        	sb.append("#,");
        	return sb.toString();
        }
        
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        
        return sb.toString();
  }
	
    TreeNode Deserialize(String str) {
    	index ++;
    	
    	String[] s = str.split(",");
    	TreeNode node = null;
    	
    	if(!s[index].equals("#")) {
    		node = new TreeNode(Integer.valueOf(s[index]));
    		node.left = Deserialize(str);
    		node.right = Deserialize(str);
    	}
    	
        return node;
  }
    
    public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		
		t1.left = t2;
		t1.right = t3;
		t2.right = t4;
		
		String s = new Serialize().Serialize(t1);
		TreeNode node = new Serialize().Deserialize(s);
		
		System.out.println(s);
		node.print(node);
	}
}
