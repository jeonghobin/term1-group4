package com.ssafy.study.beakjoon.아기상어_16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 
 */
public class Main {
	static int N;
	static int[][] map;
	static Shark shark;
	static ArrayList<Shark>[] fish;
	static int eatFish;

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	static class Shark {
		int r, c, Ssize, cnt;

		public Shark(int r, int c, int ssize, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.Ssize = ssize;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", Ssize=" + Ssize + ", cnt=" + cnt + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		fish = new ArrayList[7];// 1~6

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 9)
					shark = new Shark(i, j, 2, 0);
				else if (map[i][j] != 0) // 왼쪽 위부터 들어감.
					fish[map[i][j]].add(new Shark(i, j, map[i][j], 0));
			}
		}

		// 아기 상어 최단거리 이동
		moveShark();

	}

	private static void moveShark() {
		Queue<Shark> Q = new LinkedList<Shark>();
		
		Q.offer(shark);

		while (!Q.isEmpty()) {
			Queue<Shark> fishs = new LinkedList<Shark>();
			Shark shark = Q.poll();
			// 상어가 먹을 수 있는 물고기 담기.

			for (int i = 0; i < 4; i++) {
				int dx = shark.r + dr[i];
				int dy = shark.c + dc[i];

				if (dx >= 0 && dy >= 0 && dx < N && dy < N) {

					// 상어 이동 -> 0이나 자신과 크기가 같은 물고기는 밟고 이동할 수 있다.
					if (map[dx][dy] == 0 || map[dx][dy] == shark.Ssize) {

						Q.offer(new Shark(dx, dy, shark.Ssize, shark.cnt + 1));

					} else if (map[dx][dy] < shark.Ssize) {// 자신보다 작은 물고기 먹기

						// 상어가 먹을 수 있는 물고기 담기.
						fishs.offer(new Shark(dx, dy, map[dx][dy], 0));
					}
				}
			}

			// 상어가 먹을 수 있는 물고기들 중, 왼쪽 위 부터 먹기.
			if (!fishs.isEmpty()) {
				int r = N;
				int c = N;
				for (Shark iseat : fishs) {
					if (iseat.r < r)
						r = iseat.r;
					if (iseat.c < c)
						c = iseat.c;
					
				}

				// 만일 상어가 물고기를 자기 사이즈만큼 먹었다면 크기 +1 증가

			}
		}

	}

}
