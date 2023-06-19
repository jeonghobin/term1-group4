package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 디저트카페_2105 {
	static int N, sr, sc, max;
	static ArrayList<Integer> list;
	static int[][] map;
	static int[] dr = { 1, 1, -1, -1 };
	static int[] dc = { 1, -1, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			max = -1;
			for (int i = 0; i < N - 2; i++) {
				for (int j = 1; j < N - 1; j++) {
					sr = i;
					sc = j;
					list = new ArrayList<>();
					list.add(map[sr][sc]);
					boolean[][] v = new boolean[N][N];
					v[sr][sc] = true;
					dfs(sr, sc, 1, 0, list, v);
				}
			}

			System.out.println("#" + test_case + " " + max);

		}

	}

	private static void dfs(int r, int c, int cnt, int dir, ArrayList<Integer> list, boolean[][] v) {
		
		if (r == sr + 1 && c == sc - 1) {
			if (list.size() >= 4)
				max = Math.max(max, cnt);
			return;
		}

		for (int i = dir; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= N || nc >= N || nr < 0 || nc < 0) continue;

			if (!v[nr][nc] && check(map[nr][nc])) {
				v[nr][nc] = true;
				list.add(map[nr][nc]);
				dfs(nr, nc, cnt + 1, i, list, v);
				v[nr][nc] = false;
				list.remove(list.size() - 1);
			}
		}
	}

	private static boolean check(int num) {
		boolean ischeck = true;

		for (int n : list) {
			if (n == num)
				ischeck = false;
		}

		return ischeck;
	}

	static class Point{
		int r,c,cnt,dir;

		public Point(int r, int c, int cnt, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.dir = dir;
		}

	}
}
