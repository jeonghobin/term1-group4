package com.ssafy.study.swea;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//이렇게 하면 시간초과남. 약품을 넣을 곳을 조합으로 찾는게 아니라 
//약품을 넣지 않는경우, A약품을 넣는 경우, B약품을 넣는 경우를 재귀/부분집합으로 만들어 돌리기
public class 보호필름_2112 {
	static int Ans, D, W, K;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());// 두께
			W = Integer.parseInt(st.nextToken());// 막
			K = Integer.parseInt(st.nextToken());// 합격 검사 개수
			Ans = Integer.MAX_VALUE;
			map = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 합격 검사
			if (PassTest() || D == 1) {
				System.out.println("#" + test_case + " " + 0);
				continue;
			}

			// 조합으로 넣기
			// 몇개 뽑을 건지 넣어주기
			for (int i = 1; i <= D; i++) {
				inputRow(new int[i], 0, 0, new boolean[D]);
			}
			System.out.println("#" + test_case + " " + Ans);

		}
	}

	private static void print() {
		for (int i = 0; i < D; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static boolean flag = false;

	private static void inputRow(int[] sel, int sIdx, int aIdx, boolean[] v) {
		if (Ans < sel.length)
			return;
		
		if (sIdx == sel.length) {
			System.out.println(Arrays.toString(sel));

			// 약품 투입할 수 있는 순열 돌리기
			// 두가지 약품 투입
			drugRecursive(sel, new int[] { 0, 1 }, new int[sel.length], 0);

			return;
		}

		// 약품을 투입할 곳 조합 돌리기.
		for (int i = aIdx; i < D; i++) {
			if (!v[i]) {
				v[i] = true;
				sel[sIdx] = i;
				inputRow(sel, sIdx + 1, i, v);
				v[i] = false;
				sel[sIdx] = i;
			}
		}
	}

	private static void drugRecursive(int[] com, int[] arr, int[] sel, int sIdx) {
		if (Ans < sel.length)
			return;

		if (sel.length == sIdx) {
			// 넣기 전 배열 복사
			int[][] copy = new int[com.length][W];
			for (int j = 0; j < com.length; j++) {
				for (int k = 0; k < W; k++) {
					copy[j][k] = map[com[j]][k];
				}
			}

			// 약품 막에 투입
			for (int j = 0; j < com.length; j++) {
				for (int k = 0; k < W; k++) {
					map[com[j]][k] = sel[j];
				}
			}

//			print();
//			System.out.println("-----------------------");

			// 합격 검사
			if (PassTest()) {
				Ans = Math.min(Ans, com.length);
			}

			// 검사 후 돌려 놓기
			for (int j = 0; j < copy.length; j++) {
				for (int k = 0; k < W; k++) {
					map[com[j]][k] = copy[j][k];
				}
			}

			return;
		}

		for (int i = 0; i < 2; i++) {
			sel[sIdx] = i;
			drugRecursive(com, arr, sel, sIdx + 1);
		}
	}

	// 합격 검사
	private static boolean PassTest() {
		for (int j = 0; j < W; j++) {
			boolean isSame = false;
			int sameCnt = 1;
			for (int i = 1; i < D; i++) {
				if (map[i][j] == map[i - 1][j])
					sameCnt++;
				else
					sameCnt = 1;

				// 누적하는 카운트값이 K개에 도달하면 ok!
				if (sameCnt == K) {
					isSame = true;
					break;
				}
			}
			if (!isSame)
				return false;
		}
		return true;
	}

}
