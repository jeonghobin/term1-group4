package com.ssafy.study.swea.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 수지의수지맞은여행
 * 1행, 1열로 시작해서 R행, C열까지 있으며, 총 R*C 칸
 * 수지는 지금 1행 1열에 있으며,각 칸에는 알파벳이 적혀있다
 * 각 알파벳 명물을 처음 볼 땐 무료, 명물을 최대한 많이 보되, 요금을 지급하지 않는 방법
 * 
 * 접근 -> 경로에 특징이 있음. 완탐 DFS
 */
public class D4_7699 {
	static int N;
	static int M;
	static int max;
	static int[][] map;
	static boolean[] v;// A ~ Z까지 26개

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			v = new boolean[100];
			max = 0;
			map = new int[N][M];

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			DFS(0, 0, 1);

			System.out.println("#" + test_case + " " + max);
		}
	}

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	public static void DFS(int x, int y, int depth) {
		
		max = Math.max(max, depth);
		v[map[x][y]] = true;
		
		for (int k = 0; k < 4; k++) {
			int dx = x + dr[k];
			int dy = y + dc[k];

			if (dx >= 0 && dy >= 0 && dx < N && dy < M) {
				if (!v[map[dx][dy]]) {
					DFS(dx, dy, depth+1);
				}
			}
		}
		v[map[x][y]] = false;//뒤로 돌아와 다시 검색
	}
}
