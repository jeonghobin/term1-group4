package com.ssafy.study.beakjoon.배열돌리기.beak_16926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[][] list = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Rotation(list, N, M, R);

	}

	private static void Rotation(int[][] list, int rN, int rM, int R) {
		if (R == 0) {
			print(list, rN, rM);
			return;
		}

		int[][] map = new int[rN][rM];
		
		for (int i = 0; i < rN; i++) {
			for (int j = 0; j < rM; j++) {
				// 오른쪽
				if(j < rM-1)
					map[i][j] = list[i][j+1];
				else//rM == j
					map[i][j] = list[rN-1][j+1];
			}
			// 위
			map[i][rM-1] = list[i][rM-2];
			
			for (int j = 0; j < rM; j++) {
				// 왼쪽
				if(j > 0)
					map[i][j] = list[i][j-1];
				else
					map[i][j] = list[i-1][j-1];
			}
			// 아래
			map[i][0] = list[i-1][0];
		}
		
		print(map, rN, rM);
		//배열 자체 돌리기
//		int tmp = rN;
//		rN = rM;
//		rM = tmp;

		Rotation(map, rN, rM, R - 1);
	}

	private static void print(int[][] list, int N, int M) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(list[i][j] + " ");
			}
			System.out.println();
		}
	}

}
