package com.ssafy.study.LSJ;

import java.util.Scanner;

//막대붙이기
public class DP_연습문제2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		
		//4 1 5 
		//파파파//파파노//파노파//파노노//
		dp[0] = 1;
		dp[1] = 2;
		for (int i = 2; i <= N; i++) {
			dp[i] = 2*dp[i-1]+dp[i-2];
		}
		System.out.println(dp[N]);
	}

}
