package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 규영이와 인영이의 카드게임
 * 1이상 18이하 카드 9장씩 카드를 나눈다. 아홉 라운드. 
 * 높은 수가 적힌 카드를 낸 사람은 두 카드 합만큼 점수를 얻고, 진사람은 0
 * 규영이가 이기는 경우와 지는 경우가 총 몇 가지 인지 구하는 프로그램
 */
public class D3_6808 {
	static int N;
	static int win;
	static int lose;
	static int[] card;
	static int[] card2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			card = new int[9 + 1];
			card2 = new int[9 + 1];
			boolean[] v = new boolean[18 + 1];// 18개의 카드

			win = 0;
			lose = 0;

			// 규영이가 선택한 카드 정보
			for (int i = 0; i < 9; i++) {
				card[i] = Integer.parseInt(st.nextToken());
				v[card[i]] = true; // 규영이가 선택한 카드는 true로 체크
			}

			int tmp = 0;
			for (int i = 1; i <= 18; i++) {
				if (!v[i]) // 상대방 카드 : 카드가 체크가 안되어있는 경우, bd2에 카드 숫자 넣는다.
					card2[tmp++] = i;
			}
			System.out.println(Arrays.toString(card2));

			cur(new boolean[9], 0, 0, 0);

			System.out.println("#" + test_case +" "+ win + " " + lose);
		}
	}

	public static void cur(boolean[] v, int k, int sum1, int sum2) {
		if (k == 9) { // 9라운드가 지나고, 값 비교를 통해
			if (sum1 > sum2)
				win++; // 이긴 가지수
			if (sum1 < sum2)
				lose++;
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (!v[i]) {
				v[i] = true;
				if (card[k] > card2[i]) {
					cur(v, k + 1, sum1 + card[k] + card2[i], sum2); // 이긴경우.
				} else {
					cur(v, k + 1, sum1, sum2 + card[k] + card2[i]); // 진경우.
				}
				v[i] = false;
			}
		}
	}
}
