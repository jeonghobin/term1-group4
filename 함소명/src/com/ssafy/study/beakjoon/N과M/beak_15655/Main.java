package com.ssafy.study.beakjoon.N과M.beak_15655;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		recursive(arr, new int[M], 0, new boolean[N]);
	}

	private static void recursive(int[] arr, int[] sel, int sIdx, boolean[] v) {
		if (sIdx == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!v[i]) {
				v[i] = true;
				sel[sIdx] = arr[i];
				recursive(arr, sel, sIdx + 1, v);
				for (int j = i + 1; j < arr.length; j++) {
					v[j] = false;
				}
			}
		}
	}

}
