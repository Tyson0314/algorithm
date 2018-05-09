/**   
* @Title: StringPermutation.java 
* @Package com.tyson.algorithm 
* @Description: TODO 
* @author Tyson
* @date 2018年5月4日 下午10:12:00 
* @version V1.0   
*/
package com.tyson.algorithm;

import java.util.ArrayList;
import java.util.TreeSet;

/**  
* @ClassName: StringPermutation  
* @Description: TODO 
* @author Tyson
* @date 2018年5月4日 下午10:12:00  
*    
*/
public class StringPermutation {
	public ArrayList<String> Permutation(String str) {
		ArrayList<String> list = new ArrayList<>();
		TreeSet<String> t = new TreeSet<>();
		
		if(str == null || str.length()==0) {
			return list;
		}
		char[] chars = str.toCharArray();
		
		Permutation(chars, 0, t);
		
		list.addAll(t);
		
	    return list;
    }
	
	public void Permutation(char[] chars, int index, TreeSet<String> t) {
		if(chars == null || chars.length==0) 
			return;
		if(index < 0 || index>chars.length - 1)
			return;
		if(index == chars.length-1)
			t.add(String.valueOf(chars));
		else {
			for(int i=index; i<=chars.length-1;i++) {
				swap(chars, index, i);
				Permutation(chars, index+1, t);
				swap(chars, index, i);
			}
		}
	}
	
	public void swap(char[] c, int x, int y) {
		char tmp;
		tmp = c[x];
		c[x] = c[y];
		c[y] = tmp;	
	}
	
	public static void main(String[] args) {
		/*char[] c = {'a', 'b', 'n', 'o'};
		
		String s = Arrays.toString(c);
		System.out.println(s);
		System.out.println(s.length());*/
		
		String s = "Hello";
		
		ArrayList<String> list = new ArrayList<>();
		list = new StringPermutation().Permutation(s);
		
		System.out.println(list.size());
		for(String str : list) {
			System.out.print(str + " ");
		}
	}
}
