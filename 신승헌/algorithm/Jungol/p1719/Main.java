package Jungol.p1719;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken()); // 크기
		int M = Integer.parseInt(st.nextToken()); // 종류
		
		if (N % 2 != 1 || N > 100 || N < 1 || M > 4 || M < 1) {
			System.out.println("INPUT ERROR!");
			return;
		} 

		int mid = N / 2;
		
		if (M == 1) {
			for (int i = 1; i <= mid; i++) { // 행
				for (int j = 1; j <= i; j++) { // 별 길이
					System.out.print("*");
				}
				System.out.println();
			}
			for (int i = mid + 1; i <= N; i++) {
				for (int j = N + 1; j > i; j--) {
					System.out.print("*");
				}
				System.out.println();
			}
			
			
		} else if (M == 2) {
			for (int i = 1; i <= mid; i++) { // 행
				for (int j = N/2+1; j > i; j--) {
					System.out.print(" ");
				}
				for (int j = 1; j <= i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			
			for (int i = mid + 1; i <= N; i++) {
				for (int j = N/2+1; j < i; j++) {
					System.out.print(" ");
				}
				for (int j = 1; j <= N +1 -i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			
		} else if (M == 3) {
			// 가운데 위
			for (int i = 1; i <= mid; i++) { // 행
				for (int j = 1; j < i; j++) {
					System.out.print(" ");
				}
				System.out.print("*");
				for (int j = mid; j >= i; j--) {
					System.out.print("**");	
				}
				System.out.println();
			}
			// 가운데 아래
			for (int i = mid + 1; i <= N; i++) { // 행
				for (int j = i; j < N; j++) { // 띄워쓰기
					System.out.print(" ");
				}
				System.out.print("*");
				for (int j = mid + 1; j < i; j++) {
					System.out.print("**");
				}
				System.out.println();
			}
		} else if (M == 4) {
			// 가운데 위
			for (int i = 1; i <= mid; i++) {
				for (int j = 1; j < i; j++) {
					System.out.print(" ");
				}
				for (int j = mid + 1; j >= i; j--) {
					System.out.print("*");
				}
				System.out.println();
			}
			// 가운데 아래
			for (int i = mid + 1; i <= N; i++) {
				for (int j = 1; j < mid + 1; j++) {
					System.out.print(" ");
				}
				for (int j = mid; j < i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			
		}
		
		else {
			System.out.println("INPUT ERROR!");
		}
		
	}
}
