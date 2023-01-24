package Jungol.p1329;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d3_2805/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		
		if (N % 2 == 0 || N > 100 || N < 1) {
			System.out.println("INPUT ERROR!");
			return;
		}
		
		int mid = N / 2;
		
		// 가운데 위
		for (int i = 1; i <= mid; i++) { // 행 반복
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			System.out.print("*");
			for (int j = 1; j < i; j++) {
				System.out.print("**");
			}
			System.out.println();
		}
		
		// 가운데 아래
		for (int i = mid + 1; i <= N; i++) {
			for (int j = N; j > i; j--) {
				System.out.print(" ");
			}
			
			System.out.print("*");
			for (int j = N; j > i; j--) {
				System.out.print("**");
			}
			System.out.println();
		}
	}
}
