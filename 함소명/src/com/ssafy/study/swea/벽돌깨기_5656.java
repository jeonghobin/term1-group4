package com.ssafy.study.swea;

import java.io.*;
import java.util.*;

/*
 * 구술을 쏘아 벽돌을 깨트리는 게임
 * 구슬을 떨어뜨리는 곳을 먼저 중복 순열로 뽑는 다는것만 캐치하면 됨.
 */
public class 벽돌깨기_5656 {
	static int N, W, H;
	static int[][] map;
	static int min = Integer.MAX_VALUE;
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
			min = Integer.MAX_VALUE;

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			select(new int[N], 0);

			System.out.println("#" + test_case + " " + min);
//			print(map);
		}
	}

	// 공 떨어뜨리는 곳 순서 정함.
	// 중복 순열 : 뿌시는 순서에 따라 달라짐.
	private static void select(int[] sel, int idx) {
		if (idx == N) {
//			System.out.println(Arrays.toString(sel));
			gameMap(sel);

			return;
		}

		for (int i = 0; i < W; i++) {
			sel[idx] = i;
			select(sel, idx + 1);
		}
	}

	static int[][] gameBoard;// N판 게임마다

	private static void gameMap(int[] sel) {
		gameBoard = new int[H][W];
		for (int j = 0; j < H; j++) {
			for (int i = 0; i < W; i++) {
				gameBoard[j][i] = map[j][i];
			}
		}

		for (int i = 0; i < sel.length; i++) {
			// 구슬이 떨어지는 좌표
			int c = sel[i];
			int r = 0;
			for (int j = 0; j < H; j++) {
				if (gameBoard[j][c] != 0) {
					r = j;
					break;
				}
			}

			// 제일 위칸이 0이면 깰 블록이 없음.
			if (gameBoard[r][c] != 0) {

				blockbreak(r, c, gameBoard[r][c]);

				blockdown();
			}
		}

//		print(gameBoard);

		int sumCnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (gameBoard[i][j] != 0)
					sumCnt++;
			}
		}

		min = Math.min(min, sumCnt);
	}

	// 벽돌 부수기
	private static void blockbreak(int r, int c, int num) {

		Queue<Point> Q = new LinkedList<>();
		Q.add(new Point(r, c, num));

		while (!Q.isEmpty()) {
			Point p = Q.poll();

			gameBoard[p.r][p.c] = 0;

			for (int i = 0; i < 4; i++) {
				// 퍼져나가는 깊이
				for (int depth = 1; depth < p.cnt; depth++) {
					int dx = p.r + (dr[i] * depth);
					int dy = p.c + (dc[i] * depth);

					if (dx >= 0 && dy >= 0 && dx < H && dy < W && gameBoard[dx][dy] != 0) {
						if (gameBoard[dx][dy] != 1)
							Q.add(new Point(dx, dy, gameBoard[dx][dy]));
						gameBoard[dx][dy] = 0;
					}
				}
			}
		}
	}

	// 벽돌 내리기
	private static void blockdown() {
		Stack<Integer>[] stacks = new Stack[W];
		for (int i = 0; i < W; i++) {
			stacks[i] = new Stack();
		}

		// 0이 아니면 리스트 담기
		for (int j = 0; j < H; j++) {
			for (int i = 0; i < W; i++) {
				if (gameBoard[j][i] != 0)
					stacks[i].push(gameBoard[j][i]);
			}
		}

		// 0으로 초기화
		for (int j = 0; j < H; j++) {
			for (int i = 0; i < W; i++) {
				gameBoard[j][i] = 0;
			}
		}

		// 순서대로 다시 넣기.
		for (int j = 0; j < W; j++) {
			int size = stacks[j].size();
			for (int i = 0; i < size; i++) {
				gameBoard[(H - 1) - i][j] = stacks[j].pop();
			}
		}
	}

	private static void print(int[][] board) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
