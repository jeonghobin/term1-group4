package day10;

import java.io.*;
import java.util.*;

public class 감시 {

	static int[][] map;
	static int[][] copyMap;
	static int N, M, answer;
	static LinkedList<Point> q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 첫 번째 줄
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = Integer.MAX_VALUE;

		map = new int[N][M];
		q = new LinkedList<>();

		// 나머지 줄
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6) {
					q.offer(new Point(i, j, map[i][j], 0));
				}
			}
		}

//		print(map);

		sel = new int[q.size()];
		if (q.size() != 0) {
			dfs(0);
		} else {
			int nowAnswer = 0;
			for (int x = 0; x < map.length; x++) {
				for (int y = 0; y < map[0].length; y++) {
					if (map[x][y] == 0) {
						nowAnswer++;
					}
				}
			}
			answer = Math.min(nowAnswer, answer);
		}

		System.out.println(answer);

	} // [E] main

	static int[] sel;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	private static void dfs(int cnt) {
		// basis
		if (cnt == q.size()) {
			copyMap = new int[N][M];
			mapCopy(map, copyMap);

			// 2) 각 cctv를 정해진 회전방향으로 탐색
			// cctv 개수만큼 반복
			for (int i = 0; i < q.size(); i++) {
				Point p = q.get(i);

				// cctv의 종류에 따라서 다른 결과 도출
				if (p.camera == 1) {
					for (int c = 0; c < 1; c++) {
						search(p, c, i);
					}
				} else if (p.camera == 2) {
					for (int c = 0; c < 3; c = c + 2) {
						search(p, c, i);
					}
				} else if (p.camera == 3) {
					for (int c = 0; c < 2; c = c + 1) {
						search(p, c, i);
					}
				} else if (p.camera == 4) {
					for (int c = 0; c < 3; c = c + 1) {
						search(p, c, i);
					}
				} else if (p.camera == 5) {
					for (int c = 0; c < 4; c++) {
						search(p, c, i);
					}
				}

				// 3) 사각지대 개수 count
				int nowAnswer = 0;
				for (int x = 0; x < copyMap.length; x++) {
					for (int y = 0; y < copyMap[0].length; y++) {
						if (copyMap[x][y] == 0) {
							nowAnswer++;
						}
					}
				}
				answer = Math.min(nowAnswer, answer);
			}
			return;
		}

		// inductive
		// 1) 회전 방향을 정함
		for (int i = 0; i < 4; i++) {
			sel[cnt] = i;
			dfs(cnt + 1);
		}

	}

	private static void mapCopy(int[][] map, int[][] copyMap) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}

	private static void search(Point p, int c, int i) {
		// 한쪽 끝으로 반복
		for (int d = 1;; d++) {
			// 회전 방향 + 카메라의 감시 방향을 향해서 끝까지 보기
			int nx = p.x + dx[(sel[i] + c) % 4] * d;
			int ny = p.y + dy[(sel[i] + c) % 4] * d;
			// 지도 내에 위치하고 / 벽이 아니라면
			if (nx >= 0 && nx < copyMap.length && ny >= 0 && ny < copyMap[0].length && copyMap[nx][ny] != 6) {
				if (copyMap[nx][ny] == 0) {
					copyMap[nx][ny] = 9;
				}
			} else {
				break;
			}
		}

	}

	static class Point {
		int x;
		int y;
		int camera;
		int rot;

		Point(int x, int y, int camera, int rot) {
			this.x = x;
			this.y = y;
			this.camera = camera;
			this.rot = rot;
		}

	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
