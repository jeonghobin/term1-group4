package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 수영대회결승전_4193_Re {
	static int N, Ans;
	static int[][] map;
	static boolean[][] v;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static ArrayList<int[]> swing;
	static int[] start;
	static int[] end;

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
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			v = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			start = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0};
			st = new StringTokenizer(br.readLine());
			end = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0};

//			BFS();

			System.out.println("#"+test_case+" "+bfs());
		}

	}
	
	static int bfs() {
		Queue<int[]> Q = new LinkedList<>();
		v = new boolean[N][N];
		v[start[0]][start[1]] = true;
		Q.offer(start);
		int time = 0;
		while (!Q.isEmpty()) {
			
			int size = Q.size();//한번에 움직이는 시간
			while ((size--)>0) {
				int[] p = Q.poll();
				for (int i = 0; i < 4; i++) {
					int nr = p[0]+dr[i];
					int nc = p[1]+dc[i];
					
					if(nr<0||nc<0||nr>=N||nc>=N) continue;
					if(v[nr][nc])continue;
					if(map[nr][nc]==1) continue;
					if(map[nr][nc]==2) {
						if(time%3!=2) {//나머지가 2가 아닌경우, 소용돌이가 사라지지 않은경우
							Q.add(p);
							continue;
						}
					}
					
					if(nr==end[0]&&nc==end[1]) {
						return time+1;
					}
					
					Q.add(new int[] {nr,nc});
					v[nr][nc] = true;
					
				}
			}
		
			time++; 
		}

		return -1;
	}

//	//RuntimeError
//	private static void BFS() {
//		Queue<Point> Q = new LinkedList<>();
//		Q.add(start);
//		v[start.r][start.c] = true;
//
//		int value = 2;
//		L: while (true) {
//			Point p = Q.poll();
//
//			if (p.r == end.r && p.c == end.c) {
//				Ans = p.cnt;
//				break L;
//			}
//
//			for (int d = 0; d < 4; d++) {
//				int nr = p.r + dr[d];
//				int nc = p.c + dc[d];
//
//				if (nr >= 0 && nc >= 0 && nr < N && nc < N && !v[nr][nc]) {
//					if (map[nr][nc] == 0) {
//						v[nr][nc] = true;
//						Q.add(new Point(nr, nc, p.cnt + 1));
//					}
//
//					for (int i = 0; i < swing.size(); i++) {
//						int sr = swing.get(i)[0];
//						int sc = swing.get(i)[1];
//						if(nr==sr && nc==sc)
//							Q.add(new Point(p.r, p.c, p.cnt + 2));
//					}
//				}
//			}
//
//			value--;
//			for (int i = 0; i < swing.size(); i++) {
//				int sr = swing.get(i)[0];
//				int sc = swing.get(i)[1];
//
//				if (value < 0) {
//					value = 2;
//					map[sr][sc] = value;
//				} else
//					map[sr][sc] = value;
//
//			}
////			print();
//
//		}
//
//	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
