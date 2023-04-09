package com.ssafy.study.beakjoon.테트로미노_14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//처음에 dfs방법 생각해내지 못해서 시뮬로 다 돌림.
//ㅜㅗㅏㅓ 빼고 모두 정사각형 4개를 dfs완탐한 모양이다.
//ㅜㅗㅏㅓ 모양은 사방에서 3개 뽑기.
public class Main2 {
	static int N, M, max;
	static int map[][];
	static boolean v[][];// dfs할때마다 객체를 만들어주면 시간초과 난다.
	static Point start;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		max = Integer.MIN_VALUE;
		map = new int[N][M];
		v = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(i, j, 1, map[i][j]);
				
				combi(0,0,i,j,map[i][j]);
			}
		}

		System.out.println(max);
	}


	private static void combi(int cnt, int start, int y, int x, int sum) {
		if(cnt == 3) {
			max = Math.max(max, sum);
			return;
		}
		
		for (int d = start; d < 4; d++) {
			int ny = y + dr[d];
			int nx = x + dc[d];
			
			if(ny<0 || ny>=N || nx<0 || nx>=M) continue;
			
			combi(cnt+1, d+1, y, x, sum+map[ny][nx]);
		}
	}



	private static void dfs(int r, int c, int Idx, int sum) {
		if (Idx == 4) {
			max = Math.max(max, sum);
			
			return;
		}
		v[r][c] = true;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= N || nc >= M || nr < 0 || nc < 0 || v[nr][nc])
				continue;
			
			dfs(nr, nc, Idx + 1, sum + map[nr][nc]);
			
		}
		v[r][c] = false;
	}
}