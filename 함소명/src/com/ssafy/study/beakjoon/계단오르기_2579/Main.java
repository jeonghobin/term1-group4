package com.ssafy.study.beakjoon.계단오르기_2579;

import java.util.Scanner;
import java.util.concurrent.RecursiveAction;

public class Main {
	static int N, min = Integer.MAX_VALUE;
	static int[] step;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		step = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			step[i] = sc.nextInt();
		}

		int[] dp = new int[N + 1];

		dp[1] = step[1];
		if (step.length > 2)
			dp[2] = Math.max(dp[1], dp[1] + step[2]);
		
		// 3번째 계단까지 연속해서 밟으면 안됨.
		// 3번째 계단에 갈 수 있는 경우 -> 1번 계단 밟고 3번 계단 or 2번 계단 밟고 3번 계단
		// 5번째 계단까지 확인해보면 규칙을 찾을 수 있음.
//		dp[3] = Math.max(dp[1],step[2]+dp[0])+step[3];

		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(step[i - 1] + dp[i - 3], dp[i - 2]) + step[i];
		}

		System.out.println(dp[N]);
	}
}
