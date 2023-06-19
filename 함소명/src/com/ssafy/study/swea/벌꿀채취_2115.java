package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * A가 벌꿀을 채취하는거나 B가 벌꿀을 채취하는게 같으므로 -> 조합
 * 조합된 벌꿀의 합이 C를 넘지 않아야한다 -> 부분집합???
 * 
 * 가로만보니까 M개에서 얻을 수 있는 최대 이익을 배열에 저장.
 */
public class 벌꿀채취_2115 {
	static int N, M, C;
	static Point startM, endM;
	static int[][] map, maxMap;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());// 벌통 크기
			M = Integer.parseInt(st.nextToken());// 선택 할 벌통 개수
			C = Integer.parseInt(st.nextToken());// 벌꿀 채취량
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int Ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N - M; j++) {

					startM = new Point(i, j, 0, new int[M]);
					startbeneMax(i, j, new int[M], 0, 0, new boolean[M]);
					System.out.println(startM);

//					for (int er = i; er < N; er++) {
//						for (int ec = j; ec <= N-M; ec++) {
//							
//							endM = new Point(er, ec, 0, new int[M]);
//							endbeneMax(er, ec, new int[M], 0, 0, new boolean[M]);
//							System.out.println(endM);
//							int max = sum();
//							
//						}
//					}

				}
			}

			System.out.println("#" + test_case + " ");
		}

	}

	private static void endbeneMax(int r, int c, int[] sel, int sIdx, int sum, boolean[] v) {
		if (sum > C) {
			if (endM.sum <= sum - sel[sIdx - 1]) {
				endM.r = r;
				endM.c = c;
				endM.sum = sum - sel[sIdx - 1];
				
				sel[sIdx - 1] = 0;
				System.out.println(""+Arrays.toString(sel));
				endM.arr = sel;
			}
			return;
		}

		if (sIdx == sel.length) {
			if (endM.sum <= sum) {
				endM.arr = sel;
				endM.r = r;
				endM.c = c;
				endM.sum = sum;
			}
			return;
		}

		for (int k = 0; k < M; k++) {
			if (!v[k]) {
				v[k] = true;
				sel[sIdx] = map[r][c + k];
				startbeneMax(r, c, sel, sIdx + 1, sum + sel[sIdx], v);
				v[k] = false;
			}
		}
	}

	private static void startbeneMax(int r, int c, int[] sel, int sIdx, int sum, boolean[] v) {
		if (sum > C) {
			if (startM.sum <= sum - sel[sIdx - 1]) {
				startM.r = r;
				startM.c = c;
				startM.sum = sum - sel[sIdx - 1];
				sel[sIdx - 1] = 0;
				startM.arr = sel;
			}
			return;
		}

		if (sIdx == sel.length) {
			if (startM.sum <= sum) {
				startM.arr = sel;
				startM.r = r;
				startM.c = c;
				startM.sum = sum;
			}
			return;
		}

		for (int k = 0; k < M; k++) {
			if (!v[k]) {
				v[k] = true;
				sel[sIdx] = map[r][c + k];
				startbeneMax(r, c, sel, sIdx + 1, sum + sel[sIdx], v);
				v[k] = false;
			}
		}

	}

	static class Point {
		int r, c, sum;
		int[] arr;

		public Point(int r, int c, int sum, int[] arr) {
			super();
			this.r = r;
			this.c = c;
			this.sum = sum;
			this.arr = arr;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", sum=" + sum + ", arr=" + Arrays.toString(arr) + "]";
		}

	}
}