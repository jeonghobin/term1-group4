package com.ssafy.study.beakjoon.감시_15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// 0 오-1, 왼-2, 위-3, 아-4
	static int N, M;
	static int[] dr = { 0, 0, 0, -1, 1 };
	static int[] dc = { 0, 1, -1, 0, 0 };
	static int[][] map;
	static ArrayList<Point> list;
	static int[][] cctv1 = { { 1 }, { 2 }, { 3 }, { 4 } };
	static int[][] cctv2 = { { 1, 2 }, { 3, 4 } };
	static int[][] cctv3 = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 1 } };
	static int[][] cctv4 = { { 1, 2, 3 }, { 2, 3, 4 }, { 3, 4, 1 }, { 4, 1, 2 } };
//	static int[][] cctv5 = { { 1, 2, 3, 4 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		// 0은 빈 칸, 6은 벽, 1~5는 CCTV
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 6 && map[i][j] != 0)
					list.add(new Point(map[i][j], i, j));
			}
		}

		// 1 -> 4가지 경우
		// 2 -> 2가지 경우
		// 3 -> 4가지 경우
		// 4 -> 4가지 경우
		// 5 -> 1가지 경우
		// 경우의 수 = 경우 모두 곱하기;

		// 1. 각 CCTV 를 차례대로 선택해 가능한 방향 중 하나를 선택합니다.(순열)
		// 2. 선택한 방향에 대해 벽이나 CCTV 가 있을 때까지 직진하면서 사각 지대를 없앱니다.
		// 3.모든 CCTV 에 대해 선택한 방향을 모두 확인하면서 최소 사각 지대의 개수를 계산합니다.

		dfs(0);

		// for (int i = 0; i < list.size(); i++) {
//			int cctvN = list.get(i).num;
//			int r = list.get(i).r;
//			int c = list.get(i).c;
//			int[] dir;
//			if (cctvN == 5) {
//				dir = new int[] { 1, 2, 3, 4 };
//			} else {
//				dir = direction(cctvN, r, c);
//			}
//
//			int max = Math.max(N, M);
//			for (int j = 0; j < dir.length; j++) {
//				int d = dir[j];
//				
//				for (int m = 1; m <= max; m++) {
//					int nr = r + (dr[d] * m);
//					int nc = c + (dc[d] * m);
//
//					if (nr < 0 || nr >= N || nc < 0 || nc >= M)
//						continue;
//
//					if (map[nr][nc] == 6)// 벽을 만남
//						break;
//
//					map[nr][nc] = 9;// 감시구역 채우기
//				}
//			}
//
//		}




	}

	private static void dfs(int idx) {
		
	     // 모든 CCTV 에 대해 검사가 끝난 경우, 최소 사각 지대의 개수를 반환
        if (idx == list.size()) {
    		// 사각지대 개수 계산
    		int cnt = 0;
    		for (int i = 0; i < N; i++) {
    			for (int j = 0; j < M; j++) {
    				if (map[i][j] == 0)
    					cnt++;
    			}
    		}
    		
    		System.out.println(cnt);
    		return;
        }

        
        
	}

	private static int[] direction(int cctvN, int r, int c) {
		int[][] cctv = null;
		if (cctvN == 1)
			cctv = cctv1;
		if (cctvN == 2)
			cctv = cctv2;
		if (cctvN == 3)
			cctv = cctv3;
		if (cctvN == 4)
			cctv = cctv4;

		int[] sel = new int[1];
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < cctv.length; i++) {
			int[] dir = cctv[i];

			int cnt = 0;
			int max2 = Math.max(N, M);
			for (int j = 0; j < dir.length; j++) {
				int d = dir[j];

				for (int m = 1; m <= max2; m++) {
					int nr = r + (dr[d] * m);
					int nc = c + (dc[d] * m);

					if (nr < 0 || nr >= N || nc < 0 || nc >= M)
						continue;

					if (map[nr][nc] == 6)// 벽을 만남
						break;

					cnt++;
				}
			}

			if (cnt > max) {
				max = cnt;
				sel = cctv[i];
			}
		}

		return sel;
	}

	static class Point implements Comparable<Point> {
		int num, r, c;

		public Point(int num, int r, int c) {
			super();
			this.num = num;
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [num=" + num + ", r=" + r + ", c=" + c + "]";
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(o.num, this.num);
		}

	}
}
