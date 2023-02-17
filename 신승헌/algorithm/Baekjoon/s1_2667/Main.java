package algo.bj.s1_2667;

import java.io.*;
import java.util.*;


public class Main {
	static int[][] map;
	static boolean[][] v;
	
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {-1, 0, 1, 0};
	
	static ArrayList<Integer> answer = new ArrayList<>();
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		v = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String[] S = st.nextToken().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(S[j]);
			}
		}
		
//		print(map);
		
		int count = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (map[i][j] == 1) {
					bfs(i, j);
					count++;
				}
			}
		}
		
		System.out.println(count);
		
		Collections.sort(answer);
		
		for (int i = 0; i < answer.size(); i++) {
			System.out.println(answer.get(i));
		}
	}

	static class Point {
		int r, c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	private static void bfs(int i, int j) {
		Queue<Point> q = new LinkedList();
		
		v[i][j] = true;
		q.offer(new Point(i, j));
		map[i][j] = 0;
		
		int cnt = 1;
		while (!q.isEmpty()) {
			Point nowP = q.poll();
			
			for (int k = 0; k < dx.length; k++) {
				int cx = nowP.r + dx[k];
				int cy = nowP.c + dy[k];
				
				if (cx >= 0 && cx < map.length && cy >= 0 && cy < map.length 
						&& map[cx][cy] == 1) {
					map[cx][cy] = 0;
//					v[cx][cy] = true;
					q.add(new Point(cx, cy));
					cnt++;
				}
			}
		}
		answer.add(cnt);
	}

	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
