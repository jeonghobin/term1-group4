package com.ssafy.study.swea.D1_D2;

import java.util.Scanner;

public class D2_1976 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			int[] list = new int[4];
			System.out.print("#" + i + " ");

			for (int j = 0; j < 4; j++) {
				list[j] = sc.nextInt();
			}

			int hour = list[0] + list[2];
			int min = list[1] + list[3];

			int min2 = 0;
			if (min >= 60) {
				min2 = 1;
				hour(hour,min2);
				System.out.println(min - 60);
			} else {
				hour(hour,min2);
				System.out.println(min);
			}
		}

	}
	
	public static void hour(int hour, int min2) {
		if (hour > 12) {
			System.out.print((hour - 12 + min2) + " ");
		} else {
			System.out.print(hour + min2 + " ");
		}
	}
}
