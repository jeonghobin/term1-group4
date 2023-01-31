package test.baekjoon.b1_1934;

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

		int T = Integer.parseInt(st.nextToken());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			if (B > A) {
				int temp = B;
				B = A;
				A = temp;
			}

			int G = (gcd(A, B));
			System.out.println(A * B / G);

		}
	}
}
