package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//파리퇴치
public class D2_2001 {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// M=2, (0,0)(1,1)
			// M=3, (0,0)(2,2)
			int Max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int sum = 0;
					if (i + M  <= N && j + M  <= N) {
						for (int k = i; k < i + M; k++) {
							for (int L = j; L < j + M; L++) {
								sum += arr[k][L];
							}
						}
					}
					Max = Math.max(Max, sum);
				}
			}

			System.out.println("#" + test_case + " "+Max);
		}

	}

}
