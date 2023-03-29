package com.ssafy.study.LSJ;

import java.util.Scanner;

//아파트 색칠하기
public class DP_연습문제1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		//색칠할 방법의 수
		int[] dp = new int[N+1];
		
		//2층
		//노노//노파//파노
		//3층
		//노노노//노노파//노파노//파노노//파노파
		dp[0] = 1;
		dp[1] = 2;
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		System.out.println(dp[N]);
	}

}
