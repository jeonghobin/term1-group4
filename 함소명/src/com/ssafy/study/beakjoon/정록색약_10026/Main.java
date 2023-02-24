package com.ssafy.study.beakjoon.정록색약_10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 *  빨간색과 초록색의 차이를 거의 느끼지 못한다
 */

public class Main {
	static char[][] map;
	static boolean[][] v1;
	static boolean[][] v2;
	static int N;
	static int cnt;
	static int cntRG;

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	static class Point {
		int r, c, cnt, color;

		public Point(int r, int c, int color) {
			super();
			this.r = r;
			this.c = c;
			this.color = color;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", cnt=" + cnt + ", color=" + color + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		v1 = new boolean[N][N];
		v2 = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!v1[i][j]) {
					cnt++;
					DFS(i, j);
				}
			}
		}

		System.out.println(cnt);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'G')
					map[i][j] = 'R';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!v2[i][j]) {
					cntRG++;
					DFS2(i, j);
				}
			}
		}

		System.out.println(cntRG);

	}

	/*
	 * 일반인 탐색
	 */
	private static void DFS(int r, int c) {

		v1[r][c] = true;

		for (int i = 0; i < 4; i++) {
			int dx = r + dr[i];
			int dy = c + dc[i];

			if (dx >= 0 && dy >= 0 && dx < N && dy < N && !v1[dx][dy]) {
				if (map[r][c] == map[dx][dy])
					DFS(dx, dy);
			}
		}
	}

	/*
	 * 정록색약 탐색
	 */
	private static void DFS2(int r, int c) {

		v2[r][c] = true;

		for (int i = 0; i < 4; i++) {
			int dx = r + dr[i];
			int dy = c + dc[i];

			if (dx >= 0 && dy >= 0 && dx < N && dy < N && !v2[dx][dy]) {
				if (map[r][c] == map[dx][dy])
					DFS2(dx, dy);
			}
		}
	}

}
