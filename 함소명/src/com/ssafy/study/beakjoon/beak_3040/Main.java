package com.ssafy.study.beakjoon.beak_3040;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 백설 공주와 일곱 난쟁이
 * 
 */
public class Main {
	static int[] nanjeng;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		nanjeng = new int[9];
		for (int i = 0; i < 9; i++) {
			nanjeng[i] = sc.nextInt();
		}
		find(0, new int[7], 0, 0);
	}

	public static void find(int nIdx, int[] sel, int sIdx, int sum) {
		if (sIdx == 7) {
			if (sum == 100) {
				for (int i = 0; i < sel.length; i++) {
					System.out.println(sel[i]);
				}
				return;
			}
			return;
		}

		for (int i = nIdx; i < 9; i++) {
			sel[sIdx] = nanjeng[i];
			find(i+1, sel, sIdx+1, sum+nanjeng[i]);
		}

	}

}
