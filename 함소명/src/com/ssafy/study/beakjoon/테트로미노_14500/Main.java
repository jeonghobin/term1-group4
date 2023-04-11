package com.ssafy.study.beakjoon.테트로미노_14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M, max;
	static int map[][];
	static Point start;

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		max = Integer.MIN_VALUE;
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(i, j);
			}
		}

		System.out.println(max);
	}

	private static void dfs(int r, int c) {

		// 가로 4칸
		int sum = 0;
		if (c + 3 < M) {
			for (int i = 0; i < 4; i++) {
				sum += map[r][i + c];
			}
		}
		max = Math.max(sum, max);

		// 세로 4칸
		sum = 0;
		if (r + 3 < N) {
			for (int i = 0; i < 4; i++) {
				sum += map[r + i][c];
			}
		}
		max = Math.max(sum, max);

		// 가로 3칸
		// ㅗ,ㄴ모양이 가질 수 있는 경우는 비슷하다.
		sum = 0;
		if (c + 2 < M) {
			int three = 0;
			// 가로 3칸
			for (int k = 0; k < 3; k++) {
				three += map[r][c + k];
			}

			if (r + 1 < N)
				for (int i = 0; i < 3; i++) {
					sum = map[r + 1][c + i] + three;// 아래쪽
					max = Math.max(max, sum);
				}
			if (r - 1 >= 0)
				for (int i = 0; i < 3; i++) {
					sum = map[r - 1][c + i] + three;// 위쪽
					max = Math.max(max, sum);
				}
		}

		// 세로 3칸
		sum = 0;
		if (r + 2 < N) {
			int three = 0;
			// 세로 3칸
			for (int k = 0; k < 3; k++) {
				three += map[r + k][c];
			}

			if (c + 1 < M)// 오른쪽
				for (int i = 0; i < 3; i++) {
					sum = map[r + i][c + 1] + three;
					max = Math.max(max, sum);
				}
			if (c - 1 >= 0)// 왼쪽
				for (int i = 0; i < 3; i++) {
					sum = map[r + i][c - 1] + three;
					max = Math.max(max, sum);
				}
		}

		// 가로 2칸
		sum = 0;
		if (c + 1 < M) {
			int two = 0;
			for (int k = 0; k < 2; k++) {
				two += map[r][c + k];
			}

			if (r + 1 < N) {// 아래쪽
				if (c - 1 >= 0) {// 왼
					sum = map[r + 1][c - 1] + map[r + 1][c] + two;
					max = Math.max(max, sum);
				}
				
				sum = map[r + 1][c] + map[r + 1][c + 1] + two;
				max = Math.max(max, sum);
				
				if (c + 2 < M) {// 오
					sum = map[r + 1][c + 1] + map[r + 1][c + 2] + two;
					max = Math.max(max, sum);
				}
			}
		}

		// 세로 2칸
		sum = 0;
		if (r + 1 < N) {
			int two = 0;
			for (int k = 0; k < 2; k++) {
				two += map[r + k][c];
			}

			if (c + 1 < M) {// 오른쪽
				if (r - 1 >= 0) {// 위
					sum = map[r - 1][c+1] + map[r][c+1] + two;
					max = Math.max(max, sum);
				}
				
				sum = map[r][c+1] + map[r+1][c+1] + two;
				max = Math.max(max, sum);
				
				if (r + 2 < N) {// 오
					sum = map[r + 1][c + 1] + map[r + 2][c + 1] + two;
					max = Math.max(max, sum);
				}
			}
		}
	}

}