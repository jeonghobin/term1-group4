package Baekjoon.b3_2445;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

// 별 찍기 8
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i < N * 2; i++) {
			if (i <= N) {
				for (int j = 1; j <= i; j++) {
					System.out.print("*");
				}
				for (int j = N ; j > i; j--) {
					System.out.print("  ");
				}
				for (int j = 1; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			} else {
				for (int j = N * 2; j > i; j--) {
					System.out.print("*");
				}
				for (int j = N+1; j <= i; j++) {
					System.out.print("  ");
				}
				for (int j = N * 2; j > i; j--) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
		
	}
}
