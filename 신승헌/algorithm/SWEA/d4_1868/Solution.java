package algo.swea.d4_1868;

import java.io.*;
import java.util.*;

public class Solution {
	static char[][] map;
	static boolean[][] v;
	static int answer;

	static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			// input
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 배열 크기

			answer = 0;

			map = new char[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j);
				}
			}

			// 1회 탐색 (배열 조정)
			v = new boolean[N][N];
			bfs(0, 0);

//			print(map);

			// 2회 탐색
			v = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '0' && v[i][j] == false) { // 0이고 방문한 적이 없으면
						bfs2(i, j);
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (v[i][j] == false && map[i][j] != '*') { // 0이고 방문한 적이 없으면
						answer++;
					}
				}
			}
			System.out.println("#" + test_case + " " + answer);

		} // [E] test_case
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y));
		v[x][y] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();

			int bombCount = 0;

			for (int i = 0; i < dx.length; i++) {
				int cx = p.x + dx[i];
				int cy = p.y + dy[i];

				if (cx >= 0 && cx < map.length && cy >= 0 && cy < map[0].length) {
					if (v[cx][cy] == false) {
						q.offer(new Point(cx, cy));
						v[cx][cy] = true;
					}

					if (map[cx][cy] == '*') {
						bombCount++;
					}
				}

				if (i == dx.length - 1 && map[p.x][p.y] == '.') { // 마지막 반복이고 폭탄이 아니면
					map[p.x][p.y] = (char) (bombCount + '0');
				}
			}
		}
	}

	private static void bfs2(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		Queue<Point> tempQ = new LinkedList<>();
		q.offer(new Point(x, y));
		v[x][y] = true;
		answer++;

		while (!q.isEmpty()) {
			Point p = q.poll();

			if (map[x][y] == '0') { // 첫 시작이 0이라면
				for (int i = 0; i < dx.length; i++) {
					int cx = p.x + dx[i];
					int cy = p.y + dy[i];

					if (cx >= 0 && cx < map.length && cy >= 0 && cy < map[0].length && map[cx][cy] != '*') {
						if (map[cx][cy] == '0' && v[cx][cy] == false) {
							q.offer(new Point(cx, cy));
						}
						v[cx][cy] = true;
					}
				}
			}
		}
	}

	private static void print(char[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
