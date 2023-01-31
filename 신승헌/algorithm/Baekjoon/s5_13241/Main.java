package test.baekjoon.s5_13241;

import java.io.*;
import java.util.*;

public class Main {
	public static long gcd(long A, long B) {
		long C = A % B;
		if ( C == 0 ) {
			return B;
		}
		return gcd(B, C);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
				
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		if (B > A) {
			long temp = B;
			B = A;
			A = temp;
		}
		
		long G = gcd(A, B);
		long L = A * B / G;
		
		System.out.println(L);
	}
}
