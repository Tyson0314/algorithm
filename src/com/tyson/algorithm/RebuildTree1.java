/**   
* @Title: RebuildTree1.java 
* @Package com.tyson.offer 
* @Description: TODO 
* @author Tyson
* @date 2018年4月22日 下午9:43:44 
* @version V1.0   
*/
package com.tyson.algorithm;

/**  
* @ClassName: RebuildTree1  
* @Description: TODO 
* @author A18ccms a18ccms_gmail_com  
* @date 2018年4月22日 下午9:43:44  
*    
*/
public class RebuildTree1 {
	public static void solve(int[] pre, int[] in) {
		int[] post = new int[pre.length];
		solve(pre, in, post, 0, 0, 0, pre.length);
		for(int i=0; i<post.length;i++) {
			System.out.println(post[i]);
		}
	}
	public static void solve(int[] pre, int[] in, int[] post, int preL, int inL, int postL, int length) {
		int root = pre[preL];
		post[postL+length-1] = root;
		
		int i = 0;
		for(;i<length;i++) {
			if(in[0] == root)
				break;
		}
		
		int L = i;
		int R = length - L -1;
		
		solve(pre, in, post, preL+1, inL, postL, L);
		solve(pre, in, post, preL+L+1, inL+1+L, postL+L, R);
	}
	
	public static void main(String[] args) {
		int[] arr1 = {1,2,4,7,3,5,6,8};
		int[] arr2 = {4,7,2,1,5,3,8,6};
		
		solve(arr1, arr2);
	}
}
