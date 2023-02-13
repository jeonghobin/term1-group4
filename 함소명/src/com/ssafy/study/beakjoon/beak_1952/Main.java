package com.ssafy.study.beakjoon.beak_1952;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] rx = { 0, 1, 0, -1 };
		int[] ry = { 1, 0, -1, 0 };

		int cnt = 0;
		int dirCnt = 0;
		int x = 0;
		int y = 0;
		int t = 0;
		int[][] map = new int[N][M];
		while (cnt <= N * M) {
			t = t % 4;

			int dx = x + rx[t];
			int dy = y + ry[t];

			if (dx < 0 | dx == N | dy < 0 | dy == M) {//행 내려가야함.
				t++;
				dirCnt++;
				continue;
			}

			map[x][y] = cnt++;

			x = dx;
			y = dy;

		}

		System.out.println(dirCnt);
		System.out.println(Arrays.deepToString(map));
	}

}
