package com.ssafy.study.swea.D1_D2;

import java.util.Iterator;
import java.util.Scanner;

//날짜 계산기
public class D2_1948 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		for (int test_case = 1; test_case <= T; test_case++) {
			int[] list = new int[4];
			int[] day = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

			for (int i = 0; i < 4; i++) {
				list[i] = sc.nextInt();
			}

			int mm = list[2] - list[0];
			int sum = 0;
			for (int i = 0; i <= mm; i++) {
				if (mm == 0) {
					sum += list[3] - list[1];
				} else if (list[0] + i == list[0]) {
					sum += day[list[0] + i - 1] - list[1];
				} else if (list[0] + i == list[2]) {
					sum += list[3];
				} else {
					sum += day[list[0] + i - 1];
				}
			}
			System.out.println("#" + test_case + " " + (sum + 1));

		}
	}

}
