package com.ssafy.study.beakjoon.beak_11659;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringBufferInputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

//구간 합 구하기 4
//수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합
public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());// 합을 구해야 하는 횟수

		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine());

		arr[0] = 0;
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()) + arr[i - 1];
		}
		// [0,5,9,12,14,15] -> 2, 4 -> 14-5
		// 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = arr[Integer.parseInt(st.nextToken())-1];
			int jdx = arr[Integer.parseInt(st.nextToken())];
			int toSum = jdx - idx;
			bw.write(String.valueOf(toSum));
			bw.newLine();
			//시간초과
//			sum(arr, Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, 0);
		}

		bw.flush();
		bw.close();

	}

//	public static void sum(int[] arr, int ix, int jx, int toSum) throws IOException {
//		if (ix > jx) {
//			bw.write(String.valueOf(toSum));
//			bw.newLine();
//			return;
//		}
//
//		sum(arr, ix + 1, jx, toSum+arr[ix]);
//	}
}
