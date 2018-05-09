/**   
* @Title: TwoNumberSumS.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年5月7日 下午5:38:36 
* @version V1.0   
*/
package com.tyson.algorithm;

import java.util.ArrayList;

/**  
* @ClassName: TwoNumberSumS  
* @Description: TODO 
* @author Tyson
* @date 2018年5月7日 下午5:38:36  
*    
*/
public class TwoNumberSumS {
	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
		ArrayList<Integer> list = new ArrayList<>();
		if(array==null||array.length==0)
			return list;
		
        int begin = 0;
        int end = array.length - 1;
        int num1;
        int num2;
        
        while(begin <= end - 1) {
        	if(array[begin] + array[end] == sum) {
        		if(!list.isEmpty()) {
        			num1 = list.get(0);
            		num2 = list.get(1);
            		if(num1*num2>array[begin]*array[end]) {
            			list.clear();
            			list.add(array[begin]);
                    	list.add(array[end]);
            		}
        		}
        		else {
        			list.add(array[begin]);
                	list.add(array[end]);
        		}
            	begin++;
            	end--;
        	}	
        	else if(array[begin] + array[end] > sum) {
        		end--;
        	}
        	else
        		begin++;
        }
        return list;
    }
}
