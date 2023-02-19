package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 1861. 정사각형 방
 * N2개의 방이 N×N형태, 위에서 i번째 줄의 왼쪽에서 j번째 방에는 1이상 N2 이하의 수 Ai,j가 적혀 있으며,이 숫자는 모든 방에 대해 서로 다르다.
 * 이동하려는 방에 적힌 숫자가 현재 방에 적힌 숫자보다 정확히 1 더 커야 한다.
 * 가장 많이 이동 할 수 있는 경우 수는?
 * 
 * 접근 -> 시작점에서 최대 몇 개의 방을 이동할 수 있는지 탐색 완탐 DFS
 */
public class D4_1861 {
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static int[][] map;
	static int max;
	static int Snum[];// 시작점에서 갈수 있는 방문 기록
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N + 1][N + 1];
			Snum = new int[N * N + 1];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

				}
			}

			// 방 탐색
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					max = 0;
					DFS(1, 1, 0, map[i][j]);
				}
			}

			
			int maxIdx = 0;
			int maxNum = 0;
			// 방의 개수가 최대인 시작점 찾기 (여럿이라면 적힌 수가 가장 작은 것)
			for (int i = Snum.length - 1; i > 0; i--) {
				if (Snum[i] >= max) {
					maxIdx = Snum[i];
					maxNum = i;
				}
			}
			
			// 처음에 출발해야 하는 방 번호 , 최대 몇 개의 방을 이동할 수 있는지
			System.out.println("#" + test_case + " " + maxNum + " " + maxIdx);
		}
	}

	static int temp;

	private static void DFS(int r, int c, int path, int start) {

		if (max <= path) {
			max = path;
			Snum[start] = max; // Snum start 시작점에 max 인덱스 넣는다.
		}

		// 이동하려는 방에 적힌 숫자가 현재 방에 적힌 숫자보다 정확히 1 더 커야 한다.
		for (int i = 0; i < 4; i++) {
			int nx = r + dr[i];
			int ny = c + dc[i];

			if (nx > 1 && ny > 1 && nx <= N && ny <= N) {
				if (map[nx][ny] - map[r][c] == 1) {// 정확히 1 더 커야 한다.
					DFS(nx, nx, path + 1, start);
					System.out.println("@@" + path + 1);
				}
			}
		}

		
	
	}
}
