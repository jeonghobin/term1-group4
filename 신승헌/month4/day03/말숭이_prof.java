package day03;

import java.io.*;
import java.util.*;

// bfs
// 방문배열, dr, dc

public class 말숭이_prof {
	static int W, H, K;
	static int answer = Integer.MAX_VALUE;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		
		map = new int[H][W];
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		bfs();
		
		print(map);
		System.out.println(answer==Integer.MAX_VALUE?-1:answer);
	}
	
	static class Point {
		int x, y, cnt, k;

		public Point(int x, int y, int cnt, int k) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.k = k;
		}
	}
	
	
//	static int[] mdx = {-1, 0, 1, 0};
//	static int[] mdy = {0, 1, 0, -1};
//	
//	static int[] hdx = {-2, -1, 1, 2, 2, 1, -1, -2};
//	static int[] hdy = {1, 2, 2, 1, -1, -2, -2, -1};
	
	// 말처럼 뛰는 경우와 원숭이처럼 뛰는 경우를 모두 합쳐서 풀기
	static int[] dx = {-1, 0, 1, 0, -2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dy = {0, 1, 0, -1, 1, 2, 2, 1, -1, -2, -2, -1};

	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		// 말을 몇 번 써서 왔는지를 저장할 수 있도록 3차원 배열을 사용해야 함
		boolean[][][] v = new boolean[H][W][K+1];
		
		q.add(new Point(0, 0, 0, K));
		v[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.x == H-1 && p.y == W-1) {
				answer = Math.min(answer, p.cnt);
				break;
			}
			// 말처럼 뛸 수 있으면 12번, 아니면 4번까지 반복
			for (int d = 0; d < (p.k>0?12:4); d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				// 원숭이처럼 뛰면 k는 그대로, 말처럼 뛰면 k감소
				int nk = d < 4 ? p.k : p.k - 1;
				
				if(nx >= 0 && nx < H && ny >= 0 && ny < W && !v[nx][ny][nk] && map[nx][ny] != 1 ) {
					v[nx][ny][nk] = true;
					q.offer(new Point(nx, ny, p.cnt+1, nk));
				}
			}
		}
	}



	private static void print(int[][] map) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
