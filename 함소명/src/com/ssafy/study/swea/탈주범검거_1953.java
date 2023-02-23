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
		List<Integer> dir = new ArrayList<>();

		@Override
		public String toString() {
			return "Position [r=" + r + ", c=" + c + ", pipe=" + pipe + ", dir=" + dir + "]";
		}

		public Position(int r, int c, int pipe, List dir) {
			super();
			this.r = r;
			this.c = c;
			this.pipe = pipe;
			this.dir = dir;
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
			cnt = 0;

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
		// x,y,pipe,파이프가 갈 수 있는 방향
		Q.offer(new Position(r, c, pipe, PipeDir(pipe)));

//		System.out.println(p1.toString());

		L: while (!Q.isEmpty()) {

			int len = Q.size();
			for (int i = 0; i < len; i++) {
				Position p = Q.poll();
				visit[r][c] = true;
				cnt++;
//				System.out.println(p.toString());

				// 갈 수 있는 방향
				for (Integer dir2 : p.dir) {
					// 방향이 들어왔을 때 갈 수 있는 파이프 리턴
					List list = findPipe(dir2);

					for (int j = 0; j < list.size(); j++) {
						// 들어온 파이프가 갈 수 있는 파이프라면 이동

//						for (Integer dir : p.dir) {
						int dx = p.r + dr[dir2];
						int dy = p.c + dc[dir2];

						if (dx >= 0 && dy >= 0 && dx < N && dy < M && map[dx][dy] != 0 && !visit[dx][dy]) {
							if ((int) list.get(j) == map[dx][dy]) {
								visit[dx][dy] = true;

								Q.offer(new Position(dx, dy, map[dx][dy], PipeDir(map[dx][dy])));
							}
						}
//						}
					}
				}
			}

			L--;

			if (L == 0)
				break L;
		}

	}

	// 파이프가 갈 수 있는 방향 리턴
	public static List<Integer> PipeDir(int pipe) {
		List<Integer> list = new ArrayList<>();

		if (pipe == 1)
			list = Arrays.asList(0, 1, 2, 3);
		else if (pipe == 2)
			list = Arrays.asList(0, 2);
		else if (pipe == 3)
			list = Arrays.asList(1, 3);
		else if (pipe == 4)
			list = Arrays.asList(0, 1);
		else if (pipe == 5)
			list = Arrays.asList(1, 2);
		else if (pipe == 6)
			list = Arrays.asList(2, 3);
		else if (pipe == 7)
			list = Arrays.asList(3, 0);

		return list;
	}

	// 방향이 들어왔을 때 갈 수 있는 파이프 리턴
	public static List<Integer> findPipe(int dir) {
		List<Integer> list = new ArrayList<>();

		if (dir == 0)// 상
			list = Arrays.asList(1, 2, 5, 6);
		if (dir == 1)// 우
			list = Arrays.asList(1, 3, 6, 7);
		if (dir == 2)// 하
			list = Arrays.asList(1, 2, 4, 7);

		if (dir == 3)// 좌
			list = Arrays.asList(1, 3, 4, 5);

		return list;
	}
}
