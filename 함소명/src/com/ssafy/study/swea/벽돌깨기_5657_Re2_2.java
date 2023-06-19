package com.ssafy.study.swea;

import java.io.*;
import java.util.*;

public class 벽돌깨기_5657_Re2_2 {
	static int N, W, H;
	static int[][] map;
	static int min = Integer.MAX_VALUE;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

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
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());// 구슬을 쏠 수 있는 번수
			W = Integer.parseInt(st.nextToken());// 넓이
			H = Integer.parseInt(st.nextToken());// 높이
			map = new int[H][W];
			min = Integer.MAX_VALUE;

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// N번 구슬을 떨어뜨릴 지점을 구한다.
			dfs(new int[N], 0, 0);

			System.out.println("#" + test_case + " " + min);
		}
	}

	private static void dfs(int[] sel, int sIdx, int cnt) {
		if (sIdx == N) {// 구슬을 N번까지 쏜다.
//			System.out.println(Arrays.toString(sel));
			int[][] copyMap = new int[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					copyMap[i][j] = map[i][j];
				}
			}
			dfs2(copyMap, sel, 0);

			return;
		}

		// 구슬을 놓을 경우의 수 //같은 곳에도 놓을 수 있다.
		for (int j = 0; j < W; j++) {
			sel[sIdx] = j;
			dfs(sel, sIdx + 1, cnt);
		}
	}

	private static void dfs2(int[][] copyMap, int[] sel, int sIdx) {
		if (sel.length == sIdx) {
			int namBlock = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (copyMap[i][j] != 0)
						namBlock++;
				}
			}
			min = Math.min(min, namBlock);

			return;
		}

		boolean success = false;
		for (int h = 0; h < H; h++) {
			if (copyMap[h][sel[sIdx]] != 0) {
				Broken(copyMap, sel[sIdx], h);
				downBlock(copyMap);
				dfs2(copyMap, sel, sIdx + 1);
				success = true;
				break;
			}
		}
		if(!success)dfs2(copyMap, sel, sIdx + 1);
	}

	// 맨 위에 있는 벽돌을 깬다.
	private static void Broken(int[][] copyMap, int widx, int hidx) {
		Queue<Point> Q = new LinkedList<>();
		Q.add(new Point(hidx, widx));
		while (!Q.isEmpty()) {
			Point p = Q.poll();
			int num = copyMap[p.r][p.c];

			copyMap[p.r][p.c] = 0;

			for (int cur = 1; cur < num; cur++) {

				for (int i = 0; i < 4; i++) {
					int nr = p.r + (dr[i] * cur);
					int nc = p.c + (dc[i] * cur);

					if (nr < 0 || nr >= H || nc < 0 || nc >= W)
						continue;

					if (copyMap[nr][nc] != 0) {
						if (copyMap[nr][nc] != 1)
							Q.add(new Point(nr, nc));
						else
							copyMap[nr][nc] = 0;
					}
				}
			}
		}
	}
	//블록을 내린다
	private static void downBlock(int[][] copyMap) {
		for (int i = H - 1; i >= 0; i--) {
			for (int j = W - 1; j >= 0; j--) {
				if (copyMap[i][j] == 0) {
					int h = i;
					while (h >= 0) {
						if (copyMap[h][j] != 0) {
							copyMap[i][j] = copyMap[h][j];
							copyMap[h][j] = 0;
							break;
						}
						h--;
					}

				}
			}
		}
	}
}
