package com.ssafy.study.beakjoon.통나무옮기기;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static char[][] map;
	// 상, 하, 좌, 우, 회전(중심점을 기준으로 열/행에 있는지 확인하고, 열에있으면 행으로/ 행에 있으면 열로 옮긴다.)
	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

	static ArrayList<Point> start;
	static ArrayList<Point> end;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		start = new ArrayList<>();
		end = new ArrayList<>();
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);

				if (map[i][j] == 'B') {
					if (start.size() > 0) {
						int check = 0;
						if (start.get(0).r == i)
							check = 1;// 행 정렬
						else if (start.get(0).c == j)
							check = 0;// 열 정렬

						start.add(new Point(i, j, 0, check));
					} else
						start.add(new Point(i, j, 0, 0));
				}
				if (map[i][j] == 'E') {
					end.add(new Point(i, j, 0, 0));
				}
			}
		}

//        print();

		BFS();
	}

	private static void BFS() {
		Queue<Point> Q = new LinkedList<>();
		boolean[][][] v = new boolean[N][N][2];//0->4방 BFS, 1->회전 확인
		// 중심점
		Point mid = start.get(1);
		Q.add(mid);
		v[mid.r][mid.c][0] = true;

		int cnt = 0;
		L: while (!Q.isEmpty()) {
			Point p = Q.poll();
//			System.out.println(p.r+" "+p.c);

			// 8방에 1이 있는지 확인하고, 중심점을 기준으로 90도 회전, 걸리는게 없으면 화전한 값을 Q에 넣는다.
			if (!v[p.r][p.c][0] || !v[p.r][p.c][1]) {
				boolean isCheck = true;
				for (int i = 0; i < 8; i++) {
					int nr = p.r + dr[i];
					int nc = p.c + dc[i];

					if (nr < 0 || nc < 0 || nr >= N || nc >= N)
						continue;

					if (map[nr][nc] == '1') {
						isCheck = false;
					}
				}

				if (isCheck) {
					ArrayList<Point> list = new ArrayList<Point>();
					list.add(new Point(p.r, p.c));

					for (int j = -1; j < 2; j = j + 2) {
						int nr2 = p.r;
						int nc2 = p.c;

						if (p.check == 1)
							nr2 = p.r + j;
						else
							nc2 = p.c + j;

						if (nr2 < 0 || nc2 < 0 || nr2 >= N || nc2 >= N || map[nr2][nc2] == '1')
							continue;

						list.add(new Point(nr2, nc2));
					}

					// EEE 도착점과 같은지 확인한다.
					if (list.size() == 3) {
						if (checkEnd(list)) {
							cnt = p.cnt + 1;
							break L;
						}
						
						Q.add(new Point(p.r, p.c, p.cnt + 1, p.check == 0 ? 1 : 0));
					}
				}				
			}

			// 4방으로 퍼져나간다.
			for (int i = 0; i < 4; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				// 한번 회전한것은 들어갈 수 있게.
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] == '1')
					continue;

				if(!v[nr][nc][p.check]) {
				ArrayList<Point> list = new ArrayList<Point>();
				list.add(new Point(nr, nc));

				for (int j = -1; j < 2; j = j + 2) {
					int nr2 = nr;
					int nc2 = nc;

					// 행 정렬
					if (p.check == 1)
						nc2 = nc + j;

					// 열 정렬
					if (p.check == 0)
						nr2 = nr + j;

					if (nr2 < 0 || nc2 < 0 || nr2 >= N || nc2 >= N || map[nr2][nc2] == '1')
						continue;

					list.add(new Point(nr2, nc2));

				}

				// UDLR로 옮긴 막대기가 끝날 막대기와 같은지 확인
				if (list.size() == 3) {
					if (checkEnd(list)) {
						cnt = p.cnt + 1;
						break L;

					}
					// BFS로 퍼져나가면서 UDLR로 옮겨본다.;
					v[nr][nc][p.check] = true;
					Q.add(new Point(nr, nc, p.cnt + 1, p.check));
				}
				}
			}
			
			
			
		}

		System.out.println(cnt);

	}

	private static boolean checkEnd(ArrayList<Point> list) {
		// EEE와 같은지 확인
		boolean isSame = true;
		for (Point Pstart : list) {
			boolean isCheck = false;
			for (Point Pend : end) {
				if (Pstart.r == Pend.r && Pstart.c == Pend.c)
					isCheck = true;
			}
			if (!isCheck)
				isSame = false;
		}

		return isSame;
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	static class Point {
		int r, c, cnt, check;// check: 행인지 열인지 리턴 (행(1) 열(0)) 

		public Point(int r, int c, int cnt, int check) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.check = check;
		}

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", cnt=" + cnt + ", check=" + check + "]";
		}

	}
}