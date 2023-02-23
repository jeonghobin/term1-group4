package com.ssafy.study.beakjoon.backTracking.beak_15650_Re;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * N과 M (2)
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		recursive(0, new int[M], new boolean[N + 1]);
	}

	// k= index
	// b 중복 트리 막기
	public static void recursive(int sIdx, int[] sel, boolean[] v) {
		if (sIdx == sel.length) {

			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i < v.length; i++) {
			if (!v[i]) {
				v[i] = true;
				sel[sIdx] = i;
				recursive(sIdx + 1, sel, v);
				for (int j = i+1; j < v.length; j++) {
					v[j] = false;
				}
				
			}
			
		}
	}
}
