package com.ssafy.study.swea;

import java.util.Scanner;

/*
 * 한빈이와 Spot Mart
 * N개의 과자 봉지, 봉지는 ai그램의 무게, M 그램 이하, 과자 2봉지
 * 한빈이가 들고 다닐수 있는 과자들의 최대 무게 합
 */
public class D3_9229 {
	static int N;
	static int M;
	static int max = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int test_case = 1; test_case <= TC; test_case++) {
			N = sc.nextInt();// 과자 개수
			M = sc.nextInt();// M 무게
			max = -1;

			int[] snack = new int[N];
			for (int i = 0; i < N; i++) {
				snack[i] = sc.nextInt();
			}

			Rcursive(snack, new boolean[2], 0, 0, 0);

			System.out.println("#" + test_case + " " + max);
		}

	}

	public static void Rcursive(int[] arr, boolean[] sel, int k, int i, int weight) {

		if (sel.length == k) {
			if (weight > M)
				return;

			max = Math.max(max, weight);
			return;
		}

		for (int j = 0; j < arr.length; j++) {
//			if (!sel[k]) {
//				sel[k] = true;
				Rcursive(arr, sel, k + 1, j + 1, weight + arr[j]);
//				sel[k] = false;
//			}
		}

	}
}
