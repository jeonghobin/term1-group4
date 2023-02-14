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

		int cnt = 2;
		int dirCnt = 0;
		int x = 0, y = 0;
		int t = 0;
		int[][] map = new int[N][M];
		map[0][0] = 1;
//		int xx = 0, yy= 0;
		while (cnt <= N * M) {
			t = t % 4;

			int dx = x + rx[t];
			int dy = y + ry[t];

			// || 먼저 확인하면 뒤는 확인하지 않음.
			if (dx < 0 || dx == N || dy < 0 || dy == M || map[dx][dy]!=0) {//행 내려가야함.
				t++;
				dirCnt++;
				
				continue;
			}
			
			x = dx;
			y = dy;
	
//			if(cnt == N * M) {
//				xx = x+1;
//				yy = y+1;
//			}
			
			map[x][y] = cnt++;
			
		}

		System.out.println(dirCnt);
//		System.out.println(xx+" "+yy);
	}

}
