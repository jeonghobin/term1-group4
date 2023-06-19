package com.ssafy.study.beakjoon.불;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, Ans;
	static char[][] map;
	static ArrayList<Point> fire;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	private static class Point {
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

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			Ans = Integer.MAX_VALUE;

			Point start = null;
			fire = new ArrayList<>();
			for (int j = 0; j < N; j++) {
				String str = br.readLine();
				for (int k = 0; k < M; k++) {
					map[j][k] = str.charAt(k);
					if (map[j][k] == '@')
						start = new Point(j, k, 0);
					if (map[j][k] == '*')
						fire.add(new Point(j, k, 0));
				}
			}

			BFS(start);
			System.out.println(Ans != Integer.MAX_VALUE ? Ans : "IMPOSSIBLE");

		}
	}

	
	private static void BFS(Point start) {
		Queue<Point> SQ = new LinkedList<>();
		Queue<Point> FQ = new LinkedList<>();
		boolean[][] Sv = new boolean[N][M];
		boolean[][] Fv = new boolean[N][M];
		SQ.add(start);
		Sv[start.r][start.c] = true;
		for (Point f : fire) {
			FQ.add(f);
			Fv[f.r][f.c]=true;
		}
		
		L : while (true) {
			int FQsize = FQ.size();
			for (int i = 0; i < FQsize; i++) {
				Point p = FQ.poll();
				
				for (int j = 0; j < 4; j++) {
					int nr = p.r+dr[j];
					int nc = p.c+dc[j];
					
					if(nr<0 || nr>=N || nc<0 || nc>=M || map[nr][nc]=='#' || Fv[nr][nc]) continue;
					Fv[nr][nc] = true;
					FQ.add(new Point(nr, nc, p.cnt+1));
				}
			}
			
			int SQsize = SQ.size();
			if(SQsize==0)
				break L;
			
			for (int i = 0; i < SQsize; i++) {
				Point p = SQ.poll();
				
				if(p.r == N-1 || p.r==0 || p.c==M-1 || p.c==0) {
					Ans = p.cnt+1;
					break L;
				}
				
				for (int j = 0; j < 4; j++) {
					int nr = p.r+dr[j];
					int nc = p.c+dc[j];
					
					if(nr<0 || nr>=N || nc<0 || nc>=M || map[nr][nc]=='#' || Fv[nr][nc] || Sv[nr][nc]) continue;
					Sv[nr][nc] = true;
					SQ.add(new Point(nr, nc, p.cnt+1));
				}
			}
		}
		
		
	}
	

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
