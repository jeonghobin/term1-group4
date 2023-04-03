package com.ssafy.study.beakjoon.녹색옷입은애가젤다지_4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, Ans;
	static int[][] arr;
	static int[][] memo;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 };

	static class Point {
		int r, c, coin;

		public Point(int r, int c, int coin) {
			super();
			this.r = r;
			this.c = c;
			this.coin = coin;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		L :while (true) {
			cnt++;
			N = Integer.parseInt(br.readLine());
			Ans = Integer.MAX_VALUE;
			arr = new int[N][N];
			memo = new int[N][N];
			if (N == 0)
				break L;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					memo[i][j] = Integer.MAX_VALUE;
				}
			}

			BFS();

			System.out.println("Problem " + cnt + ": " + Ans);
		}
	}

	private static void BFS() {	
		Queue<Point> Q = new LinkedList<Point>();
		Q.add(new Point(0, 0, arr[0][0]));
		memo[0][0] = arr[0][0];
		while (!Q.isEmpty()) {
			Point p = Q.poll();

			if (p.r == N - 1 && p.c == N - 1) {
				Ans = Math.min(Ans, p.coin);
			}

			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;

				// 가중치 높은거 쳐내기
				if (memo[nr][nc] > p.coin + arr[nr][nc]) {
					memo[nr][nc] = p.coin + arr[nr][nc];
					Q.add(new Point(nr, nc, memo[nr][nc]));
				}
			}

		}

	}

}
