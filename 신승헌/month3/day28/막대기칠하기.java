package day28;

import java.io.*;
import java.util.*;

public class 막대기칠하기 {
	// 1cm 노란 막대
	// 1cm 파란 막대
	// 2cm 빨간 막대
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 2;
		
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] * 2 + dp[i-2];
		}
		
		System.out.println(Arrays.toString(dp));
		
		System.out.println(dp[n]);
		
		
	}
}
