package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * A가 벌꿀을 채취하는거나 B가 벌꿀을 채취하는게 같으므로 -> 조합
 * 조합된 벌꿀의 합이 C를 넘지 않아야한다 -> 부분집합???
 * 
 * 가로만보니까 M개에서 얻을 수 있는 최대 이익을 배열에 저장.
 */
public class 벌꿀채취_2115 {
	static int N,M,C;
	static int[][] map, maxMap;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());//벌통 크기
			M = Integer.parseInt(br.readLine());//선택 할 벌통 개수
			C = Integer.parseInt(br.readLine());//벌꿀 채취량
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			System.out.println("#" + test_case + " " + getMaxBenefit());
		}

	}

	private static int getMaxBenefit() {
		makeMaxMap();
		return processCombination();
	}
	private static void makeMaxMap() {
		for (int i = 0; i < N; ++i) { // 연속된 M개를 만들수 있는 위치마다 연속 M개로 만들수 있는 부분집합의 최대이익 계산
			for (int j = 0; j <= N - M; ++j) {
				makeMaxSubset(i, j, 0, 0, 0);
			}
		}
	}
	private static void makeMaxSubset(int i, int j, int cnt, int sum, int powSum) {

		if (sum > C) return;
		if (cnt == M) {
			if (maxMap[i][j - M] < powSum) maxMap[i][j - M] = powSum;
			return;
		}
		makeMaxSubset(i, j + 1, cnt + 1, sum + map[i][j], powSum + map[i][j] * map[i][j]); // 선택
		makeMaxSubset(i, j + 1, cnt + 1, sum, powSum); // 비선택
	}

	private static int processCombination() {
		int max = 0, aBenefit = 0, bMaxBenefit;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j <= N - M; ++j) { // a 일꾼
				aBenefit = maxMap[i][j];

				bMaxBenefit = 0;
				// b 일꾼 조합
				for (int j2 = j + M; j2 <= N - M; j2++) { // 같은 행 뒷쪽 열
					if (bMaxBenefit < maxMap[i][j2])
						bMaxBenefit = maxMap[i][j2];
				}

				for (int i2 = i + 1; i2 < N; i2++) { // 다음 행 첫열부터
					for (int j2 = 0; j2 <= N - M; j2++) {
						if (bMaxBenefit < maxMap[i2][j2])
							bMaxBenefit = maxMap[i2][j2];
					}
				}
				if (max < aBenefit + bMaxBenefit)
					max = aBenefit + bMaxBenefit;
			}
		}
		return max;
	}
}