package com.ssafy.study.beakjoon.beak_2798;

import java.util.Arrays;
import java.util.Scanner;

//구간 합 구하기 4
//카드의 합이 21을 넘지 않는 한도 내에서
//3장의 카드를 골라야 한다
public class Main2 {

	static int M;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		M = sc.nextInt();
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
	
		DFS(arr, new int[3], 0, 0, 0);
		System.out.println(max);
	}

	public static void DFS(int[] arr, int[] sel, int k, int idx, int sum) {
		if (sum > M)
			return;

		if (k == sel.length) {
			max = Math.max(max, sum);
			return;
		}

		for (int i = idx; i < arr.length; i++) {
			sel[k] = arr[i];
			DFS(arr, sel, k + 1,i+1, sum+arr[i]);
		}
	}
}
