/**   
* @Title: CompleteBinarySearchTree.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年4月30日 上午9:03:56 
* @version V1.0   
*/
package com.tyson.algorithm;

import java.util.Arrays;

/**  
* @ClassName: CompleteBinarySearchTree  
* @Description: TODO 
* @author Tyson
* @date 2018年4月30日 上午9:03:56  
*    
*/
public class CompleteBinarySearchTree {
	public int[] solve(int[] arr) {
		int[] treeArr = new int[arr.length];
		solve(arr, 0, arr.length-1, treeArr, 0);
		return treeArr;
	}
	
	public void solve(int[] arr, int left, int right, int[] treeArr, int treeRoot) {
		int n = right - left +1;
		if(n==0) return;  //边界条件
		int leftNum = findLeftNum(n);
		treeArr[treeRoot] = arr[leftNum+left];
		int leftRoot = 2*treeRoot + 1;
		int rightRoot = leftRoot + 1;
		
		solve(arr, left, left+leftNum-1, treeArr, leftRoot);
		solve(arr, left+leftNum+1, right, treeArr, rightRoot);
	}
	
	public int findLeftNum(int n) {
		if(n==1) return 0;  //边界条件
		int layer = (int) (Math.log(n + 1)/Math.log(2));
		int lastLayerNum = (int) (n - Math.pow(2, layer) + 1);

		return  (int) (lastLayerNum>(int) Math.pow(2, layer-1)?
				(Math.pow(2, layer-1) + Math.pow(2, layer-1) - 1):lastLayerNum + Math.pow(2, layer-1) - 1);
		/*int H=(int)(Math.log(N+1)/Math.log(2));  
	    int Up=(int)Math.pow(2,H-1)-1;  
	    int Down=(N+1-(int)Math.pow(2,H))>(int)Math.pow(2,H-1)?(int)Math.pow(2,H-1):(N+1-(int)Math.pow(2,H));  
	    return Up+Down;   */
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		arr = new CompleteBinarySearchTree().solve(arr);
		System.out.println(Arrays.toString(arr));
	}
}
