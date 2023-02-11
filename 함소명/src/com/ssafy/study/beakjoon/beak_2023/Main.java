package com.ssafy.study.beakjoon.beak_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//신기한 소수
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double limit = Math.pow(10, N);
		double start = Math.pow(10, N - 1);

		// 1의 자리 소수
		int[] arr = { 1, 2, 3, 5, 7, 8, 9 };

		for (int i = 0; i < arr.length; i++) {
			System.out.println(isSosu(arr[i]));
		}
		


	}

	public static int isSosu(int num) {
		for(int i = 2; i<=num/2; i++) {
			if (num % i == 0)//소수 아님
				num = 0;
		}

		return num;
	}
}
