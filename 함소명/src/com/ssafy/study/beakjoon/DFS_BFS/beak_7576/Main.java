package com.ssafy.study.beakjoon.DFS_BFS.beak_7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//토마토
//인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
//며칠이 지나면 토마토들이 모두 익는지,그 최소 일수를 구하는 프로그램을 작성하라
//정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸
//토마토가 모두 익지는 못하는 상황이면 -1을 출력
public class Main {
	static int[][] map;
	static int M;
	static int N;
	static int level;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		BFS();

	}

	static class Point {
		int r, c, cnt = 0;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void BFS() {
		Queue<Point> Q = new LinkedList<>();
		boolean[][] v = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					v[i][j] = true;
					Q.offer(new Point(i, j, 0));
				}
			}
		}

		while (!Q.isEmpty()) {
			Point p = Q.poll();
			for (int i = 0; i < 4; i++) {
				int dr = p.r + dx[i];
				int dc = p.c + dy[i];

				if (dr >= 0 && dr < N && dc >= 0 && dc < M && !v[dr][dc] && map[dr][dc] == 0) {
					v[dr][dc] = true;
					map[dr][dc] = 1;
					Q.offer(new Point(dr, dc, p.cnt + 1));
					level = Math.max(level, p.cnt + 1);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					level = -1;
			}
		}

		System.out.println(level);
	}

}
