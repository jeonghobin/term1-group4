package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 치즈도둑
 * 요정은 100일동안 치즈를 갉아먹는데
 * 맛있는 정도는 1부터 100 사이, X번째날에는 맛있는 정도가 X인 칸을 먹어버린다.
 * 치즈 덩어리란상, 하, 좌, 우로인접한 칸들을 하나로 묶어놓은 것
 * 100일 중에서 치즈덩어리가 가장 많을 때의 덩어리 개수
 * 
 */

public class D4_7733 {
	static int N;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			DFS(0, 0, 1);
		}
	}

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	public static void DFS(int r, int c, int day) {
		int eat = map[r][c]-day;

		for (int i = 0; i < 4; i++) {
			int nx = r + dr[i];
			int ny = c + dc[i];

			if (nx >= 0 && ny >= 0 && nx < N && ny < N) {

				DFS(nx, ny, day + 1);
			}
		}

	}

}
