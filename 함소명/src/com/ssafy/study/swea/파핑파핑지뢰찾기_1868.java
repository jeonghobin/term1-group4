package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 파핑파핑지뢰찾기_1868 {
	static int N,click;
	static char[][] map;
	static int[][] cntMap;
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
				}
			}

			// 1.주변 지뢰 개수 세기
			// -1로 초기화
			cntMap = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cntMap[i][j] = -1;
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '.') {
						int cnt = 0;
						for (int c = 0; c < 8; c++) {
							int nr = i + dr[c];
							int nc = j + dc[c];

							if (nr < 0 || nr >= N || nc < 0 || nc >= N)
								continue;

							if (map[nr][nc] == '*')
								cnt++;
						}
						cntMap[i][j] = cnt;
					}
				}
			}

//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(cntMap[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();

			// 2. 주변에 지뢰가 0인것 부터 클릭
			int click = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (cntMap[i][j] == 0 && map[i][j] != '9') {
						click++;
						poping(i, j);
					}
				}
			}
//			print(map);
//			System.out.println(click);

			// 3. 나머지 누른다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '.' && map[i][j]!='9') {
						click++;
					}
				}
			}

			System.out.println("#" + test_case + " " + click);
		}

	}

	// 0주위 파핑파핑
	private static void poping(int r, int c) {
		Queue<Point> Q = new LinkedList<>();
		Q.add(new Point(r, c));
		map[r][c] = '9';
		while (!Q.isEmpty()) {
			Point p = Q.poll();

			for (int i = 0; i < 8; i++) {
				int nr = p.r + dr[i];
				int nc = p.c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == '*' || map[nr][nc] == '9')
					continue;

				map[nr][nc] = '9';

				if (cntMap[nr][nc] == 0)
					Q.add(new Point(nr, nc));

			}
		}

	}

	private static void print(char[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
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
