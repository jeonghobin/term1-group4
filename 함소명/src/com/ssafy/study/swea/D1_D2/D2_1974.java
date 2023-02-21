package com.ssafy.study.swea.D1_D2;

import java.util.Scanner;

//스도쿠 검증
public class D2_1974 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		
		int[] di = {-1,-1,-1,0,0,0,1,1,1}; // 8방
		int[] dj = {-1,0,1,-1,0,1,-1,0,1}; // 8방
		
		for (int i = 1; i < t + 1; i++) {
			int[][] arr = new int[9][9];
			int answer = 1;
			System.out.print("#" + i + " ");

			// 배열입력
			for (int j = 0; j < 9; j++) {
				for (int k = 0; k < 9; k++) {
					arr[j][k] = sc.nextInt();
				}
			}

			for (int j = 0; j < 9; j++) {
				int sum = 0;
				for (int k = 0; k < 9; k++) {
					sum += arr[j][k];
				}
				if (sum != 45) {
					answer = 0;
					break;
				}
			}

			for (int j = 0; j < 9; j++) {
				int sum = 0;
				for (int k = 0; k < 9; k++) {
					sum += arr[k][j];
				}
				if (sum != 45) {
					answer = 0;
					break;
				}
			}

			for (int q = 1; q < 9; q =q+3) {//1,4,7
				for (int j = 1; j < 9; j=j+3) {//1,4,7
					int sum = 0;
					for (int k = 0; k < 9; k++) {
						sum += arr[q+di[k]][j+dj[k]];
					}
					if (sum != 45) {
						answer = 0;
						break;
					}
				}
			}

			System.out.println(answer);

		}
	}

}
