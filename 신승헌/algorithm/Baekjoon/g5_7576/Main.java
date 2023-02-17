package algo.bj.g5_7576;

import java.io.*;
import java.util.*;

public class Main {

	static int[][] map;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int max = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken()); // 가로
		int N = Integer.parseInt(st.nextToken()); // 세로

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(max);

	}

	static class Point {
		int x;
		int y;
		int level;

		public Point(int x, int y, int level) {
			this.x = x;
			this.y = y;
			this.level = level;
		}

	}

	private static void bfs() {
		Queue<Point> q = new LinkedList<>();

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == 1) {
					q.offer(new Point(i, j, 0));
				}
			}
		}

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < dx.length; i++) {
				int cx = p.x + dx[i];
				int cy = p.y + dy[i];

				if (cx >= 0 && cx < map.length && cy >= 0 && cy < map[0].length 
						&& map[cx][cy] == 0) {
					map[cx][cy] = 1;
					q.offer(new Point(cx, cy, p.level + 1));
					max = Math.max(p.level + 1, max);
				}
			}
		}
	}
}
