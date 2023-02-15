package com.ssafy.study.beakjoon.beak_10859;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//뒤집업진 소수
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long N = Long.parseLong(br.readLine());

		boolean origin = sosu(N);
		if (origin)
			origin = reverse(N);

		System.out.println(origin ? "yes" : "no");
	}

	public static boolean reverse(long num) {

		long answer = 0;
		boolean v = true;
		L: while (num != 0) {
			answer = answer * 10 + num % 10;
			
			if (answer == 6) {
				answer = 9;
			} else if (answer == 9) {
				answer = 6;
			} else if (answer == 3 || answer == 4 || answer == 7) {
				v = false;
				break L;
			}
			
			num /= 10;
		}
//		System.out.println(answer);

		if (v)
			return sosu(answer);
		else
			return false;
	}

	// 일반적
	boolean isPrime(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	// 에라토스테네스의 체
	public static boolean sosu(long n) {
		long[] arr = new long[(int) (n + 1)];

		// 0과 1은 소수가 아니다
		arr[0] = 1;
		arr[1] = 1;
		for (int i = 2; i <= n; i++) {// 1~n 쭉 돌리면
			// 이미 소수 아닌걸로 판명됨
			if (arr[i] == 1)
				continue;

			// i 배수면 소수가 아니다.
			for (int j = i + i; j <= n; j += i) {
				arr[j] = 1;
			}
		}

		// 1이면 소수 아님
		return arr[(int) n] == 1 ? false : true;
	}

}
