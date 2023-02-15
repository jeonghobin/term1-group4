package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 1행, 1열로 시작해서 R행, C열까지 있으며, 총 R*C 칸
 * 수지는 지금 1행 1열에 있으며,각 칸에는 알파벳이 적혀있다
 * 각 알파벳 명물을 처음 볼 땐 무료, 명물을 최대한 많이 보되, 요금을 지급하지 않는 방법-> 경로에 특징이 있음. 완탐 DFS
 */
public class D4_7699 {
	static int N;
	static int M;
	static int max;
	static int[][] map;
	static boolean[]v;// A ~ Z까지 26개

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
					map[i][j] = str.charAt(j)-'0';
				}
			}
			DFS(0, 0, 1);

			System.out.println("#"+test_case+" "+max);
		}
	}

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	public static void DFS(int x, int y, int depth) {
		
		v[map[x][y]] = true;
//		depth++;
		max = Math.max(max, depth);

		for (int i = 0; i < 4; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];

			if (nx >= 0 && ny >= 0 && nx < N && ny < M  ) {
				if (!v[map[nx][ny]])
					DFS(nx, ny, depth+1);
			}
		}
		v[map[x][y]] = false;
	}
}
