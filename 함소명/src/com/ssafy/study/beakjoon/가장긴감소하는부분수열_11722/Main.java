package com.ssafy.study.beakjoon.가장긴감소하는부분수열_11722;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, Ans;
	static int[] dp, arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		arr = new int[N+1];
		dp = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		// 완탐
		// 몇번째 수열, 현재 비교할 수열, 리턴한 횟 수
//		recursive(0, Integer.MAX_VALUE, 0);

		// 리턴 재귀//안해..
//		Ans = Math.max(Ans ,recursive2(0));

		// DP
		// 일반적인 규칙을 찾는것이 중요! 앞보다 뒤가 작으면 +1
		
		
		// 앞보다 뒤의 수가 작은 경우 수 담을 배열
		int[] dp = new int[N]; 
		Arrays.fill(dp, 1); // 기본 자신의 개수 1개씩 입력
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				//이전값들 보다 현재 값이 작은 경우 : cnt+1;
				//저장된게 있을 수 있으니 max값 구함
				if (arr[j] > arr[i]) {
					dp[i] = dp[j] + 1;
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			// 현재 개수와 dp[i]의 개수 중 더 큰 값
			Ans = Math.max(Ans, dp[i]);
		}

		System.out.println(Ans);
	}

	private static void recursive(int n, int num, int cnt) {
		if (n >= N) {
			Ans = Math.max(Ans, cnt);
			return;
		}

		for (int i = 0; i < N; i++) {
			// 감소한 수열이라면
			if (arr[i] < num)
				recursive(n + 1, arr[i], cnt + 1);

			// 감소한 수열이 아니라면
			recursive(n + 1, num, cnt);
		}
	}

	//내려오기
	private static int recursive2(int n) {
		if (n == N) {
			return 0;
		}
		
		if (arr[n] > arr[n+1]) return Integer.MIN_VALUE;

		Ans = 0;
		for (int i = n; i < N; i++) {
			Ans += Math.max(Ans, recursive2(i)+1);
		}

		return 1;
	}

}
