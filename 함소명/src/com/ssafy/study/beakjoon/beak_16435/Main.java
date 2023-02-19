package com.ssafy.study.beakjoon.beak_16435;

import java.util.Arrays;
import java.util.Scanner;

//스네이크버드
//과일 하나를 먹으면 길이가 1만큼 늘어납니다.
//i (1 ≤ i ≤ N) 번째 과일의 높이는 hi입니다
//자신의 길이보다 작거나 같은 높이에 있는 과일들을 먹을 수 있습니다.
//처음 길이가 L일때 과일들을 먹어 늘릴 수 있는 최대 길이
public class Main {
	static int N;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 과일의 개수
		int L = sc.nextInt();// 초기 길이

		int sum = L;
		int[] fruit = new int[N];
		for (int i = 0; i < N; i++) {
			fruit[i] = sc.nextInt();
		}
		Arrays.sort(fruit);

		Recursive(fruit, new boolean[N], 0, L);
		System.out.println(max);
	}

	// 과일, 인덱스, 스네이크 길이
	public static void Recursive(int[] fruit, boolean[] v, int k, int sum) {
		if (k == fruit.length) {
			max = Math.max(max, sum);
			return;
		}

		if (!v[k]) {
			v[k] = true;
			if (sum >= fruit[k])
				sum++;
			Recursive(fruit, v, k + 1, sum);
			v[k] = false;
		}

	}

}
