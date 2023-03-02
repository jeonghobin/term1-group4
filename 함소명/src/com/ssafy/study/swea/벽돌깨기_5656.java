package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 구술을 쏘아 벽돌을 깨트리는 게임
 * 구슬은 좌, 우로만 움직일 수 있어서 항상 맨 위에 있는 벽돌만 깨트릴 수 있다.
 * 벽돌은 숫자 1 ~ 9 로 표현되며, 구술이 명중한 벽돌은 상하좌우로 ( 벽돌에 적힌 숫자 - 1 ) 칸 만큼 같이 제거된다.
 * 제거되는 범위 내에 있는 벽돌은 동시에 제거된다.
 */
public class 벽돌깨기_5656 {
	static int N, W, H;
	static int[][] map;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

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

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());// 구슬을 쏠 수 있는 번수
			W = Integer.parseInt(st.nextToken());// 넓이
			H = Integer.parseInt(st.nextToken());// 높이
			map = new int[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			findVertex(map);

			print(map);

		}
	}

	private static void print(int[][] board) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}


	static int min = Integer.MAX_VALUE;

	private static void findVertex(int[][] board) {
		boolean[] v = new boolean[W];

		// 구슬이 깰 수 있는 맨 위 정점 넣기.
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (!v[j] && board[i][j] != 0) {
					v[j] = true;
		
					BFS(new Point(i, j, board[i][j]), board,0);
				}
			}
		}
		
	}

	private static void BFS(Point start, int[][] board, int k) {

		int sum = 0;
		
		Queue<Point> Q = new LinkedList<벽돌깨기_5656.Point>();
		Q.add(start);

		if (!Q.isEmpty()) {
			Point p = Q.poll();

			for (int i = 0; i < 4; i++) {

				// 퍼져나가는 깊이
				for (int depth = 1; depth < p.cnt; depth++) {
					int dx = p.r + dr[i] + depth;
					int dy = p.c + dc[i] + depth;

					if (dx >= 0 && dy >= 0 && dx < H && dy < W) {
						sum += board[dx][dy];
						if (board[dx][dy] > 1)
							Q.add(new Point(dx, dy, board[dx][dy]));
					}
				}
			}
		}

		findVertex(board);
		
		System.out.println(Q.toString());

	}

}
