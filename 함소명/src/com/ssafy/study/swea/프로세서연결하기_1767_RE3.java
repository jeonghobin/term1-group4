package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class 프로세서연결하기_1767_RE3 {

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static int[][] map;
	static int N, maxCore, minLength;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			maxCore = Integer.MIN_VALUE;
			minLength = Integer.MAX_VALUE;

			ArrayList<Point> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (j > 0 && i > 0 && i < N - 1 && j < N - 1)
						if (map[i][j] == 1)
							list.add(new Point(i, j));
				}
			}

			// 순열로 연결할 코어 순서 뽑기 -> fail 조합으로 뽑아야 시초안남!!!!
			// 많은 코어를 연결할 수 있는 순서로 뽑기!!
			for (int i = list.size(); i >= 0; i--) {
				recursive(list, new Point[i], new boolean[list.size()], 0,0);
				if(minLength != Integer.MAX_VALUE)
					break;
			}
			

			System.out.println("#" + test_case + " " + minLength);
		}
	}

	private static void recursive(ArrayList<Point> list, Point[] sel, boolean[] v,int aIdx, int sIdx) {
		if (sel.length == sIdx) {
//			System.out.println(Arrays.toString(sel));
			dfs(sel, 0, 0);
			return;
		}

		for (int i = aIdx; i < list.size(); i++) {
			if (!v[i]) {
				v[i] = true;
				sel[sIdx] = list.get(i);
				recursive(list, sel, v, i, sIdx+1);
				v[i] = false;
			}
		}
	}

	private static void dfs(Point[] sel, int cnt, int len) {
		if (sel.length == cnt) {
			minLength = Math.min(minLength, len);
			return;
		}

		for (int i = 0; i < 4; i++) {
			Point p = sel[cnt];
			int nr = p.r;
			int nc = p.c;
			int length = 0;
			boolean success = false;

			while (true) {
				nr += dr[i];
				nc += dc[i];
				
				if (nr < 0 || nr > N - 1 || nc < 0 || nc > N - 1) {
					success  = true;
					break;
				}
				
				if (map[nr][nc] != 0)
					break;

				map[nr][nc] = 2;
				length++;
			}
			
			if(success)
				dfs(sel, cnt + 1, len + length);
			
			while (true) {
				nr -= dr[i];
				nc -= dc[i];
				
				if(map[nr][nc]==1)
					break;
				
				map[nr][nc] = 0;
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
