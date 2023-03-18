package com.ssafy.study.beakjoon.치킨배달_1586;

import java.io.*;
import java.util.*;

/*
 * 문제
 * M개의 치킨집 고르고 최단 거리 치킨 거리 합 가장 낮은것 
 * 방법 1. 조합 -> 완탐
 * 방법 2. 조합 -> BFS(X) -> 메모리 초과
 */
public class Main {
	static int N, M, Ans;
	static int[][] street;
	static ArrayList<Point> chickenArr = new ArrayList<>();
	static ArrayList<Point> homeArr = new ArrayList<>();

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Ans = Integer.MAX_VALUE;

		street = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				street[i][j] = Integer.parseInt(st.nextToken());
				if (street[i][j] == 2)
					chickenArr.add(new Point(i, j));
				else if (street[i][j] == 1)
					homeArr.add(new Point(i, j));
			}
		}

		// n개에서 1개면 치킨집을 돌려서 집과의 거리 합 구하기
		// n개에서 2개면 nC2 조합을 돌려서 집과의 거리 합 구하기 -> 해당 집에 거리 저장
		// n개에서 r개 이하면 nC1~r까지 다 돌려서 거리 합 구하기 -> 해당 집에 거리 저장
		for (int i = 1; i <= M; i++) {
			recursive(new Point[i], 0, 0, new boolean[chickenArr.size()]);
		}

		System.out.println(Ans);
	}

	/*
	 * 완탐
	 */
	private static void recursive(Point[] sel, int sIdx, int aIdx, boolean[] v) {
		if (sIdx == sel.length) {

			int[] homeDistance = new int[homeArr.size()];
			Arrays.fill(homeDistance, Integer.MAX_VALUE);

			for (int i = 0; i < sel.length; i++) {
				for (int j = 0; j < homeArr.size(); j++) {
					int chickenDistance = Math.abs(sel[i].r - homeArr.get(j).r) + Math.abs(sel[i].c - homeArr.get(j).c);
					if (homeDistance[j] > chickenDistance)
						homeDistance[j] = chickenDistance;
				}
			}

			int cityDistance = 0;
			for (int i = 0; i < homeDistance.length; i++) {
				cityDistance += homeDistance[i];
			}
			Ans = Math.min(Ans, cityDistance);

			return;
		}

		for (int i = aIdx; i < chickenArr.size(); i++) {
			if (!v[i]) {
				v[i] = true;
				sel[sIdx] = chickenArr.get(i);
				recursive(sel, sIdx + 1, i, v);
				v[i] = false;
			}
		}
	}

	/*
	 * BFS 메모리 초과
	 */
//	private static void BFS(Point[] sel) {
//		Queue<Point> Q = new LinkedList<>();
//		boolean v[][] = new boolean[N + 1][N + 1];
//		int distance = 0;
//		int cnt = 0;
//
//		for (int i = 0; i < sel.length; i++) {
//			Q.add(sel[i]);
//		}
//
//		L: while (!Q.isEmpty()) {
//			Point p = Q.poll();
//
//			for (int i = 0; i < 4; i++) {
//				int nr = p.r + dr[i];
//				int nc = p.c + dc[i];
//
//				if (nr > 0 && nr <= N && nc > 0 && nc <= N) {
//					if (street[nr][nc] == 1 && !v[nr][nc]) {
//						v[nr][nc] = true;
//						distance += (p.cnt + 1);
//						cnt++;
//						if (homeCnt == cnt)
//							break L;
//					}
//
//					Q.add(new Point(nr, nc, p.cnt + 1));
//				}
//
//			}
//		}
//
//		min = Math.min(min, distance);
//	}

}
