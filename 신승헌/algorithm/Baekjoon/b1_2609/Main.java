package test.baekjoon.b1_2609;

import java.io.*;
import java.util.*;

// 최대공약수 최소공배수 구하기
public class Main {
	static int gcd(int N, int M) {
		
		int L = N % M;
		if (L == 0) {
			return M;
		}
		return gcd(M, L);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		if (N < M) {
			int temp = M;
			M = N;
			N = temp;
		}
		
		int G = gcd(N, M); // 최대공약수
		int L = N * M / G; // 최소공배수
		
		System.out.println(G);
		System.out.println(L);
	}
}
