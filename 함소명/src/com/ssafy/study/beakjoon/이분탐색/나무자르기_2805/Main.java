package com.ssafy.study.beakjoon.이분탐색.나무자르기_2805;

import java.io.*;
import java.util.*;

public class Main {

	/*
	 * 나무 자르기 
	 * 이분탐색 
	 * 최댓값을 반으로 나눈 뒤
	 * 목표 값보다 낮으면 최솟값을 half+1 씩 높혀 탐색, 
	 * 목표 값보다 높으면 최댓값을 half부터 시작해 최솟값과 최댓값 사이 다시 탐색.
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());// 나무
		long M = Integer.parseInt(st.nextToken());// 가져갈 나무 길이

		st = new StringTokenizer(br.readLine());
		int[] trees = new int[N];
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(trees);

		int maxTree = trees[N - 1];
		int minTree = 0;		

		while (minTree < maxTree) {
			int half = (minTree + maxTree) / 2;
			long len = 0;

			for (int i = 0; i < trees.length; i++) {
				long cha = trees[i] - half;
				if (cha > 0)
					len += cha;
			}

			if (M > len) {
				maxTree = half;
			} else
				minTree = half + 1;
		}

		System.out.println(minTree - 1);

	}
}
