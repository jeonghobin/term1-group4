package com.ssafy.study.beakjoon.beak_1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer numbers = new StringTokenizer(br.readLine());
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(numbers.nextToken());

			// 0과 1은 소수가 아니다.
			for (int j = 2; j <= num; j++) {
				if (j == num) {//자기 자신
					cnt++;
				}
				if (num % j == 0) {
					break;
				}
			}
		}

		System.out.println(cnt);
	}

	public static Integer sosu(int num, int n) {
		if (num == 0 || num == 1)
			return 0;

		for (int i = 2; i < n; i++) {
			if (num % i == 0)
				return 1;
		}

		return 0;
	}

}
