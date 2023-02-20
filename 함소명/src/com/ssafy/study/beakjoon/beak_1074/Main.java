package com.ssafy.study.beakjoon.beak_1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * Z
 * 분할로 문제 풀기.
 */
public class Main {
	static int cnt = 0;
	static int dr;
	static int dc;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		N = (int) Math.pow(2, N);// 제곱근

		dr = Integer.parseInt(st.nextToken());
		dc = Integer.parseInt(st.nextToken());

		cut(0, 0, N);

	}

	public static void cut(int r, int c, int N) {

		if (N == 1) {
			return;
		}

		int half = N / 2;
		if (half > dr && r < dr)
			cut(r, c, half);
		
		if (half < dr && N < dr)
			cut(r + N, c, half);
		
		if (half > dc && c < dc)
			cut(r + N, c, half);
		
		if (half < dc && N < dc)
			cut(r + N, c+N, half);

		cnt++;

		if (dr == r && dc == c) {
			System.out.println(cnt);
		}
	}
}
