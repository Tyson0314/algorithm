/**   
* @Title: MergeListNode.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年4月28日 下午7:48:25 
* @version V1.0   
*/
package com.tyson.algorithm;

/**  
* @ClassName: MergeListNode  
* @Description: TODO 
* @author Tyson
* @date 2018年4月28日 下午7:48:25  
*    
*/
public class MergeListNode {
public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null) 
        	return list2;
        if(list2 == null) 
        	return list1;

        ListNode merge = null;
        
        if(list1.val>list2.val) {
        	merge = list2;
        	merge.next = Merge(list1, list2.next);
        } else {
        	merge = list1;
        	merge.next = Merge(list1.next, list2);
        }
        
        return merge;
    }

	public static void main(String[] args) {
		ListNode l1 = new ListNode(11);
		ListNode l2 = new ListNode(24);
		ListNode l3 = new ListNode(30);
		
		l1.next = l2;
		l2.next = l3;
		
		ListNode l4 = new ListNode(40);
		ListNode l5 = new ListNode(55);
		ListNode l6 = new ListNode(86);
		
		l4.next = l5;
		l5.next = l6;
		
		ListNode l = new MergeListNode().Merge(l1, l4);
		
		l.print(l);
	}
}

