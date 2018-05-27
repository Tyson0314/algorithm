/**   
* @Title: EntryNodeOfLoop.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年5月26日 下午9:31:43 
* @version V1.0   
*/
package com.tyson.algorithm;

/**  
* @ClassName: EntryNodeOfLoop  
* @Description: TODO 
* @author Tyson
* @date 2018年5月26日 下午9:31:43  
*    
*/
public class EntryNodeOfLoop {
	public ListNode EntryNodeOfLoop(ListNode pHead) {
		if(pHead == null || pHead.next == null) {
			return null;
		}
		ListNode slow = pHead;
		ListNode fast = pHead;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				fast = pHead;
				while(fast != slow) {
					fast = fast.next;
					slow = slow.next;
				}
				
				if(fast == slow)
					return slow;
			}
		}
		
		return null;
	}
}
