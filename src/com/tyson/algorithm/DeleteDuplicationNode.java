/**   
* @Title: DeleteDuplicationNode.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年5月26日 下午9:20:36 
* @version V1.0   
*/
package com.tyson.algorithm;

/**  
* @ClassName: DeleteDuplicationNode  
* @Description: TODO 
* @author Tyson
* @date 2018年5月26日 下午9:20:36  
*    
*/
public class DeleteDuplicationNode {
	public ListNode deleteDuplication(ListNode pHead) {
		if(pHead == null)
            return pHead;
        ListNode first = new ListNode(-1);
        first.next = pHead;
        ListNode p = pHead;
        ListNode preNode = first;
        
        while(p != null && p.next != null) {
            if(p.val == p.next.val) {
                int val = p.val;
                
                while(p != null && p.val == val) {
                    p = p.next;
                }
                preNode.next = p;
            } else {
                preNode = p;  //preNode.next = p
                p = p.next;
            }
        }
        
        return first.next;
	}
	
	public ListNode deleteDuplication1(ListNode pHead)
    {
        if(pHead == null || pHead.next == null)
            return pHead;
        
        ListNode pre = new ListNode(-1);
        ListNode current = pHead;
        ListNode next = pHead;
        ListNode result = pre;
        
        while(current.next != null) {
            next = current.next;
            
            if(current.val == next.val) {
                while(next.next != null && current.val == next.val) {
                    next = next.next;
                }
                if(current.val == next.val)
                    break;
                else {
                    current = next;
                    pre.next = current;
                }
            }
            else {
                pre.next = current;
                pre = current;
                current = next;
            } 
        }
        
        return result.next;
    }
	
	public static void main(String[] args) {
		DeleteDuplicationNode ddn = new DeleteDuplicationNode();
		
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(3);
		ListNode l6 = new ListNode(3);
		ListNode l7 = new ListNode(4);
		ListNode l8 = new ListNode(4);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;
		
		ListNode l = ddn.deleteDuplication1(l1);
		
		while(l != null) {
			System.out.println(l.val);
			l = l.next;
		}
	}
}
