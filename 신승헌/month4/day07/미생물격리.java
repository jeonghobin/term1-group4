package day07;

import java.io.*;
import java.util.*;

public class 미생물격리 {

	static int N, M, K, answer;
	static Point[][] map;
	static PriorityQueue<Point> q;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class Point implements Comparable<Point> {
		int x;
		int y;
		int size;
		int rot;
		int level;

		Point(int x, int y, int size, int rot, int level) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.rot = rot;
			this.level = level;
		}

		@Override
		public int compareTo(Point o) {
			return o.size - this.size;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			// 첫 번째 줄
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 맵 크기
			M = Integer.parseInt(st.nextToken()); // 시간
			K = Integer.parseInt(st.nextToken()); // 미생물 개수

			answer = 0;
			map = new Point[N][N];
			q = new PriorityQueue<>();
//			print(map);

			for (int i = 0; i < K; i++) {
				// 나머지 줄
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int size = Integer.parseInt(st.nextToken());
				int rot = Integer.parseInt(st.nextToken()) - 1; // 0부터 시작을 위해
				q.offer(new Point(x, y, size, rot, 0));
			}

			bfs();

			System.out.println("#" + test_case + " " + answer);

		} // [E] test_case
	}

	private static void print(Point[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			Point p = q.poll();

			// 시간이 모두 지나면 종료
			if (p.level == M) {
				answer += p.size;

				while (!q.isEmpty()) {
					p = q.poll();
					answer += p.size;
				}

				return;
			}

			int nx = p.x + dx[p.rot];
			int ny = p.y + dy[p.rot];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				// 가장자리라면
				if (nx == 0 || nx == N - 1 || ny == 0 || ny == N - 1) {
					p.size = p.size / 2; // 사이즈를 반으로 만듦

					if (p.rot == 0) { // 회전
						p.rot = 1;
					} else if (p.rot == 1) {
						p.rot = 0;
					} else if (p.rot == 2) {
						p.rot = 3;
					} else if (p.rot == 3) {
						p.rot = 2;
					}
				}

				Point before = map[nx][ny];
				// 맵에 기존 값이 존재한다면 값을 비교
				if (before != null) {
					// 현재 값이 더 크다면
					if (before.size < p.size) {
						before.rot = p.rot;
					}
					before.size += p.size;

				}
				// 맵에 기존 값이 존재하지 않는다면
				else {
					map[nx][ny] = new Point(nx, ny, p.size, p.rot, p.level + 1);
				}
			}
		} // [E] q while

		// 모든 미생물 처리가 끝나면 맵을 탐색하여 미생물을 q에 저장
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] != null) {
					q.offer(map[i][j]);
				}
			}
		}

		// map 초기화
		map = new Point[N][N];
		bfs();
	}
}
