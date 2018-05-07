/**   
* @Title: PrintMatrix.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年4月29日 下午9:52:07 
* @version V1.0   
*/
package com.tyson.algorithm;

import java.util.ArrayList;

/**  
* @ClassName: PrintMatrix  
* @Description: TODO 
* @author Tyson
* @date 2018年4月29日 下午9:52:07  
*    
*/
public class PrintMatrix {
	public ArrayList<Integer> printMatrix(int [][] matrix) {
		  ArrayList<Integer> list = new ArrayList<>();
		  
	       if(matrix == null)
	    	   return list;
	       
	       int start = 0;
	       int endX;
	       int endY;
	       
	       while(matrix.length>start*2&&matrix[0].length>start*2) {
	    	   endY = matrix.length - 1 - start;
		       endX = matrix[0].length - 1 - start;
		       
    		   for(int i=start;i<=endX;i++) {
    			   list.add(matrix[start][i]);
    		   }
	    	   
	    	   if(endY > start) {
	    		   for(int j=start+1;j<=endY;j++) {
	    			   list.add(matrix[j][endX]);
	    		   }
	    	   }
	    	   if(endX > start && endY > start) {
	    		   for(int m=endX-1;m>=start;m--) {
	    			   list.add(matrix[endY][m]);
	    		   }
	    	   }
	    	   if(endY > start + 1 && endX > start) {
	    		   for(int n=endY-1;n>start;n--) {
	    			   list.add(matrix[n][start]);
	    		   }
	    	   }
	    	   start++;
	       }
	       return list;
    }
	
	public static void main(String[] args) {
		int [][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
				{13, 14, 15, 16}};
		int [][] arr1 = {{1},{2},{3},{4},{5}};
		ArrayList<Integer> list = new PrintMatrix().printMatrix(arr1);
		
		System.out.println(list);
	}
}
