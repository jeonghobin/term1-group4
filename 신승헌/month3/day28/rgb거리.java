package day28;

import java.io.*;
import java.util.*;

public class rgb거리 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int[][] home = new int[n][3];
		
		for (int i = 0; i < n; i++) { // 집의 개수
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) { // 각 집의 색칠 비용
				home[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] dp = new int[n][3]; 
		
		dp[0][0] = home[0][0];
		dp[0][1] = home[0][1];
		dp[0][2] = home[0][2];
		
		for (int i = 1; i < n; i++) { // 집의 개수만큼 반복
			// 색깔 개수만큼 반복
			dp[i][0] = Math.min(dp[i-1][1] + home[i][0], dp[i-1][2] + home[i][0]);
			dp[i][1] = Math.min(dp[i-1][0] + home[i][1], dp[i-1][2] + home[i][1]);
			dp[i][2] = Math.min(dp[i-1][0] + home[i][2], dp[i-1][1] + home[i][2]);
		}
		
		System.out.println(Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2])));
		
	}
}
