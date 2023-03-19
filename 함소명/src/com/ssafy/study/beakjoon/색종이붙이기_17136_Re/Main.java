package com.ssafy.study.beakjoon.색종이붙이기_17136_Re;

import java.io.*;
import java.util.*;

/*
 * 1*1 ~ 5*5 색종이 5장씩 갖고 있음.
 * 5~1까지 큰 색종이 부터 붙이면 된다고 생각함.
 * 	 But 8*8 종이에 색종이를 붙일때, 5색종이부터 붙으면 색종이를 더 많이 사용하게 된다.
 * 따라서 붙일 수 있는 경우의 수를 모두 하고, 최소 색종이 개수를 알아야한다.
 * 
 * 	// 가장 큰거 5개 붙이고 나서 -> 4개 붙이고 나서 ~ 0개 붙이고 나서 다음 크기 다 붙여보기
	// 다음 크기도 똑같이..
 */
public class Main {
	static int[][] paper;
	static int maxSize;
	static int[] cntPaper;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		paper = new int[10][10];
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 붙일 수 있는 색종이 가장 큰 크기
		for (int k = 1; k < 6; k++) {
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					isPaper(i, j, k);
				}
			}
		}

		int resultCnt = Integer.MAX_VALUE;
		// 크기가 큰 색종이 부터 5장 붙여보기
		for (int T = maxSize; T > 0; T--) {
			cntPaper = new int[] { 0, 5, 5, 5, 5, 5 };
			cnt = 0;
			int[][] newPaper = new int[10][10];
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					newPaper[i][j] = paper[i][j];
				}
			}

			// + 더 작은걸 차례대로 다 붙여보기
			for (int k = T; k > 0; k--) {
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						putPaper(newPaper, i, j, k);
					}
				}

				// 다 붙여 졌는지 확인
				int sum = 0;
				for (int i = 0; i < 10; i++) {
					for (int j = 0; j < 10; j++) {
						sum += newPaper[i][j];
					}
				}

				if (sum == 0 && cnt != 0)
					resultCnt = Math.min(resultCnt, cnt);

			}
		}

		if (maxSize == 0)
			resultCnt = 0;

		System.out.println(resultCnt < Integer.MAX_VALUE ? resultCnt : -1);
	}

	// 가장 큰거 5개 붙이고 나서 -> 4개 붙이고 나서 ~ 0개 붙이고 나서 다음 크기 다 붙여보기
	// 담
	// 두번째 큰거 5개 붙이고 나서
	private static void putPaper(int[][] newPaper, int r, int c, int size) {
		if (cntPaper[size] == 0)
			return;

		if (r + size > 10 || c + size > 10)
			return;

		// size의 색종이를 붙일 수 있는지 없는지 검사
		boolean isboolean = true;
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (newPaper[i][j] == 0)
					isboolean = false;
			}
		}

		// 붙일 수 있다면 붙이기
		if (isboolean) {
			for (int i = r; i < r + size; i++) {
				for (int j = c; j < c + size; j++) {
					newPaper[i][j] = 0;// 다시 복구해야하는데..
				}
			}

//			print(newPaper);

			cnt++;
			cntPaper[size]--;
		}
	}

	private static void print(int[][] print) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(print[i][j]);
			}
			System.out.println();
		}
		System.out.println("----------------");
	}

	private static void isPaper(int nr, int nc, int size) {
		if (nr + size > 10 || nc + size > 10)
			return;

		boolean isboolean = true;
		for (int i = nr; i < nr + size; i++) {
			for (int j = nc; j < nc + size; j++) {
				if (paper[i][j] == 0)
					isboolean = false;
			}
		}

		if (isboolean && size > maxSize)
			maxSize = size;
	}
}
