/**   
* @Title: ReverseList.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年4月27日 下午4:13:55 
* @version V1.0   
*/
package com.tyson.algorithm;

/**  
* @ClassName: ReverseList  
* @Description: TODO 
* @author Tyson
* @date 2018年4月27日 下午4:13:55  
*    
*/
public class ReverseList {
	public static void reverseList(ListNode head) {
		if(head == null) 
			return;
		ListNode pre = null;
		ListNode current = head;
		ListNode next = null;
		
		while(current.next != null) {
			next = current.next;
			
			current.next = pre;
			pre = current;
			current = next;
		}
		current.next = pre;
		
		while(current!=null) {
			System.out.println(current.val);
			current = current.next;
		}
	}
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		
		l1.next = l2;
		l2.next = l3;
		
		reverseList(l1);
	}
}

