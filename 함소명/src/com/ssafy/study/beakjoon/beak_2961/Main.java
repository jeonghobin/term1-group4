package com.ssafy.study.beakjoon.beak_2961;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//도영이가 만든 맛있는 음식
//재료가 N개
//신맛 S => 신맛의 곱, 쓴맛 B => 쓴맛의 합
//신맛과 쓴맛의 차이를 가장 작게.
public class Main {
	static int Min = Integer.MAX_VALUE;
	static int[] S;
	static int[] B;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		B = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}

		Recur(0, 1, 0);
		System.out.println(Min);
	}

	public static void Recur(int k, int gob, int sum) {

		if (k == N) {
			if (gob > 1)
				Min = Math.min(Min, Math.abs(gob - sum));
			return;
		}

		Recur(k + 1, gob * S[k], sum + B[k]);
		Recur(k + 1, gob, sum);
	}

}
