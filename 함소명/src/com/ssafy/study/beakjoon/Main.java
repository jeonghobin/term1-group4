package com.ssafy.study.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());// N개의 시험장

		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());// 각 시험장의 응시자 수.
		}

		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		// 총감독관(한명)-> 감시할 수 있는 응시자수 B명, 부감독관(여러명 가능)-> 감시할 수 있는 응시자수 C명이다.
		// 필요 감독관 수 최솟값은?
		long cnt = 0;
		for (int num : arr) {
			num = num - B;
			cnt++;

			if (num > 0) {
				cnt += num / C;
				if (num % C != 0)
					cnt++;
			}
		}

		System.out.println(cnt);

	}

}
