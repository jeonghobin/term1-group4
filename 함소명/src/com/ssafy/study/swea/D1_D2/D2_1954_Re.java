package com.ssafy.study.swea.D1_D2;

import java.util.Arrays;
import java.util.Scanner;

public class D2_1954_Re {

	static int[] rt = { 0, 1, 0, -1 };// 행
	static int[] ct = { 1, 0, -1, 0 };// 열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 0,0/0,1/0,2/0,3/1,3
		int[][] map = new int[N][N];
		int cnt = 1; // 들어갈 숫자
		int x = 0;
		int y = 0;
		int t = 0;// 4방탐색 index
		map[0][0] = 1;
		while (cnt < N * N) {// 돌 껍질 수

			int dx = x + rt[t];
			int dy = y + ct[t];

			if (dx < 0 || dy < 0 || dx == N || dy == N || map[dx][dy] != 0) {
				t = (t + 1) % 4;
				continue;// 아래 코드는 실행시키지 않고, 반복문 위에서부터 다시 실행
			}
			
			map[dx][dy] = ++cnt;
			x = dx;
			y = dy;
//			System.out.println(x + ", " + y);

		}

		System.out.println(Arrays.deepToString(map));
	}
}
