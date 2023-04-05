package day04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 수영대회결승전_prof {
	static int N, M, T;
	static int Ans = 0;
	static int[][] map;
	static int[][] copy;

	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
		
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			copy = new int[N][N];
			for (int r = 0; r < map.length; r++) {
				for (int c = 0; c < map.length; c++) {
					map[r][c] = sc.nextInt();
					// 벽을 -1 로 수정
					if (map[r][c] == 1) {
						map[r][c] = -1;
					}
				}
			}
			Point start = new Point(sc.nextInt(), sc.nextInt());
			Point end = new Point(sc.nextInt(), sc.nextInt());
			System.out.printf("#%d %d\n",tc,bfs(start, end));
		}
	}

	private static int bfs(Point start, Point end) {
		Queue<Point> Q = new LinkedList<Point>();
		boolean[][] v = new boolean[N][N];
		Q.add(start);
		v[start.r][start.c] = true;
		int time = 0;
		while (!Q.isEmpty()) {
			// 3초마다
			if (time % 3 == 0) {
				copy = mapCopy(map);
			}
			int size = Q.size();
			// 1초 동안 일어난 일~~~~~~~
			for (int cnt = 0; cnt < size; cnt++) {
				Point p = Q.poll();
				if (p.r == end.r && p.c == end.c) {

					return time;
				}
				for (int d = 0; d < 4; d++) {
					int nr = p.r + dr[d];
					int nc = p.c + dc[d];
					if (nr >= 0 && nr < N && nc >= 0 && nc < N && !v[nr][nc]) {
						// 가려는 위치에 소용돌이가 있으면 대기
						if (copy[nr][nc] > 0) {
							Q.add(p);
						}
						// 갈수 있으면 고고싱~~~~~
						if (copy[nr][nc] == 0) {
							v[nr][nc] = true;
							Q.add(new Point(nr, nc));
						}
					}
				}

			} // 1초 동안 일어난 일~~~~~~~
			time++;
			// 소용돌이 업데이트
			for (int r = 0; r < map.length; r++) {
				for (int c = 0; c < map.length; c++) {
					// 소용돌이면 시간변화
					if (copy[r][c] > 0) {
						copy[r][c]--;
					}
				}
			}
		}
		// 도착하지 못하면 -1 을 리턴
		return -1;
	}

	private static int[][] mapCopy(int[][] map) {
		int[][] tmp = new int[N][N];
		for (int r = 0; r < tmp.length; r++) {
			for (int c = 0; c < tmp.length; c++) {
				tmp[r][c] = map[r][c];
			}
		}
		return tmp;
	}

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	private static void print(int[][] map) {
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}

}