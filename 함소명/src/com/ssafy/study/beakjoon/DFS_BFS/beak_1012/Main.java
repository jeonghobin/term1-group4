package com.ssafy.study.beakjoon.DFS_BFS.beak_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//유기농 배추
//0은 배추가 심어져 있지 않은 땅이고, 1은 배추가 심어져 있는 땅
public class Main {
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());// 가로 길이
			int N = Integer.parseInt(st.nextToken());// 세로 길이
			int k = Integer.parseInt(st.nextToken());// 배추가 심어져 있는 위치의 개수

			map = new int[N][M];

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int Y = Integer.parseInt(st.nextToken());// 가로 길이
				int X = Integer.parseInt(st.nextToken());// 세로 길이

				map[X][Y] = 1;
			}

			bfs(N, M);

		}
	}

	static class Point {
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}

	}

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void bfs(int N, int M) {
		Queue<Point> Q = new LinkedList<Point>();
		boolean[][] v = new boolean[N][M];
		int total = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				
				if (map[i][j] == 1) {// 1이 잡히면
					total++;
					v[i][j] = true;
					Q.offer(new Point(i, j, 0));

					while (!Q.isEmpty()) {
						Point p = Q.poll();
						map[p.r][p.c] = 0;

						for (int k = 0; k < 4; k++) {
							int dr = p.r + dx[k];
							int dc = p.c + dy[k];

							if (dr >= 0 && dr < N && dc >= 0 && dc < M && !v[dr][dc] && map[dr][dc] == 1) {
								v[dr][dc] = true;
								map[dr][dc] = 0;
								Q.offer(new Point(dr, dc, p.cnt + 1));
							}
						}
					}
				}
			}
		}

		System.out.println(total);

	}
}
