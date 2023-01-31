package com.ssafy.study.beakjoon.beak_2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	// 나무 자르기
	// N개의 수직선 위에 C개의 공유기설치 시, 공유기 사이의 거리는 가능한 크게 설치
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer number = new StringTokenizer(str);
		int N = Integer.parseInt(number.nextToken());
		int M = Integer.parseInt(number.nextToken());

		StringTokenizer Trees = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(Trees.nextToken());
		}
		Arrays.sort(arr);

		int max = arr[N - 1];// 가장 큰 나무의 높이
		int min = 0;

		while (min < max) {
			int mid = (max + min) / 2;// 중간값 = 나무를 자른 위치
			long sum = 0;

			for (int tree : arr) {
				if (tree - mid > 0)
					sum += tree - mid;
			}

			if (sum < M)// 합이 더 낮다는 것은 자르는 위치가 높다는 의미로 낮춰야함.
				max = mid;
			else
				min = mid + 1;// 합이 더 크다는 것은 자르는 위치가 낮다는 더 높게 잘라야함.
		}

		System.out.println(min - 1);

	}
}
