package algo.bj.s2_4963;

import java.io.*;
import java.util.*;

public class Main {

	static int[][] map;
	static int answer; // 섬의 개수 기록
	static int[] dx = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());

			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0) {
				return;
			}

			map = new int[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			answer = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1) {
						bfs(i, j);
					}
				}
			}
			System.out.println(answer);
		} // [E] while
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
					map[cx][cy] = 0;
					q.offer(new Point(cx, cy));
				}
			}
		}
		answer++;
	}
}
