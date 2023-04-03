package com.ssafy.study.beakjoon.파이프옮기기_17070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.management.Query;

//17069 파이프 옮기기2
//DP 사용
public class Main2 {
	static int N, Ans, cnt;
	static int[][] arr;
	static int[][][] dp;

	// 가로,세로,대각선
	// 0,1,2
	// 오,아,대
	static int[] dr = { 0, 1, 1 };
	static int[] dc = { 1, 0, 1 };

	static class Point {
		int r, c, dir;

		public Point(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		dp = new int[N][N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Ans = DFS(0,1,0);
		System.out.println(Ans);
	}
	
	
	private static int DFS(int r, int c, int dir) {
		if (r == N - 1 && c == N - 1) {
			return 1;
		}
		
		if(dp[r][c][dir]!=0) return dp[r][c][dir];
		
		for (int d = 0; d < 3; d++) {
			if(dir==0 && d==1) continue;
			if(dir==1 && d==0) continue;
			
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			boolean isEmpty = true;
			if(d==2) {
				for (int j = 0; j < 2; j++) {
					int nr2 = r + dr[j];
					int nc2 = c + dc[j];
					if (nr2 >= 0 && nr2 < N && nc2 >= 0 && nc2 < N && arr[nr2][nc2] != 0)
						isEmpty = false;
				}
			}
			
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] == 0 && isEmpty)
				 dp[r][c][dir] += DFS(nr, nc, d);
		}
		
		return dp[r][c][dir];
	}
}
