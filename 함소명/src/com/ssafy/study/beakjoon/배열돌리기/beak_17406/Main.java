package com.ssafy.study.beakjoon.배열돌리기.beak_17406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//배열돌리기4
public class Main {
	static int N, M, K, min = Integer.MAX_VALUE;
	static int[][] A, copy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());// 회전 연산 개수

		// N×M 크기인 배열 A가 있을때, 배열 A의 값은 각 행에 있는 모든 수의 합 중 최솟값을 의미한다.
		A = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Input[] input = new Input[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());

			input[i] = new Input(r, c, s);
		}

		// 순열로 경우의 수 구하기
		recursive(input, new Input[K], 0, new boolean[K]);

		System.out.println(min);

	}

	// 중복되지 않는 순열
	private static void recursive(Input[] input, Input[] sel, int sIdx, boolean[] v) {
		if (sIdx == sel.length) {
//			System.out.println(Arrays.toString(sel));

			// 깊은 복사
			copy = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					copy[i][j] = A[i][j];
				}
			}

			// 배열 돌리기
			doCycle(sel);

			// 최솟값 구하기
			for (int i = 0; i < N; i++) {
				int sum = 0;
				for (int j = 0; j < M; j++) {
					sum += copy[i][j];
				}
				min = Math.min(sum, min);
			}

			return;
		}

		for (int i = 0; i < input.length; i++) {
			if (!v[i]) {
				sel[sIdx] = input[i];
				v[i] = true;
				recursive(input, sel, sIdx + 1, v);
				v[i] = false;
			}
		}
	}

	public static void doCycle(Input[] arr) {
		for (int k = 0; k < K; k++) {
			int r = arr[k].r;
			int c = arr[k].c;
			int S = arr[k].s;

			// 껍질 수를 계산하는게 아니라
			// 가장 왼쪽 윗 칸이 (r-s, c-s), 가장 오른쪽 아랫 칸이 (r+s, c+s)로 주어졌으니까,
			// s가 껍질이라는 것을 파악해야한다.
//			int roll = Math.min((er - sr), (ec - sc)) / 2;// 껍질 수
			for (int s = 1; s <= S; s++) {
				// 위
				int upTmp = copy[r - s][c + s];
				for (int y = c + s; y > c - s; y--) {
					copy[r - s][y] = copy[r - s][y - 1];
				}
				// 오른쪽
				int rightTmp = copy[r + s][c + s];
				for (int x = r + s; x > r - s; x--) {
					copy[x][c + s] = copy[x - 1][c + s];
				}
				copy[r - s + 1][c + s] = upTmp;
				// 아래
				int leftTmp = copy[r + s][c - s];
				for (int y = c - s; y < c + s; y++) {
					copy[r + s][y] = copy[r + s][y + 1];
				}
				copy[r + s][c + s - 1] = rightTmp;
				// 왼쪽
				for (int x = r - s; x < r + s; x++) {
					copy[x][c - s] = copy[x + 1][c - s];
				}
				copy[r + s - 1][c - s] = leftTmp;
			}
		}
	}


	static class Input {
		int r, c, s;

		public Input(int r, int c, int s) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}

}
