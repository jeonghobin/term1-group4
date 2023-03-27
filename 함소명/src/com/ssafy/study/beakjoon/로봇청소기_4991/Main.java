package com.ssafy.study.beakjoon.로봇청소기_4991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int h, w, min;
	static ArrayList<Point> list;

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

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		char[][] map = new char[h][w];
		list = new ArrayList<>();
		int r = 0;
		int c = 0;
		for (int i = 0; i < h; i++) {
			String str = br.readLine();
			for (int j = 0; j < w; j++) {
				map[i][j] = (char) str.charAt(j);
				if (map[i][j] == 'o') {
					r = i;
					c = j;
				}
				if (map[i][j] == '*') {
					list.add(new Point(i, j, 0));
				}
			}
		}

		print(map);

//		DFS(map, r, c, 0, 0);
		BFS(map, r, c);

		System.out.println(min);
	}

//	private static void DFS(char[][] map, int r, int c, int cnt, int idx) {
//		if (idx > list.size()) {
//			min = cnt;
//		}
//
//		for (int i = 0; i < 4; i++) {
//			int nr = r + dr[i];
//			int nc = c + dc[i];
//
//			if (nr >= 0 && nc >= 0 && nr < h && nc < w) {
//				if (nr == list.get(idx).r && nc == list.get(idx).c) {
//					map[nr][nc] = '.';
//					DFS(map, nr, nc, cnt + 1, idx + 1);
//					map[nr][nc] = '*';
//				}
//
//				DFS(map, nr, nc, cnt + 1, idx);
//			}
//
//		}
//	}

	private static void BFS(char[][] map, int r, int c) {
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(r, c, 0));
		int result = 0;

		L:while (!Q.isEmpty()) {
			Point p = Q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				if (nr >= 0 && nc >= 0 && nr < h && nc < w) {

					if (map[nr][nc] == '*') {
						map[nr][nc] = '.';
						result += p.cnt+1;

						Q.clear();
						Q.offer(new Point(nr, nc, 0));
					}
					
					if (map[nr][nc] == '.') {
						Q.offer(new Point(nr, nc, p.cnt + 1));
					}
				}
			}
		}
		
		System.out.println(result);

	}

	private static boolean clear(char[][] map) {
		boolean isboolean = true;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (map[i][j] == '*')
					isboolean = false;
			}
		}
		return isboolean;
	}

	private static void print(char[][] map) {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
