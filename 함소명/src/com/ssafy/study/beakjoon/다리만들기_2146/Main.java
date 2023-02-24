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
	static int[][] map;
	static boolean[][] v;

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	static class Position {
		int r, c;

		public Position(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Position [r=" + r + ", c=" + c + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		v = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!v[i][j] && map[i][j] ==1)
					BFS(i, j);
			}
		}

		System.out.println(Arrays.deepToString(map));
		
	}

	static int different = 1;
	private static void BFS(int r, int c) {
		different++;
		System.out.println(r+", "+c);
		
		Queue<Position> Q = new LinkedList<Position>();
		Q.offer(new Position(r, c));
		v[r][c] = true;
		map[r][c] = different;
	
		while (!Q.isEmpty()) {
			Position land = Q.poll();
			
			for (int i = 0; i < 4; i++) {
				int dx = land.r + dr[i];
				int dy = land.c + dc[i];
				
				if(dx>=0 && dy>=0 && dx<N && dy<N && map[dx][dy]==1 && !v[dx][dy]) {
					v[dx][dy] = true;
					map[dx][dy] = different;
				}
			}
			
		}
	}

}
