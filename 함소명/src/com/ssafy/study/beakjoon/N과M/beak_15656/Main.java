package com.ssafy.study.beakjoon.N과M.beak_15656;

import java.io.*;
import java.util.*;

/*
 * N과 M(7)
 * 순열
 * bw.append("\n"); 로 담아 출력해야 시간초과가 나지 않는다.
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

		recursive(arr, new int[M], 0);
		bw.flush();
	}

	private static void recursive(int[] arr, int[] sel, int k) throws IOException {
		if (sel.length == k) {
			for (int i = 0; i < sel.length; i++) {
				bw.append(sel[i] + " ");
			}
			bw.append("\n");
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			sel[k] = arr[i];
			recursive(arr, sel, k + 1);
		}
	}

}
