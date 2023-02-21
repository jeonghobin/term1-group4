package com.ssafy.study.beakjoon.backTracking.beak_1182;

import java.util.Scanner;

/*
 * 부분수열의 합
 * 조합
 */
public class Main {

	static int N;
	static int M;
	static int cnt;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

//		DFS();
		System.out.println(cnt);
	}

	public static void DFS(int aIdx, int[] sel, int sIdx, int sum) {
		if (M == sum) {
			cnt++;
		}
		
		if (sIdx > N) {
			return;
		}
		

		for (int i = aIdx; i < N; i++) {
			
			DFS(i, sel, sIdx+1, sum+arr[i]);
		}
	}

}
