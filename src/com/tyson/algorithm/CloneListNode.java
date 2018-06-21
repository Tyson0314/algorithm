/**   
* @Title: CloneListNode.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年5月4日 下午3:22:03 
* @version V1.0   
*/
package com.tyson.algorithm;

/**  
* @ClassName: CloneListNode  
* @Description: TODO 
* @author Tyson
* @date 2018年5月4日 下午3:22:03  
*    
*/
public class CloneListNode {
	public RandomListNode Clone(RandomListNode pHead)
    {		
//        if(pHead == null) {
//        	return null;
//        }
//        
//        RandomListNode pClone = pHead;
//        
//        while(pClone!=null) {
//        	RandomListNode node = new RandomListNode(pClone.label);
//        	node.next = pClone.next;
//        	pClone.next = node;
//        	pClone = node.next;
//        }
//        
//        pClone = pHead;
//        while(pClone!=null) {
//        	if(pClone.random != null) 
//        		pClone.next.random = pClone.random.next;
//        	pClone = pClone.next.next;
//        }
//          
//        
//        RandomListNode head = pHead.next;
//        pClone = head;
//        RandomListNode pCur = pHead;
//        
//        while(pCur != null) {
//        	pCur.next = pCur.next.next;	//添加
//        	if(pClone.next != null) 
//        		pClone.next = pClone.next.next;
//        	pClone = pClone.next;
//        	pCur = pCur.next;
//        }
//        
//        return head;
		
		if(pHead == null)
            return null;
        
        RandomListNode node = pHead;
        
        while(node != null) {
            RandomListNode tmp = new RandomListNode(node.label);
            tmp.next = node.next;
            node.next = tmp;
            node = tmp.next;
        }
        
        node = pHead;
        while(node != null) {
            node.next.random = node.random;
            node = node.next.next;
        }
        
        RandomListNode result = pHead.next;
        RandomListNode head = result;
        node = pHead;
        while(head.next != null) {
            head.next = head.next.next;
            head = head.next;
        }
        
        return result;
    }
	public static void main(String[] args) {
		RandomListNode r1 = new RandomListNode(1);
		RandomListNode r2 = new RandomListNode(2);
		RandomListNode r3 = new RandomListNode(3);
		RandomListNode r4 = new RandomListNode(4);
		RandomListNode r5 = new RandomListNode(5);
		RandomListNode r6 = new RandomListNode(6);
		RandomListNode r7 = new RandomListNode(7);
		RandomListNode r8 = new RandomListNode(8);
		
		
		r1.next = r2;
		r2.next = r3;
		r3.next = r4;
		r4.next = r5;
		r5.next = r6;
		r6.next = r8;
		r8.next = r7;
		
		r2.random = r4;
		r3.random = r1;
		
		RandomListNode r = new CloneListNode().Clone(r1);
		
		System.out.println(r);
		
		System.out.println(r.next);
		
		while(r != null) {
			System.out.println(r.label);
			r = r.next;
		}
		
	}
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
