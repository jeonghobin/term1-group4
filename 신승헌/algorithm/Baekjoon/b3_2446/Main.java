package Baekjoon.b3_2446;

import java.io.*;
import java.util.*;

// 별 찍기 9
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			int starCount = (N * 2) - i * 2 - 1;
			for (int j = 0; j < starCount; j++) {
				System.out.print("*");
				
			}
			System.out.println();
		}

		for (int i = 2; i <= N; i++) {
			for (int j = N; j > i; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < i * 2 - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		
	}
}
