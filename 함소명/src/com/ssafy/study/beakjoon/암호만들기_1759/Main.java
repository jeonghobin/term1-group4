package com.ssafy.study.beakjoon.암호만들기_1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//암호만들기_1759
public class Main {
	static int L, C;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		char[] list = new char[C];
		String str = br.readLine().replace(" ", "");
		for (int i = 0; i < C; i++) {
			list[i] = str.charAt(i);
		}

		Arrays.sort(list);

		recursive(list, new char[L], 0, 0, new boolean[C]);
	}

	static char[] mo = { 'a', 'e', 'i', 'o', 'u' };

	private static void recursive(char[] arr, char[] sel, int aIdx, int sIdx, boolean[] v) {
		if (sel.length == sIdx) {

			int cnt = 0;
			for (char b : sel) {
				for (char s : mo) {
					if (s == b) {
						cnt++;
					}
				}
			}

			// 최소 한개의 모음, 최소 두개의 자음
			if (cnt >= 1 && sel.length - 2 >= cnt) {
				for (int i = 0; i < sel.length; i++) {
					System.out.print(sel[i]);
				}
				System.out.println();
			}
			
			return;
		}

		for (int i = aIdx; i < arr.length; i++) {
			if (!v[i]) {
				v[i] = true;
				sel[sIdx] = arr[i];
				recursive(arr, sel, i, sIdx + 1, v);
				v[i] = false;
			}
		}
	}
}