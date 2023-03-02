package com.ssafy.study.beakjoon.beak_2563;

import java.util.Scanner;


//색종이
//각 색종이가 보이는 부분의 면적

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[][] paper = new int[101][101];

		// 가장 왼쪽아래(1,4), 너비 3, 높이 2
		for (int i = 1; i <= N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					paper[j][k] = 1;
				}
			}
		}

		int cnt = 0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if(paper[i][j] == 1)
					cnt++;
			}
		}
		System.out.println(cnt);
	}

}
