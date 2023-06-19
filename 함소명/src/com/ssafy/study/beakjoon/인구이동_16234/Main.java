package com.ssafy.study.beakjoon.인구이동_16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

//인구이동
public class Main {
	static int N, L, R;
	static int map[][];
	static Point start;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 땅 크기
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		// 인구 차이가 L명 이상, R명 이하 라면 인구 이동
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 더 이상 아래 방법에 의해 인구 이동이 없을 때까지 지속
		// 1.국경선을 공유하는 두 나라의 인구 차이가 L명 이상, R명 이하라면, 두 나라가 공유하는 국경선을 오늘 하루 동안 연다.

		// 2.인구 이동을 시작
		// 연합을 이루고 있는 각 칸의 인구수는 (연합의 인구수) / (연합을 이루고 있는 칸의 개수)가 된다

		boolean check = true;
		int day = 0;
		while (check) {
			boolean[][] v = new boolean[N][N];
			HashMap<Point, Integer> hashMap = new HashMap<>();
			check = false;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!v[i][j]) {

						Queue<Point> Q = new LinkedList<>();
						ArrayList<Point> list = new ArrayList<>();
						boolean isMove = false;

						Q.add(new Point(i, j));
						v[i][j] = true;

						while (!Q.isEmpty()) {
							Point p = Q.poll();

							for (int k = 0; k < 4; k++) {
								int nr = p.r + dr[k];
								int nc = p.c + dc[k];

								if (nr < 0 || nr >= N || nc < 0 || nc >= N || v[nr][nc])
									continue;

								int cha = Math.abs(map[nr][nc] - map[p.r][p.c]);

								if (L <= cha && cha <= R) {
									boolean ischeck = false;
									for (Point point : list) {
										if (point.r == p.r && point.c == p.c) {
											ischeck = true;
										}
									}

									if (!ischeck)
										list.add(p);
									list.add(new Point(nr, nc));
									isMove = true;
									v[nr][nc] = true;
									Q.add(new Point(nr, nc));
								}
							}
						}

						if (isMove) {
							int sum = 0;
							for (Point p : list) {
								sum += map[p.r][p.c];
							}

							int num = sum / list.size();
//							System.out.println(list.size());
//							System.out.println(num);

							for (Point p : list) {
								hashMap.put(p, num);
							}
						}

					}
				}
			}
			
			for ( Point key : hashMap.keySet() ) {
				map[key.r][key.c] = hashMap.get(key);
				check = true;
			}
//			System.out.println();
			day++;
		}
		
		System.out.println(day-1);

	}

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
}