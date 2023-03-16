package com.ssafy.study.beakjoon.부등호_2529;

import java.io.*;
import java.util.*;

/*
 * 순열, 백트래킹
 */
public class Main {
	static String minStr = String.valueOf(Long.MAX_VALUE), maxStr = String.valueOf(Long.MIN_VALUE);

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];

		String[] budengho = new String[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			budengho[i] = st.nextToken();
		}

		recursive(budengho, new int[N + 1], 0, new boolean[10]);

		System.out.println(maxStr);
		System.out.println(minStr);
	}

	private static void recursive(String[] budengho, int[] sel, int sIdx, boolean[] v) {
		if (sIdx > 1) {
			if ("<".equals(budengho[sIdx - 2]) && sel[sIdx - 2] > sel[sIdx - 1])
				return;
			if (">".equals(budengho[sIdx - 2]) && sel[sIdx - 2] < sel[sIdx - 1])
				return;
		}

		if (sel.length == sIdx) {
			String num = "";
			for (int i = 0; i < sel.length; i++) {
				num += sel[i];
			}

			if (Long.parseLong(num) < Long.parseLong(minStr))
				minStr = num;
			if (Long.parseLong(num) > Long.parseLong(maxStr))
				maxStr = num;

			return;
		}

		for (int i = 0; i < 10; i++) {
			if (!v[i]) {
				sel[sIdx] = i;
				v[i] = true;
				recursive(budengho, sel, sIdx + 1, v);
				v[i] = false;
			}
		}
	}

}
