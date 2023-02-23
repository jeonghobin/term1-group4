package com.ssafy.study.beakjoon.cut.beak_1992;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 쿼드트리
 * 분할로 문제 풀기.
 * 왼쪽 위를 중심으로.
 */
public class Main {
	static int[][] arr;
	static String answer = "";

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// (0(0011)(0(0001)01)1)
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}

//		System.out.println(Arrays.deepToString(arr));
		cut(0, 0, N);

		System.out.println(answer);
	}

	public static void cut(int r, int c, int N) {

		int sum = 0;
		
		for (int i = r; i < r+N; i++) {
			for (int j = c; j < c+N; j++) {
				sum += arr[i][j];
			}
		}
		
		if(N*N == sum) {
			answer += 1;
		}else if(sum == 0){
			answer += 0;
		}else {
			//4분할
			int half = N/2;
			answer += "(";
			cut(r, c, half);
			cut(r, c+half, half);
			cut(r+half, c, half);
			cut(r+half, c+half, half);
			answer += ")";
		}
	}
}
