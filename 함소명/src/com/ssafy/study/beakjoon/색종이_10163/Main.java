package com.ssafy.study.beakjoon.색종이_10163;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		map = new int[101][101];

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			cnt++;

			// (1,4)가 가장 왼쪽 아래에 있고 너비 3, 높이 2이므로 1 4 3 2로 표현
			int r = sc.nextInt();
			int c = sc.nextInt();
			int w = sc.nextInt();
			int h = sc.nextInt();

			for (int j = c; j < c+h; j++) {
				for (int k = r; k < r+w; k++) {
					map[j][k] = cnt;
				}
			}
		}

		if (cnt == 0)
			System.out.println(0);
		else
			for (int i = 1; i <= cnt; i++) {
				int num = 0;
				for (int j = 0; j < map.length; j++) {
					for (int k = 0; k < map.length; k++) {
						if (map[j][k] == i)
							num++;
					}
				}
				System.out.println(num);
			}

	}

}
