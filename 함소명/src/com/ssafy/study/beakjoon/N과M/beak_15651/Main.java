package com.ssafy.study.beakjoon.N과M.beak_15651;

import java.io.*;
import java.util.*;

/*
 * N과 M (3)
 * 중복 순열
 */
public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		recursive(0, new int[M]);
		bw.flush(); // 남아있는 데이터 모두 출력
		bw.close();
	}

	public static void recursive(int k, int[] M) throws IOException {
		if (k == M.length) {
			k = 0;

			for (int i = 0; i < M.length; i++) {
				bw.write(M[i] + " ");
			}
			bw.newLine();

			return;
		}

		for (int i = 1; i <= N; i++) {
			M[k] = i;
			recursive(k + 1, M);
		}

	}
}
