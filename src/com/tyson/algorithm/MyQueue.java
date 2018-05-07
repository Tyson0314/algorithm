/**   
* @Title: MyStack.java 
* @Package com.tyson.offer 
* @Description: TODO 
* @author Tyson
* @date 2018年4月22日 上午9:07:34 
* @version V1.0   
*/
package com.tyson.algorithm;

import java.util.Stack;

/**  
* @ClassName: MyStack  
* @Description: TODO 
* @author A18ccms a18ccms_gmail_com  
* @date 2018年4月22日 上午9:07:34  
*    
*/
public class MyQueue<Anytype> {
	Stack s1 = new Stack();
	Stack s2 = new Stack();
	Stack stack1 = new Stack();
	Stack stack2 = new Stack();
	
	public void push(int node) {
		stack1.push(node);
		}
		public int pop() throws Exception {
		if (stack1.isEmpty() && stack2.isEmpty()) {
		throw new Exception("栈为空！");
		}
		if (stack2.isEmpty()) {
		while(!stack1.isEmpty()) {
		stack2.push(stack1.pop());
		}
		}
		return (int) stack2.pop();
		}
	
	
	/*public void enQueue(Anytype x) {
		s1.push(x);
	}
	
	public Anytype deQueue() {
		Anytype tmp;
		if(!s2.isEmpty()) {
			return (Anytype) s2.pop();
		} 
		else if(s2.isEmpty()&&!s1.isEmpty()) {
			while(!s1.isEmpty()) {
				tmp = (Anytype) s1.pop();
				s2.push(tmp);
			}
			return (Anytype) s2.pop();
		}
		return null;*/

	
	public static void main(String[] args) throws Exception {
		/*MyQueue q = new MyQueue();
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		q.enQueue(4);
		
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());
		System.out.println(q.deQueue());*/
		
		MyQueue q = new MyQueue();
		q.push(1);
		q.push(2);
		q.push(3);
		q.push(4);
		
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());
		System.out.println(q.pop());
	}
}
