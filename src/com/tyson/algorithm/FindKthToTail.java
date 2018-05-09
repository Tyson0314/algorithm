/**   
* @Title: FindKthToTail.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年4月27日 下午3:45:22 
* @version V1.0   
*/
package com.tyson.algorithm;

/**  
* @ClassName: FindKthToTail  
* @Description: TODO 
* @author Tyson
* @date 2018年4月27日 下午3:45:22  
*    
*/
public class FindKthToTail {
	public static ListNode FindKthToTail(ListNode head, int k) {
		if(head == null || k<=0)  //&&-->||
			return null;
		
		ListNode fast = head;
		ListNode slow = head;
		
		while(k-- > 1) {
			if(fast.next!=null)
				fast = fast.next;
			else 
				return null;
		}
		
		while(fast.next!=null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		return slow;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		
		l1.next = l2;
		l2.next = l3;
		
		ListNode l = FindKthToTail(l1, 1);
		System.out.println(l.val);
	}
}

class ListNode {
	int val;
	ListNode next = null;
	
	ListNode(int val) {
		this.val = val;
	}
	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}	
	
	public void print(ListNode l) {
		while(l!=null) {
			System.out.println(l.val);
			l = l.next;
		}
	}
}