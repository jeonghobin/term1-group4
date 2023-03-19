package com.ssafy.study.beakjoon.N과M.beak_15657;

import java.io.*;
import java.util.*;

/*
 * 조합
 */
public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
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

		recursive(arr, new int[M], 0, 0);
		bw.flush();
	}

	private static void recursive(int[] arr, int[] sel, int aIdx, int sIdx) throws IOException {
		if (sel.length == sIdx) {
			for (int i = 0; i < sel.length; i++) {
				bw.append(String.valueOf(sel[i] + " "));
			}
			bw.append("\n");
			return;
		}

		for (int i = aIdx; i < arr.length; i++) {
			sel[sIdx] = arr[i];
			recursive(arr, sel, i, sIdx + 1);
		}
	}

}
