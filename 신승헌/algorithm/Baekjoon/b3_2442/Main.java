package Baekjoon.b3_2442;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문제
//첫째 줄에는 별 1개, 둘째 줄에는 별 3개, ..., N번째 줄에는 별 2×N-1개를 찍는 문제
//별은 가운데를 기준으로 대칭이어야 한다.

/*
 * 문제에 답이 있다! 문제를 잘 읽자!!
 */

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			for (int j = N; j > i; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < i * 2 -1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
