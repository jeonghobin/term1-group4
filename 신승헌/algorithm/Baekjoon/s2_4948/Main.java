package week04.s2_4948;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 소수가 아니면 true
		boolean[] prime = new boolean[246912 + 1];
		
		prime[0] = true;
		prime[1] = true;
		
		for (int i = 2; i * i < prime.length; i++) {
			if (prime[i] == false) {
				for (int j = i * i; j < prime.length; j+=i) {
					prime[j] = true;
				}
			}
		}
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 시작 값
			int M = N * 2; // 끝 값
			int answer = 0;
			
			if (N == 0) {
				break;
			} 
		
			for (int i = N + 1; i <= M; i++) {
				if (prime[i] == false) {
					answer += 1;
				}
			}
			
			sb.append(answer + "\n");
			
		}
		
		System.out.println(sb);
	}
}
