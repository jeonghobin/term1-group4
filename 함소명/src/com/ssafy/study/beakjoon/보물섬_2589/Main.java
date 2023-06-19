package com.ssafy.study.beakjoon.보물섬_2589;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	
	//육지L, 바다W
	//보물은 서로 최단 거리로 이동하는데 있어 가장 긴 시간이 걸리는 육지 두곳에 묻혀있다.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);;
			}
		}
		
		//가장 긴 거리 찾기
		int Ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]=='L') {
					Queue<Point> Q = new LinkedList<>();
					boolean[][] v = new boolean[N][M];
					Q.add(new Point(i, j, 0));
					v[i][j] = true;
					
					while (!Q.isEmpty()) {
						Point p = Q.poll();
						
						Ans = Math.max(Ans, p.cnt);
						
						for (int k = 0; k < 4; k++) {
							int nr = p.r+dr[k];
							int nc = p.c+dc[k];
							
							if(nr<0||nr>=N||nc<0||nc>=M||v[nr][nc]||map[nr][nc]!='L') continue;
							
							Q.add(new Point(nr, nc, p.cnt+1));
							v[nr][nc] = true;
						}
					}
					
					
				}
			}
		}
		
		System.out.println(Ans);
	}
	
	static class Point{
		int r,c,cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}
		
	}

}
