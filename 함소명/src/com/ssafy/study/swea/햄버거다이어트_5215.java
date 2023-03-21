package com.ssafy.study.swea;

import java.io.*;
import java.util.*;

/*
 * 조합 , 같은 재료 다시 사용 못함, 칼로리 넘지 않게
 */
public class 햄버거다이어트_5215 {
	static int N, LimitCal, max;
	static HashMap<Integer, int[]> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			LimitCal = Integer.parseInt(st.nextToken());
			max = Integer.MIN_VALUE;

			map = new HashMap<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int score = Integer.parseInt(st.nextToken());
				int cal = Integer.parseInt(st.nextToken());
				map.put(i, new int[] { score, cal });
			}

			recursive(map, 0, 0, 0, new boolean[N]);
//			recursive(0, 0, 0);

			System.out.println("#" + test_case + " " + max);
		}
	}

	private static void recursive(HashMap<Integer, int[]> map, int k, int ScoreSum, int Calsum, boolean[] v) {
		if (Calsum > LimitCal)
			return;

		max = Math.max(max, ScoreSum);

		if (max < ScoreSum)
			return;

		for (int i = k; i < N; i++) {
			if (!v[i]) {
				v[i] = true;
				recursive(map, i, ScoreSum + map.get(i)[0], Calsum + map.get(i)[1], v);
				v[i] = false;
			}
		}
	}

//	private static void recursive(int k, int ScoreSum, int Calsum) {
//		if (Calsum > LimitCal)
//			return;
//
//		max = Math.max(max, ScoreSum);
//
//		if (max < ScoreSum)
//			return;
//
//		if (k == N)
//			return;
//
//		recursive(k + 1, ScoreSum + map.get(k)[0], Calsum + map.get(k)[1]);
//		recursive(k + 1, ScoreSum, Calsum);
//	}

}
