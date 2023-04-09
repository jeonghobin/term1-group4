package com.ssafy.study.beakjoon.봄버맨2_16919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static int h, w, totalSec;
	static char[][] map;
	static ArrayList<Point> boom;
	static ArrayList<Point> boom1;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		totalSec = Integer.parseInt(st.nextToken());

		map = new char[h][w];
		boom = new ArrayList<>();
		boom1 = new ArrayList<>();

		for (int i = 0; i < h; i++) {
			String str = br.readLine();
			for (int j = 0; j < w; j++) {
				map[i][j] = (char) str.charAt(j);
				if (map[i][j] == 'O') {
					boom.add(new Point(i, j));
				}
			}
		}

		init();
		
		if (totalSec == 0 || totalSec == 1)
			print();
		else
			boomberman();
	}

	private static void init() {
		char[][] map2 = new char[h][w];
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				map2[i][j] = 'O';
			}
		}
		
		for (Point p : boom) {
			map2[p.r][p.c] = '.';

			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= h || nc >= w)
					continue;

				map2[nr][nc] = '.';
			}
		}
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (map2[i][j] == 'O') {
					boom1.add(new Point(i, j));
				}
			}
		}
		
	}

	private static void boomberman() {
		int time = 1;
		int rep = 0;
		while (time++ < totalSec) {
			rep = time % 4;
		}
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				map[i][j] = 'O';
			}
		}

		if (rep == 3) {	
			for (Point p : boom) {
				map[p.r][p.c] = '.';

				for (int i = 0; i < 4; i++) {
					int nr = p.r + dr[i];
					int nc = p.c + dc[i];

					if (nr < 0 || nc < 0 || nr >= h || nc >= w)
						continue;

					map[nr][nc] = '.';
				}
			}
		} else if (rep == 1) {
			for (Point p : boom1) {
				map[p.r][p.c] = '.';

				for (int i = 0; i < 4; i++) {
					int nr = p.r + dr[i];
					int nc = p.c + dc[i];

					if (nr < 0 || nc < 0 || nr >= h || nc >= w)
						continue;

					map[nr][nc] = '.';
				}
			}
		}

		print();
	}

	private static void print() {
		for (int i = 0; i < h; i++) {
			System.out.println(map[i]);
		}
	}

}
