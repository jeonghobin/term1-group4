package com.ssafy.study.beakjoon.backTracking.beak_1182_Re;

import java.util.Scanner;

/*
 * 부분수열의 합
 * 조합
 */
public class Main {

	static int N;
	static int M;
	static int cnt;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();// 정수 개수
		M = sc.nextInt();// 정수 합
		arr = new int[N];
		cnt = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		DFS(0, 0);

		// M이 0일때, sum이 0이니까 cnt가 올라가기때문에 -1 을 해주어야 한다.
		if (M == 0)
			System.out.println(cnt - 1);
		else
			System.out.println(cnt);
	}

	public static void DFS(int aIdx, int sum) {

		if (aIdx == N) {
			if (M == sum)
				cnt++;
			return;
		}

		DFS(aIdx + 1, sum + arr[aIdx]);
		DFS(aIdx + 1, sum);
	}

}
