package test.baekjoon.s1_11660;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

//		int map[][] = new int[N + 1][N + 1];
		int S[][] = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				S[i][j] = S[i][j - 1] + Integer.parseInt(st.nextToken());
			}
		}

//		print(S);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());

			int answer = 0;

			for (int r = startX; r <= endX; r++) {
				answer += S[r][endY] - S[r][startY - 1];
			}

			sb.append(answer + "\n");
		}
		System.out.println(sb);

	}

//	private static void print(int[][] s) {
//		for (int i = 0; i < s.length; i++) {
//			for (int j = 0; j < s[i].length; j++) {
//				System.out.print(s[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}
}
