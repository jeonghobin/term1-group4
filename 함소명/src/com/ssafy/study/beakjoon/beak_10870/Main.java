package com.ssafy.study.beakjoon.beak_10870;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		check(T,0,0,1);
	}
	public static void check(int t, int k, int sum, int temp) {
		if(k>=t) {
			System.out.println(sum);
			return;
		}
		
		check(t, k+1, temp+sum, temp=sum);
			
	}
}
