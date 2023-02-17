package algo.bj.s1_2178;

import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String[] s = st.nextToken().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		bfs(0, 0, 0);
		
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
	
	private static void bfs(int x, int y, int level) {
		Queue<Point> q = new LinkedList<>();
		
		q.offer(new Point(x, y, level));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if (p.x == map.length - 1 && p.y == map[0].length -1) {
				System.out.println(p.level + 1);
				break;
			}
			
			for (int i = 0; i < dx.length; i++) {
				int cx = p.x + dx[i];
				int cy = p.y + dy[i];
				
				if (cx >= 0 && cx < map.length && cy >= 0 && cy < map[0].length
					&& map[cx][cy] == 1) {
					map[cx][cy] = 0;
					q.offer(new Point(cx, cy, p.level + 1));
				}
			}
		}
	}
}
