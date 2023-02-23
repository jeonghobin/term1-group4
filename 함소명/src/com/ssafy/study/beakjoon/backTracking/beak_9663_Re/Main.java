package com.ssafy.study.beakjoon.backTracking.beak_9663_Re;

import java.util.Scanner;

/*
 * M-Queen
 */
public class Main {

	static int N, cnt;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];

		solve(0);
		System.out.println(cnt);
	}

	/**
	 * @param rowNo : 놓으려고 하는 퀸의 행 번호
	 * @param Queen : 1, blank : 0
	 */
	public static void solve(int r) {
		if (r == N) {
			cnt++;
			return;
		}

		for (int c = 0; c < N; c++) {
			if (check(r, c)) {
				map[r][c] = 1;
				solve(r + 1);
				map[r][c] = 0;
			}
		}

	}

	// r과 c위치에 퀸을 놓는 시점에 검사해야 하는 방향은
	// 좌상, 상, 우상 방향 검사.
	// 퀸이 있으면 false, 없으면 true
	// 위 삼방탐색은 바로 위만 검사해서 기각.
	private static boolean check(int r, int c) {
		// 좌상
		for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
			if (map[i][j] == 1)
				return false;
		}
		// 상
		for (int i = r; i >= 0; i--) {
			if (map[i][c] == 1)
				return false;
		}
		// 우상
		for (int i = r, j = c; i >= 0 && j < N; i--, j++) {
			if (map[i][j] == 1)
				return false;
		}

		return true;
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
