/**   
* @Title: FindFirstCommonNode.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年5月6日 下午5:31:50 
* @version V1.0   
*/
package com.tyson.algorithm;

import java.util.HashMap;

/**  
* @ClassName: FindFirstCommonNode  
* @Description: TODO 
* @author Tyson
* @date 2018年5月6日 下午5:31:50  
*    
*/
public class FindFirstCommonNode {
	/*public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if(pHead1==null||pHead2==null)
			return null;
		
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        
        int count = 0;
        while(p1!=null&&p2!=null) {
        	p1 = p1.next;
        	p2 = p2.next;
        }
        
        if(p1!=null) {
	        while(p1!=null) {
	        	count ++;
	        	p1 = p1.next;
	        }
	        while(pHead1 != pHead2) {
	        	if(count-->0)
	        		pHead1 = pHead1.next;
	        	else {
	        		pHead1 = pHead1.next;
	        		pHead2 = pHead2.next;
	        	}
	        	if(pHead1 == pHead2)
	        		return pHead1;
	        }
        }
        if(p2!=null) {
        	while(p1!=null) {
        		count ++;
        		p2 = p2.next;
        	}
        	while(pHead1!=pHead2) {
        		if(count-->0)
        			pHead2 = pHead2.next;
        		else {
        			pHead1 = pHead1.next;
        			pHead2 = pHead2.next;
        		}
        		if(pHead1 == pHead2)
        			return pHead1;
        	}
        }
        
        return null;
    }*/
	
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		HashMap<ListNode, Integer> map = new HashMap<>();
		
		while(pHead1!=null) {
			map.put(pHead1, null);
			pHead1 = pHead1.next;
		}
		
		while(pHead2!=null) {
			if(map.containsKey(pHead2))
				return pHead2;
			pHead2 = pHead2.next;
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(5);
		ListNode l3 = new ListNode(6);
		ListNode l4 = new ListNode(9);
		//ListNode l5 = null;
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		
		ListNode l = new FindFirstCommonNode().FindFirstCommonNode(l1, l3);
		System.out.println(l.val);
	}
}
