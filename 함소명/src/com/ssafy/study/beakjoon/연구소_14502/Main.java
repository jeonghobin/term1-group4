package com.ssafy.study.beakjoon.연구소_14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, Ans = Integer.MIN_VALUE;
	static int[][] map;
	static ArrayList<Point> virus = new ArrayList<>();
	static ArrayList<Point> empty = new ArrayList<>();
	static ArrayList<Point> kan = new ArrayList<>();
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 };

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 2)
					virus.add(new Point(i, j));
				if (map[i][j] == 1)
					kan.add(new Point(i, j));
				if (map[i][j] == 0)
					empty.add(new Point(i, j));
			}
		}

		ArrayList<Boolean> v = new ArrayList<>();
		for (int i = 0; i < empty.size(); i++) {
			v.add(false);
		}

		// 조합
		BackTracking(empty, new Point[3], 0, 0, v);

		System.out.println(Ans);
	}

	private static void BackTracking(ArrayList<Point> arr, Point[] sel, int aIdx, int sIdx, ArrayList<Boolean> v) {
		if (sel.length == sIdx) {
			BFS();
//			System.out.println(Arrays.toString(sel));
			return;
		}

		for (int i = aIdx; i < arr.size(); i++) {
			if (!v.get(i)) {
				v.set(i, true);
				Point p = arr.get(i);
				sel[sIdx] = p;
				map[p.r][p.c] = 1;
				BackTracking(arr, sel, i, sIdx + 1, v);
				map[p.r][p.c] = 0;
				v.set(i, false);
			}
		}

	}

	private static void BFS() {
		Queue<Point> Q = new LinkedList<>();
		boolean[][] v = new boolean[N][M];
		for (Point point : virus) {
			Q.add(point);
		}

		int cnt = 0;
		while (!Q.isEmpty()) {
			Point p = Q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				if (nr >= 0 && nc >= 0 && nr < N && nc < M && !v[nr][nc] && map[nr][nc] == 0) {
					cnt++;
					v[nr][nc] = true;
					Q.add(new Point(nr, nc));
				}
			}
		}

		int save = N * M - (virus.size() + cnt + kan.size() + 3);
		Ans = Math.max(Ans, save);

	}
}
