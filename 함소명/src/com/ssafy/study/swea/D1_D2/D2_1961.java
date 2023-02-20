package com.ssafy.study.swea.D1_D2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

//숫자 배열 회전
public class D2_1961 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			System.out.println("#" + i);
			int N = sc.nextInt();

			int[][] list = new int[N][N];
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					list[j][j2] = sc.nextInt();
				}
			}

			int M = N - 1;
			for (int k = 0; k < N; k++) {
				for (int j = N - 1; j >= 0; j--) {
					System.out.print(list[j][k]);
				}
				System.out.print(" ");

				for (int j = N - 1; j >= 0; j--) {
					System.out.print(list[M][j]);
				}
				System.out.print(" ");

				for (int j = 0; j < N; j++) {
					System.out.print(list[j][M]);
				}
				M--;
				System.out.println();
			}

		}
	}

}
