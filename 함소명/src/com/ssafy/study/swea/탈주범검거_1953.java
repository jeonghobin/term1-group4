package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 1초일 때, 자기 자신이 꼭 나와야한다. 49개
 * 탈주범은 시간당 1의 거리를 움직일 수 있다.
 * 탈주범이 있을 수 있는 위치의 개수를 계산
 * 세로 크기는 5, 가로 크기는 6
 */
public class 탈주범검거_1953 {

	static int[][] map;
	static boolean[][] visit;
	static int N;
	static int M;
	static int L;
	static int cnt;

	// 상 우 하 좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static class Position {
		int r, c, pipe;

		@Override
		public String toString() {
			return "Position [r=" + r + ", c=" + c + ", pipe=" + pipe + "]";
		}

		public Position(int r, int c, int pipe) {
			super();
			this.r = r;
			this.c = c;
			this.pipe = pipe;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());// 세로
			M = Integer.parseInt(st.nextToken());// 가로
			// 맨홀뚜껑 위치
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());// 탈출 후 소요된 시간
			cnt = 1;

			map = new int[N][M];
			visit = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			BFS(R, C);
			System.out.println("#" + test_case + " " + cnt);
		}
	}

	private static void BFS(int r, int c) {
		Queue<Position> Q = new LinkedList<>();

		int pipe = map[r][c];
		Q.add(new Position(r, c, map[r][c]));
//		Position p1 = Q.peek();
//		System.out.println(p1.toString());

		L: while (!Q.isEmpty()) {

			int len = Q.size();
			for (int i = 0; i < len; i++) {
				Position p = Q.poll();

				switch (p.pipe) {
				case 1:
					for (int j = 0; j < 4; j++) {
						int dx = p.r + dr[j];
						int dy = p.c + dc[j];

						if (dx >= 0 && dy >= 0 && dx < N && dy < M && map[dx][dy] != 0 && !visit[dx][dy]) {
							visit[p.r][p.c] = true;
							cnt++;
							Q.offer(new Position(dx, dy, map[dx][dy]));
						}
					}
					break;
				case 2:
					for (int j = 0; j < 4; j = j + 2) {
						// 상=0, 하=2
						int dx = p.r + dr[j];
						int dy = p.c + dc[j];

						if (dx >= 0 && dy >= 0 && dx < N && dy < M && map[dx][dy] != 0 && !visit[dx][dy]) {
							if (map[dx][dy] == 1 || map[dx][dy] == 2|| map[dx][dy] == 4 || map[dx][dy] == 7) {
								visit[p.r][p.c] = true;
								cnt++;
								pipe = map[dx][dy];
								Q.offer(new Position(dx, dy, pipe));
							}
						}
					}
					break;
				case 3:
					for (int j = 1; j < 4; j = j + 2) {
						// 좌=1, 우=3
						int dx = p.r + dr[j];
						int dy = p.c + dc[j];

						if (dx >= 0 && dy >= 0 && dx < N && dy < M && map[dx][dy] != 0 && !visit[dx][dy]) {
							if (map[dx][dy] == 1 || map[dx][dy] == 3) {
								visit[p.r][p.c] = true;
								cnt++;
								pipe = map[dx][dy];
								Q.offer(new Position(dx, dy, pipe));
							}
						}
					}
					break;
				case 4:
					for (int j = 0; j < 2; j++) {
						// 상=0 우=1 -> 하=2 좌=3 에서 들어와야함.
						int dx = p.r + dr[j];
						int dy = p.c + dc[j];

						if (dx >= 0 && dy >= 0 && dx < N && dy < M && map[dx][dy] != 0 && !visit[dx][dy]) {
							if (map[dx][dy] == 1 || map[dx][dy] == 0) {
								visit[p.r][p.c] = true;
								cnt++;
								pipe = map[dx][dy];
								Q.offer(new Position(dx, dy, pipe));
							}
						}
					}
					break;
				case 5:
					for (int j = 1; j < 3; j++) {
						// 우=1 하=2-> 좌=3 상=0 에서 들어와야함.
						int dx = p.r + dr[j];
						int dy = p.c + dc[j];

						if (dx >= 0 && dy >= 0 && dx < N && dy < M && map[dx][dy] != 0 && !visit[dx][dy]) {
							if (map[dx][dy] == 3 || map[dx][dy] == 0) {
								visit[p.r][p.c] = true;
								cnt++;
								pipe = map[dx][dy];
								Q.offer(new Position(dx, dy, pipe));
							}
						}
					}
					break;
				case 6:
					for (int j = 2; j < 4; j++) {
						// 하=2 좌=3-> 상=0 우=1 에서 들어와야함.
						int dx = p.r + dr[j];
						int dy = p.c + dc[j];

						if (dx >= 0 && dy >= 0 && dx < N && dy < M && map[dx][dy] != 0 && !visit[dx][dy]) {
							if (map[dx][dy] == 0 || map[dx][dy] == 1) {
								visit[p.r][p.c] = true;
								cnt++;
								pipe = map[dx][dy];
								Q.offer(new Position(dx, dy, pipe));
							}
						}
					}
					break;
				case 7:
					for (int j = 0; j < 4; j = j + 3) {
						// 상=0, 좌=3-> 우=1 하=2 에서 들어와야함.
						int dx = p.r + dr[j];
						int dy = p.c + dc[j];

						if (dx >= 0 && dy >= 0 && dx < N && dy < M && map[dx][dy] != 0 && !visit[dx][dy]) {
							if (map[dx][dy] == 1 || map[dx][dy] == 2) {
								visit[p.r][p.c] = true;
								cnt++;
								pipe = map[dx][dy];
								Q.offer(new Position(dx, dy, pipe));
							}
						}
					}
					break;

				default:
					break;
				}
			}

			L--;

			if (L == 1)
				break L;
		}

	}

//	public static List Fpipe(int pipe) {
//		List<Integer> list = new ArrayList<>();
//
//		if (pipe == 1)
//			list = List.of(0, 1, 2, 3);
//		else if (pipe == 2)
//			list = List.of(0, 2);
//		else if (pipe == 3)
//			list = List.of(1, 3);
//		else if (pipe == 4)
//			list = List.of(0, 1);
//		else if (pipe == 5)
//			list = List.of(1, 2);
//		else if (pipe == 6)
//			list = List.of(2, 3);
//		else if (pipe == 7)
//			list = List.of(3, 0);
//
//		return list;
//	}
}
