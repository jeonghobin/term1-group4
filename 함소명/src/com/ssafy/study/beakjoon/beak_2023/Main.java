package com.ssafy.study.beakjoon.beak_2023;

import java.util.Scanner;

//신기한 소수
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double limit = Math.pow(10, N);
		double start = Math.pow(10, N - 1);

		int[] sosu = {2, 3, 5, 7};




	}

	public static int isSosu(int num) {
		for(int i = 2; i<=num/2; i++) {
			if (num % i == 0)//소수 아님
				num = 0;
		}

		return num;
	}
}
