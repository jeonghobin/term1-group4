package algo.bj.s2_1012;

import java.io.*;
import java.util.*;

public class Main {

	static int[][] map;
	static int count;

	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int i = 0; i < T; i++) {

			st = new StringTokenizer(br.readLine());

			int M = Integer.parseInt(st.nextToken()); // 가로
			int N = Integer.parseInt(st.nextToken()); // 세로
			int K = Integer.parseInt(st.nextToken()); // 배추 개수

			map = new int[M][N];

			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken()); // 가로 위치
				int Y = Integer.parseInt(st.nextToken()); // 세로 위치

				map[X][Y] = 1;
			}
			count = 0;

			for (int j = 0; j < map.length; j++) {
				for (int k = 0; k < map[j].length; k++) {
					if (map[j][k] == 1) {
						bfs(j, k);
					}
				}
			}
			System.out.println(count);
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

		map[x][y] = 0;

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < dx.length; i++) {
				int cx = p.x + dx[i];
				int cy = p.y + dy[i];

				if (cx >= 0 && cx < map.length && cy >= 0 && cy < map[0].length && map[cx][cy] == 1) {
					q.offer(new Point(cx, cy));
					map[cx][cy] = 0;
				}
			}
		}
		count++;
	}
}
