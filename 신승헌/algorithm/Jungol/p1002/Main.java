package jungol.p1002;

import java.io.*;
import java.util.*;

public class Main {
	public static int gcd(int A, int B) {
		if (B > A) {
			int temp = B;
			B = A;
			A = temp;
		}
		
		int C = A % B;
		if (C == 0) {
			return B;
		}
		return gcd(B, C);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int[] number = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		int A = number[0]; // 최대공약수
		int L = number[0]; // 최소공배수
		for (int i = 1; i < M; i++) {
			int B = number[i];
			

			A = gcd(A, B); // 최대공약수 구하기
			L = L * number[i] / gcd(L, number[i]); // 최소공배수 구하기
		}
	
		System.out.println(A + " " + L);
	}
}
