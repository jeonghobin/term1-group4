package com.ssafy.study.beakjoon.beak_16926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//다시, 달팽이
public class Main {

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
		
		int temp;
		int prev = 0;

		for (int round = 0; round < Math.min(N, M) / 2; round++) {
			for (int Rotation = 0; Rotation < R; Rotation++) {
				int row = round - 1;
				int col = round;
				prev = arr[row + 1][col + 1];

				int num = 0;
				int direction = 1;
				for (int xxx = 0; xxx < 2; xxx++) {

					for (int i = 0; i < N - round * 2 - num; i++) {
						row += direction;

						temp = arr[row][col];
						arr[row][col] = prev;
						prev = temp;
					}

					num++;

					for (int i = 0; i < M - round * 2 - num; i++) {
						col += direction;

						temp = arr[row][col];
						arr[row][col] = prev;
						prev = temp;
					}

					direction *= -1;

				}
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
