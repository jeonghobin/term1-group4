package Baekjoon.un_2556;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 별 찍기 14
// 적절한 별찍기..
// 언랭..

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				System.out.print("*");
			}
			System.out.println();
			
		}

		
		
	}
}
