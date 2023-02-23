package com.ssafy.study.beakjoon.permutation.beak_10972;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 다음 순열
 * 
 */
public class Main {

	static int[] arr;
	static int[] copy;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N];
		copy = new int[N];
		for (int i = 0; i < N; i++) {
			copy[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		permutation(new int[N], new boolean[N], 0);

		if(check.equals("")) System.out.println("-1");
		else System.out.println(check);
	}

	static boolean ischeck = false;
	static String check = "";
	public static void permutation(int[] sel, boolean[] v, int idx) {
		if (idx == sel.length) {
			if(ischeck) {
				for (int i = 0; i < sel.length; i++) {
					check += sel[i]+" ";
				}
				ischeck = false;
			}
			if (Arrays.equals(copy, sel) && !ischeck) ischeck = true;
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!v[i]) {
				v[i] = true;
				sel[idx] = arr[i];
				permutation(sel, v, idx + 1);
				v[i] = false;
			}
		}

	}

}
