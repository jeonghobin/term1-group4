package com.ssafy.study.swea;

import java.util.Arrays;
import java.util.Scanner;

//-> 2^N 가지 //2^10=1000 2^20=100만
public class 최장증가부분수열_D3_3307_LIVE {
	static int N, Ans = 1;
	static int[] arr;
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			Ans = 0;
			N = sc.nextInt();
			arr = new int[N + 1];
			dp = new int[N];

			for (int j = 0; j < N; j++) {
				arr[j] = sc.nextInt();
			}

//			//증가 수열 //완탐
//			for (int j = 0; j < N - 1; j++) {
//				recursive(j, 1);
//			}

			// 리턴 DP//안해...
//			for (int j = N - 1; j >= 0; j--) {
//				Ans = Math.max(Ans, recursive2(j));
//				System.out.println();
//			}

			//Live1 DP n^2
			//뒤 값이 더 크면 길이를 +1해서 저장
			for (int i = 0; i < N; i++) {
				dp[i] = 1;//자신만 끝에 세웠을 경우 길이는 1;
				for (int k = 0; k < i; k++) {//직전까지 돌려야하니까
					//전의 값들보다 크고 , 저장된 값보다 전에 저장된 값+1이 크다면
					if(arr[k] < arr[i] && dp[i]<dp[k]+1) {
						dp[i] = dp[k]+1;
					}
				}
				if(Ans<dp[i]) Ans = dp[i];
			}

			// Live2 DP 이진검색 활용-> 이진탐색은 원소가 정렬됐을 때만 쓸 수 있음
			// 뒤 값이 더 작으면, 자신이 들어갈 수 있는 지점을 찾아 작은 값을 dp에 change 저장
			// 위 탐색하는것을 이진 탐색으로 함
			// 뒤 값이 더 크면 길이가 늘어나서 뒤에 추가
			// 다 되면 점진적으로 증가되는 배열이 만들어짐
			// 어디까지 채워졌는지 길이가 Ans

			System.out.println("#" + test_case + " " + Ans);
		}
	}

	// 리턴 재귀
//	private static int recursive2(int n) {
//		if (n > N)
//			return 0;
//
//		Ans = 0;// 맨 끝에서부터 리턴값을 받아야하니까
//		for (int i = n+1; i < N; i++) {
//			if (arr[i] > arr[n]) {
//				Ans += Math.max(Ans, recursive2(i)+1);
//				System.out.println(Ans);
//			}
//		}
//
//		return Ans;
//	}
//	
	private static int recursive2(int n) {
		if (n == N - 1) {
			return 1;
		}
		
		if (n > Ans)
			return Integer.MAX_VALUE;


		Ans = 0;// 맨 끝에서부터 리턴값을 받아야하니까
		for (int i = n + 1; i < N; i++) {
			if (arr[i] > arr[n]) {
				Ans +=  Math.max(Ans, recursive2(n + 1) + 1);
			}
			System.out.println(Ans);
		}

		return Ans;
	}

	/*
	 * n : 올라가는 재귀 cnt : 증가한 수열 수
	 */
	private static void recursive(int n, int cnt) {
		if (n == N - 1) {
			Ans = Math.max(Ans, cnt);
			return;
		}

		if (arr[n] < arr[n + 1])
			recursive(n + 1, cnt + 1);

		recursive(n + 1, cnt);
	}

}
