package com.ssafy.study.beakjoon.N과M.beak_15650_Re;

import java.io.*;
import java.util.*;

/*
 * N과 M (2)
 */
public class Main {
	// TODO N과 M에서 이것만 봐도될듯

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		recursive(0, new int[M], new boolean[N + 1]);
	}

	public static void recursive(int sIdx, int[] sel, boolean[] v) {
		if (sIdx == sel.length) {

			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i < v.length; i++) {
			if (!v[i]) {
				sel[sIdx] = i;
				v[i] = true;
				recursive(sIdx + 1, sel, v);
				for (int j = i + 1; j < v.length; j++) {
					v[j] = false;
				}

			}
		}
	}
}
