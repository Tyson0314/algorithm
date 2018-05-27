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
}
