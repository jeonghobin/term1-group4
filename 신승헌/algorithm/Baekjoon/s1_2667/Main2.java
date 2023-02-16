package algo.bj.s1_2667;

import java.io.*;
import java.util.*;

public class Main2 {
	static int[][] map;
	static int answer; // 총 단지 개수
	static ArrayList<Integer> count = new ArrayList<>(); // 단지 크기

	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		// input
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String[] s = st.nextToken().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				// 탐색할 위치를 찾으면
				if (map[i][j] == 1) {
					bfs(i, j);
					answer++;
				}
			}
		}

		System.out.println(answer);
		Collections.sort(count);
		for (int i = 0; i < count.size(); i++) {
			System.out.println(count.get(i));
		}

	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	private static void bfs(int i, int j) {
		Queue<Point> q = new LinkedList<>();

		q.offer(new Point(i, j));

		int counter = 1;

		while(!q.isEmpty()) {
			Point p = q.poll();
			map[p.x][p.y] = 0;
			
			for (int k = 0; k < dx.length; k++) {
				int cx = p.x + dx[k];
				int cy = p.y + dy[k];

				if (cx >= 0 && cx < map.length && cy >= 0 && cy < map[0].length && map[cx][cy] == 1) {
					map[cx][cy] = 0;
					q.offer(new Point(cx, cy));
					counter++;
				}
			}
		}

		count.add(counter);

	}
}
