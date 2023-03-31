package com.ssafy.study.beakjoon.일이삼더하기.더하기_9095;

import java.util.*;

public class Main {
	static int[] dp;
	static int Ans;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			Ans = 0;
			int N = sc.nextInt();
			
			//완탐
			recursive(N, 0, 0);
			
			// 1, 2, 3의 합으로 나타내는 방법의 수
			dp = new int[12];
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;

			// 하향식 DP
			int Ans = recursive_memo(N);

			System.out.println(Ans);
		}

	}

	private static int recursive_memo(int n) {
		if (n == 1)
			return 0;
		if (n == 2)
			return 0;
		if (n == 3)
			return 0;

		if (dp[n] != 0)
			return dp[n];

		return dp[n] = recursive_memo(dp[n - 1]) + recursive_memo(dp[n - 2]);
	}

	private static void recursive(int M, int k, int sum) {
		if (sum > M)
			return;
		if (sum == M) {
			Ans++;
			return;
		}

		for (int i = 1; i <= 3; i++) {
			recursive(M, i, sum + i);
		}
	}

}
