package com.ssafy.study.beakjoon.탈출_3055;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//고슴도치는 물이 찰 예정인 칸으로 이동할 수 없다.
public class Main {
	static int N, M, Ans;
	static char map[][];
	static Point start;
	static ArrayList<Point> water = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());// 가로 길이
		M = Integer.parseInt(st.nextToken());// 세로 길이

		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'S')
					start = new Point(i, j);
				if (map[i][j] == '*')
					water.add(new Point(i, j));
			}
		}

		bfs(N, M);
	}

	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void bfs(int N, int M) {
		Queue<Point> wQ = new LinkedList<Point>();
		Queue<Point> bQ = new LinkedList<Point>();
		boolean[][][] v = new boolean[N][M][2];
		for (int i = 0; i < water.size(); i++) {
			wQ.add(water.get(i));// 물
		}
		bQ.add(start);// 비버

		int cnt = 0;// 시간
		L : while (!bQ.isEmpty()) {
			int wQsize = wQ.size();
			int bQsize = bQ.size();
			// 물
			while (wQsize-- > 0) {
				Point p = wQ.poll();

				for (int i = 0; i < 4; i++) {
					int nr = p.r + dr[i];
					int nc = p.c + dc[i];

					if (nr < 0 || nc < 0 || nr >= N || nc >= M)
						continue;
					if (v[nr][nc][0] || map[nr][nc] == 'X' || map[nr][nc] == 'D')
						continue;

					wQ.add(new Point(nr, nc));
					v[nr][nc][0] = true;
					map[nr][nc] = '*';
				}
			}

			// 비버
			while (bQsize-- > 0) {
				Point p = bQ.poll();

				for (int i = 0; i < 4; i++) {
					int nr = p.r + dr[i];
					int nc = p.c + dc[i];

					if (nr < 0 || nc < 0 || nr >= N || nc >= M)
						continue;
					if (v[nr][nc][1] || map[nr][nc] == 'X' || map[nr][nc] == '*')
						continue;

					if (map[nr][nc] == 'D') {
						Ans = cnt + 1;
						break L;
					}

					bQ.add(new Point(nr, nc));
					v[nr][nc][1] = true;
					map[nr][nc] = 'S';
				}
			}

			cnt++;
		}

		System.out.println(Ans == 0 ? "KAKTUS" : Ans);//정답

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

	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}
