/**   
* @Title: IsPopOrder.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年4月30日 下午1:32:09 
* @version V1.0   
*/
package com.tyson.algorithm;

import java.util.Stack;

/**  
* @ClassName: IsPopOrder  
* @Description: TODO 
* @author Tyson
* @date 2018年4月30日 下午1:32:09  
*    
*/
public class IsPopOrder {
	 public boolean IsPopOrder(int [] pushA,int [] popA) {
		 if(pushA == null || popA == null) {
			 return false;
		 }
		 
		 Stack<Integer> s = new Stack<>();
		 int index = 0;
		 
		 for(int i=0;i<pushA.length;i++) {
			 s.push(pushA[i]);
			 while(!s.isEmpty()&&s.peek()==popA[index]) {
				 s.pop();
				 index++;
			 }
		 }
		 return s.isEmpty();
	 }
	 
	 public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		int[] arr1 = {4, 5, 3, 1, 2};
		System.out.println(new IsPopOrder().IsPopOrder(arr, arr1));
	}
}
