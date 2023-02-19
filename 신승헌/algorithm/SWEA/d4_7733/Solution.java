package algo.swea.d4_7733;

import java.io.*;
import java.util.*;

public class Solution {

	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	static int[][] map;
	static boolean[][] v;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 한 변의 길이

			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			answer = 0;

			for (int i = 0; i <= 100; i++) {
				v = new boolean[N][N]; // 반복 시 마다 초기화
				int nowCount = 0;
				for (int j = 0; j < map.length; j++) {
					for (int k = 0; k < map[0].length; k++) {
						if (map[j][k] == i) {
							map[j][k] = 0;
						}
					}
				}

				for (int j = 0; j < map.length; j++) {
					for (int k = 0; k < map[j].length; k++) {
						if (map[j][k] != 0 && v[j][k] == false) {
							bfs(j, k);
							nowCount++;
						}
					}
				}
				if (nowCount > answer) {
					answer = nowCount;
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

			for (int i = 0; i < dx.length; i++) {
				int cx = p.x + dx[i];
				int cy = p.y + dy[i];

				if (cx >= 0 && cx < map.length && cy >= 0 && cy < map[0].length && v[cx][cy] == false
						&& map[cx][cy] != 0) {
					v[cx][cy] = true;
					q.offer(new Point(cx, cy));
				}
			}
		}

	}
}
