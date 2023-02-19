package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 4012. [모의 SW 역량테스트] 요리사
 * 2명의 손님에게 비슷한 음식을 만들어 내야한다. 
 * A음식과 B음식의 맛의 차이가 최소가 되도록 재료 분배 N/2(N은 짝수이다.)
 * 식재료 i를 식재료 j와 같이 요리하게 되면 시너지 Sij, 두 음식 맛 차이 최소값은?
 * 
 * 접근 -> 시너지 합. 조합
 */
public class 요리사_4012 {
	static int N;
	static int min;// 최소 차
	static int[] S;// 시너지
	static int[][] ingredents;
	static boolean[] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			ingredents = new int[N][N];
			min = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					ingredents[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = i; j < N; j++) {
					ingredents[i][j] = ingredents[i][j] + ingredents[j][i];
				}
			}

			System.out.println(Arrays.deepToString(ingredents));
			// solve
//			combination(0, 0);

			System.out.println(min);
		}
	}

	public static void combination() {
	

	}
}
