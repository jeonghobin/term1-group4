package Jungol.p1523;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken()); // 크기
		int M = Integer.parseInt(st.nextToken()); // 종류
		
		if (N >= 100) {
			System.out.println("INPUT ERROR!");
		} else if (M == 1) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		} else if (M == 2) {
			for (int i = N; i >= 1; i--) {
				for (int j = 1; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		} else if (M == 3) {
			for (int i = 1; i <= N; i++) {
				for (int j = N; j > i; j--) {
					System.out.print(" ");
				}	
				System.out.print("*");
				for (int j = 1; j < i; j++) {
					System.out.print("**");
				}	
				System.out.println();
			}
		} else {
			System.out.println("INPUT ERROR!");
		}
		
	}
}
