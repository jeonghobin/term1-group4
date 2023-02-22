package com.ssafy.study.beakjoon.DFS_BFS.beak_4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//섬의 개수
//섬과 바다 지도가 주어진다. 섬의 개수를 세는 프로그램을 작성
//가로, 세로 또는 대각선으로 연결
//1은 땅, 0은 바다
public class Main {
	static int[][] map;
	static int M;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());// 가로 길이
			N = Integer.parseInt(st.nextToken());// 세로 길이
			if (N == 0 && M == 0)
				break;

			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			bfs();
		}
	}

	static class Point {
		int r, c, cnt;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	// 8방탐
	static int[] dr = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dc = { 1, 1, 0, -1, -1, -1, 0, 1 };

	public static void bfs() {
		int level = 0;
		Queue<Point> Q = new LinkedList();
		boolean[][] v = new boolean[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 1) {
					Q.offer(new Point(r, c));
					v[r][c] = true;
					level++;

					while (!Q.isEmpty()) {
						Point p = Q.poll();
						map[p.r][p.c] = 0;
						for (int d = 0; d < 8; d++) {
							int nr = p.r + dr[d];
							int nc = p.c + dc[d];
							if (nr >= 0 && nr < N && nc >= 0 && nc < M && !v[nr][nc] && map[nr][nc] == 1) {

								map[nr][nc] = 0;
								v[nr][nc] = true;
								Q.add(new Point(nr, nc));
							}
						}
					}

				}
			}
		}

		System.out.println(level);
	}

}
