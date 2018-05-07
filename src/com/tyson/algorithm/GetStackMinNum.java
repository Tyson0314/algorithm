/**   
* @Title: GetStackMinNum.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年4月30日 上午11:02:47 
* @version V1.0   
*/
package com.tyson.algorithm;

import java.util.Stack;

/**  
* @ClassName: GetStackMinNum  
* @Description: TODO 
* @author Tyson
* @date 2018年4月30日 上午11:02:47  
*    
*/
public class GetStackMinNum {
	Stack<Integer> s = new Stack<>();
	Stack<Integer> tmp = new Stack<>();
	
	public void push(int node) {
        s.push(node);
        
        if(!tmp.isEmpty()&&node<tmp.peek()) {
        	tmp.push(node);
        } else if(!tmp.isEmpty()&&node>=tmp.peek())
        {
        	tmp.push(tmp.peek());
        } else
        	tmp.push(node);
    }
    
    public void pop() {
        s.pop();
        tmp.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int min() {
        return tmp.peek();
    }
    
    public static void main(String[] args) {
		GetStackMinNum s = new GetStackMinNum();
		
		s.push(1);
		s.push(2);
		s.push(3);
		
		System.out.println(s.min());
	}
}
