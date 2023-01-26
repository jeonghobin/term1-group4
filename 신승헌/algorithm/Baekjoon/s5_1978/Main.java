package homework.Baekjoon.s5_1978;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken()); // 소수를 구할 범위
		
		st = new StringTokenizer(br.readLine());
		String[] s = new String[N];
		for (int i = 0; i < s.length; i++) {
			s[i] = st.nextToken();
		}
		
		
		// false는 소수가 아닌 값
		boolean[] prime = new boolean[100 + 1];
		prime[0] = true;
		prime[1] = true;
		
		for (int i = 2; i*i <= N; i++) {
			if (!prime[i]) { // 소수인 경우
				for (int j = i*i; j < N; j += i) {
					prime[j] = true; // 소수가 아님
				}
			}
		}
		
		int count = 0;

		for (int i = 0; i < s.length; i++) {
			if (prime[Integer.parseInt(s[i])] == false) {
				count += 1;
			}
		}
		
		System.out.println(count);
		
		
		
	}
}
