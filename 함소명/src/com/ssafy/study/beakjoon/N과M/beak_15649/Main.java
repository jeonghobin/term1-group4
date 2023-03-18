package com.ssafy.study.beakjoon.N과M.beak_15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * N과 M (1)
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		recursive(N, 0, new int[M], new boolean[N]);
	}

	// k= index
	// b 중복 트리 막기
	public static void recursive(int N, int k, int[] M, boolean[] b) {
		if (k == M.length) {
			k = 0;

			for (int i : M) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (b[i] == false) {
				b[i] = true;
				M[k] = i + 1;
				recursive(N, k + 1, M, b);
				b[i] = false;
			}
		}

	}
}
