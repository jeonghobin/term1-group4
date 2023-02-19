package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import com.azul.crs.client.service.FirstCallMonitor;

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
	static Ingredient[] S;// 시너지
	static int[][] ingredents;
	static boolean[] v;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			ingredents = new int[N + 1][N + 1];
			min = Integer.MAX_VALUE;

			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					ingredents[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int food = (N * N - N) / 2;// 경우의 수
			S = new Ingredient[food + 1];
			int k = 1;
			for (int i = 1; i <= N; i++) {
				for (int j = i; j <= N; j++) {
					if (i != j) {
						int s = ingredents[i][j] + ingredents[j][i];
						S[k] = new Ingredient(i, j, s);
						k++;
					}
				}
			}

		
			v = new boolean[food + 1];
			for (int m = 1; m < S.length; m++) {
				int sum = S[m].sum;

				v[S[m].r] = true;// 1
				v[S[m].c] = true;// 2
				for (int n = 1; n < S.length; n++) {
					if (S[m].r == S[n].r || S[m].r == S[n].c || S[m].c == S[n].c || S[m].c == S[n].r)
						continue;
					else {
						min = Math.min(min,  Math.abs(sum - S[n].sum));
//						
					}
				}
			}

			System.out.println(min);
		}
	}

	// 조합
	public static void cur(int k, int cha, int start) {
		if (k == S.length) {
			min = Math.min(min, cha);

			return;
		}
//		System.out.println(cha);

		if (!v[k]) {
			v[k] = true;
			System.out.println(start + ", " + S[k].sum);
			cur(k + 1, Math.abs(start - S[k].sum), start);
//			v[k] = false;
		}

	}
}

class Ingredient {
	int r, c, sum = 0;

	public Ingredient(int r, int c, int sum) {
		super();
		this.r = r;
		this.c = c;
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "ingredient [r=" + r + ", c=" + c + ", sum=" + sum + "]";
	}

}
