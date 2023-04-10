package day07;

import java.io.*;
import java.util.*;

public class 곱셈 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// A의 B제곱을 C로 나눈 나머지를 구하라
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		pow(A, B, C);
	}

	
	// a^4 = a^2 * a^2 = a^1 * a^1 * a^1 * a^1
	private static int pow(int A, int B, int C) {
		// 지수가 1이면
		if (B == 1) {
			return A % C;
		}
		
		// 짝수라면 
		
		// 홀수라면
		
		
		return 1;
	}
}
