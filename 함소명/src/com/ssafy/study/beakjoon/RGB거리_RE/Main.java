package com.ssafy.study.beakjoon.RGB거리_RE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 1~N 까지 집
 * 인접한 집의 색이 같지 않게 칠 할 수 있는 최소비용?
 */
public class Main {
	static int N, result = Integer.MAX_VALUE;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N + 1][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 첫 집과 두번째 집의 color index가 다른 두 집의 최소 값을 저장한다.
		int[][] dp = new int[N + 1][3];
		dp[0][0] = map[0][0];
		dp[0][1] = map[0][1];
		dp[0][2] = map[0][2];
		
		//dp[0][0] dp[0][1] dp[0][2]
//		dp[1][0]= map[1][0]+dp[0][1] map[1][0]+dp[0][2]->min 
//		dp[1][1]= map[1][1]+dp[0][0] map[1][1]+dp[0][2]->min 
//		dp[1][2]= map[1][2]+dp[0][0] map[1][2]+dp[0][1]->min 
		
		// 두번째 집부터 계산
		for (int i = 1; i < N; i++) {
			// 색깔 개수만큼 반복
			dp[i][0] = Math.min(dp[i - 1][1] + map[i][0], dp[i - 1][2] + map[i][0]);
			dp[i][1] = Math.min(dp[i - 1][0] + map[i][1], dp[i - 1][2] + map[i][1]);
			dp[i][2] = Math.min(dp[i - 1][0] + map[i][2], dp[i - 1][1] + map[i][2]);
		}

		System.out.println(Math.min(dp[N - 1][0], Math.min(dp[N - 1][1], dp[N - 1][2])));
	}

}
