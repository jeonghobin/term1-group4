package com.ssafy.study.beakjoon.다리만들기_2146;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 섬과 섬을 잇는 다리. BFS
 */
public class Main {
	static int N;
	static int min;
	static boolean arrive;
	static int[][] map;
	static boolean[][] v;

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	static class Position {
		int r, c, cnt;

		public Position(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Position [r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}

		

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		v = new boolean[N][N];
		min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}


		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!v[i][j] && map[i][j] == 1)
					BFS(i, j);
			}
		}

//		

		if (arrive)
			System.out.println(min);
		else
			System.out.println(0);
	}

	static int different = 1;

	private static void BFS(int r, int c) {
		different++;

		Queue<Position> Q = new LinkedList<Position>();
		Q.offer(new Position(r, c,0));
		v[r][c] = true;
		map[r][c] = different;

		while (!Q.isEmpty()) {
			Position land = Q.poll();

			for (int i = 0; i < 4; i++) {
				int dx = land.r + dr[i];
				int dy = land.c + dc[i];

				if (dx >= 0 && dy >= 0 && dx < N && dy < N && map[dx][dy] == 1 && !v[dx][dy]) {
					v[dx][dy] = true;
					map[dx][dy] = different;
					Q.offer(new Position(dx, dy,0));
				}
			}
		}

		// 자신의 섬이랑 다른 섬을 만나면 거리 체크
//		System.out.println(Arrays.deepToString(map));
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == different) 
					BFS2(i, j, new boolean[N][N]);
			}
		}

	}

	private static void BFS2(int r, int c, boolean[][] v) {

		int len =0;
		Queue<Position> Q = new LinkedList<Position>();
		Q.offer(new Position(r, c,0));
		v[r][c] = true;

		L: while (!Q.isEmpty()) {
			Position land = Q.poll();
//			System.out.println(land);
			
			for (int i = 0; i < 4; i++) {
				int dx = land.r + dr[i];
				int dy = land.c + dc[i];

				if (dx >= 0 && dy >= 0 && dx < N && dy < N && !v[dx][dy]) {
					if (map[dx][dy] != 0&&map[dx][dy] != different) {
						len = land.cnt;
						break L;
					}
					
					if (map[dx][dy] == 0) {
						
						v[dx][dy] = true;
						arrive = true;
						Q.offer(new Position(dx, dy,land.cnt+1));
					}
					
				}
			}
		}
		if(len!=0)
			min = Math.min(min, len);
	}
}
