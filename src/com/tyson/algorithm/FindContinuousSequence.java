/**   
* @Title: FindContinuousSequence.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年5月7日 下午4:57:01 
* @version V1.0   
*/
package com.tyson.algorithm;

import java.util.ArrayList;

/**  
* @ClassName: FindContinuousSequence  
* @Description: TODO 
* @author Tyson
* @date 2018年5月7日 下午4:57:01  
*    
*/
public class FindContinuousSequence {
	public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
       int begin = 1;
       int end = 2;
       int result = 0;
       
       if(sum<=0)
    	   return list;
       
       while(begin < (sum+1)/2) {   //退出循环条件
    	   result = 0;	//清零
    	   if(begin == end)
    		   break;
    	   for(int i=begin;i<=end;i++) {
        	   result += i;
           }
    	   if(result==sum) {
    		   ArrayList<Integer> l = new ArrayList<>();	//放到外面初始化，数据叠加
    		   for(int i=begin;i<=end;i++) {
            	   l.add(i);
               }
    		   list.add(l);
    		   begin += 2;
    		   end ++;
    	   }
    	   else if(result<sum) {
    		   end++;
    	   }
    	   else
    		   begin++;
       }
       return list;
    }
}
