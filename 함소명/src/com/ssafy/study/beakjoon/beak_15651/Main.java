package com.ssafy.study.beakjoon.beak_15651;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.StringTokenizer;

//중복 순열
public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		recursive(0, new int[M]);
		bw.close();
	}

	// k= index
	public static void recursive(int k, int[] M) throws IOException {
		if (k == M.length) {
			k = 0;

			for (int i = 0; i < M.length; i++) {
				bw.write(M[i] + " ");
			}
			bw.newLine();
			bw.flush(); // 남아있는 데이터 모두 출력

			return;
		}

		for (int i = 0; i < N; i++) {

			M[k] = i + 1;
			recursive(k + 1, M);
		}

	}
}
