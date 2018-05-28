/**   
* @Title: ReverseSentence.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年5月28日 下午10:12:51 
* @version V1.0   
*/
package com.tyson.algorithm;

/**  
* @ClassName: ReverseSentence  
* @Description: TODO 
* @author Tyson
* @date 2018年5月28日 下午10:12:51  
*    
*/
public class ReverseSentence {
	public String ReverseSentence(String str) {
        if(str == null || str.length() == 0)
            return "";
        
        if(str.equals(" "))
            return " ";
        
        String[] strArr = str.split(" ");
        
        reverse(strArr, 0, strArr.length-1);
        
        StringBuffer sb = new StringBuffer(strArr.length);
        for(String s : strArr)
            sb.append(s + " ");
        sb.deleteCharAt(sb.length() - 1);
        
        return sb.toString();
    }
    
    public void reverse(String[] arr, int low, int high) {
        String tmp;
        while(low<high) {
            tmp = arr[high];
            arr[high] = arr[low];
            arr[low] = tmp;
            
            high --;
            low ++;
        }
    }
    
    public static void main(String[] args) {
		String s = new ReverseSentence().ReverseSentence(" ");
		
		System.out.println("i" + s + "i");
	}
}
