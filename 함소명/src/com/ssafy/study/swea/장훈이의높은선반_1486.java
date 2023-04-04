package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 장훈이의높은선반_1486 {
	static int S, Ans, B;
	static int[] H;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());// 점원수
			B = Integer.parseInt(st.nextToken());// 물건높이
			Ans = Integer.MAX_VALUE;
			H = new int[S];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < S; i++) {
				H[i] = Integer.parseInt(st.nextToken());
			}

//			for (int i = 2; i <= S; i++) {
//				recursive(new int[i], 0, 0, 0, new boolean[S]);
//			}

			dfs(0, 0);

			System.out.println("#" + test_case + " " + Ans);

		}

	}

	private static void dfs(int Idx, int sum) {
		if (Idx >= S) {
			//끝까지 확인해줘야한다. 
			if (sum >= B)
				Ans = Math.min(Ans, Math.abs(sum - B));
			return;
		}

		if (sum >= B) {
			Ans = Math.min(Ans, Math.abs(sum - B));
			return;
		}

		dfs(Idx + 1, sum + H[Idx]);
		dfs(Idx + 1, sum);

	}

	private static void recursive(int[] sel, int sIdx, int aIdx, int sum, boolean[] v) {
		if (sIdx == sel.length) {
			if (sum >= B)
				Ans = Math.min(Ans, Math.abs(sum - B));
			return;
		}

		for (int i = aIdx; i < H.length; i++) {
			if (!v[i]) {
				v[i] = true;
				sel[sIdx] = H[i];
				recursive(sel, sIdx + 1, i, sum + H[i], v);
				v[i] = false;
				sel[sIdx] = H[i];
			}
		}
	}
}
