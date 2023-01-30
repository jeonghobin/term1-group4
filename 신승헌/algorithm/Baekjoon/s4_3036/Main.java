package test.baekjoon.s4_3036;

import java.io.*;
import java.util.*;

public class Main {
	public static int gcd(int A, int B) {
		int L = A % B;
		if (L == 0) {
			return B;
		}

		return gcd(B, L);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int originA = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N - 1; i++) {
			int originB = Integer.parseInt(st.nextToken());

			int B = originB;
			int A = originA;

			if (A < B) {
				int temp = B;
				B = A;
				A = temp;
			}

			int G = gcd(A, B);

			System.out.println(originA / G + "/" + originB / G);

		}
	}

}
