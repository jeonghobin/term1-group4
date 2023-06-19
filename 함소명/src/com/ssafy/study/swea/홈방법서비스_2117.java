package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 홈방법서비스_2117 {
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	// 보안회사가 손해를 보지 않고 서비스 가능한 최대 집의 수?
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());// 넓이
			int M = Integer.parseInt(st.nextToken());// 각 집이 내는 비용

			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int home = 1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					Queue<Point> Q = new LinkedList<>();
					boolean[][] v = new boolean[N][N];

					int cost = 1;// 운영비용, 마름모 면적
					int Hcnt = map[i][j]==1?1:0;// 서비스를 제공받는 집의 수
					
					Q.add(new Point(i, j, 1));
					v[i][j] = true;

					for (int k = 2; k <= N+1; k++) {// 마름모 크기
						cost = k * k + (k - 1) * (k - 1);
						
						int size = Q.size();
						while (size != 0) {
							Point p = Q.poll();

							for (int l = 0; l < 4; l++) {
								int nr = p.r + dr[l];
								int nc = p.c + dc[l];

								if (nr < 0 || nc < 0 || nr >= N || nc >= N || v[nr][nc])
									continue;

								if(map[nr][nc]==1) Hcnt++;
								
								v[nr][nc] = true;
								Q.add(new Point(nr, nc, p.cnt + 1));
							}
							
							size--;
						}
						
						if(((Hcnt*M)-cost)>=0) //손해보지 않으면
							home = Math.max(home, Hcnt);
					}

				}
			}

			System.out.println("#"+test_case+" "+home);
		}

	}

	static class Point {
		int r, c, cnt;

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
