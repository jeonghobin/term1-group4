package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class 프로세서연결하기_1767_RE2 {

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static int[][] map;
	static int N, minLineCnt,maxCoreCnt,connectedCore;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			minLineCnt = Integer.MAX_VALUE;
			maxCoreCnt = Integer.MIN_VALUE;

			ArrayList<Point> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						if (i == 0 || i == N - 1 || j == 0 || j == N - 1)
							continue;
						list.add(new Point(i, j));
					}
				}
			}

			// 1.조합으로 연결할수있는 코어가 많은경우부터 추출한다.
			for (int i = list.size(); i >= 0; i--) {
				connectedCore = i;
				recursive(list, new Point[i], new boolean[list.size()], 0, 0);
				if (minLineCnt != Integer.MAX_VALUE)
					break;
			}

			System.out.println("#" + test_case + " " + minLineCnt);
		}
	}

	private static void recursive(ArrayList<Point> list, Point[] sel, boolean[] v, int aIdx, int sIdx) {
		if (sel.length == sIdx) {
			// dfs로 모든 경우의 수 구하기
//			System.out.println(Arrays.toString(sel));
			dfs(sel, 0, 0);
			return;
		}

		for (int i = aIdx; i < list.size(); i++) {
			if (!v[i]) {
				v[i] = true;
				sel[sIdx] = list.get(i);
				recursive(list, sel, v, i, sIdx + 1);
				v[i] = false;
			}
		}
	}

	private static void dfs(Point[] sel, int cnt, int idx) {
		if (idx == sel.length) {
			// 현재 연결된 코어 수가 최대 코어 수와 같은 경우
	        minLineCnt = Math.min(cnt, minLineCnt); 
	        return;
		}

		for (int i = 0; i < 4; i++) {
			int r = sel[idx].r;
			int c = sel[idx].c;

			int cur = 0;
			boolean success = false;
			while (true) {
				r += dr[i];
				c += dc[i];

				//r==0과 같을때가 아니라 넘어갔을 때 성공한거임.
				if(r < 0 || r >= N || c < 0 || c >= N) {
					success = true;
					break;
				}
				
				if (map[r][c] != 0)
					break;

				map[r][c] = 2;
				cur++;

			}

			if (success) {
				dfs(sel, cnt+cur, idx + 1);
			}

			// 이상하면 돌아와서 다른 경로 봐야함 ->초기화시키자
			while (true) {
				r -= dr[i];
				c -= dc[i];

				if (r == sel[idx].r && c == sel[idx].c)
					break;
				
				map[r][c] = 0;
			}
		}

	}

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
}
