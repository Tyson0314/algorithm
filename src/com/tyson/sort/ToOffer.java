/**   
* @Title: ToOffer.java 
* @Package com.tyson.sort 
* @Description: TODO 
* @author Tyson
* @date 2018年4月16日 下午4:13:37 
* @version V1.0   
*/
package com.tyson.sort;

import java.util.ArrayList;
import java.util.Stack;

/**  
* @ClassName: ToOffer  
* @Description: TODO 
* @author A18ccms a18ccms_gmail_com  
* @date 2018年4月16日 下午4:13:37  
*    
*/
public class ToOffer {
	
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
			
		if(listNode==null) {
			return null;
		}
		
		while(listNode!=null) {
			stack.push(listNode.val);
			listNode = listNode.next;
		}
		
		while(!stack.isEmpty()) {
			list.add(stack.pop());
		}
		
		return list;
	}

	public static void main(String[] args) {
		/*final int ROW = 1000, COLUMN = ROW, NUM = ROW;
		Random rand = new Random();
		ToOffer to = new ToOffer();
		
		int[][] arr = new int[ROW][COLUMN];
		for(int i=0; i<ROW; i++) {
			for(int j=0; j<COLUMN; j++) {
				arr[i][j] = rand.nextInt(NUM);
				//System.out.print(arr[i][j] + " ");
				//System.out.print("ha");
			}
			//System.out.println();
		}
		
		System.out.println("----------------");
		
		long startTime = System.currentTimeMillis();
		boolean b = to.find(arr, rand.nextInt(ROW));
		long endTime = System.currentTimeMillis();
		
		System.out.println(b);	
		System.out.println(endTime - startTime);*/
		
		ToOffer to = new ToOffer();
		
		ListNode l1 = null;
		
		
		ArrayList<Integer> list = to.printListFromTailToHead(l1);
		
		System.out.println(list.get(0));
		
	}
}

class ListNode {
	int val;
	ListNode next = null;
	
	public ListNode(int val) {
		this.val = val;
	}
}
