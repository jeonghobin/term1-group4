package com.ssafy.study.beakjoon.부분수열의합_1182;

import java.io.*;
import java.util.*;

/*
 * 조합?
 * Backtracking 
 */
public class Main {
	static int N, S, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			BackTracking(arr, new int[i], 0, 0, new boolean[N]);
		}

		System.out.println(cnt);
	}

	private static void BackTracking(int[] arr, int[] sel, int aIdx, int sIdx, boolean[] v) {
		if (sel.length == sIdx) {
			int sum = 0;
			for (int i = 0; i < sel.length; i++) {
				sum += sel[i];
			}
			if (sum == S)
				cnt++;
			return;
		}

		for (int i = aIdx; i < arr.length; i++) {
			if (!v[i]) {
				v[i] = true;
				sel[sIdx] = arr[i];
				BackTracking(arr, sel, i, sIdx + 1, v);
				v[i] = false;
			}
		}

	}

}
