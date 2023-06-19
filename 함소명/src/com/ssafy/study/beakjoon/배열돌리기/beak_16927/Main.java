package com.ssafy.study.beakjoon.배열돌리기.beak_16927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//배열돌리기2
public class Main {
	static int N, M, R;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 배열 돌리기
		Rotation();
	}

	private static void Rotation() {
		int rot = 0;
		int rotTime = R % (2*N + 2*M - 4);
		while (rot++ < rotTime) {
			// 껍질 수 
			for (int cur = 0; cur < Math.min(N, M) / 2; cur++) {
				int s = cur;
				int n = N-cur;
				int m = M-cur;
				//0,0
				//0,N-1
				//N-1,M-1
				//M-1,0
				
				//0+1,0+1 
				//0+1,N-2
				//N-2,M-2
				//M-2,0+1
				
				int temp = map[s][s];
				//위 열
				for (int i = s; i < m-1; i++) {
					map[s][i] = map[s][i+1];
				}
				//오 행
				for (int i = s; i < n-1; i++) {
					map[i][m-1] = map[i+1][m-1];
				}
				//아 열
				for (int i = m-1; i > s; i--) {
					map[n-1][i] = map[n-1][i-1];
				}
				//왼 행
				for (int i = n-1; i > s; i--) {
					map[i][s] = map[i-1][s];
				}
				
				map[s+1][s] = temp;
			}
		}
		
		print();
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}

}
