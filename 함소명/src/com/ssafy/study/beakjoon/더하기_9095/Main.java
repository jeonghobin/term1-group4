package com.ssafy.study.beakjoon.더하기_9095;

import java.util.*;

public class Main {

	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			cnt = 0;
			int num = sc.nextInt();
			recursive(num, 0, 0);
			System.out.println(cnt);
		}

	}

	private static void recursive(int M, int k, int sum) {
		if (sum > M)
			return;
		if (sum == M) {
			cnt++;
			return;
		}

		for (int i = 1; i <= 3; i++) {
			recursive(M, i, sum + i);
		}

	}

}
