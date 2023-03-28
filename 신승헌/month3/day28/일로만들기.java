package day28;

import java.io.*;
import java.util.*;

public class 일로만들기 {
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		dp = new int[n+1];

		// 상향식
		dp[0] = 0;
		dp[1] = 0;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + 1;
			if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
			if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
		}
		System.out.println(dp[n]);
		
		// 하향식
//		dp = new int[n+1];
//		Arrays.fill(dp, -1);
//		dp[1] = 0;
//		
//		System.out.println(recursive(n));
		
	}

	private static int recursive(int n) {
		// 찾지 못했다면
		if (dp[n] == -1) {
			// 2와 3 모두 나누어 떨어지는 경우
			if (n % 6 == 0) {
				dp[n] = Math.min( recursive(n / 3), Math.min(recursive(n / 2), recursive(n - 1)) ) + 1;
			}
			// 3으로 나누어 떨어지는 경우
			else if (n % 3 == 0) {
				dp[n] = Math.min(recursive(n / 3), recursive(n - 1)) + 1;
			}
			// 2로 나누어 떨어지는 경우
			else if (n % 2 == 0) {
				dp[n] = Math.min(recursive(n / 2), recursive(n - 1)) + 1;
			}
			// 2와 3으로 나누어떨어지지 않는 경우
			else {
				dp[n] = recursive(n - 1) + 1;
			}
		}
		return dp[n];
		
		
	}
}
