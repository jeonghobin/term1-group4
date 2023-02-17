package com.ssafy.study.beakjoon.beak_2563;

import java.util.Scanner;


//색종이
//각 색종이가 보이는 부분의 면적

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[][] papaer = new int[101][101];

		// 가장 왼쪽아래(1,4), 너비 3, 높이 2
		for (int i = 1; i <= N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int wide = sc.nextInt();
			int high = sc.nextInt();

			for (int j = x; j < x + wide; j++) {
				for (int k = y; k < y + high; k++) {
					papaer[j][k] = i;
				}
			}
		}

		int[] answer = new int[N + 1];
		int cunt = 0;
		for (int i = 0; i < papaer.length; i++) {
			for (int j = 0; j < papaer.length; j++) {
				answer[papaer[i][j]] += 1;
			}
		}

		for (int i = 1; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

}
