package Baekjoon.b3_2443;

import java.io.*;
import java.util.*;
/* 
 * 문제
	첫째 줄에는 별 2×N-1개, 둘째 줄에는 별 2×N-3개, ..., N번째 줄에는 별 1개를 찍는 문제
	별은 가운데를 기준으로 대칭이어야 한다.
 */

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			int countngStar = (N - i) * 2 - 1;
			for (int j = 0; j < countngStar; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
