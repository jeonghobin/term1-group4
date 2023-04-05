package day05;

import java.io.*;
import java.util.*;

public class 탈출 {

	static char map[][];

	static Queue<Point> q = new LinkedList<>();

	static int R, C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		Point S = null; // 고슴도치 위치 저장 변수

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);

				// 고슴도치라면
				if (map[i][j] == 'S') {
					S = new Point(i, j, 0, 'S');
				}

				// 물이라면
				if (map[i][j] == '*') {
					q.offer(new Point(i, j, 0, '*'));
				}

			}
		}
		// 고슴도치를 가장 마지막에 넣음
		q.offer(S);

		int answer = bfs();

//		print(map);
		System.out.println(answer == 0 ? "KAKTUS" : answer);

	}

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	private static int bfs() {
		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int d = 0; d < dx.length; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];

				if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] != 'X' && map[nx][ny] != '*') {
					// 물의 경우
					if (p.chara == '*') {
						// 물, 돌, 비버집이 아닌 경우
						if (map[nx][ny] == '.' || map[nx][ny] == 'S') {
//							print(map);
							q.offer(new Point(nx, ny, p.level + 1, '*'));
							map[nx][ny] = '*';
						}
					}

					// 고슴도치의 경우
					if (p.chara == 'S') {
						// 비버집 이라면
						if (map[nx][ny] == 'D') {
//							print(map);

							return p.level + 1;
						}
						// 빈칸 이라면
						if (map[nx][ny] == '.') {
							map[nx][ny] = 'S';
							q.offer(new Point(nx, ny, p.level + 1, 'S'));
//							print(map);

						}

					}
				}
			}
		}
		return 0;
	}

	static class Point {
		int x;
		int y;
		int level; // 이동하는데 걸린 시간
		char chara; // 고슴도치 또는 물을 저장

		public Point(int x, int y, int level, char chara) {
			this.x = x;
			this.y = y;
			this.level = level;
			this.chara = chara;
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
