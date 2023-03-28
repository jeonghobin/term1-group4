package com.ssafy.study.beakjoon.일로만들기;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();

		// DP로 해결
		long[] dp = new long[X+1];
		// index 0과 1은 어떤 연산을 해도 1이 되지 않으므로 제외한다.
		// 0,0,1
		for (int i = 2; i <= X; i++) {
			long min = dp[i - 1] + 1;//항상
			if (i % 2 == 0)
				min = Math.min(min, dp[i / 2] + 1);
			if (i % 3 == 0)
				min = Math.min(min, dp[i / 3] + 1);
			dp[i] = min;
		}
		System.out.println(dp[X]);
	}

//	//시간초과
//	private static void recursive(int x, int cnt) {
//		if(x == 1) {
//			min = Math.min(min, cnt);
//			return;
//		}
//		recursive(x-1, cnt+1);
//		if(x%2==0)
//		recursive(x/2, cnt+1);
//		if(x%3==0)
//		recursive(x/3, cnt+1);
//	}

}