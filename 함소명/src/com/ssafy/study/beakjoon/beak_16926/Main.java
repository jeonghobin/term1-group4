package com.ssafy.study.beakjoon.beak_16926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//배열 돌리기1
public class Main {

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());// 행
		int M = Integer.parseInt(st.nextToken());// 열
		int R = Integer.parseInt(st.nextToken());// 회전 수

		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int min = Math.min(N, M);
		// R만큼 회전
		for (int rot = 0; rot < R; rot++) {
			for (int cur = 0; cur < min / 2; cur++) {// 최대 껍질 수
				int r = cur;
				int c = cur;
				int idx = 0;// 방향 돌리기
				int first = arr[r][c];// 처음 값 저장

				while (idx < 4) {
					int dx = r + dr[idx];
					int dy = c + dc[idx];

					if (dx < cur || dx >= N - cur || dy < cur || dy >= M - cur) {
						idx++;
					} else {
						int temp = arr[dx][dy];
						arr[dx][dy] = first;
						first = temp;

						r = dx;
						c = dy;
					}

				}
				// 배열 길이가 작아지면 끝자리에 다시 들어감.
				arr[cur + 1][cur] = first;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}
}
