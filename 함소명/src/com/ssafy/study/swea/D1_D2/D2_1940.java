package com.ssafy.study.swea.D1_D2;

import java.util.Scanner;

//가랏! RC카!
public class D2_1940 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();

			int move = 0;
			int curSpeed = 0;
			for (int i = 0; i < N; i++) {
				int speed = 0;
				int input = sc.nextInt();
				if (input != 0)
					speed = sc.nextInt();

				switch (input) {
					case 0: {
						curSpeed = curSpeed;
	
						break;
					}
					case 1: {
						curSpeed = curSpeed + speed;
	
						break;
					}
					case 2: {
						if (curSpeed < speed) {
							curSpeed = 0;
						} else {
							curSpeed = curSpeed - speed;
						}
	
						break;
					}
				}
				move += curSpeed;
			}
			System.out.println("#" + test_case + " " + move);
		}
	}

}
