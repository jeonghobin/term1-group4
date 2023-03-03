package com.ssafy.study.LSJ;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//최소 거리가 아닌 최소 연료!경로 가중치! DFS
public class 산악구조로봇 {
	static int N;
	static int[][] map;
	static boolean[][] v;
	static int min;
	static ArrayList<Point>[] adj;
	static int[][] Nodes;

	// 상 하 좌 우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Point implements Comparable<Point> {
		int r, c, fuel;

		public Point(int r, int c, int fuel) {
			super();
			this.r = r;
			this.c = c;
			this.fuel = fuel;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", fuel=" + fuel + "]";
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.fuel, o.fuel);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("산악구조로봇.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			Nodes = new int[N][N];
			v = new boolean[N][N];
			min = Integer.MAX_VALUE;

			// Nodes max로 채우기
			for (int i = 0; i < N; i++) {
				Arrays.fill(Nodes[i], Integer.MAX_VALUE);
			}

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			Dijkstra();

			
			System.out.println("#" + test_case + " " + Nodes[N-1][N-1]);
		}
	}

	private static void Dijkstra() {
		PriorityQueue<Point> Q = new PriorityQueue<>();
		Q.offer(new Point(0, 0, 0));
		Nodes[0][0] = 0;

		while (!Q.isEmpty()) {
			Point p = Q.poll();
			int r = p.r;
			int c = p.c;

			
			if(v[r][c]) continue;
			
			v[r][c] = true;

			for (int i = 0; i < 4; i++) {
				int dx = r + dr[i];
				int dy = c + dc[i];

				if (dx >= 0 && dy >= 0 && dx < N && dy < N && !v[dx][dy]) {

					// 이동 시 연료 소모량
					int addfuel = 0;// 낮은곳

					if (map[r][c] == map[dx][dy])// 같은곳
						addfuel = 1;

					else if (map[r][c] < map[dx][dy])// 높은곳
						addfuel = (map[dx][dy] - map[r][c]) * 2;

					// 이전에 왔던 연료소모량보다 적다면
					if (Nodes[dx][dy] > Nodes[r][c] + addfuel) {// Dijkstra
						
						Nodes[dx][dy] = Nodes[r][c] + addfuel;// Dijkstra

						Q.offer(new Point(dx, dy, Nodes[r][c] + addfuel));
					}

				}
			}

		}
	}

	// DFS
//	private static void DFS(int r, int c, int fuel, boolean[][] v) {
//    //현재 소모된 연료량이 지금까지 찾아낸 최소연료소모량보다 많다면 더이상 제귀를 할필요가 업다
//	/ *******************  가지치기   ********************/
//			if(fuel>=min) return;
//		if (r == N - 1 && c == N - 1) {
//
////			System.out.println(min);
////			min = Math.min(min, fuel);
//
//			return;
//		}
//
//		for (int j = 0; j < 4; j++) {
//			int nr = r + dr[j];
//			int nc = c + dc[j];
//
//			if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc]) {
//				v[nr][nc] = true;
//				DFS(nr, nc, fuel + map[nr][nc], v);
//
//				v[nr][nc] = false;
//			}
//		}
//	}

}
