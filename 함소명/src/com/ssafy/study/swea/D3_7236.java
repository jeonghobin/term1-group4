package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 저수지의 물의 총 깊이 구하기 
 *  NxN 구획으로 이루어진 지역에 있는 저수지의 물(W)의 가장 깊은 물의 깊이는?
 *  애워싼 영역에 땅(G)이 있으면 땅을 뺀 합이 그 구획의 물 깊이다. But 모든 땅 둘러싸면 깊이는 1.
 *   
 *   
 */
public class D3_7236 {

	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			String[][] water = new String[N][N];
			int[][] length = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					water[i][j] = st.nextToken();
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int cnt = 0;
					for (int k = 0; k < 8; k++) {
						int dx = i + dr[k];
						int dy = j + dc[k];
						if (dx >= 0 && dy >= 0 && dx < N && dy < N) {
							if (water[dx][dy].equals("W"))
								cnt++;
						}
					}
					if (cnt == 0)
						length[i][j] = 1;
					else
						length[i][j] = cnt;
				}
			}
			int max = 0;
			for (int i = 0; i < length.length; i++) {
				for (int j = 0; j < length.length; j++) {
					max = Math.max(max, length[i][j]);
				}
			}
			System.out.println("#" + test_case + " " + max);

		}

	}

}
