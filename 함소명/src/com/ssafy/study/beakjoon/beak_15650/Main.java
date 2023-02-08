package com.ssafy.study.beakjoon.beak_15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		recursive(0, new int[M], new boolean[N]);
	}

	// k= index
	// b 중복 트리 막기
	public static void recursive( int k, int[] sel, boolean[] v) {
		if (k ==sel.length) {
			k = 0;

			for (int i : sel) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < v.length; i++) {
			
			if (v[i] == false) {
				v[i] = true;
				sel[k] = i + 1;

				recursive(k + 1, sel, v);
				for (int j = i+1; j < v.length; j++) {
					v[j] = false; 
				}
			}
			
		}
		

	}
}
