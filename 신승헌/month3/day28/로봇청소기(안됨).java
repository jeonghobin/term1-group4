package day28;

import java.io.*;
import java.util.*;

public class 로봇청소기 {
	static Character[][] map;
	static boolean[][] v;
	static int count; // 더러운 칸의 개수
	static int startX; // 시작하는 더러운 칸의 위치
	static int startY; // 시작하는 더러운 칸의 위치
	static int answer; // 정답

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 첫 번째 줄
		while (true) {
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());

			if (W == 0 && H == 0)
				break;

			count = 0;
			answer = 0;

			map = new Character[H][W];
			// 나머지 줄
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				String s = st.nextToken();

				for (int j = 0; j < W; j++) {
					map[i][j] = s.charAt(j);
					if (map[i][j] == '*') {
						count++;
					}
					if (map[i][j] == 'o') {
						startX = i;
						startY = j;
						map[i][j] = '.';
					}
				}
			}

			for (int i = 0; i < count; i++) {
				v = new boolean[H][W];
				boolean flag = bfs();
				if (flag == false) {
					answer = -1;
					break;
				}
			}

			System.out.println(answer);

		}

	}

	static class Point {
		int x;
		int y;
		int level;

		public Point(int x, int y, int level) {
			super();
			this.x = x;
			this.y = y;
			this.level = level;
		}

	}

	private static boolean bfs() {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(startX, startY, 0));
		v[startX][startY] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < dx.length; i++) {
				int x = p.x + dx[i];
				int y = p.y + dy[i];

				if (x >= 0 && x < map.length && y >= 0 && y < map[0].length && v[x][y] == false && map[x][y] != 'x') {
					// 더러운 칸이라면
					if (map[x][y] == '*') {
						map[x][y] = '.';
						answer += p.level + 1;
						startX = x;
						startY = y;
						return true;
					} else {
						v[x][y] = true;
						q.offer(new Point(x, y, p.level + 1));
					}

				}
			}
		}
		return false;
	}

	private static void print(Character[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
