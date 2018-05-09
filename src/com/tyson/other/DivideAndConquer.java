package com.tyson.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DivideAndConquer {
	public int findMaxSum(int[] arrInt) {		
		long startTime = System.nanoTime();
		
		//数组只有一个元素，返回第一个数
		if(arrInt.length==1) {
			return arrInt[0];
		}
		
		int last = arrInt.length - 1;
		int mid = last/2;
		
		//左半边找子序列最大值
		int leftMaxSum=0, leftSum=0;
		for(int i=mid;i>=0;i--) {
			leftSum += arrInt[i];
			if(leftSum>leftMaxSum) {
				leftMaxSum = leftSum;
			}
		}
		//右半边找子序列最大值
		int rightMaxSum=0, rightSum=0;
		for(int i=mid+1;i<arrInt.length;i++) {
			rightSum += arrInt[i];
			if(rightSum>rightMaxSum) {
				rightMaxSum = rightSum;
			}
		}
		long endTime;
		if(rightMaxSum>leftMaxSum&&rightMaxSum>(rightMaxSum+leftMaxSum)) {
			endTime = System.nanoTime();
			System.out.println("程序运行时间：" + (endTime - startTime) + "ns");
			return rightMaxSum;
		} else if(leftMaxSum>rightMaxSum&&leftMaxSum>(leftMaxSum+rightMaxSum)) {
			endTime = System.nanoTime();
			System.out.println("程序运行时间：" + (endTime - startTime) + "ns");
			return leftMaxSum;
		} else {
			endTime = System.nanoTime();
			System.out.println("程序运行时间：" + (endTime - startTime) + "ns");
			return leftMaxSum + rightMaxSum;
		}
	}
	
/*	public int max(int a, int b, int c) {
		if(a>b&&a>c) {
			return a;
		} else if(b>a&&b>c) {
			return b;
		} else {
			return c;
		}		
	}*/
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		while(sc.hasNextInt()) {
			list.add(sc.nextInt());
		}
		int[] arrInt = new int[list.size()];
		for(int i=0;i<list.size();i++) {
			arrInt[i] = list.get(i);
			//System.out.println(arrInt[i]);
		}
		int sum = new DivideAndConquer().findMaxSum(arrInt);
		System.out.println(sum);
		
	}
}
