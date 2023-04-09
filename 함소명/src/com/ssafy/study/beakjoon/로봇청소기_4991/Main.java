package com.ssafy.study.beakjoon.로봇청소기_4991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 먼지들을 모두 청소 하는데 최소 거리 구하기
 * 처음 생각 : 순열로 청소할 순서를 뽑고 BFS로 최단 경로 돌리기. -> 시간초과..
 * Solution : BFS로 모든 경로의 최소 거리를 뽑은 후, 순열로 순서를 뽑고 최단 경로 찾기.
 */

public class Main {
	static int h, w, min;
	static Point start;
	static char[][] map;
	static int[][][][] distance;
	static ArrayList<Point> list;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0)
				break;

			min = Integer.MAX_VALUE;

			map = new char[h][w];
			list = new ArrayList<>();

			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == 'o') {
						start = new Point(i, j, 0);
					}
					if (map[i][j] == '*') {
						list.add(new Point(i, j, 0));
					}
				}
			}

			// 모든 정점의 최단경로 뽑기
			int dist = -1;
			distance = new int[h][w][h][w];
			L : for (int i = 0; i < list.size(); i++) {
				dist = BFS(start, list.get(i));
				if(dist == -1) break L;
				//양방향
				distance[start.r][start.c][list.get(i).r][list.get(i).c] = dist;
				distance[list.get(i).r][list.get(i).c][start.r][start.c] = dist;
				for (int j = i + 1; j < list.size(); j++) {
					dist = BFS(list.get(i),list.get(j));
					if(dist == -1) break L;
					//양방향
					distance[list.get(i).r][list.get(i).c][list.get(j).r][list.get(j).c] = dist;
					distance[list.get(j).r][list.get(j).c][list.get(i).r][list.get(i).c] = dist;
				}
			}
			
			if(dist == -1) {
				System.out.println(-1);
			}else {
				recursive(new Point[list.size()], 0, new boolean[list.size()]);
				System.out.println(min);
			}

		}

	}

	// 청소할 순서 순열로 뽑기
	private static void recursive(Point[] sel, int sIdx, boolean[] v) {
		if (sIdx == sel.length) {
//			System.out.println(Arrays.toString(sel));
			int sum = distance[start.r][start.c][sel[0].r][sel[0].c];
			for (int i = 0; i < sel.length-1; i++) {
				sum += distance[sel[i].r][sel[i].c][sel[i+1].r][sel[i+1].c];
			}
			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < list.size(); i++) {
			if (!v[i]) {
				v[i] = true;
				sel[sIdx] = list.get(i);
				recursive(sel, sIdx + 1, v);
				v[i] = false;
			}
		}
	}

	private static int BFS(Point start, Point end) {
		Queue<Point> Q = new LinkedList<>();
		boolean[][] v = new boolean[h][w];
		Q.offer(start);
		v[start.r][start.c] = true;

		int cnt = 0;
		L: while (!Q.isEmpty()) {
			Point p = Q.poll();

			if (p.r == end.r && p.c == end.c) {
				cnt = p.cnt;
				break L;
			}

			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				if (nr >= 0 && nc >= 0 && nr < h && nc < w && !v[nr][nc]) {
					v[nr][nc] = true;

					if (map[nr][nc] == 'x')
						continue;

					Q.offer(new Point(nr, nc, p.cnt + 1));
				}
			}
		}
		

		if (cnt == 0)
			return -1;
		else
			return cnt;
	}

	private static void print(char[][] map) {
		for (int i = 0; i < h; i++) {
			System.out.println(map[i]);
		}
		System.out.println();
	}

}