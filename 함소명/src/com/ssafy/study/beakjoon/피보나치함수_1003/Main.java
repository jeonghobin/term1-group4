package com.ssafy.study.beakjoon.피보나치함수_1003;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();

			// 0이 몇 개?
			//1 0 1 1 2 3...
			int[] fibo0 = new int[40 + 1];//N은 40보다 작거나 같은 자연수
			fibo0[0] = 1;
			fibo0[1] = 0;

			// 1이 몇 개?
			// 0 1 1 2 3...
			int[] fibo1 = new int[40 + 1];
			fibo1[0] = 0;
			fibo1[1] = 1;
			
			for (int j = 2; j <= N; j++) {
				fibo0[j] = fibo0[j-1]+fibo0[j-2];
				fibo1[j] = fibo1[j-1]+fibo1[j-2];
			}

			System.out.println(fibo0[N]+" "+fibo1[N]);
		}

	}


}
