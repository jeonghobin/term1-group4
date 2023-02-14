package com.ssafy.study.beakjoon.beak_10859;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//뒤집업진 소수
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		String origin = sosu(N);
		
		String revers = sosu(reverse(N));
		
	}
	
	public static int reverse(int n) {

		
		return 0;
	}
	
	public static String sosu(int n) {
		int[] arr = new int[n + 1];

		for (int i = 2; i <= n; ++i) {
			if (arr[i] == 1)
				continue;
			for (int j = i + i; j <= n; j += i) {// i의 배수
				arr[j] = 1;
			}
		}
		
		//1이면 소수 아님 0이면 소수(true)
		return arr[n]!=0 ? "no" : "yes";
	}

}
