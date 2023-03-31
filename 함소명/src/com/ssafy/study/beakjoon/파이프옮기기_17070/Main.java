package com.ssafy.study.beakjoon.파이프옮기기_17070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.management.Query;

public class Main {
	static int N, Ans;
	static int[][] arr;
	static boolean[][] v;

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
		v = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		BFS();
		DFS(0,1,0);
		System.out.println(Ans);
	}
	
	
	private static void DFS(int r, int c, int dir) {
		if (r == N - 1 && c == N - 1) {
			Ans++;
			return;
		}
		
		boolean isEmpty = true;
		for (int j = 0; j < 2; j++) {
			int nr = r + dr[j];
			int nc = c + dc[j];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] != 0)
				isEmpty = false;
		}
		
		//해당 방향을 갈 수 있는지 체크
		if (dir == 0) {
			rotation(r,c,0);
		} else if (dir == 1) {
			rotation(r,c,1);
		} else if (dir == 2) {
			rotation(r,c,0);
			rotation(r,c,1);
		}
	
		if(isEmpty)rotation(r,c,2);
		
	}

	private static void rotation(int r, int c, int i) {
		int nr = r + dr[i];
		int nc = c + dc[i];

		if (nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] == 0) {
			DFS(nr, nc, i);
		}
	}


//	// 시간초과..
//	static Queue<Point> Q = new LinkedList<>();
//	private static void BFS() {
//		Q.add(new Point(0, 1, 0));
//
//		while (!Q.isEmpty()) {
//			Point p = Q.poll();
//
//			boolean isEmpty = true;
//			for (int j = 0; j < 2; j++) {
//				int nr = p.r + dr[j];
//				int nc = p.c + dc[j];
//				if (nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] != 0)
//					isEmpty = false;
//			}
//
//			if (isEmpty)
//				rotation(p, 2);
//			if (p.dir == 0) {
//				rotation(p, 0);
//			} else if (p.dir == 1) {
//				rotation(p, 1);
//			} else if (p.dir == 2) {
//				rotation(p, 0);
//				rotation(p, 1);
//			}
//		}
//
//		System.out.println(Ans);
//	}
//
//	private static void rotation(Point p, int i) {
//		int nr = p.r + dr[i];
//		int nc = p.c + dc[i];
//
//		if (nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] == 0) {
//			Q.add(new Point(nr, nc, i));
//
//			if (nr == N - 1 && nc == N - 1)
//				Ans++;
//		}
//	}

}
