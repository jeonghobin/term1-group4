package com.ssafy.study.beakjoon.N과M.beak_15654;

import java.util.Arrays;
import java.util.Scanner;

/*
 * N과 M (5)
 * 정렬 후 순열
 */
public class Main {

	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		Recursive(new int[M], new boolean[N], 0);
	}
	public static void Recursive(int[] sel, boolean[] v, int sIdx) {
		if(sel.length == sIdx) {
			for (int i = 0; i < sel.length; i++) {
				System.out.print(sel[i]+" ");
			}
			System.out.println();
			
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			
			if(!v[i]) {
				v[i] = true;
				sel[sIdx] = arr[i];
				Recursive(sel, v, sIdx+1);
				v[i] = false;
			}
		}
	}

}
