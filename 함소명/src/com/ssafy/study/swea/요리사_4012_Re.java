package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 4012. [모의 SW 역량테스트] 요리사
 * ij ji 12 21 34 43 24 42 13 31
 * 두 음식 맛 차이 최소값은?
 * 식재료의 수는 N, 뽑은 식재료는 /2 -> 뽑은 식재료의 조합 합이 시너지.
 * 
 * 접근 -> 시너지 합. 조합
 */
public class 요리사_4012_Re {
	static int N;
	static int min;// 최소 차
	static int[] S;// 시너지
	static int[][] ingredents;
	static boolean[] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			ingredents = new int[N][N];
			min = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					ingredents[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 1. A음식 B음식 뽑기.조합.
			// 2. 재료를 각각 조합하기.순열
			select(0, new int[N / 2], 0);

			System.out.println("#"+test_case+" "+min);
		}
	}

	static int Asum = 0;
	static int Bsum = 0;

	// 재료 뽑기
	public static void select(int aIdx, int[] Asel, int sIdx) {
		if (Asel.length == sIdx) {
			Asum = 0;
			Bsum = 0;
			
			int[] Bsel = new int[N/2];
			
			boolean[] v = new boolean[N];
			for (int i = 0; i < Asel.length; i++) {
				v[Asel[i]] = true;
			}

			int idx = 0;
			for (int i = 0; i < v.length; i++) {
				if (!v[i]) {
					Bsel[idx] = i;
					idx++;
				}
			}

			// A음식
			combinationA(Asel, new boolean[Asel.length], new int[2], 0);

			// B음식
			combinationB(Bsel, new boolean[Bsel.length], new int[2], 0);

			min = Math.min(min, Math.abs(Asum-Bsum));
			
			return;
		}

		for (int i = aIdx; i < N; i++) {
			Asel[sIdx] = i;
			select(i + 1, Asel, sIdx + 1);
		}
	}
	

	public static void combinationA(int[] arr, boolean[] v, int[] sel, int sIdx) {
		if (sIdx == sel.length) {
			Asum += ingredents[sel[0]][sel[1]];
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!v[i]) {
				v[i] = true;
				sel[sIdx] = arr[i];
				combinationA(arr, v, sel, sIdx + 1);
				v[i] = false;
			}
		}
	}

	public static void combinationB(int[] arr, boolean[] v, int[] sel, int sIdx) {
		if (sIdx == sel.length) {
			Bsum += ingredents[sel[0]][sel[1]];
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!v[i]) {
				v[i] = true;
				sel[sIdx] = arr[i];
				combinationB(arr, v, sel, sIdx + 1);
				v[i] = false;
			}
		}
	}
}
