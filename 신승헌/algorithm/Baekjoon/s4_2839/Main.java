package Baekjoon.s4_2839;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		
		int bestSol = 5000;
		int nowSol = 5000;
		
		for (int i = 0; i <= N / 5; i++) {
			int nowSearch = N - 5*i;
			if (nowSearch == 0) {
				nowSol = i;
				if (nowSol < bestSol) {
					bestSol = nowSol;
				}
				break;
			}
			for (int j = 1; j <= N / 3; j++) {
				nowSearch -= 3;
				if (nowSearch > 0) {
					continue;
				} else if (nowSearch == 0) {
					nowSol = i + j;
					if (nowSol < bestSol) {
						bestSol = nowSol;
					}
				} else {
					break;
				}
			}
		}
		
		if (bestSol == 5000) {
			System.out.println(-1);
		} else {
			System.out.println(bestSol);
		}
	}
}
