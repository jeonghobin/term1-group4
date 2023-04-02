package com.ssafy.study.beakjoon.일이삼더하기.더하기_9095;

import java.util.*;

public class Main {

	static int N, Ans;
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 0; t < T; t++) {
			N = sc.nextInt();
			Ans = 0;

//			// 백트래킹
//			backtracking(0);

			// 백트래킹 리턴
//			Ans = returnback(0);

//			// DP
//			dp = new int[N+1];
//			Arrays.fill(dp, -1);
//			Ans = recursive(0);
			
			//점화식
	        dp[1] = 1;
	        dp[2] = 2;
	        dp[3] = 4;
	        for (int i = 4; i <= N; i++) {
	            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
	        }
	        Ans = dp[N];

			
			System.out.println(Ans);
		}
	}

	private static void backtracking(int n) {
		if (n > N)
			return;

		if (n == N) {
			Ans++;
			return;
		}

		for (int i = 1; i <= 3; i++) {
			backtracking(n + i);
		}
	}

	private static int returnback(int n) {
		if (n > N)
			return 0;

		if (n == N) {
			return 1;
		}

		Ans = 0;//맨 끝에서부터 리턴값을 받아야하니까
		for (int i = 1; i <= 3; i++) {
			Ans += returnback(n + i);
		}
		 
		return Ans;
	}
	
	
	//dp 배열은 재귀 인자와 같게 한다.
	//dp[2] = 2;
	//dp[3] = 4;
	private static int recursive(int n) {
		if (n > N)
			return 0;

		if (n == N) {
			return 1;
		}
		
		if(dp[n]!=-1) return dp[n];

		Ans = 0;//맨 끝에서부터 리턴값을 받아야하니까
		//n이 될 수 있는 경우 수 리턴
		//24, 13, 7, 4, 2, 1
		for (int i = 1; i <= 3; i++) {
			Ans += recursive(n + i);
		}
		
		dp[n] = Ans;
		 
		return dp[n];
	}

}
