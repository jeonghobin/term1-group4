package test.baekjoon.s3_11659;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];

		int[] S = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			System.out.println(S[m] - S[n - 1]);

		}

	}

}
