package com.ssafy.study.beakjoon.다음순열_10972;

import java.io.*;
import java.util.*;

/*
 * 순열의 가지는 N!개 
 * 다음 순열 찾는 방법  => https://dundung.tistory.com/58
 * 
 */

public class Main {
	static int N;
	static int[] comp;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		comp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			comp[i] = Integer.parseInt(st.nextToken());
		}

		recursive(new int[N], 0, new boolean[N + 1]);

		System.out.println(-1);
	}

	static boolean ischeck = false;

	private static void recursive(int[] sel, int k, boolean[] v) throws IOException {
		if (sel.length == k) {

			if (ischeck) {
				for (int i = 0; i < sel.length; i++) {
					bw.write(sel[i] + " ");
				}
				bw.flush();
				bw.close();
				System.exit(0);
			}

			if (Arrays.equals(sel, comp))
				ischeck = true;

			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!v[i]) {
				v[i] = true;
				sel[k] = i;
				recursive(sel, k + 1, v);
				v[i] = false;
			}
		}
	}

}
