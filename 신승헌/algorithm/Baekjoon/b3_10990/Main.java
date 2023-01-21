package Baekjoon.b3_10990;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 별 찍기 15

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			int spaceCount = N - i;
			for (int j = 0; j < spaceCount; j++) {
				System.out.print(" ");
			}
			System.out.print("*");
			
			int spaceCount2 = (i-2) * 2 + 1;
			for (int j = 0; j < spaceCount2; j++) {
				System.out.print(" ");
			}
			
			if (i == 1) {
				System.out.println();
				continue;
			}

			System.out.println("*");
		}
	}
}
