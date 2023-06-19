package com.ssafy.study.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ShotGame_Re {
	static int N, max, sum;
	static int[] arr;
	static boolean[] v;// 터뜨린 풍선

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			v = new boolean[N];
			max = Integer.MIN_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			// 순열
			recursive(0, 0);

			System.out.println("#" + testCase + " " + max);
		}

	}

	private static void recursive(int idx, int sum) {
		if (idx == N) {
			max = Math.max(sum, max);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!v[i]) {
				v[i] = true;
				int score = boom(i);
				recursive(idx + 1, sum + score);
				v[i] = false;
			}
		}
	}

	private static int boom(int index) {
		int l = index - 1;
		while (l >= 0) {
			if (!v[l])
				break;
			l--;
		}
		int r = index + 1;
		while (r < N) {
			if (!v[r])
				break;
			r++;
		}

		if (l >= 0 && r < N)
			return arr[r] * arr[l];
		else if (l >= 0 && r >= N)
			return arr[l];
		else if (l < 0 && r < N)
			return arr[r];
		else
			return arr[index];
	}

}
