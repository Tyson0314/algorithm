/**   
* @Title: BubbleSort.java 
* @Package com.tyson.sort 
* @Description: TODO 
* @author Tyson
* @date 2018年4月16日 下午7:28:35 
* @version V1.0   
*/
package com.tyson.sort;

import java.util.Random;

/**  
* @ClassName: BubbleSort  
* @Description: TODO 
* @author A18ccms a18ccms_gmail_com  
* @date 2018年4月16日 下午7:28:35  
*    
*/
public class BubbleSort<Anytype extends Comparable<? super Anytype>> {
	public void bubbleSort(Anytype[] arr) {
		Anytype tmp;
		boolean flag = false;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length-1-i; j++) {
				if(arr[j+1].compareTo(arr[j])<0) {
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
					flag = true;
				}
			}
			if(flag==false) 
				break;
		}
	}
	
	/**  
	* @Title: main  
	* @Description: TODO 
	* @param @param args    
	* @return void  
	* @throws  
	*/
	public static void main(String[] args) {
		final int ROW = 100;
		Random rand = new Random();
		BubbleSort<Integer> bs = new BubbleSort<Integer>();
		
		Integer[] arr = new Integer[ROW];
		for(int i=0; i<ROW; i++) {
			arr[i] = rand.nextInt(ROW);
			//System.out.print(arr[i]);
		}
		
		System.out.println("----------------");

		long startTime = System.currentTimeMillis();
		bs.bubbleSort(arr);
		long endTime = System.currentTimeMillis();
		
		for(int i=0; i<ROW; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		System.out.println(endTime - startTime);
	}
}
