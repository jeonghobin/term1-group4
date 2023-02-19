package algo.swea.d_4012;

import java.io.*;
import java.util.*;

public class Solution3 {
	static int[][] synergy;
	static int nowATaste;
	static int nowBTaste;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());

			synergy = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			nowATaste = 0;
			nowBTaste = 0;
			answer = Integer.MAX_VALUE;
			recursive(new int[N / 2], 0, 0);

			System.out.println("#" + test_case + " " + answer);

		} // [E] test_case
	}

	private static void recursive(int[] sel, int aIdx, int sIdx) {
		// basis part
		if (sIdx == synergy.length / 2) {
			// 음식 a의 식재료 

			// 음식 b의 식재료
			int[] bSel = new int[synergy.length / 2];

			boolean[] v = new boolean[synergy.length];
			for (int i = 0; i < sel.length; i++) {
				v[sel[i]] = true;
			}

			int bIdx = 0;
			for (int i = 0; i < v.length; i++) {
				if (v[i] == false) {
					bSel[bIdx] = i;
					bIdx++;
				}
			}

			sRecursive(sel, new int[2], 0, 0, 'a');
			sRecursive(bSel, new int[2], 0, 0, 'b');

			// compare
			if (answer > Math.abs(nowATaste - nowBTaste)) {
				answer = Math.abs(nowATaste - nowBTaste);
			}
			nowATaste = 0;
			nowBTaste = 0;

			return;
		}

		// inductive part
		for (int i = aIdx; i < synergy.length; i++) {
			sel[sIdx] = i;
			recursive(sel, i + 1, sIdx + 1);
		}
	}

	private static void sRecursive(int[] arr, int[] sel, int aIdx, int sIdx, char type) {
		// basis part
		if (sel.length == sIdx) {
			if (type == 'a') {
				nowATaste += synergy[sel[0]][sel[1]] + synergy[sel[1]][sel[0]];
			}
			if (type == 'b') {
				nowBTaste += synergy[sel[0]][sel[1]] + synergy[sel[1]][sel[0]];
			}
			return;
		}

		// inductive part
		for (int i = aIdx; i < arr.length; i++) {
			sel[sIdx] = arr[i];
			sRecursive(arr, sel, i + 1, sIdx + 1, type);
		}
	}
}
