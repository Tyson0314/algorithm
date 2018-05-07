package com.tyson.other;

import java.util.Scanner;

public class PowerDemo {
	public long powerDemo(int x, int y) {
		if(y==0) {
			return 1;
		}
		while(y>1) {
			if(y%2==1)
				return x*powerDemo(x*x, y/2);
			else 
				return powerDemo(x*x, y/2);
		}
		return x;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		long power = new PowerDemo().powerDemo(x, y);
		
		System.out.println(power);
	}
}
